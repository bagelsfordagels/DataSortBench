import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(InputConfig userdata) throws Exception;
	public ArrayList<Integer> recieveData(UUID key) throws Exception;
	public File mkFile(ArrayList<char[]> charAl) throws IOException;
}

