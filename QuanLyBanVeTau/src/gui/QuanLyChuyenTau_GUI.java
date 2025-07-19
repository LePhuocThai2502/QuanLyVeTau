package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import connectDB.ConnectDB;
import dao.ChuyenTau_DAO;
import entity.ChuyenTau;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyChuyenTau_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private ChuyenTau_DAO qlychuyentau_dao;
	private DefaultTableModel tablemodel1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyChuyenTau_GUI frame = new QuanLyChuyenTau_GUI();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public QuanLyChuyenTau_GUI() throws IOException {
		setTitle("Quản lý chuyến tàu ");
		setName("\r\n");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\JavaProject\\QuanLyBanVeTau\\icons\\5452470_high_speed_train_tram_vehicle_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1619, 739);

		// ket noi database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// khoi tao DAO
		qlychuyentau_dao = new ChuyenTau_DAO();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBackground(new Color(178, 34, 34));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setUI(null);

		setJMenuBar(menuBar);

		UIManager.put("NewMenu.selectionBackground", new Color(105, 105, 105));

		JMenu mnNewMenu_9 = new JMenu("Trang Chủ");
		mnNewMenu_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TrangChuQuanLy_GUI trangchu=new TrangChuQuanLy_GUI();
					trangchu.setVisible(true);
					trangchu.setExtendedState(MAXIMIZED_BOTH);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_9.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299061_house_icon.png"));
		mnNewMenu_9.setForeground(new Color(255, 255, 255));
		mnNewMenu_9.setBackground(new Color(178, 34, 34));
		mnNewMenu_9.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_9);

		JMenu mnNewMenu = new JMenu("Đặt Vé");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DatVe_GUI dv=new DatVe_GUI();
					dv.setVisible(true);
					dv.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Component horizontalStrut = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);
		mnNewMenu.setBackground(new Color(178, 34, 34));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\8973742_buy_sale_icon.png"));
		menuBar.add(mnNewMenu);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_1);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_2);

		JMenu mnNewMenu_1 = new JMenu("Đơn Vé ");
		mnNewMenu_1.setBackground(new Color(178, 34, 34));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\416404_bill_receipt_icon.png"));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Tra cứu thông tin hóa đơn");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoaDonBan_GUI hd=new HoaDonBan_GUI();
					hd.setVisible(true);
					hd.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_10.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		mntmNewMenuItem_10.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_10.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_10);

		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_3);

		Component horizontalStrut_1_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_4);

		JMenu mnNewMenu_2 = new JMenu("Đổi Trả ");
		mnNewMenu_2.setBackground(new Color(178, 34, 34));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\5027818_currency_exchange_money_payment_icon.png"));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tạo đơn đổi trả");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TaoHDDoiTra_GUI tao=new TaoHDDoiTra_GUI();
					tao.setVisible(true);
					tao.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_1.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_1
				.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\61472_bill_invoice_send_icon.png"));
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quản lý đơn đổi trả");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QLyHDDoiTra_GUI qlydt=new QLyHDDoiTra_GUI();
					qlydt.setVisible(true);
					qlydt.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_2.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_2.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_2.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\906567_calendat_clock_manage_plan_schedule_icon.png"));
		mnNewMenu_2.add(mntmNewMenuItem_2);

		Component horizontalStrut_1_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_5);

		Component horizontalStrut_1_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_6);

		JMenu mnNewMenu_10 = new JMenu("Chuyến Tàu");
		mnNewMenu_10.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49721_train_trains_icon.png"));
		mnNewMenu_10.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_10.setForeground(new Color(255, 255, 255));
		mnNewMenu_10.setBackground(new Color(178, 34, 34));
		menuBar.add(mnNewMenu_10);

		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Quản lý chuyến tàu");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyChuyenTau_GUI qlyct=new QuanLyChuyenTau_GUI();
					qlyct.setVisible(true);
					qlyct.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_17.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\5452510_high_speed_train_tram_vehicle_icon.png"));
		mntmNewMenuItem_17.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_17.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_17.setBackground(new Color(178, 34, 34));
		mnNewMenu_10.add(mntmNewMenuItem_17);

		Component horizontalStrut_1_7 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_7);

		Component horizontalStrut_1_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_8);

		JMenu mnNewMenu_3 = new JMenu("Vé Tàu ");
		mnNewMenu_3.setBackground(new Color(178, 34, 34));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		mnNewMenu_3.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49627_ticket_tix_icon.png"));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Quản lý vé tàu");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyVeTau_GUI qlvt=new QuanLyVeTau_GUI();
					qlvt.setVisible(true);
					qlvt.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_13.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\3688441_event_ticket_appointment_plan_schedule_icon.png"));
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_13.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_13.setBackground(new Color(178, 34, 34));
		mnNewMenu_3.add(mntmNewMenuItem_13);

		Component horizontalStrut_1_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_9);

		Component horizontalStrut_1_10 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_10);

		JMenu mnNewMenu_4 = new JMenu("Nhân Viên");
		mnNewMenu_4.setBackground(new Color(178, 34, 34));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_4.setForeground(new Color(255, 255, 255));
		mnNewMenu_4.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\6071820_corona_coronavirus_employee_personnel_worker_icon.png"));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Quản lý thông tin nhân viên");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanVien_GUI nv=new NhanVien_GUI();
					nv.setVisible(true);
					nv.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_11.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_11.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_11.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\9554766_technical_support_customer_call_telephone_icon.png"));
		mnNewMenu_4.add(mntmNewMenuItem_11);

		Component horizontalStrut_1_11 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_11);

		Component horizontalStrut_1_12 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_12);

		JMenu mnNewMenu_5 = new JMenu("Khách Hàng");
		mnNewMenu_5.setBackground(new Color(178, 34, 34));
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_5.setForeground(new Color(255, 255, 255));
		mnNewMenu_5.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1931212_client_consumer_customer_user_avatar_icon.png"));
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Quản lý thông tin khách hàng");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KhachHang_GUI kh=new KhachHang_GUI();
					kh.setVisible(true);
					kh.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_15
				.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\48812_manage_school_icon.png"));
		mntmNewMenuItem_15.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_15.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_15.setBackground(new Color(178, 34, 34));
		mnNewMenu_5.add(mntmNewMenuItem_15);

		Component horizontalStrut_1_13 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_13);

		Component horizontalStrut_1_14 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_14);

		JMenu mnNewMenu_6 = new JMenu("Thống Kê");
		mnNewMenu_6.setBackground(new Color(178, 34, 34));
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_6.setForeground(new Color(255, 255, 255));
		mnNewMenu_6.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\9554855_statistic_graph_statistics_analytics_report_icon.png"));
		menuBar.add(mnNewMenu_6);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Thống kê doanh thu");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ThongKeDoanhThu_GUI tkdt=new ThongKeDoanhThu_GUI();
					tkdt.setVisible(true);
					tkdt.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\897226_balance spendings_budget_money_save money_icon.png"));
		mntmNewMenuItem_6.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_6.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_6.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Thống kê đơn vé");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ThongKeDonVe_GUI tkdv=new ThongKeDonVe_GUI();
					tkdv.setVisible(true);
					tkdv.setExtendedState(MAXIMIZED_BOTH);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49628_tickets_tix_icon.png"));
		mntmNewMenuItem_7.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_7.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_6.add(mntmNewMenuItem_7);

		Component horizontalStrut_1_15 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_15);

		Component horizontalStrut_1_16 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_16);

		JMenu mnNewMenu_7 = new JMenu("Tài Khoản");
		mnNewMenu_7.setBackground(new Color(178, 34, 34));
		mnNewMenu_7.setForeground(new Color(255, 255, 255));
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_7.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\3841789_account_avatar_multimedia_person_profil_icon.png"));
		menuBar.add(mnNewMenu_7);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangDangNhap_GUI dangnhap=new TrangDangNhap_GUI();
				dangnhap.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\5452459_arrow_direction_door_emergency_exit_icon.png"));
		mntmNewMenuItem_5.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem_5.setForeground(new Color(255, 255, 255));
		mnNewMenu_7.add(mntmNewMenuItem_5);

		Component horizontalStrut_1_17 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_17);

		Component horizontalStrut_1_18 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_18);

		JMenu mnNewMenu_8 = new JMenu("Hỗ Trợ");
		mnNewMenu_8.setBackground(new Color(178, 34, 34));
		mnNewMenu_8.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_8.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\416400_call center_customer support_icon.png"));
		mnNewMenu_8.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_8);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Về chúng tôi");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs().setVisible(true);
			}
		});
		mntmNewMenuItem_3.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_3.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\6333180_ask_doubt_query_question_suspect_icon.png"));
		mntmNewMenuItem_3.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_8.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Hướng dẫn");
		mntmNewMenuItem_4.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem_4.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\11407757_user_manual_ui_account_ux_icon.png"));
		mntmNewMenuItem_4.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_8.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Quản lý chuyến tàu");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\897245_clock_manage_schedule_time_icon.png"));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAndDisplayTrainByCode();

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(178, 34, 34));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c chuy\u1EBFn t\u00E0u ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				// column maCT:
				textField_1.setText(tablemodel1.getValueAt(row, 0).toString());
				// column tenCT:
				textField_2.setText(tablemodel1.getValueAt(row, 1).toString());
				// column ngay di:
				String maCT = tablemodel1.getValueAt(row, 0).toString();
				try {
					Date ngayDi = qlychuyentau_dao.getNgayDiByCode(maCT);
					textField_3.setText(ngayDi.toString());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				// column ngay den:
				try {
					Date ngayDen = qlychuyentau_dao.getNgayDenByCode(maCT);
					textField_4.setText(ngayDen.toString());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				// column thoi gian xuat phat:
				try {
					Time gioKH = qlychuyentau_dao.getTGByCode(maCT);
					textField_5.setText(gioKH.toString());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				// column thoi gian den:
				try {
					Time gioden = qlychuyentau_dao.getTGDenByCode(maCT);
					textField_8.setText(gioden.toString());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				// column gaDi:
				String gadi = tablemodel1.getValueAt(row, 3).toString();
				textField_6.setText(gadi.toString());

				// column gaDen:
				String gaden = tablemodel1.getValueAt(row, 2).toString();
				textField_7.setText(gaden.toString());

				// column soLuongVe
				try {
					int soVe = qlychuyentau_dao.getSoLuongVeByCode(maCT);
					textField_9.setText(String.valueOf(soVe));
				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(tablemodel1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã chuyến tàu", "Tên chuyến tàu", "Ga đến", "Ga đi" }));

		// doc du lieu tu database
		DocdulieudatabasevaoTable();

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("") || textField_2.getText().equals("")
						|| textField_3.getText().equals("") || textField_4.getText().equals("")
						|| textField_5.getText().equals("") || textField_6.getText().equals("")
						|| textField_7.getText().equals("") || textField_8.getText().equals("")||textField_9.getText().equals("")){
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					textField_1.setText(autoMaCT());
					ChuyenTau ctau = revertChuyenTaufromTxt();
					qlychuyentau_dao.addCTau(ctau);
					JOptionPane.showMessageDialog(panel, "Thêm chuyến tàu thành công !!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					XoaTrang();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299068_add_sign_icon.png"));
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Cập nhật");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("") || textField_2.getText().equals("")
						|| textField_3.getText().equals("") || textField_4.getText().equals("")
						|| textField_5.getText().equals("") || textField_6.getText().equals("")
						|| textField_7.getText().equals("") || textField_8.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					ChuyenTau ctau = revertChuyenTaufromTxt();
					qlychuyentau_dao.updateCTau(ctau);
					JOptionPane.showMessageDialog(panel, "Cập nhật chuyến tàu thành công !!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					XoaTrang();
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1329089_arrows_circle_refresh_replace_round_icon.png"));
		panel_4.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Hủy chuyến");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if (r >= 0) {
					String maCT = tablemodel1.getValueAt(r, 0).toString();
					int hoi = JOptionPane.showConfirmDialog(panel, "Bạn chắc chắn muốn xóa chuyến tàu này?", "Yes",
							JOptionPane.YES_OPTION);
					if (hoi == JOptionPane.YES_OPTION) {
						qlychuyentau_dao.deleteCTau(maCT);
						JOptionPane.showMessageDialog(panel, "Hủy chuyến tàu thành công !!");
						tablemodel1.removeRow(r);
						XoaTrang();
					}
				}

			}
		});
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1_2.setBackground(new Color(178, 34, 34));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1398919_close_cross_incorrect_invalid_x_icon.png"));
		panel_4.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Xóa trắng");
		btnNewButton_1_3.setForeground(new Color(255, 255, 255));

		// Ham Xoa Trang
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_2.requestFocus();

			}
		});
		btnNewButton_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1_3.setBackground(new Color(178, 34, 34));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_3.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\118917_edit_clear_icon.png"));
		panel_4.add(btnNewButton_1_3);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt ", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		Component verticalStrut = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel_5.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel_1 = new JLabel("Mã chuyến tàu :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(autoMaCT());
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		panel_5.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		panel_5.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên chuyến tàu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel_5.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		panel_5.add(textField_2, gbc_textField_2);

		Component verticalStrut_2 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 4;
		panel_5.add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày đi:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 5;
		panel_5.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 5;
		panel_5.add(textField_3, gbc_textField_3);

		Component verticalStrut_3 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 6;
		panel_5.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày đến:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 7;
		panel_5.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 7;
		panel_5.add(textField_4, gbc_textField_4);

		Component verticalStrut_4 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 8;
		panel_5.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Thời gian xuất phát:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 9;
		panel_5.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 9;
		panel_5.add(textField_5, gbc_textField_5);

		Component verticalStrut_5 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 10;
		panel_5.add(verticalStrut_5, gbc_verticalStrut_5);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Thời gian đến:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 11;
		panel_5.add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 11;
		panel_5.add(textField_8, gbc_textField_8);

		Component verticalStrut_6 = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 12;
		panel_5.add(verticalStrut_6, gbc_verticalStrut_6);

		// bo border tf
		textField_1.setBorder(null);
		textField_2.setBorder(null);
		textField_3.setBorder(null);
		textField_4.setBorder(null);
		textField_5.setBorder(null);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Ga đi:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_2.gridy = 13;
		panel_5.add(lblNewLabel_1_1_1_1_2, gbc_lblNewLabel_1_1_1_1_2);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 13;
		panel_5.add(textField_6, gbc_textField_6);
		textField_6.setBorder(null);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 14;
		panel_5.add(verticalStrut_10, gbc_verticalStrut_10);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 16;
		panel_5.add(verticalStrut_11, gbc_verticalStrut_11);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Ga đến:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_2_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_2_1.gridy = 17;
		panel_5.add(lblNewLabel_1_1_1_1_2_1, gbc_lblNewLabel_1_1_1_1_2_1);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 17;
		panel_5.add(textField_7, gbc_textField_7);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 18;
		panel_5.add(verticalStrut_9, gbc_verticalStrut_9);

		Component verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_12.gridx = 1;
		gbc_verticalStrut_12.gridy = 19;
		panel_5.add(verticalStrut_12, gbc_verticalStrut_12);

		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Số lượng vé:");
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_2_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_2_1_1.gridy = 20;
		panel_5.add(lblNewLabel_1_1_1_1_2_1_1, gbc_lblNewLabel_1_1_1_1_2_1_1);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 20;
		panel_5.add(textField_9, gbc_textField_9);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 22;
		panel_5.add(verticalStrut_8, gbc_verticalStrut_8);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 24;
		panel_5.add(verticalStrut_7, gbc_verticalStrut_7);

		// label chạy
		timer = new Timer(60, new ActionListener() {
			private int xposition;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xposition += 8;

				if (xposition > getWidth()) {
					xposition = -lblNewLabel.getWidth(); // Đặt lại vị trí khi vượt quá chiều rộng của cửa sổ
				}
				lblNewLabel.setBounds(xposition, 0, lblNewLabel.getPreferredSize().width,
						lblNewLabel.getPreferredSize().height);

			}
		});
		timer.start();

	}

	// doc du lieu tu database
	public void DocdulieudatabasevaoTable() {
		List<ChuyenTau> list = qlychuyentau_dao.getalltbQLChuyenTau();
		for (ChuyenTau chuyenTau : list) {
			String maChuyenTau = chuyenTau.getMaChuyenTau();
			String tenChuyenTau = chuyenTau.getTenChuyenTau();
			String gaDen = chuyenTau.getGaDen();
			String gaDi = chuyenTau.getGaDi();

			tablemodel1.addRow(new Object[] { maChuyenTau, tenChuyenTau, gaDen, gaDi });
		}

	}

	public ChuyenTau revertChuyenTaufromTxt() {
		String maCT = textField_1.getText();
		String tenCT = textField_2.getText();
		String ngayDi = textField_3.getText();
		Date ngayKH = Date.valueOf(ngayDi);
		String ngayDen = textField_4.getText();
		Date ngayToi = Date.valueOf(ngayDen);
		String timexuatphat = textField_5.getText();
		Time TgXuatPhat = Time.valueOf(timexuatphat);
		String timeden = textField_8.getText();
		Time TgDen = Time.valueOf(timeden);
		String gaDi = textField_6.getText();
		String gaDen = textField_7.getText();
		int soLuongVe=Integer.parseInt(textField_9.getText());
		return new ChuyenTau(maCT, tenCT, ngayToi, ngayKH, TgXuatPhat, TgDen, gaDi, gaDen,soLuongVe);

	}

	public void XoadulieuTablemodel() {
		while (table.getRowCount() > 0) {
			tablemodel1.removeRow(0);
		}
	}

	public void XoaTrang() {
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		textField_1.requestFocus();

	}

	private void searchAndDisplayTrainByCode() {
		// Lấy mã Chuyến tàu từ TextField
		String maChuyenTau = textField.getText().trim();
		// Xóa dữ liệu hiện tại của bảng
		tablemodel1.setRowCount(0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM ChuyenTau WHERE maChuyenTau = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maChuyenTau);

			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = stmt.executeQuery();
			boolean found = false;
			while (rs.next()) {
				Object[] row = { rs.getString("maChuyenTau"), rs.getString("tenChuyenTau"), rs.getString("gaDen"),
						rs.getString("gaDi") };
				tablemodel1.addRow(row); // Thêm hàng mới vào bảng
				found = true;
				textField.requestFocus();

			}
			if (!found) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy chuyến tàu có mã " + maChuyenTau);
				textField.setText("");
				DocdulieudatabasevaoTable();
				textField.requestFocus();

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(table, "Đã xảy ra lỗi khi tìm kiếm chuyến tàu!" + ex.getMessage());
		}
	}

	public String autoMaCT() {
		String str;
		int ma = qlychuyentau_dao.getMaCTau();
		str = "CT" + String.format("%04d", ma);
		return str;
	}
	
	// Phương thức để thiết lập JFrame toàn màn hình
    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
}
