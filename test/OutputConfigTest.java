import java.util.ArrayList;
import java.util.List;
public class OutputConfigTest implements OutputConfig{
	private ArrayList<Character> testOutput = new ArrayList<>();
	public OutputConfigTest(ArrayList<Character> sortedArr) {
		testOutput = sortedArr;
	}
	public List<char[]> outputData = new ArrayList<>();
	public List<char[]> getOutputData(){
			return outputData;
	}
}