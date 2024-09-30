import java.util.Scanner;
import java.util.UUID;

public class UserInterface{
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner userData = new Scanner(System.in);
		System.out.println("please enter an integer: ");
		
		int userInt = userData.nextInt();
		
		
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		UUID key = css.sendData(userInt);
		char[] sortedArr = css.retreiveSortedData(key);
		
		for(int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i] + " ");
		}
		
	}
	
	
	
	
}