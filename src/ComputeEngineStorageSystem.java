import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface ComputeEngineStorageSystem {
	UUID sendData(InputConfig userData) throws Exception;
	char[] retreiveCharArr(UUID key) throws Exception;
	ArrayList<char[]> retreiveCharAl(UUID key) throws IOException, Exception;
	
}
