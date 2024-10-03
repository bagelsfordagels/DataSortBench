import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class UserInterface{
	public static void main(String[] args){
		//the 2 strings are used when reading in a file
		String usersFileData = null;
		String line = null;

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
			char[] sortedArr = css.retreiveSortedData(key);
			
			for(int i = 0; i < sortedArr.length; i++) {
				System.out.print(sortedArr[i] + " ");
			}
			userData.close();
			return;
			
		}
		if(userChoice == 2) {
			System.out.println("Enter the file name: ");
			String fileName = userData.next();
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
			InputConfig userFileInputConfig = new FileInputConfig(usersFileData);
			
			UUID key = css.sendData(userFileInputConfig);
			css.retreiveSortedData(key);
		} else {
			System.out.println("Incorrect input");
		}
		
		userData.close();
		
	}
	
	
	
	
}