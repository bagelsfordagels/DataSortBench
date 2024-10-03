import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ComputeEngine{
	//method to do convert int to randomized char array
	int userInt;
	//the 2 strings are used when reading in a file
	
	//public ComputeEngine(int userInt) {
		//this.userInt = userInt;
	//}
	
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
	
	public ArrayList<char[]> readFile(ArrayList<Integer> userInts) {
		ArrayList<char[]> listCharArrs = new ArrayList<>();
		for(int j = 0; j<userInts.size();j++) {
			char[] randomArr = new char[userInts.get(j)];
			Random random = new Random();

	        for (int i = 0; i < userInts.get(j); i++) {
	            // Generate a random character between 'a' and 'z' (lowercase letters)
	            char randomChar = (char) ('a' + random.nextInt(26));
	            randomArr[i] = randomChar;
	        }
	        Arrays.sort(randomArr);
	        listCharArrs.add(randomArr);
		}
		return listCharArrs;
		
	}
	
	
	
//	public static void main(String[] args) {
//		char[] a = mkArr(5);
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//	}
}