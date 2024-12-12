
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.example.grpc.ComputeServiceGrpc;
import com.example.grpc.ComputeServiceGrpc.ComputeServiceBlockingStub;
import com.example.grpc.Service.CSRetreiveAlRequest;
import com.example.grpc.Service.CSRetreiveAlResponse;
import com.example.grpc.Service.CSRetreiveArrRequest;
import com.example.grpc.Service.CSRetreiveArrResponse;
import com.example.grpc.Service.CSSendDataRequest;
import com.example.grpc.Service.CSSendDataResponse;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;



public class ComputeServiceClient implements ComputeEngineStorageSystem{ // Boilerplate TODO: change to <servicename>Client
    private final ComputeServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public ComputeServiceClient(Channel channel) {
        blockingStub = ComputeServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public void order() throws Exception { 
    	Scanner userData = new Scanner(System.in);
		System.out.println("Enter 1 for Integers or 2 for a FileName:");
		
		int userChoice = userData.nextInt();
		
//		 String target = "localhost:50052";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

//	     ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
//	    		 .build();

		//ComputeEngineStorageSystem css = new ComputeServiceClient(channel);
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
					UUID key = sendData(userInputConfig);
					char[] sortedArr = retrieveCharArr(key);
					
					System.out.println("Here is a randomized and sorted char array with length " +userInputConfig.getUserData());
					for(int i = 0; i < sortedArr.length; i++) {
						if(i % 10 == 0) {  // print new line if line is 10 in length
							System.out.println();						
						}
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
			UUID key = sendData(userFileInputConfig);
			ArrayList<char[]> userCharAl = retrieveCharAl(key);
			System.out.println("Here are the randomized arrays from the file\n");
			for(int i = 0; i < userCharAl.size(); i++) {
				for(char c : userCharAl.get(i)) {
					System.out.print(c + " ");
				}
				System.out.println();
			}
			System.out.println("\nA file called UserData.txt was created with the arrays");
//			for(char[] arr : userCharAl) {
//				System.out.print(arr);
//			}
		} else {
			System.out.println("Incorrect input");
		}
		userData.close();
		
	}
	
    public static void main(String[] args) throws Exception {
        String target = "localhost:50052";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            ComputeServiceClient client = new ComputeServiceClient(channel); // Boilerplate TODO: update to this class name
            client.order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

	@Override
	public UUID sendData(InputConfig userData) throws Exception {
		if(userData instanceof IntegerInputConfig) {
			CSSendDataRequest request = CSSendDataRequest.newBuilder().setIntInput(userData.getUserData()).build();  
			CSSendDataResponse response;
			try {
				response = blockingStub.sendData(request);
				
				if(response.getUuid().isEmpty()) {
					throw new RuntimeException("Server returned an empty UUID");
				}
				return UUID.fromString(response.getUuid());
			} catch (StatusRuntimeException e) {
				throw new RuntimeException("Error for integer input" + e);
			}
			
		}else {
//			String file = "";
//			BufferedReader br = new BufferedReader(new FileReader(userData.getUserFileData()));
//			String line; 
//			while((line = br.readLine()) != null){
//				file = file + line;
//			}
//			br.close();
			CSSendDataRequest request = CSSendDataRequest.newBuilder().setUserData(userData.getUserFileData()).build();
			CSSendDataResponse response;
		    try {
		        response = blockingStub.sendData(request);
		    } catch (StatusRuntimeException e) {
		        e.printStackTrace();
		        return null;
		    }		   
			return UUID.fromString(response.getUuid());
		}
			
	}

	@Override
	public ArrayList<char[]> retrieveCharAl(UUID key, String fileName) throws IOException, Exception {
		CSRetreiveAlRequest request = CSRetreiveAlRequest.newBuilder().setUuid(key.toString()).build();
		CSRetreiveAlResponse response;
		try {
			response = blockingStub.retrieveCharAl(request);
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(response);
		
		List<String> strList = response.getCharArraysList();
		ArrayList<char[]> charAl = new ArrayList<>();
		
		
	
		for(String s : strList) {
				charAl.add(s.toCharArray());

		}

//		
//		for(int i = 0; i < strList.size(); i++) {
//			String str = strList.get(i);
//			char[] arr = str.toCharArray();
//			charAl.add(arr);
//		}
		
//		for(int i = 0; i < response.getCharArraysCount(); i++) {
//			String strResponse = response.getCharArrays(i);
//			char[] arr = strResponse.toCharArray();
//			charAl.add(arr);	
//		}

		

//		Scanner reader = new Scanner(new FileReader(fileName));
//	
//		ArrayList<Integer> numOfElements = new ArrayList<>();
//		while(reader.hasNextLine()) {
//			numOfElements.add(reader.nextInt());
//		}
//		reader.close();
//		
//		
//		int currentIndex = 0;
//		
//		for(int n : numOfElements) {
//			String substring = stringResponse.substring(currentIndex, numOfElements.get(n));
//			charAl.add(substring.toCharArray());
//			currentIndex += numOfElements.get(n);
//		}
		return charAl;
	}

	@Override
	public File userFile(ArrayList<char[]> al) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] retrieveCharArr(UUID key) throws Exception {
		CSRetreiveArrRequest request = CSRetreiveArrRequest.newBuilder().setUuid(key.toString()).build();
		CSRetreiveArrResponse response;
		try {
			response = blockingStub.retrieveCharArr(request);
		} catch(StatusRuntimeException e) {
			e.printStackTrace();
			System.out.println("Error with the charArr");
			char[] charArr = {};
			return charArr;
		}
		
		List<String> stringResponse = response.getCharArrayList();
		char[] arr = new char[stringResponse.size()];
		
		int index = 0;
		
		for(String s : stringResponse) {
			for(char c : s.toCharArray()) {
				arr[index++] = c;
			}
		}
		
		
//		char[] arr = new char[stringResponse.length()];
//		
//		for(int i = 0; i < response.getCharArrayCount(); i++) {
//			String strResponse = response.getCharArray(i);
//			
//		}
//		
//		
//		for(int i = 0; i < stringResponse.length(); i++) {
//			arr[i] = stringResponse.charAt(i);
//		}
		return arr;
	}

	@Override
	public ArrayList<char[]> retrieveCharAl(UUID key) throws IOException, Exception {
		// TODO Auto-generated method stub
		return retrieveCharAl(key, "UserData.txt");
	}
	
}
