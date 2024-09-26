public class StoragePrototype{
	public void prototype(StorageToLoad stl) {
		char[] arr = {'a','b','c'};
		//stores the data and gives it a key to be accessed later
		stl.storedata(arr);
		//takes the key given to find and give back the sorted array
		stl.returndata(arr);
	}
}
	