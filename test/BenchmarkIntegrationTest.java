import java.util.UUID;

import org.junit.jupiter.api.Test;

public class BenchmarkIntegrationTest{
	@Test
	public void test() throws Exception{
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		// integer test
		for(int i = 0; i < 100_000; i++) {
			InputConfig userInt = new IntegerInputConfig(10000000);
			InputConfig userInt1 = new IntegerInputConfig(20000000);
			
			UUID key = css.sendData(userInt);
			UUID key1 = css.sendData(userInt1);
			char[] sortedArr = css.retrieveCharArr(key);
			char[] sortedArr1 = css.retrieveCharArr(key1);
			//System.out.println(sortedArr);
		}
//		InputConfig userInt = new IntegerInputConfig(30_000);
//		InputConfig userInt2 = new IntegerInputConfig(30_000);
//		UUID key = css.sendData(userInt);
//		UUID key2 = css.sendData(userInt2);
//		char[] sortedArr = css.retrieveCharArr(key);
//		char[] sortedArr2 = css.retrieveCharArr(key2);
//		System.out.println(sortedArr);
//		System.out.println(sortedArr2);
	}
}