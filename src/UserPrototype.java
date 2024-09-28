//public class UserPrototype{
//	public void prototype(DataStorageSystem dss) {
//		//send data to data storage system
//		//test to compile
//		String[] arr = {"apple","bannana"};
//		//key is associated with specific data storage system needs
//		char[] c = dss.sendData(1);
//
//		// retrieve data from storage system
//
//		dss.recieveData(1);
//		
//		InputConfig inputConfig = new InputConfig() {
//			
//		};
//		
//		OutputConfig outputConfig = null;
//		ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ',');
//
//	}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserPrototype implements DataStorageSystem{
	    public void prototype(DataStorageSystem dss) {
	        // Send data to data storage system
	        int data = 1;
	        UUID key = dss.sendData(data);

	        // Retrieve data from storage system
	        char[] result = dss.recieveData(key);

	        // Process the result
	        System.out.println("Received data: " + Arrays.toString(result));
	    }
	    
	    private Map<UUID, Integer> dataStore = new HashMap<>();

		@Override
		public UUID sendData(int userData) {
	        UUID key = UUID.randomUUID();
	        dataStore.put(key, userData);
	        return key;
	    }

		@Override
		public char[] recieveData(UUID key) {
	        Integer storedData = dataStore.get(key);
	        char[] result = new char[storedData];
	        for (int i = 0; i < storedData; i++) {
	            result[i] = (char) (storedData + '0'); // Convert int to char
	        }
	        return result;
	    }
	}
