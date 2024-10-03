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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserPrototype implements DataStorageSystem{
	    public void prototype(DataStorageSystem dss) {
	        // Send data to data storage system
	        InputConfig data = new IntegerInputConfig(1);
	        UUID key = dss.sendData(data);

	        // Retrieve data from storage system
	        dss.recieveData(key);

	    }
	    
	    private Map<UUID, InputConfig> dataStore = new HashMap<>();

		@Override
		public UUID sendData(InputConfig userData) {
	        UUID key = UUID.randomUUID();
	        dataStore.put(key, userData);
	        return key;
	    }

		@Override
		public ArrayList<Integer> recieveData(UUID key) {
	        InputConfig storedData = dataStore.get(key);
	        return null;
	    }
	}
