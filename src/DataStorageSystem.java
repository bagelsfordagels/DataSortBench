import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(InputConfig userdata);
	public ArrayList<Integer> recieveData(UUID key);
	public File mkFile(ArrayList<char[]> charAl) throws IOException;
}

