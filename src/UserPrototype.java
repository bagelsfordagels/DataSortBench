public class UserPrototype{
	public void prototype(DataStorageSystem dss) {
		//send data to data storage system
		//test to compile
<<<<<<< HEAD
		//key is associated with specific data storage system need
		int key = 1;
		dss.sendData(key);
		
		// retrieve data from storage system
		
		char[] sortedData = dss.recieveData(key);
=======
		String[] arr = {"apple","bannana"};
		//key is associated with specific data storage system needs
		int key = dss.sendData(arr);

		// retrieve data from storage system

		dss.recieveData(key);
		
		InputConfig inputConfig = new InputConfig() {
			
		};
		OutputConfig outputConfig = null;
		ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ',');
>>>>>>> main
	}
}