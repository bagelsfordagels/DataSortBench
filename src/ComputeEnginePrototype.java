public class ComputeEnginePrototype{
	public void prototype(ComputeEngineStorageSystem cess) {
		//send data to compute engine
		//test to compile
		char[] arr = {'a','b'};
		//key is associated with certain data compute engine needs
		int key =  cess.sendData(1);
		
		//receive data from compute engine
		//key is associated with sorted data
		cess.retreiveSortedData(key);
	}

 
}