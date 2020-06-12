package dataBase;

public class MusicVo {
	private int no;
	private int kunyong;
	private int taejin;
	private String m_name;
	private String m_singer;

	public MusicVo() {
	}

	public int getNo() {
		return no;
	}

	public int getKunyong() {
		return kunyong;
	}

	public int getTaejin() {
		return taejin;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_singer() {
		return m_singer;
	}

	public MusicVo(int kunyong, int taejin, String m_name, String m_singer) {
		this.kunyong = kunyong;
		this.taejin = taejin;
		this.m_name = m_name;
		this.m_singer = m_singer;

	}

}
