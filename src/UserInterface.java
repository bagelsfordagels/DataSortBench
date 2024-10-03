import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class UserInterface{
	public static void main(String[] args) throws IOException{
		

		Scanner userData = new Scanner(System.in);
		System.out.println("Enter 1 for Integers or 2 for a FileName:");
		
		int userChoice = userData.nextInt();
////		do {
////			try {
////				userChoice = userData.nextInt();
////				break;
////			} catch(InputMismatchException e) {
////				System.out.println("Invalid input. Please enter 1 or a file name.");
////				userData.nextLine(); // Clear the invalid input from the scanner buffer
////			}
//		}while(true);
		
		
		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		if(userChoice == 1) {
			System.out.println("please enter an integer: ");
			
			String userInput = userData.next();
			
			InputConfig userInputConfig = new IntegerInputConfig((Integer.parseInt(userInput))); 
			
			
			UUID key = css.sendData(userInputConfig);
			char[] sortedArr = css.retreiveCharArr(key);
			
			for(int i = 0; i < sortedArr.length; i++) {
				System.out.print(sortedArr[i] + " ");
			}
			userData.close();
			return;	
		}
		if(userChoice == 2) {
			System.out.println("Enter the file name: ");
			String fileName = userData.next();
			InputConfig userFileInputConfig = new FileInputConfig(fileName);
			UUID key = css.sendData(userFileInputConfig);
			ArrayList<char[]> userCharAl = css.retreiveCharAl(key);
			for(char[] arr : userCharAl) {
				System.out.println(arr);
			}
		} else {
			System.out.println("Incorrect input");
		}
		
		userData.close();
		
	}
	
	
	
	
}