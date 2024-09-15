public class ComputeEnginePrototype{
	public void prototype(ComputeEngineStorageSystem cess) {
		//send data to compute engine
		//test to compile
		String[] arr = {"apple","bannana"};
		//key is associated with certain data compute engine needs
		int key =  cess.sendData(arr);
		
		//receive data from compute engine
		//key is associated with sorted data
		cess.retreiveData(key);
	}

 
}