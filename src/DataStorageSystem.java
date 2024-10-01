import java.util.UUID;

public interface DataStorageSystem {
	public UUID sendData(InputConfig userdata);
	public void recieveData(UUID key);
}

