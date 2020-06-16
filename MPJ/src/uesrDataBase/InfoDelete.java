package uesrDataBase;

public class InfoDelete extends UserInfo {
	public InfoDelete(String id, String password, String repassword) {
		if (password.equals(repassword)) {
			try {
				connDB();
				String drop = "DROP TABLE " + id;
				rs = stmt.executeQuery(drop);
				String delete = "DELETE FROM USERINFO WHERE ID = '" + id + "'AND PASSWORD ='" + password + "'";
				rs = stmt.executeQuery(delete);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}

	}
}
