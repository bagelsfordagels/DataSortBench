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

public class DSImpOptimization implements DataStorageSystem{
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

	public UUID sendData(InputConfig userData) throws Exception{
		if(userData == null) {
			throw new IllegalArgumentException("User data cannot be null");
		}
        UUID key = UUID.randomUUID();
        try {
        	dataStore.put(key, userData);
        }catch(IllegalArgumentException e){
        	throw new IllegalArgumentException("Invalid InputConfig: " +userData);
        }catch(Exception e) {
        	throw new Exception("Error Storing data in dataStore" +e);
        }
        return key;
    }

	public ArrayList<Integer> recieveData(UUID key) throws Exception{
		if(key == null) {
			throw new IllegalArgumentException("key can't be null");
		}
		ArrayList<Integer> userInts = new ArrayList<>();
        InputConfig fileName = dataStore.get(key);
        try(FileReader in = new FileReader(fileName.getUserFileData())){
			BufferedReader br = new BufferedReader(in);
			//grabbing the next line and adding it to line String to store file as a string for FileInputConfig
			while((line = br.readLine()) != null) {
				userInts.add(Integer.parseInt(line));
			}
		//catching possible errors while reading the file (Ex: File not found)
		}catch(IOException e){
			System.out.println("Error while reading file" + e.getMessage());
			e.printStackTrace();
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Invalid key: "+ key,e);
		}
		return userInts;
    }
	public File mkFile(ArrayList<char[]> charAl, String file) {
		if(charAl == null) {
			throw new IllegalArgumentException("ArrayList<char[] can't be null");
		}
		File userFile = new File(file);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
	        for (char[] characterArray : charAl) {
	            String strCharArr = String.valueOf(characterArray);
	            writer.write(strCharArr);
	            writer.newLine();
	        }

	        writer.close();
		}catch(IOException e) {
			System.out.println("Error while writing file");
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Invalid ArrayList: "+ charAl,e);
		}
		
		return userFile;
	}
	public File mkFile(ArrayList<char[]> charAl) throws IOException{
//		if(charAl == null) {
//			throw new IllegalArgumentException("ArrayList<char[] can't be null");
//		}
//		File userFile = new File("UserData.txt");
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("UserData.txt"));
//			
//	        for (char[] characterArray : charAl) {
//	            for (char character : characterArray) {
//	                writer.write(character);
//	            }
//	            writer.newLine();
//	        }
//
//	        writer.close();
//		}catch(IOException e) {
//			System.out.println("Error while writing file");
//		}catch(IllegalArgumentException e){
//			throw new IllegalArgumentException("Invalid ArrayList: "+ charAl,e);
//		}
//		
//		return userFile;
		return mkFile(charAl, "UserData.txt");
	}
}