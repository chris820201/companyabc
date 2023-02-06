package Controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMember extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMember frame = new addMember();
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
	public addMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(38, 10, 312, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(55, 37, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(55, 62, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(55, 87, 46, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(55, 112, 46, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("行動");
		lblNewLabel_4.setBounds(55, 140, 46, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setBounds(55, 165, 46, 15);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(111, 34, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(111, 59, 96, 21);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(111, 84, 96, 21);
		panel.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(111, 109, 96, 21);
		panel.add(address);
		address.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(111, 137, 96, 21);
		panel.add(mobile);
		mobile.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(111, 162, 96, 21);
		panel.add(phone);
		phone.setColumns(10);
		
		JButton success = new JButton("確定");
		success.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.username->getText
				 * 2.帳號判斷->queryusername():boolean
				 * 3.true->重複->addError
				 * 4.false->接收所有資料->new member->add()->addSuccess
				 */
				
				String Username=username.getText();
				if(new implMember().queryUser(Username))
				{
					addError error=new addError();
					error.show();
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Mobile=mobile.getText();
					String Phone=phone.getText();
					
					member m=new member(Name,Username,Password,Address,Mobile,Phone);
					new implMember().add(m);
					
					addSuccess success=new addSuccess();
					success.show();
					dispose();
				}
			}
		});
		success.setBounds(111, 193, 96, 37);
		panel.add(success);
	}
}
