package test.file.dto;

public class FileDto {
	private int num;
	private String id;
	private String orgFileName; // 원본 파일명
	private String saveFileName; // 저장된 파일명
	private long fileSize; // 파일의 크기 byte 는 큰 숫자 일수 있으므로

	public FileDto() {
	}

	public FileDto(int num, String id, String orgFileName, String saveFileName, long fileSize) {
		super();
		this.num = num;
		this.id = id;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.fileSize = fileSize;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
