public class UserPrototype{
	public void prototype(DataStorageSystem dss) {
		//send data to data storage system
		//test to compile
		//key is associated with specific data storage system need
		int key = 1;
		dss.sendData(key);
		
		// retrieve data from storage system
		
		char[] sortedData = dss.recieveData(key);
	}
}