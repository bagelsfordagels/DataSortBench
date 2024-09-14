public class StoragePrototype{
	public void prototype(StorageToLoad stl) {
		int[] arr = {1,2,3};
		//stores the data and gives it a key to be accessed later
		int key = stl.storedata(arr);
		//takes the key given to find and give back the sorted array
		stl.returndata(key);
	}
}
	