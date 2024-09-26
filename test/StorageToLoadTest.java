import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class StorageToLoadTest{
	@Test
	public void storageToLoadSmokeTest() {
		StorageToLoadImp testStorageToLoad = new StorageToLoadImp();
		char[] testArray = new char[0];
		if(testStorageToLoad.storedata(testArray).length != testArray.length && testStorageToLoad.storedata(testArray).length <= 0){
			Assertions.fail();
		}
		if(testStorageToLoad.returndata(testArray).length != testArray.length && testStorageToLoad.storedata(testArray).length <= 0){
			Assertions.fail();
		}
	}
}