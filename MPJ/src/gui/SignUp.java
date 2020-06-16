package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uesrDataBase.InfoCreate;

public class SignUp extends JDialog {
	Sign si = new Sign();
	JDialog su = new JDialog(si.login, "회원가입", true);
	JLabel LID, LPWD, LNAME, LBIRTH;
	JTextField ID, PWD, NAME, BIRTHDAY;
	JButton Signup, Cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUp dialog = new SignUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openWindow() {
		su.setVisible(true);
	}

	public SignUp() {
		LID = new JLabel("아이디 : ");
		LPWD = new JLabel("패스워드 : ");
		LNAME = new JLabel("이름 : ");
		LBIRTH = new JLabel("생년월일 : ");
		ID = new JTextField(10);
		PWD = new JTextField(10);
		NAME = new JTextField(10);
		BIRTHDAY = new JTextField(10);
		Signup = new JButton("회원가입");
		Cancel = new JButton("돌아가기");
		su.getContentPane().setLayout(null);
		su.setSize(450, 300);
		su.getContentPane().add(LID);
		su.getContentPane().add(ID);
		su.getContentPane().add(LPWD);
		su.getContentPane().add(PWD);
		su.getContentPane().add(LNAME);
		su.getContentPane().add(NAME);
		su.getContentPane().add(LBIRTH);
		su.getContentPane().add(BIRTHDAY);
		su.getContentPane().add(Signup);
		su.getContentPane().add(Cancel);
		ID.setBounds(98, 36, 195, 21);
		PWD.setBounds(98, 78, 195, 21);
		NAME.setBounds(98, 124, 195, 21);
		BIRTHDAY.setBounds(98, 171, 195, 21);
		LID.setBounds(35, 39, 56, 15);
		LPWD.setBounds(24, 81, 67, 15);
		LNAME.setBounds(49, 127, 42, 15);
		LBIRTH.setBounds(24, 174, 67, 15);
		Signup.setBounds(216, 228, 87, 23);
		Cancel.setBounds(335, 228, 87, 23);
		Signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoCreate ic = new InfoCreate(ID.getText(), PWD.getText(), NAME.getText(), BIRTHDAY.getText());
			}
		});
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				su.dispose();
			}
		});
		su.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				su.dispose();
			}
		});
	}

}
