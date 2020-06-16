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
//변수생성
	public JFrame f = new JFrame();
	public JDialog login = new JDialog(f, "", true); // 로그인 창
	public JDialog su = new JDialog(login, "", true); // 회원가입창
	public JLabel lid, lpwd, LID, LPWD, LNAME, LBIRTH; // 라벨변수
	public JButton search, Favorite, SI, SU, Can, Signup, Cancel; // 버튼 변수
	public JTextField Tx, id, pwd, ID, PWD, BIRTHDAY, NAME; // 필드 변수
	public JToggleButton sign; // 토글버튼 변수
	public JComboBox<String> term; // 콤보박스 변수

	public Main() {
		// 생성자
		f.setLayout(null);// 프레임 레이아웃
		f.setSize(460, 680); // 프레임 사이즈
		search = new JButton("검색");// 검색버튼
		term = new JComboBox<>(new String[] { "전체검색", "곡명", "가수명", "번호" });// 콤보박스
		Tx = new JTextField();// 검색필드
		Favorite = new JButton("즐겨찾기");// 즐겨찾기 버튼
		sign = new JToggleButton("로그인");// 로그인 버튼
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
		search.addActionListener(new ActionListener() { // 검색버튼 액션
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
		sign.addActionListener(new ActionListener() { // 로그인버튼 액션
			public void actionPerformed(ActionEvent e) {
				sign.setText("로그인중...");
				lid = new JLabel("ID : "); // 아이디 라벨
				lpwd = new JLabel("PASSWORD : "); // 비밀번호 라벨
				id = new JTextField(10); // 아이디 필드
				pwd = new JTextField(10); // 비밀번호 필드
				SI = new JButton("로그인"); // 로그인 버튼
				SU = new JButton("회원가입"); // 회원가입버튼
				Can = new JButton("돌아가기"); // 돌아가기 버튼
				login.setLayout(null); // 로그인창 레이아웃
				login.setSize(385, 300); // 로그인창 사이즈
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
				SI.addActionListener(new ActionListener() { // 로그인 버튼 액션
					public void actionPerformed(ActionEvent e) {
						InfoRetrieve ir = new InfoRetrieve(id.getText(), pwd.getText());
						if (ir.okey == true) {
							login.dispose();
							sign.setText("로그아웃");// 로그인버튼 로그아웃으로 설정
							sign.setSelected(true); // 로그인 버튼 눌림상태
							Favorite.setEnabled(true); // 즐겨찾기 버튼 실행 가능상태
						}
					}
				});
				SU.addActionListener(new ActionListener() { // 회원가입 버튼 액션
					public void actionPerformed(ActionEvent e) {
						su = new JDialog(login, "", true); // 회원가입창
						LID = new JLabel("아이디 : "); // 회원가입창 아이디 라벨
						LPWD = new JLabel("패스워드 : "); // 회원가입창 비밀번호 라벨
						LNAME = new JLabel("이름 : "); // 회원가입창 이름 라벨
						LBIRTH = new JLabel("생년월일 : "); // 회원가입창 생년월일 라벨
						ID = new JTextField(10); // 회원가입창 아이디 필드
						PWD = new JTextField(10); // 회원가입창 비밀번호 필드
						NAME = new JTextField(10); // 회원가입창 이름 필드
						BIRTHDAY = new JTextField(10); // 회원가입창 생년월일 필드
						Signup = new JButton("회원가입"); // 회원가입창 회원가입 버튼
						Cancel = new JButton("돌아가기"); // 회원가입창돌아가기 버튼
						su.setLayout(null); // 회원가입창 레이아웃
						su.setSize(450, 300); // 회원가입창 사이즈
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
						Signup.addActionListener(new ActionListener() { // 회원가입창 회원가입 버튼 액션
							public void actionPerformed(ActionEvent e) {
								InfoCreate ic = new InfoCreate(ID.getText(), PWD.getText(), NAME.getText(),
										BIRTHDAY.getText());
							}
						});
						Cancel.addActionListener(new ActionListener() { // 회원가입창 돌아가기 버튼 액션
							public void actionPerformed(ActionEvent e) {
								su.dispose();
							}
						});
						su.addWindowListener(new WindowAdapter() { // 회원가입창 강제종료
							public void windowClosing(WindowEvent e) {
								su.dispose();
							}
						});
						su.setVisible(true);
					}
				});
				Can.addActionListener(new ActionListener() { // 로그인창 돌아가기 버튼 액션
					public void actionPerformed(ActionEvent e) {
						sign.setText("로그인");
						sign.setSelected(false);
						login.dispose();
					}
				});
				login.addWindowListener(new WindowAdapter() { // 로그인창 강제 종료
					public void windowClosing(WindowEvent e) {
						sign.setText("로그인");
						sign.setSelected(false);
						login.dispose();
					}
				});
				login.setVisible(true);
			}
		});
		f.addWindowListener(new WindowAdapter() { // 메인 화면 강제종료
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
}
