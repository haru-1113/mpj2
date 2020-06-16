package infa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import musicInfo.MusicRetrieve;
import uesrDataBase.InfoCreate;
import uesrDataBase.InfoRetrieve;

public class Main {
//��������
	public JFrame f = new JFrame();
	public JDialog login = new JDialog(f, "", true); // �α��� â
	public JDialog su = new JDialog(login, "", true); // ȸ������â
	public JLabel lid, lpwd, LID, LPWD, LNAME, LBIRTH; // �󺧺���
	public JButton search, Favorite, SI, SU, Can, Signup, Cancel; // ��ư ����
	public JTextField Tx, id, pwd, ID, PWD, BIRTHDAY, NAME; // �ʵ� ����
	public JToggleButton sign; // ��۹�ư ����
	public JComboBox<String> term; // �޺��ڽ� ����

	public Main() {
		// ������
		f.setLayout(null);// ������ ���̾ƿ�
		f.setSize(460, 680); // ������ ������
		search = new JButton("�˻�");// �˻���ư
		term = new JComboBox<>(new String[] { "��ü�˻�", "���", "������", "��ȣ" });// �޺��ڽ�
		Tx = new JTextField();// �˻��ʵ�
		Favorite = new JButton("���ã��");// ���ã�� ��ư
		sign = new JToggleButton("�α���");// �α��� ��ư
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
		Favorite.setEnabled(false);
		search.addActionListener(new ActionListener() { // �˻���ư �׼�
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
		sign.addActionListener(new ActionListener() { // �α��ι�ư �׼�
			public void actionPerformed(ActionEvent e) {
				sign.setText("�α�����...");
				lid = new JLabel("ID : "); // ���̵� ��
				lpwd = new JLabel("PASSWORD : "); // ��й�ȣ ��
				id = new JTextField(10); // ���̵� �ʵ�
				pwd = new JTextField(10); // ��й�ȣ �ʵ�
				SI = new JButton("�α���"); // �α��� ��ư
				SU = new JButton("ȸ������"); // ȸ�����Թ�ư
				Can = new JButton("���ư���"); // ���ư��� ��ư
				login.setLayout(null); // �α���â ���̾ƿ�
				login.setSize(385, 300); // �α���â ������
				login.add(lid);
				login.add(id);
				login.add(lpwd);
				login.add(pwd);
				login.add(SU);
				login.add(SI);
				login.add(Can);
				lid.setBounds(91, 85, 23, 15);
				lpwd.setBounds(45, 135, 82, 15);
				id.setBounds(139, 82, 116, 21);
				pwd.setBounds(139, 132, 116, 21);
				SI.setBounds(178, 228, 89, 23);
				Can.setBounds(272, 228, 89, 23);
				SU.setBounds(12, 228, 97, 23);
				SI.addActionListener(new ActionListener() { // �α��� ��ư �׼�
					public void actionPerformed(ActionEvent e) {
						InfoRetrieve ir = new InfoRetrieve(id.getText(), pwd.getText());
						if (ir.okey == true) {
							login.dispose();
							sign.setText("�α׾ƿ�");// �α��ι�ư �α׾ƿ����� ����
							sign.setSelected(true); // �α��� ��ư ��������
							Favorite.setEnabled(true); // ���ã�� ��ư ���� ���ɻ���
						}
					}
				});
				SU.addActionListener(new ActionListener() { // ȸ������ ��ư �׼�
					public void actionPerformed(ActionEvent e) {
						su = new JDialog(login, "", true); // ȸ������â
						LID = new JLabel("���̵� : "); // ȸ������â ���̵� ��
						LPWD = new JLabel("�н����� : "); // ȸ������â ��й�ȣ ��
						LNAME = new JLabel("�̸� : "); // ȸ������â �̸� ��
						LBIRTH = new JLabel("������� : "); // ȸ������â ������� ��
						ID = new JTextField(10); // ȸ������â ���̵� �ʵ�
						PWD = new JTextField(10); // ȸ������â ��й�ȣ �ʵ�
						NAME = new JTextField(10); // ȸ������â �̸� �ʵ�
						BIRTHDAY = new JTextField(10); // ȸ������â ������� �ʵ�
						Signup = new JButton("ȸ������"); // ȸ������â ȸ������ ��ư
						Cancel = new JButton("���ư���"); // ȸ������â���ư��� ��ư
						su.setLayout(null); // ȸ������â ���̾ƿ�
						su.setSize(450, 300); // ȸ������â ������
						su.add(LID);
						su.add(ID);
						su.add(LPWD);
						su.add(PWD);
						su.add(LNAME);
						su.add(NAME);
						su.add(LBIRTH);
						su.add(BIRTHDAY);
						su.add(Signup);
						su.add(Cancel);
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
						Signup.addActionListener(new ActionListener() { // ȸ������â ȸ������ ��ư �׼�
							public void actionPerformed(ActionEvent e) {
								InfoCreate ic = new InfoCreate(ID.getText(), PWD.getText(), NAME.getText(),
										BIRTHDAY.getText());
							}
						});
						Cancel.addActionListener(new ActionListener() { // ȸ������â ���ư��� ��ư �׼�
							public void actionPerformed(ActionEvent e) {
								su.dispose();
							}
						});
						su.addWindowListener(new WindowAdapter() { // ȸ������â ��������
							public void windowClosing(WindowEvent e) {
								su.dispose();
							}
						});
						su.setVisible(true);
					}
				});
				Can.addActionListener(new ActionListener() { // �α���â ���ư��� ��ư �׼�
					public void actionPerformed(ActionEvent e) {
						sign.setText("�α���");
						sign.setSelected(false);
						login.dispose();
					}
				});
				login.addWindowListener(new WindowAdapter() { // �α���â ���� ����
					public void windowClosing(WindowEvent e) {
						sign.setText("�α���");
						sign.setSelected(false);
						login.dispose();
					}
				});
				login.setVisible(true);
			}
		});
		f.addWindowListener(new WindowAdapter() { // ���� ȭ�� ��������
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
}
