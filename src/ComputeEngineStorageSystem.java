import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface ComputeEngineStorageSystem {
	UUID sendData(InputConfig userData) throws Exception;
	ArrayList<char[]> retrieveCharAl(UUID key) throws IOException, Exception;
	File userFile(ArrayList<char[]> al) throws IOException;
	char[] retrieveCharArr(UUID key) throws Exception;
	
}
