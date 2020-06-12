package dataBase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MusicDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	String user = "norebang";

	String password = "kosea2019a";

	private Connection con;

	private Statement stmt;

	private ResultSet rs;

	public ArrayList<MusicVo> search(String term, String getText) {
		ArrayList<MusicVo> search = new ArrayList<MusicVo>();
		boolean ok = false;
		try {
			connDB();
			if (term != "전체검색") {
				String query = "";
				switch (term) {
				case "제목검색":
					term = "m_name";
					query = "SELECT * FROM MUSIC WHERE " + term + "='" + getText + "'";
					break;
				case "가수검색":
					term = "m_singer";
					query = "SELECT * FROM MUSIC WHERE " + term + "='" + getText + "'";
					break;
				case "번호검색":
					term = "kumyong";
					String term2 = "taejin";
					query = "SELECT * FROM MUSIC WHERE " + term + "='" + getText + "' or " + term2 + "='" + getText
							+ "'";
					break;
				}
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					int ky = rs.getInt("kumyong");
					int tj = rs.getInt("taejin");
					String name = rs.getString("m_name");
					String singer = rs.getString("m_singer");
					MusicVo data = new MusicVo(ky, tj, name, singer);
					search.add(data);
				}

			} else {
				String query = "SELECT * FROM MUSIC WHERE kumyong = '" + getText + "' or taejin ='" + getText
						+ "' or m_name ='" + getText + "' or m_singer ='" + getText + "'";
				System.out.println(query);
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					int ky = rs.getInt("kumyong");
					int tj = rs.getInt("taejin");
					String name = rs.getString("m_name");
					String singer = rs.getString("m_singer");
					MusicVo data = new MusicVo(ky, tj, name, singer);
					search.add(data);
				}
				ok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return search;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public ArrayList<MusicVo> Signup(String ID, String PWS, String NAME, String BIRTH) {
		ArrayList<MusicVo> SignUp = new ArrayList<MusicVo>();
		try {
			connDB();
			String query = "INSERT INTO USERINFO values  ('" + ID + "','" + PWS + "','" + NAME + "','" + BIRTH + "')";
			System.out.println(query);
			rs = stmt.executeQuery(query);

			String newTable = "CREATE TABLE " + ID
					+ "(no number not null, KY number , TJ number, MUSIC varchar2(38), SINGER varchar2(38), constraint pk_"
					+ ID + " primary key(no))";
			System.out.println(newTable);
			rs = stmt.executeQuery(newTable);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return SignUp;

	}

	public void connDB() {

		try {

			Class.forName(driver);

			System.out.println("stock driver loading success.");

			con = DriverManager.getConnection(url, user, password);

			System.out.println("oracle connection success.");

			stmt = con.createStatement();

			System.out.println("statement create success.");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
