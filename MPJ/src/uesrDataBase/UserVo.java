package uesrDataBase;

public class UserVo {
	private String ID;
	private String PASSWORD;
	private String NAME;
	private int BIRTH;

	public String getID() {
		return ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getNAME() {
		return NAME;
	}

	public int getBIRTH() {
		return BIRTH;
	}

	public UserVo(String ID, String PASSWORD) {
		this.ID = ID;
		this.PASSWORD = PASSWORD;
	}
}
