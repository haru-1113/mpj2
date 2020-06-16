package uesrDataBase;

public class InfoUpdate extends UserInfo {
	public InfoUpdate(String id, String password, String newPassword) {
		try {
			connDB();
			String Read = "SELECT ID,PASSWORD FROM USERINFO WHERE ID = '" + id + "' AND PASSWORD = '" + password + "'";
			rs = stmt.executeQuery(Read);
			while (rs.next()) {
				String ID = rs.getString("ID");
				String PWD = rs.getString("PASSWORD");
				UserVo data = new UserVo(ID, PWD);
			}
			String update = "UPDATE USERINFO SET PASSWORD = '" + newPassword + "'";
			rs = stmt.executeQuery(update);
		} catch (Exception e) {

		}
	}
}
