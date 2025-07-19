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
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDayChooser;

import connectDB.ConnectDB;
import dao.ChuyenTau_DAO;
import dao.VeTau_DAO;
import entity.ChuyenTau;
import entity.LoaiGhe;
import entity.NhanVien;
import entity.VeTau;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class QuanLyVeTau_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTable tableVeTau;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField;
	private VeTau_DAO vetau_Dao;
	private DefaultTableModel tablemodelVeTau;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser_1_1;
	private JComboBox comboBox_1;
	private JComboBox<String> comboBox_1_2;
	private JComboBox comboBox;
	private JComboBox comboBox_3;
	private JDateChooser dateChooser;
	private JComboBox comboBox_2;
	private ChuyenTau_DAO chuyenTau_Dao;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyVeTau_GUI frame = new QuanLyVeTau_GUI();
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
	public QuanLyVeTau_GUI() throws IOException {
		setAutoRequestFocus(false);
		setTitle("Quản lý vé tàu");
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
		vetau_Dao = new VeTau_DAO();
		chuyenTau_Dao = new ChuyenTau_DAO();

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
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		Component horizontalStrut = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut);

		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_12);
		mnNewMenu.setBackground(new Color(178, 34, 34));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\8973742_buy_sale_icon.png"));
		menuBar.add(mnNewMenu);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_1);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);

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

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_2);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2);

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

		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_3);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_3);

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

		Component horizontalStrut_1_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_4);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_4);

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

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		mnNewMenu_3.add(horizontalStrut_5);

		Component horizontalStrut_1_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_5);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_10);

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

		Component horizontalStrut_1_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_6);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_6);

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

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		mnNewMenu_5.add(horizontalStrut_7);

		Component horizontalStrut_1_7 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_7);

		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_11);

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

		Component horizontalStrut_1_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_8);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_8);

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

		Component horizontalStrut_1_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_9);

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_9);

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

		JPanel panelTren = new JPanel();
		panelTren.setForeground(new Color(0, 0, 0));
		panelTren.setBackground(new Color(255, 255, 255));
		contentPane.add(panelTren, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Quản lý vé tàu");
		lblNewLabel.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49628_tickets_tix_icon.png"));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		panelTren.add(lblNewLabel);

		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panelCenter.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel_1.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel_2_1 = new JLabel("Ga đi:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 1;
		panel_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		comboBox = new JComboBox<String>();
		ArrayList<ChuyenTau> listgadi = vetau_Dao.getalltbChuyenTau();
		for (ChuyenTau chuyenTau : listgadi) {
			comboBox.addItem(chuyenTau.getGaDi());
		}

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);

		JLabel lblNewLabel_2_2 = new JLabel("Ga đến:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2.gridx = 3;
		gbc_lblNewLabel_2_2.gridy = 1;
		panel_1.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);

		comboBox_3 = new JComboBox<String>();
		ArrayList<ChuyenTau> listgaden = vetau_Dao.getalltbChuyenTau();
		for (ChuyenTau chuyenTau : listgaden) {
			comboBox_3.addItem(chuyenTau.getGaDen());
		}

		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.gridwidth = 2;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 4;
		gbc_comboBox_3.gridy = 1;
		panel_1.add(comboBox_3, gbc_comboBox_3);

		JButton btnNewButton_7 = new JButton("Tìm kiếm\r\n");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchandisplayVTbycode();
			}

		});
		btnNewButton_7.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_7.setBackground(new Color(178, 34, 34));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.gridheight = 7;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 6;
		gbc_btnNewButton_7.gridy = 1;
		panel_1.add(btnNewButton_7, gbc_btnNewButton_7);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		panel_1.add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày đi:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1.gridy = 3;
		panel_1.add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);

		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		panel_1.add(dateChooser, gbc_dateChooser);

		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_13.gridx = 0;
		gbc_horizontalStrut_13.gridy = 4;
		panel_1.add(horizontalStrut_13, gbc_horizontalStrut_13);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 4;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Loại ghế:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_1.gridy = 5;
		panel_1.add(lblNewLabel_2_1_1_1, gbc_lblNewLabel_2_1_1_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "", "Ghế ngồi cứng", "Ghế ngồi mềm",
				"Giường nằm khoang 4", "Giường nằm khoang 6", "Giường nằm khoang 2(VIP)" }));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 5;
		panel_1.add(comboBox_2, gbc_comboBox_2);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 6;
		panel_1.add(verticalStrut_3, gbc_verticalStrut_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 9;
		panel_1.add(verticalStrut_4, gbc_verticalStrut_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch v\u00E9 t\u00E0u", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 11;
		panel_1.add(scrollPane, gbc_scrollPane);

		tableVeTau = new JTable();
		tableVeTau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableVeTau.getSelectedRow();

				Object machuyentau = tablemodelVeTau.getValueAt(row, 1);
				comboBox_1_2.setSelectedItem(machuyentau);

				String maCT = tablemodelVeTau.getValueAt(row, 1).toString();

				try {
					textField_2.setText(vetau_Dao.gettenCTByCode(maCT).toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Date ngaydi = vetau_Dao.getNgayDiByCode(maCT);
					dateChooser_1.setDate(ngaydi);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Date ngayden = vetau_Dao.getNgayDenByCode(maCT);
					dateChooser_1_1.setDate(ngayden);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String gadi = vetau_Dao.getGaDiByCode(maCT).toString();
					textField_5.setText(gadi);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String gaden = vetau_Dao.getGaDenByCode(maCT).toString();
					textField_6.setText(gaden);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int soluongve = vetau_Dao.getSoLuongVeByCode(maCT);
					textField.setText(String.valueOf(soluongve));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField_7.setText(tablemodelVeTau.getValueAt(row, 0).toString());
				textField_9.setText(tablemodelVeTau.getValueAt(row, 2).toString());

				String mavetau = tablemodelVeTau.getValueAt(row, 0).toString();
				Object value1;
				try {
					value1 = vetau_Dao.getMaLoaiGheByCode(mavetau);
					comboBox_1.setSelectedItem(value1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField_1.setText(tablemodelVeTau.getValueAt(row, 4).toString());

				textField_11.setText(tablemodelVeTau.getValueAt(row, 3).toString());

			}
		});
		tableVeTau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tableVeTau);
		tableVeTau.setModel(tablemodelVeTau = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Mã chuyến tàu", "Loại ghế", "Giá vé", "Vị trí ghế" }));

		tableVeTau.setRowHeight(40);

		// doc du lieu tu database vao table
		DocdulieudatabasevaoTable();

		JPanel panel_2 = new JPanel();
		panelCenter.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin v\u1EC1 chuy\u1EBFn t\u00E0u", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_2.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 248, 0, 46, 86, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 0;
		panel.add(verticalStrut_6, gbc_verticalStrut_6);

		JLabel lblNewLabel_1 = new JLabel("Mã chuyến tàu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBox_1_2 = new JComboBox<String>();
		ArrayList<ChuyenTau> listmachuyentau = vetau_Dao.getalltbChuyenTau();
		for (ChuyenTau chuyenTau : listmachuyentau) {
			comboBox_1_2.addItem(chuyenTau.getMaChuyenTau());
		}

		comboBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_1_2 = new GridBagConstraints();
		gbc_comboBox_1_2.gridwidth = 3;
		gbc_comboBox_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_2.gridx = 2;
		gbc_comboBox_1_2.gridy = 1;
		panel.add(comboBox_1_2, gbc_comboBox_1_2);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 2;
		panel.add(verticalStrut_7, gbc_verticalStrut_7);

		JLabel lblNewLabel_1_1 = new JLabel("Tên chuyến tàu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel.add(textField_2, gbc_textField_2);

		Component verticalStrut_7_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_1 = new GridBagConstraints();
		gbc_verticalStrut_7_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_1.gridx = 1;
		gbc_verticalStrut_7_1.gridy = 4;
		panel.add(verticalStrut_7_1, gbc_verticalStrut_7_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày xuất phát:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 5;
		panel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.gridwidth = 3;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 5;
		panel.add(dateChooser_1, gbc_dateChooser_1);

		Component verticalStrut_7_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_2 = new GridBagConstraints();
		gbc_verticalStrut_7_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_2.gridx = 1;
		gbc_verticalStrut_7_2.gridy = 6;
		panel.add(verticalStrut_7_2, gbc_verticalStrut_7_2);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_16 = new GridBagConstraints();
		gbc_horizontalStrut_16.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_16.gridx = 0;
		gbc_horizontalStrut_16.gridy = 7;
		panel.add(horizontalStrut_16, gbc_horizontalStrut_16);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày đến:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 8;
		panel.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		dateChooser_1_1 = new JDateChooser();
		dateChooser_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dateChooser_1_1 = new GridBagConstraints();
		gbc_dateChooser_1_1.gridwidth = 3;
		gbc_dateChooser_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1_1.gridx = 2;
		gbc_dateChooser_1_1.gridy = 8;
		panel.add(dateChooser_1_1, gbc_dateChooser_1_1);

		Component verticalStrut_7_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_3 = new GridBagConstraints();
		gbc_verticalStrut_7_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_3.gridx = 1;
		gbc_verticalStrut_7_3.gridy = 9;
		panel.add(verticalStrut_7_3, gbc_verticalStrut_7_3);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ga khởi hành:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 10;
		panel.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 10;
		panel.add(textField_5, gbc_textField_5);

		Component verticalStrut_7_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_4 = new GridBagConstraints();
		gbc_verticalStrut_7_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_4.gridx = 1;
		gbc_verticalStrut_7_4.gridy = 11;
		panel.add(verticalStrut_7_4, gbc_verticalStrut_7_4);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Ga đến:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 12;
		panel.add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridwidth = 3;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 12;
		panel.add(textField_6, gbc_textField_6);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 13;
		panel.add(verticalStrut_8, gbc_verticalStrut_8);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Số lượng vé:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 14;
		panel.add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 14;
		panel.add(textField, gbc_textField);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 15;
		panel.add(verticalStrut_5, gbc_verticalStrut_5);

		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_14 = new GridBagConstraints();
		gbc_horizontalStrut_14.gridx = 5;
		gbc_horizontalStrut_14.gridy = 16;
		panel.add(horizontalStrut_14, gbc_horizontalStrut_14);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Xóa trắng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				dateChooser_1.setDate(null);
				dateChooser_1_1.setDate(null);
				textField_5.setText("");
				textField_6.setText("");
				textField.setText("");
				textField_7.setText("");
				textField_9.setText("");
				textField_1.setText("");
				textField_11.setText("");
				comboBox_1_2.requestFocus();
			}
		});
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\118917_edit_clear_icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cập nhật\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("")|| dateChooser_1.getDate()==null||
						 dateChooser_1_1.getDate()==null||textField_5.getText().equals("")||
						 textField_6.getText().equals("")||textField.getText().equals("")||
						 textField_7.getText().equals("")||textField_9.getText().equals("")||
						 textField_1.getText().equals("")||textField_11.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				}else {
					VeTau vetau=revertVeTaufromtxt();
					vetau_Dao.updateVTau(vetau);
					JOptionPane.showMessageDialog(panel, "Cập nhật vé tàu thành công!!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					xoatrang();
					
					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1329089_arrows_circle_refresh_replace_round_icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("")|| dateChooser_1.getDate()==null||
						 dateChooser_1_1.getDate()==null||textField_5.getText().equals("")||
						 textField_6.getText().equals("")||textField.getText().equals("")||
						 textField_7.getText().equals("")||textField_9.getText().equals("")||
						 textField_1.getText().equals("")||textField_11.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				}else {
					VeTau vetau=revertVeTaufromtxt();
					vetau_Dao.addVeTau(vetau);
					JOptionPane.showMessageDialog(panel, "Thêm vé tàu thành công!!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					xoatrang();
					
					
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299068_add_sign_icon.png"));
		panel_3.add(btnNewButton_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng tin v\u1EC1 v\u00E9 t\u00E0u", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_2.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel_1_2 = new JLabel("Mã vé:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 0;
		panel_4.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 3;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 9;
		gbc_textField_7.gridy = 0;
		panel_4.add(textField_7, gbc_textField_7);

		Component verticalStrut_7_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_5 = new GridBagConstraints();
		gbc_verticalStrut_7_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_5.gridx = 1;
		gbc_verticalStrut_7_5.gridy = 1;
		panel_4.add(verticalStrut_7_5, gbc_verticalStrut_7_5);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã loại ghế:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 1;
		gbc_lblNewLabel_1_2_1.gridy = 2;
		panel_4.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		comboBox_1 = new JComboBox<String>();
		ArrayList<LoaiGhe> listloaighe = vetau_Dao.getalltableloaiGhe();
		for (LoaiGhe loaiGhe : listloaighe) {
			comboBox_1.addItem(loaiGhe.getMaLoaiGhe());
		}

		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 9;
		gbc_comboBox_1.gridy = 2;
		panel_4.add(comboBox_1, gbc_comboBox_1);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_17 = new GridBagConstraints();
		gbc_horizontalStrut_17.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_17.gridx = 0;
		gbc_horizontalStrut_17.gridy = 3;
		panel_4.add(horizontalStrut_17, gbc_horizontalStrut_17);

		Component verticalStrut_7_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_6 = new GridBagConstraints();
		gbc_verticalStrut_7_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_6.gridx = 1;
		gbc_verticalStrut_7_6.gridy = 4;
		panel_4.add(verticalStrut_7_6, gbc_verticalStrut_7_6);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tên loại ghế:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 1;
		gbc_lblNewLabel_1_2_1_1.gridy = 5;
		panel_4.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridwidth = 3;
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 9;
		gbc_textField_9.gridy = 5;
		panel_4.add(textField_9, gbc_textField_9);

		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_15 = new GridBagConstraints();
		gbc_horizontalStrut_15.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_15.gridx = 12;
		gbc_horizontalStrut_15.gridy = 6;
		panel_4.add(horizontalStrut_15, gbc_horizontalStrut_15);

		Component verticalStrut_7_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_7 = new GridBagConstraints();
		gbc_verticalStrut_7_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_7.gridx = 1;
		gbc_verticalStrut_7_7.gridy = 7;
		panel_4.add(verticalStrut_7_7, gbc_verticalStrut_7_7);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Vị trí ghế:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 8;
		panel_4.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 9;
		gbc_textField_1.gridy = 8;
		panel_4.add(textField_1, gbc_textField_1);

		Component verticalStrut_7_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7_8 = new GridBagConstraints();
		gbc_verticalStrut_7_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7_8.gridx = 1;
		gbc_verticalStrut_7_8.gridy = 9;
		panel_4.add(verticalStrut_7_8, gbc_verticalStrut_7_8);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Giá vé:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_2_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_2_1_1_1_1.gridy = 10;
		panel_4.add(lblNewLabel_1_2_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 0, 5);
		gbc_textField_11.gridwidth = 3;
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 9;
		gbc_textField_11.gridy = 10;
		panel_4.add(textField_11, gbc_textField_11);

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

		// ham combobox
		comboBox_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCT = comboBox_1_2.getSelectedItem().toString();
				try {
					String tenCT = chuyenTau_Dao.getTenCTByCode(maCT).toString();
					textField_2.setText(tenCT);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					Date ngayxp = chuyenTau_Dao.getNgayDiByCode(maCT);
					dateChooser_1.setDate(ngayxp);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				Date ngayden;
				try {
					ngayden = chuyenTau_Dao.getNgayDenByCode(maCT);
					dateChooser_1_1.setDate(ngayden);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					String gadi=vetau_Dao.getGaDiByCode(maCT);
					textField_5.setText(gadi);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					String gaden=vetau_Dao.getGaDenByCode(maCT);
					textField_6.setText(gaden);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int soluongve=vetau_Dao.getSoLuongVeByCode(maCT);
					textField.setText(String.valueOf(soluongve));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				

			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        String maloaighe =comboBox_1.getSelectedItem().toString();
		        
		        String tenloaighe;
				try {
					tenloaighe = vetau_Dao.gettenLoaiGheByCode(maloaighe);
					 textField_9.setText(tenloaighe);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(maloaighe.equals("LG001")) {
					 textField_11.setText("200,000");
				}
				if(maloaighe.equals("LG002")) {
					 textField_11.setText("250,000");
				}
				if(maloaighe.equals("LG003")) {
					 textField_11.setText("300,000");
				}
				if(maloaighe.equals("LG004")) {
					 textField_11.setText("450,000");
				}
				if(maloaighe.equals("LG005")) {
					 textField_11.setText("1,000,000");
				}
				
		        
		      
		        
		        
		
		    }
		});

	}

	// doc du lieu tu database
	public void DocdulieudatabasevaoTable() {
		List<VeTau> listvetau = vetau_Dao.getalltbQLVeTau();

		// Tạo một đối tượng DecimalFormat để định dạng giá vé thành tiền Việt
		DecimalFormat vietnameseCurrencyFormat = new DecimalFormat("#,###");

		for (VeTau veTau : listvetau) {
			String mave = veTau.getMaVe();
			String machuyentau = veTau.getChuyenTau().getMaChuyenTau();
			String loaighe = veTau.getLoaiGhe().getTenLoaiGhe();

			// Định dạng giá vé thành tiền Việt
			String giaveFormatted = vietnameseCurrencyFormat.format(veTau.getGiaVe());

			int vitrighe = veTau.getViTriGhe();
			tablemodelVeTau.addRow(new Object[] { mave, machuyentau, loaighe, giaveFormatted, vitrighe });
		}

	}

	// ham tim kiem ve theo cac truong tim kiem
	private void searchandisplayVTbycode() {

		// Lay cac gia tri tim kiem
		String gadi = comboBox.getSelectedItem().toString();
		String gaden = comboBox_3.getSelectedItem().toString();
		java.util.Date ngaydi = dateChooser.getDate();

		String loaighe = comboBox_2.getSelectedItem().toString();

		// Kiểm tra xem tất cả các trường tìm kiếm có trống không
		if (gadi.isEmpty() && gaden.isEmpty() && ngaydi == null && loaighe.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một trường tìm kiếm.");
			return;
		}
		// Xóa dữ liệu hiện tại của bảng
		tablemodelVeTau.setRowCount(0);

		StringBuilder sqlBuilder = new StringBuilder(
				"SELECT v.maVe, v.maChuyenTau, lg.tenLoaiGhe, v.giaVe, v.viTriGhe, c.gaDi, c.gaDen, c.ngayDi ");
		sqlBuilder.append("FROM VeTau v ");
		sqlBuilder.append("JOIN ChuyenTau c ON v.maChuyenTau = c.maChuyenTau ");
		sqlBuilder.append("JOIN LoaiGhe lg ON v.maLoaiGhe = lg.maLoaiGhe ");
		sqlBuilder.append("WHERE 1=1");

		List<Object> params = new ArrayList<>(); // Danh sách các tham số trong câu truy vấn

		if (!gadi.isEmpty()) {
			sqlBuilder.append(" AND gaDi = ?");
			params.add(gadi);
		}
		if (!gaden.isEmpty()) {
			sqlBuilder.append(" AND gaDen LIKE ?");
			params.add("%" + gaden + "%");
		}
		if (ngaydi != null) {
			java.sql.Date ngaydiSQL = new java.sql.Date(ngaydi.getTime());
			sqlBuilder.append(" AND ngayDi LIKE ?");
			params.add("%" + ngaydiSQL + "%");
		}
		if (!loaighe.isEmpty()) {
			sqlBuilder.append(" AND tenLoaiGhe LIKE ?");
			params.add("%" + loaighe + "%");
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
					String tenloaighe = rs.getString("tenLoaiGhe");
					// Tạo một đối tượng DecimalFormat để định dạng giá vé thành tiền Việt
					DecimalFormat vietnameseCurrencyFormat = new DecimalFormat("#,###");
					// Định dạng giá vé thành tiền Việt
					double giaVe = rs.getDouble("giaVe");
					String giaveFormatted = vietnameseCurrencyFormat.format(giaVe);

					Object[] row = { rs.getString("maVe"), rs.getString("maChuyenTau"), tenloaighe, giaveFormatted,
							rs.getInt("viTriGhe") };
					tablemodelVeTau.addRow(row); // Thêm hàng mới vào bảng
					found = true;
				}
				if (!found) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy vé tàu phù hợp với tiêu chí tìm kiếm.");
					DocdulieudatabasevaoTable(); // Hiển thị lại dữ liệu đầy đủ
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(tableVeTau, "Đã xảy ra lỗi khi tìm kiếm vé tàu!" + ex.getMessage());
		}

	}
	public VeTau revertVeTaufromtxt() {
		String mave=textField_7.getText();
		String machuyentau=comboBox_1_2.getSelectedItem().toString();
		ChuyenTau ctau=new ChuyenTau(machuyentau);
		
		String maloaighe=comboBox_1.getSelectedItem().toString();
		LoaiGhe lghe=new LoaiGhe(maloaighe);
		
		String giave=textField_11.getText();
		giave = giave.replace(",", "");
		Double giaVeTau = Double.parseDouble(giave);
		
		
		String vitri=textField_1.getText();
		int viTriGhe=Integer.parseInt(vitri);
		
		return new VeTau(mave,giaVeTau,viTriGhe, ctau,lghe);
		
	}
	
	public void XoadulieuTablemodel() {
		while (tableVeTau.getRowCount() > 0) {
			tablemodelVeTau.removeRow(0);
		}
	}
	public void xoatrang() {
		textField_2.setText("");
		dateChooser_1.setDate(null);
		dateChooser_1_1.setDate(null);
		textField_5.setText("");
		textField_6.setText("");
		textField.setText("");
		textField_7.setText("");
		textField_9.setText("");
		textField_1.setText("");
		textField_11.setText("");
		comboBox_1_2.requestFocus();
	}

	// Phương thức để thiết lập JFrame toàn màn hình
    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
}

