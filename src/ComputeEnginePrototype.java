import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ComputeEnginePrototype implements ComputeEngineStorageSystem{
	public void prototype(ComputeEngineStorageSystem cess) throws Exception {
		//send data to compute engine
		//test to compile
		char[] arr = {'a','b'};
		//key is associated with certain data compute engine needs
		InputConfig i = new IntegerInputConfig(1);
		UUID key =  cess.sendData(i);
		
		//receive data from compute engine
		//key is associated with sorted data
		//cess.retreiveSortedData(key);
	}




	@Override
	public UUID sendData(InputConfig userData) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public char[] retreiveCharArr(UUID key) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<char[]> retreiveCharAl(UUID key) throws IOException {
		return null;
		// TODO Auto-generated method stub
		
	}




	@Override
	public File userFile(ArrayList<char[]> al) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

 
}