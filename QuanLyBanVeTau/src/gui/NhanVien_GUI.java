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
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.ChuyenTau_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.CT_HoaDon;
import entity.ChuyenTau;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NhanVien_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTable tableNhanVien;
	private JTextField textField;
	private DefaultTableModel tablemodelHD;
	private DefaultTableModel tablemodelCTHD;
	private HoaDon_DAO hoaDon_Dao;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private KhachHang_DAO khachHang_dao;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private NhanVien_DAO nhanVien_dao;
	private JTextField textField_1;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_1_1;
	private JDateChooser dateChooser_1;
	private JComboBox comboBox_1;
	private JTextField textField_6;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_GUI frame = new NhanVien_GUI();
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
	public NhanVien_GUI() throws IOException {
		setAutoRequestFocus(false);
		setTitle("Quản lý nhân viên");
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
		nhanVien_dao = new NhanVien_DAO();

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

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_1);
		mnNewMenu.setBackground(new Color(178, 34, 34));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\8973742_buy_sale_icon.png"));
		menuBar.add(mnNewMenu);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_2);

		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_3);

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

		Component horizontalStrut_1_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_4);

		Component horizontalStrut_1_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_5);

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

		Component horizontalStrut_1_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_6);

		Component horizontalStrut_1_7 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_7);

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

		Component horizontalStrut_1_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_8);

		Component horizontalStrut_1_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_9);

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

		Component horizontalStrut_1_10 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_10);

		Component horizontalStrut_1_11 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_11);

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

		Component horizontalStrut_1_12 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_12);

		Component horizontalStrut_1_13 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_13);

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

		Component horizontalStrut_1_14 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_14);

		Component horizontalStrut_1_15 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_15);

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

		Component horizontalStrut_1_16 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_16);

		Component horizontalStrut_1_17 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_17);

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

		Component horizontalStrut_1_18 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_18);

		Component horizontalStrut_1_19 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_19);

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

		// banner ảnh
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panel.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 19;
		gbc_verticalStrut.gridy = 0;
		panel_1.add(verticalStrut, gbc_verticalStrut);

		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue.gridx = 0;
		gbc_horizontalGlue.gridy = 1;
		panel_1.add(horizontalGlue, gbc_horizontalGlue);

		JLabel lblNewLabel = new JLabel("Họ tên nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 14;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên tài khoản:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 19;
		gbc_lblNewLabel_2_1_1.gridy = 1;
		panel_1.add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				// Lay cac gia tri tim kiem
//				String hotenNV = textField.getText().trim();
//				String chucvu = comboBox_1.getSelectedItem().toString().trim();
//				String tenTK = textField_7.getText().trim();
//				
//
//				// Biến cờ để đánh dấu liệu có thực hiện tìm kiếm hay không
//				boolean hasSearch = false;
//
//				if (!hotenNV.isEmpty()) {
//				    DefaultTableModel tableTimKiemTheoTenNV = nhanVien_dao.searchCustomerByName(hotenNV);
//				    tableNhanVien.setModel(tableTimKiemTheoTenNV);
//				    hasSearch = true;
//				}
//
//				if (!hasSearch && !chucvu.isEmpty()) {
//				    DefaultTableModel tableTimKiemTheoSDT = nhanVien_dao.searchCustomerByNameCV(chucvu);
//				    tableNhanVien.setModel(tableTimKiemTheoSDT);
//				    hasSearch = true;
//				}
//
//				if (!hasSearch && !tenTK.isEmpty()) {
//				    DefaultTableModel tableTimKiemTheoTK = nhanVien_dao.searchCustomerByNameTK(tenTK);
//				    tableNhanVien.setModel(tableTimKiemTheoTK);
//				    hasSearch = true;
//				}
//
//				// Kiểm tra nếu không có tìm kiếm nào được thực hiện, hiển thị thông báo lỗi
//				if (!hasSearch) {
//				    JOptionPane.showMessageDialog(panel, "Vui lòng nhập ít nhất một trường tìm kiếm.", "Thông báo",JOptionPane.ERROR_MESSAGE);
//	
//				}
				searchandisplayNVbycode();

			}
		});

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 13;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 21;
		gbc_textField_7.gridy = 1;
		panel_1.add(textField_7, gbc_textField_7);
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 44;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 19;
		gbc_verticalStrut_2.gridy = 2;
		panel_1.add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel lblNewLabel_1 = new JLabel("Chức vụ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "Nhân viên bán vé", "Nhân viên kế toán" }));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 14;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 3;
		panel_1.add(comboBox_1, gbc_comboBox_1);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 19;
		gbc_verticalStrut_1.gridy = 4;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		panel_2.add(scrollPane);

		tableNhanVien = new JTable();
		tableNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableNhanVien.getSelectedRow();
				textField_2.setText(tablemodelHD.getValueAt(row, 0).toString());
				textField_3.setText(tablemodelHD.getValueAt(row, 1).toString());
				// ngaysinh
				String ngaysinh = tablemodelHD.getValueAt(row, 2).toString();
				try {
					java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaysinh);
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// chuc vu
				textField_1.setText(tablemodelHD.getValueAt(row, 3).toString());
				// taikhoan
				textField_10.setText(tablemodelHD.getValueAt(row, 4).toString());
				Object value = tablemodelHD.getValueAt(row, 4).toString();
				comboBox.setSelectedItem(value);

				// tuoi
				String maNV = tablemodelHD.getValueAt(row, 0).toString();
				try {
					String tuoiNV = nhanVien_dao.getAgeByCode(maNV);
					textField_4.setText(tuoiNV);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// sdt
				try {
					String sdtNV = nhanVien_dao.getSDTByCode(maNV);
					textField_8.setText(sdtNV);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// gioitinh
				try {
					String gioiTinh = nhanVien_dao.getPhaiByCode(maNV).toString();
					if (gioiTinh.equals("true")) {
						rdbtnNewRadioButton_1_1.setSelected(true);
						rdbtnNewRadioButton_2.setSelected(false);
					} else {
						rdbtnNewRadioButton_2.setSelected(true);
						rdbtnNewRadioButton_1_1.setSelected(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// cmnd
				try {
					String cmnd = nhanVien_dao.getCMNDByCode(maNV);
					textField_9.setText(cmnd);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// luong
				try {
					String luong = nhanVien_dao.getLuongByCode(maNV).toString();
					float luongFloat = Float.parseFloat(luong); // Chuyển đổi chuỗi luong thành số thực
					// Tạo một đối tượng NumberFormat để định dạng số
					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
					// Định dạng số lương thành chuỗi với đơn vị tiền tệ VND
					String luongFormatted = format.format(luongFloat);
					textField_5.setText(luongFormatted);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// ngayvaolam
				try {
					String ngayvaoLam = nhanVien_dao.getDateByCode(maNV).toString();
					java.util.Date date;
					try {
						date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayvaoLam);
						dateChooser_1.setDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// password
				String tenTK = textField_10.getText();
				String password;
				try {
					password = nhanVien_dao.getPassByNameTK(tenTK);
					textField_6.setText(password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		tableNhanVien.setRowHeight(30);
		scrollPane.setViewportView(tableNhanVien);
		tableNhanVien.setModel(tablemodelHD = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Họ tên", "Ngày sinh", "Chức vụ", "Tên tài khoản" }));

		// doc du lieu tu CSDL
		DocdulieudatabasevaoTable();

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_1 = new JButton("Xóa trắng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaTrang();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\118917_edit_clear_icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(btnNewButton_1);

		JButton btnNewButton_7 = new JButton("Cập nhật");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("") || textField_5.getText().equals("")
						|| textField_8.getText().equals("") || textField_9.getText().equals("")
						|| textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					NhanVien nv = revertNhanVienfromTxt();
					nhanVien_dao.updateKH(nv);
					JOptionPane.showMessageDialog(panel, "Cập nhật thông tin nhân viên thành công !!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					XoaTrang();

				}

			}
		});
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_7.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1329089_arrows_circle_refresh_replace_round_icon.png"));
		panel_7.add(btnNewButton_7);

		JButton btnNewButton_2 = new JButton("Thêm mới");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("") || textField_5.getText().equals("")
						|| textField_8.getText().equals("") || textField_9.getText().equals("")
						|| textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					textField_2.setText(autoMa());
					NhanVien NV = revertNhanVienfromTxt();
					nhanVien_dao.addNhanVien(NV);
					JOptionPane.showMessageDialog(panel, "Thêm nhân viên thành công !!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					XoaTrang();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299068_add_sign_icon.png"));
		panel_7.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("Đặt lại mật khẩu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập vào mật khẩu cần thay đổi");
				} else {
					int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đổi mật khẩu?", "Xác nhận đổi",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						TaiKhoan tk = revertTKfromtxt();
						nhanVien_dao.updatePassword(tk);
						JOptionPane.showMessageDialog(panel, "Đổi mật khẩu nhân viên thành công !!");
						XoaTrang();
					} else {
						System.out.println("Hủy bỏ.");
					}

				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\8956781_padlock_padlocks_lock_security_secure_icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		panel_7.add(btnNewButton_1_1);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		Component verticalStrut_18 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_18 = new GridBagConstraints();
		gbc_verticalStrut_18.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_18.gridx = 0;
		gbc_verticalStrut_18.gridy = 0;
		panel_4.add(verticalStrut_18, gbc_verticalStrut_18);

		Component verticalStrut_17 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_17 = new GridBagConstraints();
		gbc_verticalStrut_17.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_17.gridx = 0;
		gbc_verticalStrut_17.gridy = 1;
		panel_4.add(verticalStrut_17, gbc_verticalStrut_17);

		JLabel lblNewLabel_2 = new JLabel("Mã NV:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 1;
		gbc_horizontalStrut_3.gridy = 3;
		panel_4.add(horizontalStrut_3, gbc_horizontalStrut_3);

		textField_2 = new JTextField();
		textField_2.setText(autoMa());

		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel_4.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 4;
		panel_4.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 5;
		panel_4.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		panel_4.add(textField_3, gbc_textField_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 6;
		panel_4.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblNewLabel_2_2 = new JLabel("Tuổi:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2.gridx = 0;
		gbc_lblNewLabel_2_2.gridy = 7;
		panel_4.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 7;
		panel_4.add(textField_4, gbc_textField_4);

		Component verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_12.gridx = 0;
		gbc_verticalStrut_12.gridy = 8;
		panel_4.add(verticalStrut_12, gbc_verticalStrut_12);

		JLabel lblNewLabel_2_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2_1.gridx = 0;
		gbc_lblNewLabel_2_2_1.gridy = 9;
		panel_4.add(lblNewLabel_2_2_1, gbc_lblNewLabel_2_2_1);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 4;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 9;
		panel_4.add(textField_8, gbc_textField_8);

		Component verticalStrut_13 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_13 = new GridBagConstraints();
		gbc_verticalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_13.gridx = 0;
		gbc_verticalStrut_13.gridy = 10;
		panel_4.add(verticalStrut_13, gbc_verticalStrut_13);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2_1_1.gridx = 0;
		gbc_lblNewLabel_2_2_1_1.gridy = 11;
		panel_4.add(lblNewLabel_2_2_1_1, gbc_lblNewLabel_2_2_1_1);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 4;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 11;
		panel_4.add(dateChooser, gbc_dateChooser);

		Component verticalStrut_14 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_14 = new GridBagConstraints();
		gbc_verticalStrut_14.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_14.gridx = 0;
		gbc_verticalStrut_14.gridy = 12;
		panel_4.add(verticalStrut_14, gbc_verticalStrut_14);

		JLabel lblNewLabel_2_4_1 = new JLabel("Giới tính:");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_4_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_4_1.gridx = 0;
		gbc_lblNewLabel_2_4_1.gridy = 13;
		panel_4.add(lblNewLabel_2_4_1, gbc_lblNewLabel_2_4_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Nam");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 2;
		gbc_rdbtnNewRadioButton_2.gridy = 13;
		panel_4.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_1_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton_1_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1_1.gridwidth = 3;
		gbc_rdbtnNewRadioButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1_1.gridx = 3;
		gbc_rdbtnNewRadioButton_1_1.gridy = 13;
		panel_4.add(rdbtnNewRadioButton_1_1, gbc_rdbtnNewRadioButton_1_1);

		Component verticalStrut_15 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_15 = new GridBagConstraints();
		gbc_verticalStrut_15.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_15.gridx = 0;
		gbc_verticalStrut_15.gridy = 14;
		panel_4.add(verticalStrut_15, gbc_verticalStrut_15);

		JLabel lblNewLabel_2_3_1 = new JLabel("CMND:");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_3_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3_1.gridx = 0;
		gbc_lblNewLabel_2_3_1.gridy = 15;
		panel_4.add(lblNewLabel_2_3_1, gbc_lblNewLabel_2_3_1);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.gridwidth = 4;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 2;
		gbc_textField_9.gridy = 15;
		panel_4.add(textField_9, gbc_textField_9);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 0;
		gbc_verticalStrut_11.gridy = 16;
		panel_4.add(verticalStrut_11, gbc_verticalStrut_11);

		JLabel lblNewLabel_2_3_2 = new JLabel("Chức vụ:");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_3_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3_2.gridx = 0;
		gbc_lblNewLabel_2_3_2.gridy = 17;
		panel_4.add(lblNewLabel_2_3_2, gbc_lblNewLabel_2_3_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 17;
		panel_4.add(textField_1, gbc_textField_1);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 0;
		gbc_verticalStrut_10.gridy = 18;
		panel_4.add(verticalStrut_10, gbc_verticalStrut_10);

		JLabel lblNewLabel_2_3 = new JLabel("Lương:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3.gridx = 0;
		gbc_lblNewLabel_2_3.gridy = 19;
		panel_4.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 19;
		panel_4.add(textField_5, gbc_textField_5);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 0;
		gbc_verticalStrut_9.gridy = 20;
		panel_4.add(verticalStrut_9, gbc_verticalStrut_9);

		JLabel lblNewLabel_2_4 = new JLabel("Ngày vào làm việc:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_4 = new GridBagConstraints();
		gbc_lblNewLabel_2_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_4.gridx = 0;
		gbc_lblNewLabel_2_4.gridy = 21;
		panel_4.add(lblNewLabel_2_4, gbc_lblNewLabel_2_4);

		dateChooser_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.gridwidth = 4;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 21;
		panel_4.add(dateChooser_1, gbc_dateChooser_1);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 0;
		gbc_verticalStrut_8.gridy = 22;
		panel_4.add(verticalStrut_8, gbc_verticalStrut_8);

		JLabel lblNewLabel_2_4_2 = new JLabel("Tài khoản:");
		lblNewLabel_2_4_2.setVisible(false);
		lblNewLabel_2_4_2.setEnabled(false);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_4_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_4_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_4_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_4_2.gridx = 0;
		gbc_lblNewLabel_2_4_2.gridy = 23;
		panel_4.add(lblNewLabel_2_4_2, gbc_lblNewLabel_2_4_2);

		textField_10 = new JTextField();
		textField_10.setVisible(false);
		textField_10.setEnabled(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.gridwidth = 4;
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 23;
		panel_4.add(textField_10, gbc_textField_10);

		JLabel lblNewLabel_2_4_2_2 = new JLabel("Tên tài khoản:");
		lblNewLabel_2_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_4_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_4_2_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_4_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_4_2_2.gridx = 0;
		gbc_lblNewLabel_2_4_2_2.gridy = 24;
		panel_4.add(lblNewLabel_2_4_2_2, gbc_lblNewLabel_2_4_2_2);

		// combobox account:
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ArrayList<TaiKhoan> listTK = nhanVien_dao.getalltbQLTaiKhoan();
		for (TaiKhoan taiKhoan : listTK) {
			comboBox.addItem(taiKhoan.getTenTK());
		}

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 24;
		panel_4.add(comboBox, gbc_comboBox);

		Component verticalStrut_16 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_16 = new GridBagConstraints();
		gbc_verticalStrut_16.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_16.gridx = 0;
		gbc_verticalStrut_16.gridy = 25;
		panel_4.add(verticalStrut_16, gbc_verticalStrut_16);

		JLabel lblNewLabel_2_4_2_1 = new JLabel("Mật khẩu:");
		lblNewLabel_2_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_4_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_4_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_4_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_4_2_1.gridx = 0;
		gbc_lblNewLabel_2_4_2_1.gridy = 26;
		panel_4.add(lblNewLabel_2_4_2_1, gbc_lblNewLabel_2_4_2_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 4;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 26;
		panel_4.add(textField_6, gbc_textField_6);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 27;
		panel_4.add(verticalStrut_5, gbc_verticalStrut_5);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 29;
		panel_4.add(verticalStrut_6, gbc_verticalStrut_6);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 0;
		gbc_verticalStrut_7.gridy = 31;
		panel_4.add(verticalStrut_7, gbc_verticalStrut_7);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 33;
		panel_4.add(horizontalStrut, gbc_horizontalStrut);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 5;
		gbc_horizontalStrut_2.gridy = 33;
		panel_4.add(horizontalStrut_2, gbc_horizontalStrut_2);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue_1 = new GridBagConstraints();
		gbc_horizontalGlue_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue_1.gridx = 6;
		gbc_horizontalGlue_1.gridy = 33;
		panel_4.add(horizontalGlue_1, gbc_horizontalGlue_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_6, BorderLayout.NORTH);

		JLabel lblQunLHa = new JLabel("Quản lý nhân viên ");
		lblQunLHa.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\9554766_technical_support_customer_call_telephone_icon.png"));
		lblQunLHa.setForeground(Color.BLACK);
		lblQunLHa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		panel_6.add(lblQunLHa);

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
				lblQunLHa.setBounds(xposition, 0, lblQunLHa.getPreferredSize().width,
						lblQunLHa.getPreferredSize().height);

			}
		});
		timer.start();

	}

	// doc du lieu tu database
	public void DocdulieudatabasevaoTable() {
		List<NhanVien> listnv = nhanVien_dao.getalltbQLNhanVien();
		for (NhanVien nhanVien : listnv) {
			String maNV = nhanVien.getMaNV();
			String tenNV = nhanVien.getTenNV();
			Date ngaySinh = nhanVien.getNamSinh();
			String chucVu = nhanVien.getChucVu();
			String tenTk = nhanVien.getTaiKhoan().getTenTK();
			tablemodelHD.addRow(new Object[] { maNV, tenNV, ngaySinh, chucVu, tenTk });
		}

	}

	public void XoaTrang() {
		textField_3.setText("");
		textField_4.setText("");
		textField_8.setText("");
		dateChooser.setDate(null);
		textField_9.setText("");
		textField_1.setText("");
		textField_5.setText("");
		dateChooser_1.setDate(null);
		textField_10.setText("");
		rdbtnNewRadioButton_1_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(false);
		textField_6.setText("");
		textField_2.requestFocus();
	}

	public NhanVien revertNhanVienfromTxt() {
		String maNV = textField_2.getText();
		String tenNV = textField_3.getText();
		String tuoi = textField_4.getText();
		int tuoiNV = Integer.parseInt(tuoi);
		String sdt = textField_8.getText();

		// ngaySinh
		java.util.Date utilDate = dateChooser.getDate(); // Lấy giá trị ngày từ JDateChooser
		java.sql.Date ngaySinh = new java.sql.Date(utilDate.getTime()); // Chuyển đổi thành java.sql.Date

		Boolean phai = null;
		// Kiểm tra trạng thái của JRadioButton để thiết lập giá trị cho phai
		if (rdbtnNewRadioButton_2.isSelected()) {
			phai = true; // Nam
		} else if (rdbtnNewRadioButton_1_1.isSelected()) {
			phai = false; // Nữ
		}
		String cmnd = textField_9.getText();
		String chucvu = textField_1.getText();

		String luong = textField_5.getText();
		// Loại bỏ các ký tự không phải số từ chuỗi
		luong = luong.replaceAll("[^\\d]", ""); // chỉ giữ lại các ký tự số và dấu chấm
		float luongNV = Float.parseFloat(luong);

		// ngayVaoLam
		java.util.Date utilDate2 = dateChooser_1.getDate(); // Lấy giá trị ngày từ JDateChooser
		java.sql.Date ngayVaoLam = new java.sql.Date(utilDate2.getTime()); // Chuyển đổi thành java.sql.Date

		String tenTk = comboBox.getSelectedItem().toString();
		TaiKhoan tentaiKhoan = new TaiKhoan(tenTk);
		return new NhanVien(maNV, tenNV, tuoiNV, sdt, ngaySinh, phai, cmnd, chucvu, luongNV, ngayVaoLam, tentaiKhoan);
	}

	public TaiKhoan revertTKfromtxt() {
		// String tenTk=textField_10.getText();
		String tenaccout = comboBox.getSelectedItem().toString();
		String pass = textField_6.getText();
		return new TaiKhoan(tenaccout, pass);
	}

	public void XoadulieuTablemodel() {
		while (tableNhanVien.getRowCount() > 0) {
			tablemodelHD.removeRow(0);
		}
	}

	public String autoMa() {
		String str;
		int ma = nhanVien_dao.getMaNV();
		str = "NV" + String.format("%02d", ma);
		return str;
	}

	// ham de tim kiem nhan vien theo cac tieu chi phu hop
	private void searchandisplayNVbycode() {
		// Lay cac gia tri tim kiem
		String tenNV = textField.getText().trim();
		String chucVu = comboBox_1.getSelectedItem().toString().trim();
		String tenTK = textField_7.getText().trim();

		// Kiểm tra xem tất cả các trường tìm kiếm có trống không
		if (tenNV.isEmpty() && chucVu.isEmpty() && tenTK.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một trường tìm kiếm.");
			return;
		}

		// Xóa dữ liệu hiện tại của bảng
		tablemodelHD.setRowCount(0);

		// Tạo câu truy vấn dựa trên các trường tìm kiếm có giá trị
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM NhanVien WHERE 1=1");
		List<Object> params = new ArrayList<>(); // Danh sách các tham số trong câu truy vấn

		if (!tenNV.isEmpty()) {
			sqlBuilder.append(" AND tenNV = ?");
			params.add(tenNV);
		}
		if (!chucVu.isEmpty()) {
			sqlBuilder.append(" AND chucVu LIKE ?");
			params.add("%" + chucVu + "%");
		}
		if (!tenTK.isEmpty()) {
			sqlBuilder.append(" AND taiKhoan LIKE ?");
			params.add("%" + tenTK + "%");
		}

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();

		// Thực hiện truy vấn và hiển thị kết quả
		try {
			PreparedStatement stmt = con.prepareStatement(sqlBuilder.toString());

			// Đặt các giá trị cho các tham số trong câu truy vấn
			for (int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}

			// Thực hiện truy vấn và lấy kết quả
			try (ResultSet rs = stmt.executeQuery()) {
				boolean found = false;
				while (rs.next()) {
					Object[] row = { rs.getString("maNV"), rs.getString("tenNV"), rs.getDate("ngaySinh"),
							rs.getString("chucVu"), rs.getString("taiKhoan") };
					tablemodelHD.addRow(row); // Thêm hàng mới vào bảng
					found = true;
				}
				if (!found) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên phù hợp với tiêu chí tìm kiếm.");
					DocdulieudatabasevaoTable(); // Hiển thị lại dữ liệu đầy đủ
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(tableNhanVien, "Đã xảy ra lỗi khi tìm kiếm nhân viên!" + ex.getMessage());
		}

	}
	
	// Phương thức để thiết lập JFrame toàn màn hình
    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }

}
