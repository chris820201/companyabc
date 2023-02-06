package Controller.sample1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField nameUpdate;
	private JTextField addressUpdate;
	private JTextField deleteId;
	private JTextField idUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 181, 410);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setBounds(10, 66, 35, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(10, 113, 35, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setBounds(10, 159, 35, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setBounds(10, 203, 35, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("行動:");
		lblNewLabel_4.setBounds(10, 251, 35, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話:");
		lblNewLabel_5.setBounds(10, 301, 35, 15);
		panel.add(lblNewLabel_5);
		
		
		
		name = new JTextField();
		name.setBounds(55, 63, 116, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(55, 110, 116, 21);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(55, 156, 116, 21);
		panel.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(55, 200, 116, 21);
		panel.add(address);
		address.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(55, 248, 116, 21);
		panel.add(mobile);
		mobile.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(55, 298, 116, 21);
		panel.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("輸入會員資料");
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_6.setBounds(27, 20, 116, 23);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(201, 10, 432, 410);
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
			
		
		
		JLabel lab1 = new JLabel("姓名");
		lab1.setBounds(119, 92, 30, 15);
		panel_1.add(lab1);
		
		JLabel lblNewLabel_8 = new JLabel("ID");
		lblNewLabel_8.setBounds(119, 125, 30, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lab2 = new JLabel("地址");
		lab2.setBounds(220, 92, 30, 15);
		panel_1.add(lab2);
		
		nameUpdate = new JTextField();
		nameUpdate.setBounds(143, 89, 67, 21);
		panel_1.add(nameUpdate);
		nameUpdate.setColumns(10);
		
		addressUpdate = new JTextField();
		addressUpdate.setBounds(246, 89, 74, 21);
		panel_1.add(addressUpdate);
		addressUpdate.setColumns(10);
		
		deleteId = new JTextField();
		deleteId.setBounds(143, 122, 67, 21);
		panel_1.add(deleteId);
		deleteId.setColumns(10);
		
		JTextArea show = new JTextArea();
		show.setBounds(10, 154, 412, 222);
		panel_1.add(show);
		
		JLabel lblNewLabel_10 = new JLabel("會員資料管理");
		lblNewLabel_10.setFont(new Font("新細明體", Font.BOLD, 26));
		lblNewLabel_10.setBounds(119, 10, 170, 39);
		panel_1.add(lblNewLabel_10);
		
		JLabel total = new JLabel("");
		total.setBounds(20, 386, 67, 15);
		panel_1.add(total);
		
		JButton add = new JButton("新增");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.UI接收 getText
				 * 2.new member
				 * 3.add(m)
				 */
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				member m=new member(Name,Username,Password,Address,Mobile,Phone);
				
				new implMember().add(m);
				
			}
		});
		add.setBounds(47, 351, 124, 23);
		panel.add(add);
		
		JButton queryAll = new JButton("查詢(全部)");
		queryAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.show.setText->queryAll1:String
				 */
				show.setText(new implMember().queryAll1());
				
				List<member> l=new implMember().queryAll2();
				total.setText("共:"+l.size()+"筆");
			}
		});
		queryAll.setBounds(10, 55, 99, 23);
		panel_1.add(queryAll);
		
		JLabel lab3 = new JLabel("ID");
		lab3.setBounds(327, 92, 20, 15);
		panel_1.add(lab3);
		
		idUpdate = new JTextField();
		idUpdate.setBounds(348, 89, 74, 21);
		panel_1.add(idUpdate);
		idUpdate.setColumns(10);
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.nameUpdate.addressUpdate ,updateId->getText
				 * 2.updateId->轉乘int->queryId(id)->member m
				 * 3.m.setNmae(),m.address()
				 * 4.update(m)
				 */
				
				String Name=nameUpdate.getText();
				String Address=addressUpdate.getText();
				
				int ID=Integer.parseInt(idUpdate.getText());
				member m=new implMember().queryId(ID);
				m.setName(Name);
				m.setAddress(Address);
				
				new implMember().update(m);
			}
		});
		update.setBounds(10, 88, 99, 23);
		panel_1.add(update);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.deleteId->getText->轉型->int
				 * 2.執行 delete(id)
				 */
				
				int Id=Integer.parseInt(deleteId.getText());
				
				new implMember().delete(Id);
			}
		});
		btnNewButton_3.setBounds(10, 121, 99, 23);
		panel_1.add(btnNewButton_3);
		
		
	}
}
