public class userPrototype{
	public void prototype(DataStorageSystem dss) {
		//send data to data storage system
		//test to compile
		String[] arr = {"apple","bannana"};
		//key is associated with specific data storage system needs
		int key = dss.sendData(arr);
		
		// retrieve data from storage system
		
		dss.recieveData(key);
	}
}