
public class TestInputConfig implements InputConfig{
	int userInt;
	public TestInputConfig(int userInt) {
		this.userInt = userInt;
	}
	
	@Override
	public int getUserData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUserFileData() {
		// TODO Auto-generated method stub
		return null;
	}
}