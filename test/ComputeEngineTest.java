import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class ComputeEngineTest{
	@Test
	public void computeEngineTest() {
		ComputeEngine testComputeEngine = new ComputeEngine();
		ArrayList<Integer> testArr = new ArrayList<>();
		testArr.add(3);
		testArr.add(7);
		ArrayList<char[]> sortedFileArr = testComputeEngine.readFile(testArr);
		Assertions.assertEquals(sortedFileArr.size(),2);
		
		InputConfig testFile = new FileInputConfig("TestFile");
		char[] sortedArr = testComputeEngine.mkArr(testFile);
		Assertions.assertEquals(sortedArr.length, 3);
	}
}