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
		search = new JButton("�˻�");
		term = new JComboBox<>(new String[] { "��ü�˻�", "���", "������", "��ȣ" });
		Tx = new JTextField();
		Favorite = new JButton("���ã��");
		sign = new JToggleButton("�α���");
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
				case "��ü�˻�":
					te = "��ü";
					break;
				case "���":
					te = "M_NAME";
					break;
				case "������":
					te = "M_SINGER";
					break;
				case "��ȣ":
					te = "���ȣ";
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
