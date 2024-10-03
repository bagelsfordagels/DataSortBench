import java.util.ArrayList;
import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(InputConfig userdata);
	public ArrayList<Integer> recieveData(UUID key);
}

