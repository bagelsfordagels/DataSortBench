import java.util.Scanner;
import java.util.UUID;

public class UserInterface{
	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		Scanner userData = new Scanner(System.in);
		System.out.println("If you would like to enter an integer enter 1/nif you would like to enter a file enter 2:");
		
		int userChoice = userData.nextInt();
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		if(userChoice == 1) {
			System.out.println("please enter an integer: ");
			
			String userInput = userData.next();
			
			InputConfig userInputConfig = new IntegerInputConfig((Integer.parseInt(userInput))); 
			
			
			
			UUID key = css.sendData(userInputConfig);
			char[] sortedArr = css.retreiveSortedData(key);
			
			for(int i = 0; i < sortedArr.length; i++) {
				System.out.print(sortedArr[i] + " ");
			}
		}
		if(userChoice == 2) {
			System.out.println("Enter the file name: ");
			String userInput = userData.next();
			
			InputConfig userFileInputConfig = new FileInputConfig(userInput);
			
			UUID key = css.sendData(userFileInputConfig);
			css.retreiveSortedData(key);

			
		}
		else {
			throw new Exception("Incorrect input");
		}
		
		
	}
	
	
	
	
}