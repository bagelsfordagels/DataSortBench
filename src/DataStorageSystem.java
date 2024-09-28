import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(int Userdata);
	public char[] recieveData(UUID key);
}

