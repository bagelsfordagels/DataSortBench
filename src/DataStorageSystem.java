import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(int userdata);
	public char[] recieveData(UUID key);
}

