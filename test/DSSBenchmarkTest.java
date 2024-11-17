import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.google.common.base.Stopwatch;

public class DSSBenchmarkTest{
	
	private static int NUM_RUNS = 100;
	
	@Test
	public void test() throws Exception{
		DataStorageSystem dss = new DataStorageImplementation();
		DataStorageSystem dss2 = new DSImpOptimization();
		
		ArrayList<char[]> charAl = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			char[] cArr = new char[100];
			for(int j = 0; j < 100; j++) {
				cArr[j] = 'a';
			}
			charAl.add(cArr);
		}
		long timeStart = System.currentTimeMillis();
		for (int i = 0; i < NUM_RUNS; i++) {
			dss.mkFile(charAl);
		}
		long timeEnd = System.currentTimeMillis();
		
		long averageElapsedTimeOriginal = (timeEnd - timeStart) / NUM_RUNS;
		System.out.println("Original: " + averageElapsedTimeOriginal);
		
		Stopwatch timer = Stopwatch.createStarted();
		for (int i = 0; i < NUM_RUNS; i++) {
			dss2.mkFile(charAl);
		}
		timer.stop();
		
		long averageElapsedTimeNew = timer.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;
		
		System.out.println("New: " + averageElapsedTimeNew);
		
		if(averageElapsedTimeNew > averageElapsedTimeOriginal*.9) {
			Assert.fail();
		}
	}
}