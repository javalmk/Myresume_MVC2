package test.users.dto;

// UsersDto
public class TB_USERDto {
	private String id;
	private String password;
	private String email;
	private String phone_no;
	private String is_admin;
	private String regdate;
	private String name;
	
	/*fileDto 내용*/
	private int num;
	private String orgFileName; // 원본 파일명
	private String saveFileName; // 저장된 파일명
	private long fileSize; // 파일의 크기 byte 는 큰 숫자 일수 있으므로
	
	public TB_USERDto() {}

	public TB_USERDto(String id, String password, String email, String phone_no, String is_admin, String regdate,
			String name) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone_no = phone_no;
		this.is_admin = is_admin;
		this.regdate = regdate;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
