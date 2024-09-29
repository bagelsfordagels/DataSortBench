import java.util.Arrays;
import java.util.Random;

public class ComputeEngine{
	//method to do convert int to randomized char array
	int userData;
	
	public ComputeEngine(int userData) {
		this.userData = userData;
	}
	
	public static char[] mkArr(int userData) {
		char[] randomArr = new char[userData];
		Random random = new Random();

        for (int i = 0; i < userData; i++) {
            // Generate a random character between 'a' and 'z' (lowercase letters)
            char randomChar = (char) ('a' + random.nextInt(26));
            randomArr[i] = randomChar;
        }
        Arrays.sort(randomArr);
        return randomArr;
	}
	
	public static void main(String[] args) {
		char[] a = mkArr(5);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}