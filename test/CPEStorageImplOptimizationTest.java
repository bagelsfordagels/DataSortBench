import java.util.UUID;

import org.junit.Test;


public class CPEStorageImplOptimizationTest{
	private static int numRuns = 100;
	
	@Test
	public void optimizationTest() throws Exception {
		
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		ComputeEngineStorageSystem css1 = new CPEStorageImplOptimized();
		
		InputConfig int1 = new IntegerInputConfig(100);
		InputConfig int2 = new IntegerInputConfig(100);
		UUID key = css.sendData(int1);
		UUID key1 = css1.sendData(int2);
		
		long timeStart = System.currentTimeMillis();
		
		for(int i = 0; i < numRuns; i ++) {
			css.retrieveCharArr(key);
		}
		long timeEnd = System.currentTimeMillis();
		
		long averageElapsedTimeOriginal = (timeEnd - timeStart) / numRuns;
		System.out.println("Original: " + averageElapsedTimeOriginal);
		
		
		long timeStart1 = System.currentTimeMillis();
		for(int i = 0; i < numRuns; i ++) {
			css1.retrieveCharArr(key1);
		}
		long timeEnd1 = System.currentTimeMillis();
		
		long averageElapsedTimeImproved = (timeEnd1 - timeStart1) / numRuns;
		System.out.println("Improved: " + averageElapsedTimeImproved);
		

	}
}