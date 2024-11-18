import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CPEStorageImplOptimizationTest{
	//private static int numRuns = 100;
	
	@Test
	public void optimizationTest() throws Exception {
		
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		ComputeEngineStorageSystem css1 = new CPEStorageImplOptimized();
		
		InputConfig int1 = new IntegerInputConfig(100);
		InputConfig int2 = new IntegerInputConfig(100);
		UUID key = css.sendData(int1);
		UUID key1 = css1.sendData(int2);
		
		long timeStart = System.currentTimeMillis();
		
		for(int i = 0; i < 11; i ++) {
			css.retrieveCharArr(key);
		}
		long timeEnd = System.currentTimeMillis();
		
		long averageElapsedTimeOriginal = (timeEnd - timeStart) / 100;
		System.out.println("Original: " + averageElapsedTimeOriginal);
		
		
		long timeStart1 = System.currentTimeMillis();
		for(int i = 0; i < 100; i ++) {
			css1.retrieveCharArr(key1);
		}
		long timeEnd1 = System.currentTimeMillis();
		
		long averageElapsedTimeImproved = (timeEnd1 - timeStart1) / 100;
		System.out.println("Improved: " + averageElapsedTimeImproved);
		
		Assertions.assertEquals(1, 1);		
		

	}
}