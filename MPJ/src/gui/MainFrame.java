package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField sete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("NB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 670);
		getContentPane().setLayout(null);

		JComboBox ste = new JComboBox();
		ste.setBounds(30, 75, 64, 23);
		getContentPane().add(ste);

		sete = new JTextField();
		sete.setBounds(93, 75, 219, 23);
		getContentPane().add(sete);
		sete.setColumns(10);

		JButton search = new JButton("\uAC80\uC0C9");
		search.setBounds(311, 75, 71, 23);
		getContentPane().add(search);

		JToggleButton login = new JToggleButton("Sign In");
		login.setBounds(310, 10, 112, 23);
		getContentPane().add(login);

		JToggleButton Fa = new JToggleButton("\uC990\uACA8\uCC3E\uAE30");
		Fa.setBounds(311, 42, 111, 23);
		getContentPane().add(Fa);

		JLabel logo = new JLabel("logo");
		logo.setBounds(30, 10, 87, 55);
		getContentPane().add(logo);

	}
}
