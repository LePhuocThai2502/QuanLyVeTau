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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.ChuyenTau_DAO;
import dao.HoaDon_DAO;
import entity.CT_HoaDon;
import entity.ChuyenTau;
import entity.HoaDon;
import entity.NhanVien;

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

public class HoaDonBan_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTable tableHoaDon;
	private JTable tableCT_hoaDon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private DefaultTableModel tablemodelHD;
	private DefaultTableModel tablemodelCTHD;
	private HoaDon_DAO hoaDon_Dao;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonBan_GUI frame = new HoaDonBan_GUI();
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
	public HoaDonBan_GUI() throws IOException {
		setAutoRequestFocus(false);
		setTitle("Quản lý hóa đơn");
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
		hoaDon_Dao = new HoaDon_DAO();

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

		JLabel lblNewLabel = new JLabel("Mã đơn hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 14;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày mua:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 19;
		gbc_lblNewLabel_2_1_1.gridy = 1;
		panel_1.add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 22;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 21;
		gbc_dateChooser.gridy = 1;
		panel_1.add(dateChooser, gbc_dateChooser);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lay cac gia tri tim kiem
//				String maHD = textField.getText();
//				String maKH = textField_1.getText();
//
//				java.util.Date utilDate = dateChooser.getDate();
//				Date ngaylap = null;
//				if (utilDate != null) {
//					ngaylap = new Date(utilDate.getTime());
//				}
//
//				// Biến cờ để đánh dấu liệu có thực hiện tìm kiếm hay không
//				boolean hasSearch = false;
//
//				if (!maHD.isEmpty()) {
//					DefaultTableModel tableTimKiemTheoMaHD = hoaDon_Dao.searchInvoiceByTicketCode(maHD);
//					tableHoaDon.setModel(tableTimKiemTheoMaHD);
//					hasSearch = true;
//				}
//				if (!maKH.isEmpty()) {
//					DefaultTableModel tableTimKiemTheoMaKH = hoaDon_Dao.searchInvoiceByCusID(maKH);
//					tableHoaDon.setModel(tableTimKiemTheoMaKH);
//					hasSearch = true;
//				}
//				if (ngaylap != null) {
//					DefaultTableModel tableTimKiemTheoNgayLap = hoaDon_Dao.searchInvoiceByNgayLap(ngaylap);
//					tableHoaDon.setModel(tableTimKiemTheoNgayLap);
//					hasSearch = true;
//				}
//				// Kiểm tra nếu không có tìm kiếm nào được thực hiện, hiển thị thông báo lỗi
//				if (!hasSearch) {
//					JOptionPane.showMessageDialog(panel, "Vui lòng nhập ít nhất một trường tìm kiếm.", "Thông báo",
//							JOptionPane.ERROR_MESSAGE);
//				}
				searchandisplayKHbycode();

			}
		});
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

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 14;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		panel_1.add(textField_1, gbc_textField_1);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 19;
		gbc_verticalStrut_1.gridy = 4;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
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

		tableHoaDon = new JTable();
		tableHoaDon.setRowHeight(40);
		tableHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableHoaDon.getSelectedRow();
				if (row != -1 && row < tablemodelHD.getRowCount()) {
					TableModel mainTableModel = tableHoaDon.getModel();
					DefaultTableModel detailTableModel = getInvoiceDetailsTableModel(mainTableModel, row);
					tableCT_hoaDon.setModel(detailTableModel);

					// Set thong tin khach hang

					String maKH = tablemodelHD.getValueAt(row, 2).toString();
					String tenKH = hoaDon_Dao.getCustomerNameById(maKH);
					String sdt = hoaDon_Dao.getSDTbyID(maKH);

					textField_4.setText(tenKH);
					textField_5.setText(sdt);
					textField_6.setText(tablemodelHD.getValueAt(row, 4).toString());
				}
				
				

			}
		});
		scrollPane.setViewportView(tableHoaDon);
		tableHoaDon.setModel(tablemodelHD = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Nhân viên", "Khách hàng", "Ngày mua", "Thành tiền" }));

		// doc du lieu tu CSDL
		DocdulieudatabasevaoTable();

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_3.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 0;
		panel_4.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 1;
		panel_4.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		panel_4.add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNewLabel_2_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2.gridx = 1;
		gbc_lblNewLabel_2_2.gridy = 3;
		panel_4.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 3;
		panel_4.add(textField_5, gbc_textField_5);

		JLabel lblNewLabel_2_3 = new JLabel("Tổng tiền:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_3.gridx = 1;
		gbc_lblNewLabel_2_3.gridy = 4;
		panel_4.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 4;
		panel_4.add(textField_6, gbc_textField_6);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 5;
		panel_4.add(verticalStrut_4, gbc_verticalStrut_4);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(scrollPane_1);

		tableCT_hoaDon = new JTable();
		tableCT_hoaDon.setRowHeight(40);
		scrollPane_1.setViewportView(tableCT_hoaDon);
		tableCT_hoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Giá vé trước thuế", "Giá vé sau thuế", "S\u1ED1 l\u01B0\u1EE3ng" }));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_6, BorderLayout.NORTH);

		JLabel lblQunLHa = new JLabel("Quản lý hóa đơn");
		lblQunLHa.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\3319634_bill_paper_receipt_sheet_icon.png"));
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

	// doc du lieu tu database HoaDOn
	public void DocdulieudatabasevaoTable() {
		List<HoaDon> list = hoaDon_Dao.getalltbHoaDon();
		for (HoaDon hoaDon2 : list) {
			String maHoaDOn = hoaDon2.getMaHD();

			String maNV = hoaDon2.getNhanVien().getMaNV();
			String tenNV = hoaDon_Dao.getTenNV(maNV);

			String maKH = hoaDon2.getKhachHang().getMaKH();
			Date ngaylap = hoaDon2.getNgayLapHD();
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			String formattedDate = formatter1.format(ngaylap);

			double thanhtien = hoaDon2.getTongDoanhThu();
			DecimalFormat formatter = new DecimalFormat("###,###,###,###.## ₫");
			String formattedAmount = formatter.format(thanhtien);
			tablemodelHD.addRow(new Object[] { maHoaDOn, tenNV, maKH, formattedDate, formattedAmount });
		}

	}

	// Hàm để lấy thông tin chi tiết hóa đơn và thêm vào table model
	public DefaultTableModel getInvoiceDetailsTableModel(TableModel mainTableModel, int selectedRow) {
		// Lấy mã hóa đơn từ table model chính
		Object invoiceCode = tableHoaDon.getValueAt(selectedRow, 0);

		// Tạo table model chi tiết hóa đơn
		String[] columnNames = { "Mã Vé", "Giá vé trước thuế", "Giá vé sau thuế", "Số Lượng" };
		DefaultTableModel detailTableModel = new DefaultTableModel(columnNames, 0);

		// Lấy danh sách chi tiết hóa đơn từ cơ sở dữ liệu
		List<Object[]> invoiceItems = hoaDon_Dao.getInvoiceItemsByCodeFromDatabase(invoiceCode);

		// Thêm dữ liệu vào table model chi tiết hóa đơn
		for (Object[] item : invoiceItems) {
			detailTableModel.addRow(item);
		}

		return detailTableModel;
	}
	
	// ham de tim kiem cac truong du lieu
		private void searchandisplayKHbycode() {
			// Lay cac gia tri tim kiem
			String maHD = textField.getText().trim();
			String maKH = textField_1.getText().trim();
			java.util.Date ngaylapHD = dateChooser.getDate();
			
			
			// Kiểm tra xem tất cả các trường tìm kiếm có trống không
			if (maHD.isEmpty() && maKH.isEmpty() && ngaylapHD==null) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một trường tìm kiếm.");
				return;
			}
			// Xóa dữ liệu hiện tại của bảng
			tablemodelHD.setRowCount(0);
			
			// Tạo câu truy vấn dựa trên các trường tìm kiếm có giá trị
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM HoaDon WHERE 1=1");
			List<Object> params = new ArrayList<>(); // Danh sách các tham số trong câu truy vấn
			
			if (!maHD.isEmpty()) {
				sqlBuilder.append(" AND maHD = ?");
				params.add(maHD);
			}
			if (!maKH.isEmpty()) {
				sqlBuilder.append(" AND maKH LIKE ?");
				params.add("%" + maKH + "%");
			}
			if (ngaylapHD!=null) {
				java.sql.Date ngaylapHDSQL = new java.sql.Date(ngaylapHD.getTime());
				sqlBuilder.append(" AND ngayLapHD LIKE ?");
				params.add("%" + ngaylapHDSQL + "%");
				
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
						DecimalFormat formatter = new DecimalFormat("#,###"); 
						String formattedTongDoanhThu = formatter.format(rs.getDouble("tongDoanhThu")); // Định dạng số tiền

				
						Object[] row = { rs.getString("maHD"),  rs.getString("maNV"),
								rs.getString("maKH"),rs.getDate("ngayLapHD"),formattedTongDoanhThu		
						};
						tablemodelHD.addRow(row); // Thêm hàng mới vào bảng
						found = true;
					}
					if (!found) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng phù hợp với tiêu chí tìm kiếm.");
						DocdulieudatabasevaoTable(); // Hiển thị lại dữ liệu đầy đủ
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(tableHoaDon, "Đã xảy ra lỗi khi tìm kiếm khách hàng!" + ex.getMessage());
			}

		}
		
		// Phương thức để thiết lập JFrame toàn màn hình
	    public void setFullScreen() {
	        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
	        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	        gd.setFullScreenWindow(this);
	    }

}
