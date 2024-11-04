
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import io.grpc.ManagedChannel;
import com.example.grpc.ComputeServiceGrpc;
import com.example.grpc.ComputeServiceGrpc.ComputeServiceBlockingStub;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;



public class ComputeServiceClient { // Boilerplate TODO: change to <servicename>Client
    private final ComputeServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public ComputeServiceClient(Channel channel) {
        blockingStub = ComputeServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public void order() throws Exception { 
    	Scanner userData = new Scanner(System.in);
		System.out.println("Enter 1 for Integers or 2 for a FileName:");
		
		int userChoice = userData.nextInt();

		ComputeEngineStorageSystem css = new ComputeEngineStorageImplementation();
		if(userChoice == 1) {
			String userInput = "";
			System.out.println("please enter an integer: ");
			
			boolean validInput = false;
			while(validInput == false) {
				userInput = userData.next();
			try {
				InputConfig userInputConfig = new IntegerInputConfig((Integer.parseInt(userInput))); 
				if(userInputConfig.getUserData() > 0) {
					validInput = true;
					UUID key = css.sendData(userInputConfig);
					char[] sortedArr = css.retrieveCharArr(key);
					
					System.out.println("Here is a randomized and sorted char array with length " +userInputConfig.getUserData());
					for(int i = 0; i < sortedArr.length; i++) {
						System.out.print(sortedArr[i] + " ");
					}
					userData.close();
					return;	
				}else {
					System.out.println("Please enter an integer greater than zero");
					
				}		
			}catch(NumberFormatException e) {
				throw new IllegalArgumentException("Please enter a value larger than zero: " + e.getMessage());
			}
			}

			
		}
		if(userChoice == 2) {
			System.out.println("Enter the file name: ");
			String fileName = userData.next();
			InputConfig userFileInputConfig = new FileInputConfig(fileName);
			UUID key = css.sendData(userFileInputConfig);
			ArrayList<char[]> userCharAl = css.retrieveCharAl(key);
			for(char[] arr : userCharAl) {
				System.out.println(arr);
			}
		} else {
			System.out.println("Incorrect input");
		}
		
		userData.close();
		
	}
	
    public static void main(String[] args) throws Exception {
        String target = "localhost:50051";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            ComputeServiceClient client = new ComputeServiceClient(channel); // Boilerplate TODO: update to this class name
            client.order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
