package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import musicInfo.MusicRetrieve;

public class Main extends Frame {
	public static JButton search, Favorite;
	public static JComboBox<String> term;
	public static JTextField Tx;
	public static JToggleButton sign;
	public static Sign s = new Sign();

	public Main() {
		search = new JButton("검색");
		term = new JComboBox<>(new String[] { "전체검색", "곡명", "가수명", "번호" });
		Tx = new JTextField();
		Favorite = new JButton("즐겨찾기");
		sign = new JToggleButton("로그인");
		f.add(term);
		f.add(Tx);
		f.add(search);
		f.add(sign);
		f.add(Favorite);
		term.setBounds(30, 75, 64, 23);
		Tx.setBounds(93, 75, 219, 23);
		sign.setBounds(310, 10, 112, 23);
		search.setBounds(311, 75, 71, 23);
		Favorite.setBounds(311, 42, 111, 23);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String te = "";
				switch ((String) term.getSelectedItem()) {
				case "전체검색":
					te = "전체";
					break;
				case "곡명":
					te = "M_NAME";
					break;
				case "가수명":
					te = "M_SINGER";
					break;
				case "번호":
					te = "곡번호";
					break;
				}

				MusicRetrieve mr = new MusicRetrieve(te, Tx.getText());
			}
		});
		sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				s.openwindow();
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}
