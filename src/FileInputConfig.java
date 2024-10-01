public class FileInputConfig implements InputConfig{
	String fileName;
	
	public FileInputConfig(String fileName) {
		this.fileName = fileName;
	}
	public int getUserData() {
		return 0;
	}
	public String getUserFileData() {
		return fileName;
	}
}