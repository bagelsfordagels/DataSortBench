public class UserPrototype{
	public void prototype(DataStorageSystem dss) {
		//send data to data storage system
		//test to compile
		String[] arr = {"apple","bannana"};
		//key is associated with specific data storage system needs
		char[] c = dss.sendData(1);

		// retrieve data from storage system

		dss.recieveData(1);
		
		InputConfig inputConfig = new InputConfig() {
			
		};
		OutputConfig outputConfig = null;
		ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ',');

	}
}