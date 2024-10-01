import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface{
	public static void main(String[] args) throws Exception {
		

		Scanner userData = new Scanner(System.in);
		System.out.println("If you would like to enter an integer enter 1/nif you would like to enter a file enter 2:");
		
		int userChoice = 0;
		do {
			try {
				userChoice = userData.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter 1 or a file name.");
				userData.nextLine(); // Clear the invalid input from the scanner buffer
			}
		}while(true);
		
		
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
			System.out.println("Incorrect input");
		}
		
		userData.close();
		
	}
	
	
	
	
}