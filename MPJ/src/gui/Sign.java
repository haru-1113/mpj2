package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uesrDataBase.InfoRetrieve;

public class Sign extends JDialog {
	public Main m = new Main();
	public JDialog login = new JDialog(m.f, "로그인", true);
	public JLabel lid, lpwd;
	public JButton SI, SU, Can;
	public JTextField id, pwd;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			Sign dialog = new Sign();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openwindow() {
		m.sign.setText("로그인중...");
		login.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public Sign() {
		lid = new JLabel("ID : ");
		lpwd = new JLabel("PASSWORD : ");
		id = new JTextField(10);
		pwd = new JTextField(10);
		SI = new JButton("로그인");
		SU = new JButton("회원가입");
		Can = new JButton("돌아가기");
		login.setLayout(null);
		login.setSize(385, 300);
		lid.setBounds(91, 85, 23, 15);
		lpwd.setBounds(45, 135, 82, 15);
		id.setBounds(139, 82, 116, 21);
		pwd.setBounds(139, 132, 116, 21);
		SI.setBounds(178, 228, 89, 23);
		Can.setBounds(272, 228, 89, 23);
		SU.setBounds(12, 228, 97, 23);
		login.add(lid);
		login.add(id);
		login.add(lpwd);
		login.add(pwd);
		login.add(SU);
		login.add(SI);
		login.add(Can);
		SI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoRetrieve ir = new InfoRetrieve(id.getText(), pwd.getText());

			}
		});
		SU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp s = new SignUp();
				s.openWindow();
			}
		});
		Can.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.dispose();

				m.sign.setText("로그인");
				m.sign.setSelected(false);
//				login.dispose();
			}
		});
		login.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				m.sign.setText("로그인");
				m.sign.setSelected(false);
				login.dispose();
			}
		});
	}

}
