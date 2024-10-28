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
	
	public static char[] mkArr(InputConfig userData) throws Exception{
//		if(userData == null) {
//			throw new IllegalArgumentException("User data cannot be null");
//		}
//		try {
//			char[] randomArr = new char[userData.getUserData()];
//			Random random = new Random();
//			
//	        for (int i = 0; i < userData.getUserData(); i++) {
//	            // Generate a random character between 'a' and 'z' (lowercase letters)
//	            char randomChar = (char) ('a' + random.nextInt(26));
//	            randomArr[i] = randomChar;
//	        }
//	        Arrays.sort(randomArr);
//	        return randomArr;
//		}catch(IllegalArgumentException e) {
//			throw new IllegalArgumentException("Invalid user data" +userData);
//		}catch(Exception e) {
//			throw new RuntimeException("Error creating array");
//		}
		return mkArr(userData, false);
		
	}
	
	public static char[] mkArr(InputConfig userData, boolean deterministic) throws Exception{
		if(userData == null) {
			throw new IllegalArgumentException("User data cannot be null");
		}
		try {
			char[] randomArr = new char[userData.getUserData()];
			Random random;
			
			if(deterministic) { // to get a fixed value
				random = new Random(0); // have random equal zero 
				
			} else {
				random = new Random();
			}
			
	        for (int i = 0; i < userData.getUserData(); i++) {
	            // Generate a random character between 'a' and 'z' (lowercase letters)
	            char randomChar = (char) ('a' + random.nextInt(26));
	            randomArr[i] = randomChar;
	        }
	        Arrays.sort(randomArr);
	        return randomArr;
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid user data" +userData);
		}catch(Exception e) {
			throw new RuntimeException("Error creating array");
		}
		
	}
	
	public char[] readFile(Integer userInt) throws Exception{
//		if(userInts == null) {
//			throw new IllegalArgumentException("ArrayList cannot be null");
//		}
//		try {
//			ArrayList<char[]> listCharArrs = new ArrayList<>();
//			for(int j = 0; j<userInts.size();j++) {
//				char[] randomArr = new char[userInts.get(j)];
//				Random random = new Random();
//
//		        for (int i = 0; i < userInts.get(j); i++) {
//		            // Generate a random character between 'a' and 'z' (lowercase letters)
//		            char randomChar = (char) ('a' + random.nextInt(26));
//		            randomArr[i] = randomChar;
//		        }
//		        Arrays.sort(randomArr);
//		        listCharArrs.add(randomArr);
//			}
//			return listCharArrs;
//		}catch(IllegalArgumentException e) {
//			throw new IllegalArgumentException("Invalid ArrayList" +userInts);
//		}catch(Exception e) {
//			throw new RuntimeException("Error creating ArrayList");
//		}
		
		if (userInt <= 0) {
	        throw new IllegalArgumentException("Input integer must be positive");
	    }
	    try {
	        char[] randomArr = new char[userInt];
	        Random random = new Random();


	        for (int i = 0; i < userInt; i++) {
	            // Generate a random character between 'a' and 'z' (lowercase letters)
	            char randomChar = (char) ('a' + random.nextInt(26));
	            randomArr[i] = randomChar;
	        }
	        Arrays.sort(randomArr);
	        return randomArr;
	    } catch (IllegalArgumentException e) {
	        throw new IllegalArgumentException("Invalid integer: " + userInt);
	    } catch (Exception e) {
	        throw new RuntimeException("Error creating character array");
	    }
		
		
	}
	
	
	
//	public static void main(String[] args) {
//		char[] a = mkArr(5);
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//	}
}