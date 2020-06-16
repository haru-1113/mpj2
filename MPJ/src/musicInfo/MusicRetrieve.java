package musicInfo;

import java.util.ArrayList;

public class MusicRetrieve extends MusicInfo {
	public MusicRetrieve(String Info, String Text) {
		ArrayList<MusicVo> Retrieve = new ArrayList<MusicVo>();
		try {
			connDB();
			String retrieve;
			if (Info.equals("ÀüÃ¼")) {
				retrieve = "SELECT * FROM MUSIC WHERE KUMYONG ='" + Text + "' OR TAEJIN ='" + Text + "' OR M_NAME ='"
						+ Text + "' OR M_SINGER = '" + Text + "'";
			} else if (Info.equals("°î¹øÈ£")) {
				retrieve = "SELECT * FROM MUSIC WHERE KUMYONG ='" + Text + "' OR TAEJIN ='" + Text + "'";
			} else {
				retrieve = "SELECT * FROM MUSIC WHERE " + Info + "= '" + Text + "'";
			}
			System.out.println(retrieve);
			rs = stmt.executeQuery(retrieve);
			while (rs.next()) {
				int ky = rs.getInt("KUMYONG");
				int tj = rs.getInt("TAEJIN");
				String mn = rs.getString("M_NAME");
				String ms = rs.getString("M_SINGER");
				MusicVo data = new MusicVo(ky, tj, mn, ms);
				Retrieve.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
