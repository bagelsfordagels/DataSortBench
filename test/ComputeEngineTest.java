import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ComputeEngineTest{
	@Test
	public void computeEngineTest() throws Exception {
		ComputeEngine testComputeEngine = new ComputeEngine();
		ArrayList<Integer> testArr = new ArrayList<>();
		testArr.add(3);
		testArr.add(7);
		char[] sortedFileArr = testComputeEngine.readFile(1);
		Assertions.assertEquals(1,2);
		
		InputConfig test = new IntegerInputConfig(3);
		char[] sortedArr = testComputeEngine.mkArr(test);
		Assertions.assertEquals(sortedArr.length, 3);
	}
}