import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ComputeEngine{
	//method to do convert int to randomized char array
	int userInt;
	//the 2 strings are used when reading in a file
	String usersFileData = null;
	String line = null;
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
	
	public ArrayList<char[]> readFile(InputConfig fileName) {
		try(FileReader in = new FileReader(fileName +".txt")){
			BufferedReader br = new BufferedReader(in);
			//grabbing the next line and adding it to line String to store file as a string for FileInputConfig
			while((line = br.readLine()) != null) {
				usersFileData += line;
			}
		//catching possible errors while reading the file (Ex: File not found)
		}catch(IOException e){
			System.out.println("Error while reading file");
		}
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		char[] a = mkArr(5);
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//	}
}