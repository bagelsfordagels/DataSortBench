import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorageImplementation implements DataStorageSystem{
//	private int userData;
//	private String fileName;
//	private char[] result;
	String usersFileData = null;
	String line = null;
////
//	
//
//	public DataStorageImplementation(int userInt) {
//		// TODO Auto-generated constructor stub
//		userData = userInt;
//	}
//	
//	public DataStorageImplementation(String fileName) {
//		this.fileName = fileName;
//	}
//
//	public void dataStorageImplementaion(int userData) {
//		this.userData = userData;
//		this.result = null; 
//	}
//	@Override
//	public char[] sendData(int key) {
//		// TODO Auto-generated method stub
//		char[] c = {'h'};
//		return c;
//	}
//
//	@Override
//	public char[] recieveData(int key) {
//		// TODO Auto-generated method stub
//		char[] c = {'h'};
//		return c;
//	}
	
	
	private Map<UUID, InputConfig> dataStore = new HashMap<>();

	public UUID sendData(InputConfig userData) {
        UUID key = UUID.randomUUID();
        dataStore.put(key, userData);
        return key;
    }

	public ArrayList<Integer> recieveData(UUID key) {
		ArrayList<Integer> userInts = new ArrayList<>();
        InputConfig fileName = dataStore.get(key);
        try(FileReader in = new FileReader(fileName.getUserFileData() +".txt")){
			BufferedReader br = new BufferedReader(in);
			//grabbing the next line and adding it to line String to store file as a string for FileInputConfig
			while((line = br.readLine()) != null) {
				userInts.add(Integer.parseInt(line));
			}
		//catching possible errors while reading the file (Ex: File not found)
		}catch(IOException e){
			System.out.println("Error while reading file");
		}
        
		return userInts;
    }
	
	public File mkFile(ArrayList<char[]> charAl) throws IOException{
		File userFile = new File("UserData.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("UserData.txt"));
			
	        for (char[] characterArray : charAl) {
	            for (char character : characterArray) {
	                writer.write(character);
	            }
	            writer.newLine();
	        }

	        writer.close();
		}catch(IOException e) {
			System.out.println("Error while writing file");
		}
		
		return userFile;
	}
}