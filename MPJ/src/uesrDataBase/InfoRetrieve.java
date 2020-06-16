package uesrDataBase;


public class InfoRetrieve extends UserInfo {
	public InfoRetrieve(String id, String password) {
		boolean ok = false;
		try {
			connDB();
			String retrieve = "SELECT ID , PASSWORD FROM USERINFO WHERE ID = '" + id + "' AND PASSWORD = '" + password
					+ "'";
			System.out.println(retrieve);
		} catch (Exception e) {
			ok = false;
			System.out.println(ok);
			e.printStackTrace();
		}
	}
}
