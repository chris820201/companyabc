package Controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(54, 26, 331, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(43, 60, 41, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("會員登入");
		lblNewLabel_2.setBounds(115, 10, 103, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(43, 100, 46, 32);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		
		username = new JTextField();
		username.setBounds(122, 62, 96, 24);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(122, 107, 96, 21);
		panel.add(password);
		password.setColumns(10);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.帳號密碼 getText();
				 * 2.queryUser(帳號,密碼):member
				 * 3.!=null->loginSuccess
				 * 4.null->loginError
				 */
				
				String Username=username.getText();
				String Password=password.getText();
				
				member m=new implMember().queryMember(Username, Password);
				
				if(m!=null)
				{
					loginSuccess l=new loginSuccess();
					l.show();
					dispose();
				}
				else
				{
					loginError l=new loginError();
					l.show();
					dispose();
				}
			}
		});
		
		login.setFont(new Font("新細明體", Font.BOLD, 16));
		login.setBounds(122, 152, 96, 24);
		panel.add(login);
	}
}
