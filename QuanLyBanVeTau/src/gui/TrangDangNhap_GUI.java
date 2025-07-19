package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.BanVe_DAO;
import dao.LogIn_DAO;
import entity.ChuyenTau;
import entity.TaiKhoan;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class TrangDangNhap_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private dao.LogIn_DAO dangnhap_DAO;
	private DefaultComboBoxModel cbx1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangDangNhap_GUI frame = new TrangDangNhap_GUI();
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
	public TrangDangNhap_GUI() {
		setResizable(false);
		setLocationRelativeTo(null);
		setAutoRequestFocus(true);
		setTitle("Trang Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 792);
		setLocationRelativeTo(null);
		

		// ket noi database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// khoi tao DAO
		dangnhap_DAO = new LogIn_DAO();

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nhà Ga Sài Gòn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(206, 11, 360, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\2730340_colour_express_harry_hogwarts_potter_icon.png"));
		lblNewLabel_1.setBounds(173, 31, 318, 273);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(67, 383, 124, 56);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(67, 471, 124, 56);
		contentPane.add(lblNewLabel_2_1);

		textField = new JTextField();
		textField.setBounds(197, 391, 392, 44);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tentk = textField.getText();
				char[] passwordclass = passwordField.getPassword();
				String matkhau = new String(passwordclass);
				String MK = matkhau;
				String role = dangnhap_DAO.CheckLogin(tentk, MK);

				dangnhap_DAO.showGUI(role);

			}

		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(67, 676, 124, 48);
		contentPane.add(btnNewButton);

		JButton btnngK = new JButton("Quên mật khẩu?");
		btnngK.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnngK.setBackground(Color.WHITE);
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnngK.setBounds(449, 676, 140, 48);
		contentPane.add(btnngK);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 477, 392, 49);
		contentPane.add(passwordField);
	}

	public void xoatrang() {
		textField.setText("");
		passwordField.setText("");
		textField.requestFocus();

	}
}
