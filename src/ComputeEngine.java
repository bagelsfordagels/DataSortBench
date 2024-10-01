import java.util.Arrays;
import java.util.Random;

public class ComputeEngine{
	//method to do convert int to randomized char array
	int userInt;
	
	public ComputeEngine(int userInt) {
		this.userInt = userInt;
	}
	
	public static char[] mkArr(InputConfig userData) {
		char[] randomArr = new char[userData.getUserData()];
		Random random = new Random();

        for (int i = 0; i < userData.getUserData(); i++) {
            // Generate a random character between 'a' and 'z' (lowercase letters)
            char randomChar = (char) ('a' + random.nextInt(26));
            randomArr[i] = randomChar;
        }
        Arrays.sort(randomArr);
        return randomArr;
	}
	
	public static void readFile(InputConfig fileName) {
		
	}
	
	
	
//	public static void main(String[] args) {
//		char[] a = mkArr(5);
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//	}
}