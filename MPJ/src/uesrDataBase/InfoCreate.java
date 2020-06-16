package uesrDataBase;

public class InfoCreate extends UserInfo {
	public InfoCreate(String id, String password, String name, String string) {
		try {
			connDB();
			String UserInfo = "INSERT INTO USERINFO values  ('" + id + "','" + password + "','" + name + "','" + string
					+ "')";
			rs = stmt.executeQuery(UserInfo);
			String CreateFavorite = "CREATE TABLE " + id
					+ "(no number not null, KY number , TJ number, MUSIC varchar2(38), SINGER varchar2(38), constraint pk_"
					+ id + " primary key(no))";
			rs = stmt.executeQuery(CreateFavorite);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
