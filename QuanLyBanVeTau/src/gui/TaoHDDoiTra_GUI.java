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
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DoiTra_DAO;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.PhieuDoiTra;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class TaoHDDoiTra_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTextField textField;
	private JTable tableCT_HoaDon;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_VeTauDT;
	private JTextField textField_5;
	private JTextField textField_6;
	private DoiTra_DAO doitra_dao;
	private DefaultTableModel tablemodelDoitra;
	private JRadioButton rdbtnTrV;
	private JRadioButton rdbtnNewRadioButton;
	private JDateChooser dateChooser;
	private DefaultTableModel tablemodel_VeTau;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoHDDoiTra_GUI frame = new TaoHDDoiTra_GUI();
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
	public TaoHDDoiTra_GUI() throws IOException {
		setTitle("Tạo hóa đơn đổi trả ");
		setName("\r\n");
		setAlwaysOnTop(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\JavaProject\\QuanLyBanVeTau\\icons\\5452470_high_speed_train_tram_vehicle_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1619, 789);

		// ket noi database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// khoitao DAO
		doitra_dao = new DoiTra_DAO();

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

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2);

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
		mnNewMenu.setBackground(new Color(178, 34, 34));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\8973742_buy_sale_icon.png"));
		menuBar.add(mnNewMenu);

		Component horizontalStrut_2_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_1);

		Component horizontalStrut_2_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_2);

		JMenu mnNewMenu_1 = new JMenu("Đơn Vé ");
		mnNewMenu_1.setBackground(new Color(178, 34, 34));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\416404_bill_receipt_icon.png"));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Tra cứu thông tin hóa đơn");
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mntmNewMenuItem.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem.setBackground(new Color(178, 34, 34));
		mntmNewMenuItem.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem);

		Component horizontalStrut_2_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_3);

		Component horizontalStrut_2_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_4);

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

		Component horizontalStrut_2_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_5);

		Component horizontalStrut_2_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_6);

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

		Component horizontalStrut_2_7 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_7);

		Component horizontalStrut_2_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_8);

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

		Component horizontalStrut_2_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_9);

		Component horizontalStrut_2_10 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_10);

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

		Component horizontalStrut_2_11 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_11);

		Component horizontalStrut_2_12 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_12);

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

		Component horizontalStrut_2_13 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_13);

		Component horizontalStrut_2_14 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_14);

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

		Component horizontalStrut_2_15 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_15);

		Component horizontalStrut_2_16 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_16);

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

		Component horizontalStrut_2_17 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_17);

		Component horizontalStrut_2_18 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2_18);

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

		JLabel lblNewLabel = new JLabel("Tạo hóa đơn đổi trả ");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\6141398_bill_invoice_payment_receipt_icon.png"));
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
				searchAndDisplayHDByCode();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\5402443_search_find_magnifier_magnifying_magnifying glass_icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(178, 34, 34));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin h\u00F3a \u0111\u01A1n ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);

		tableCT_HoaDon = new JTable();
		tableCT_HoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableCT_HoaDon.getSelectedRow();
				String maHoadon = tableCT_HoaDon.getValueAt(row, 0).toString();

				String maNV = doitra_dao.getMaNVByIdHoaDon(maHoadon);
				textField_1.setText(maNV);

				String tenNV = doitra_dao.getTenNVByIdNV(maNV);
				textField_2.setText(tenNV);

				textField_4.setText(maHoadon);

				// bang vetau
				DefaultTableModel sourceModel = (DefaultTableModel) tableCT_HoaDon.getModel();
				DefaultTableModel destinationModel = (DefaultTableModel) table_VeTauDT.getModel();
				// Lấy các dòng đã chọn trong bảng nguồn
				int[] selectedRows = tableCT_HoaDon.getSelectedRows();

				// Xác định các chỉ số của các cột cần sao chép
				int[] columnsToCopy = { 1, 2, 3, 4 };

				 //Xóa các dòng hiện có trong bảng đích
				destinationModel.setRowCount(0);
				
				// Sao chép các dòng đã chọn từ bảng nguồn sang bảng đích
				for (int rowIndex : selectedRows) {
					Object[] rowData = new Object[columnsToCopy.length];
					for (int i = 0; i < columnsToCopy.length; i++) {
						rowData[i] = sourceModel.getValueAt(rowIndex, columnsToCopy[i]);
					}
					destinationModel.addRow(rowData);
				}

				calculateTotal(3);
				String maKH;
				try {
					maKH = doitra_dao.getMaKHByCode(maHoadon);
					textField_7.setText(maKH);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String tenKH;

				try {
					String maKHtim = textField_7.getText();
					tenKH = doitra_dao.getTenKHtuMaKH(maKHtim);
					textField_8.setText(tenKH);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		tableCT_HoaDon.setRowHeight(40);
		tableCT_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tableCT_HoaDon);
		tableCT_HoaDon.setModel(tablemodelDoitra = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền" }));

		// doc du lieu tu database vao table
		DocdulieudatabasevaoTable();

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Nh\u00E2n vi\u00EAn ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panel_3.add(panel_4, BorderLayout.NORTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 2;
		gbc_verticalStrut_3.gridy = 0;
		panel_4.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 1;
		panel_4.add(horizontalStrut_5, gbc_horizontalStrut_5);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 4;
		gbc_horizontalStrut_6.gridy = 1;
		panel_4.add(horizontalStrut_6, gbc_horizontalStrut_6);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 1;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 2;
		panel_4.add(horizontalStrut_4, gbc_horizontalStrut_4);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 3;
		panel_4.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 4;
		panel_4.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		panel_4.add(textField_2, gbc_textField_2);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridx = 2;
		gbc_verticalStrut_5.gridy = 5;
		panel_4.add(verticalStrut_5, gbc_verticalStrut_5);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u1ED5i tr\u1EA3", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_3.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 0;
		panel_5.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblNewLabel_1_2 = new JLabel("Mã HDDT:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 1;
		panel_5.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		textField_3 = new JTextField();
		textField_3.setText(doitra_dao.taoMaHoaDonTuDong());
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 6;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 1;
		panel_5.add(textField_3, gbc_textField_3);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 9;
		gbc_horizontalStrut.gridy = 1;
		panel_5.add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 11;
		gbc_lblNewLabel_1_2_1.gridy = 1;
		panel_5.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 12;
		gbc_textField_4.gridy = 1;
		panel_5.add(textField_4, gbc_textField_4);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 2;
		panel_5.add(horizontalStrut_3, gbc_horizontalStrut_3);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		panel_5.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày đổi trả:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 1;
		gbc_lblNewLabel_1_2_1_1.gridy = 3;
		panel_5.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);

		dateChooser = new JDateChooser();
		setCurrentDate(dateChooser);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 9;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.anchor = GridBagConstraints.NORTH;
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 3;
		panel_5.add(dateChooser, gbc_dateChooser);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 4;
		panel_5.add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_3.gridx = 1;
		gbc_lblNewLabel_1_2_1_3.gridy = 5;
		panel_5.add(lblNewLabel_1_2_1_3, gbc_lblNewLabel_1_2_1_3);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 7;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 5;
		panel_5.add(textField_7, gbc_textField_7);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 3;
		gbc_verticalStrut_9.gridy = 6;
		panel_5.add(verticalStrut_9, gbc_verticalStrut_9);

		JLabel lblNewLabel_1_2_1_4 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_4.gridx = 1;
		gbc_lblNewLabel_1_2_1_4.gridy = 7;
		panel_5.add(lblNewLabel_1_2_1_4, gbc_lblNewLabel_1_2_1_4);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 7;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 7;
		panel_5.add(textField_8, gbc_textField_8);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Loại:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 8;
		panel_5.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);

		rdbtnTrV = new JRadioButton("Trả vé ");
		rdbtnTrV.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_rdbtnTrV = new GridBagConstraints();
		gbc_rdbtnTrV.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTrV.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTrV.gridx = 7;
		gbc_rdbtnTrV.gridy = 8;
		panel_5.add(rdbtnTrV, gbc_rdbtnTrV);

		rdbtnNewRadioButton = new JRadioButton("Đổi vé");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 10;
		gbc_rdbtnNewRadioButton.gridy = 8;
		panel_5.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"V\u00E9 T\u00E0u ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 13;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 10;
		panel_5.add(scrollPane_1, gbc_scrollPane_1);

		table_VeTauDT = new JTable();
		table_VeTauDT.setRowHeight(30);
		scrollPane_1.setViewportView(table_VeTauDT);
		table_VeTauDT.setModel(tablemodel_VeTau = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Số lượng", "Đơn giá", "Thành tiền" }));
		table_VeTauDT.setFont(new Font("Tahoma", Font.PLAIN, 15));

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 11;
		panel_5.add(verticalStrut_8, gbc_verticalStrut_8);

		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Lý do:");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_2_1_1_2.gridy = 12;
		panel_5.add(lblNewLabel_1_2_1_1_2, gbc_lblNewLabel_1_2_1_1_2);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 9;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 12;
		panel_5.add(textField_5, gbc_textField_5);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 5;
		gbc_verticalStrut_6.gridy = 14;
		panel_5.add(verticalStrut_6, gbc_verticalStrut_6);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Tiền hoàn:");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_2.gridx = 1;
		gbc_lblNewLabel_1_2_1_2.gridy = 15;
		panel_5.add(lblNewLabel_1_2_1_2, gbc_lblNewLabel_1_2_1_2);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 9;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 15;
		panel_5.add(textField_6, gbc_textField_6);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 16;
		panel_5.add(verticalStrut_7, gbc_verticalStrut_7);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_1 = new JButton("Xóa trắng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText(doitra_dao.taoMaHoaDonTuDong());
				textField_4.setText("");

				rdbtnNewRadioButton.setSelected(false);
				rdbtnTrV.setSelected(false);
				tablemodel_VeTau.setRowCount(0);
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_1.requestFocus();

			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\118917_edit_clear_icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Thêm 1 vé ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = tableCT_HoaDon.getSelectedRow();
				// bang vetau
				DefaultTableModel sourceModel = (DefaultTableModel) tableCT_HoaDon.getModel();
				DefaultTableModel destinationModel = (DefaultTableModel) table_VeTauDT.getModel();
				//Xóa các dòng hiện có trong bảng đích
				destinationModel.setRowCount(0);
				// Lấy các dòng đã chọn trong bảng nguồn
				int[] selectedRows = tableCT_HoaDon.getSelectedRows();

				// Xác định các chỉ số của các cột cần sao chép
				int[] columnsToCopy = { 1, 2, 3, 4 };

			
				// Sao chép các dòng đã chọn từ bảng nguồn sang bảng đích
				for (int rowIndex : selectedRows) {
					Object[] rowData = new Object[columnsToCopy.length];
					for (int i = 0; i < columnsToCopy.length; i++) {
						rowData[i] = sourceModel.getValueAt(rowIndex, columnsToCopy[i]);
					}
					destinationModel.addRow(rowData);
				}
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(178, 34, 34));
		btnNewButton_2.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299068_add_sign_icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Tạo đơn đổi trả");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().equals("") || dateChooser.getDate() == null
						|| textField_4.getText().equals("") || textField_5.getText().equals("")
						|| textField_6.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					PhieuDoiTra phieudt = revertfromtxt();
					doitra_dao.addPhieuDT(phieudt, tablemodel_VeTau);
					JOptionPane.showMessageDialog(panel, "Thêm phiếu đổi trả thành công!!");
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					XoaTrang();
				}

			}
		});
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(178, 34, 34));
		btnNewButton_3
				.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\285657_floppy_guardar_save_icon.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(btnNewButton_3);

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

	// doc du lieu tu database HoaDOn
	public void DocdulieudatabasevaoTable() {
		List<CT_HoaDon> list = doitra_dao.getalltbCTHoaDon();
		for (CT_HoaDon ct_HoaDon : list) {
			String maHD = ct_HoaDon.getHoaDon().getMaHD();
			String mave = ct_HoaDon.getVeTau().getMaVe();
			int soluong = ct_HoaDon.getSoLuong();

			double dongiatt = ct_HoaDon.getDonGiaTruocThue();
			DecimalFormat formatter = new DecimalFormat("###,###,###,###.## ₫");
			String donGiaTruocThue = formatter.format(dongiatt);

			double dongiast = ct_HoaDon.getDonGiaSauThue();
			String donGiaSauThue = formatter.format(dongiast);

			tablemodelDoitra.addRow(new Object[] { maHD, mave, soluong, donGiaTruocThue, donGiaSauThue });
		}

	}

	public static void setCurrentDate(JDateChooser dateChooser) {
		// Lấy ngày hiện tại
		java.util.Date currentDate = new java.util.Date();
		// Đặt ngày hiện tại cho JDateChooser
		dateChooser.setDate(currentDate);
	}

	public void XoaTrang() {
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText(doitra_dao.taoMaHoaDonTuDong());
		textField_4.setText("");

		rdbtnNewRadioButton.setSelected(false);
		rdbtnTrV.setSelected(false);
		tablemodel_VeTau.setRowCount(0);
		textField_6.setText("");
		textField_5.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_1.requestFocus();
	}

	private void searchAndDisplayHDByCode() {
		// Lấy mã Chuyến tàu từ TextField
		String maHoaDon = textField.getText().trim();
		// Xóa dữ liệu hiện tại của bảng
		tablemodelDoitra.setRowCount(0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM CT_HoaDon WHERE maHD = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHoaDon);

			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = stmt.executeQuery();
			boolean found = false;
			while (rs.next()) {
				double dongiatt = rs.getDouble("donGiaTruocThue");
				double dongiast = rs.getDouble("donGiaSauThue");
				DecimalFormat formatter = new DecimalFormat("###,###,###,###.## ₫");
				String giatt = formatter.format(dongiatt);
				String giast = formatter.format(dongiast);

				Object[] row = { rs.getString("maHD"), rs.getString("maVe"), rs.getInt("soLuong"), giatt, giast };
				tablemodelDoitra.addRow(row); // Thêm hàng mới vào bảng
				found = true;
				textField.requestFocus();

			}
			if (!found) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có mã " + maHoaDon);
				textField.setText("");
				DocdulieudatabasevaoTable();
				textField.requestFocus();

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(tableCT_HoaDon, "Đã xảy ra lỗi khi tìm kiếm hóa đơn!" + ex.getMessage());
		}
	}

	private void calculateTotal(int columnIndex) {
		if (columnIndex == -1) {
			// Không có cột nào được chọn
			textField_6.setText("");
			return;
		}

		double total = 0;
		int rowCount = table_VeTauDT.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String stringValue = (String) table_VeTauDT.getValueAt(i, columnIndex);
			try {
				double doubleValue = Double.parseDouble(stringValue.replaceAll("[₫,]", ""));
				total += doubleValue;
			} catch (NumberFormatException e) {
				// Xử lý nếu giá trị không thể chuyển đổi thành số
				e.printStackTrace();
			}
		}

		DecimalFormat formatter = new DecimalFormat("###,###,###,###.## ₫");
		double tongtien = total;
		String tongTienHoan = formatter.format(tongtien);
		textField_6.setText(tongTienHoan);

	}

	public PhieuDoiTra revertfromtxt() {
		String maphieuDT = textField_3.getText();
		String maHD = textField_4.getText();
		HoaDon hoadon = new HoaDon(maHD);
		java.util.Date thoigiantaoPhieuDT = dateChooser.getDate();
		Date thoigiantaophieu = new Date(thoigiantaoPhieuDT.getTime());

		boolean tra = false;
		// Kiểm tra trạng thái của JRadioButton để thiết lập giá trị cho tra
		if (rdbtnNewRadioButton.isSelected()) {
			tra = false; // doi
		} else if (rdbtnTrV.isSelected()) {
			tra = true; // tra
		}

		double tongtien = 0.0;
		try {
			// Lấy giá trị từ textField_6 và chuyển đổi từ chuỗi sang double
			tongtien = Double.parseDouble(textField_6.getText().replaceAll("[₫,]", ""));
		} catch (NumberFormatException e) {
			// Xử lý nếu giá trị không thể chuyển đổi thành double
			e.printStackTrace();
		}

		String lydo = textField_5.getText();
		// Truyền giá trị từ enum TrangThai
		PhieuDoiTra.TrangThai trangThai = PhieuDoiTra.TrangThai.DANG_CHO;

		return new PhieuDoiTra(maphieuDT, hoadon, thoigiantaophieu, tra, tongtien, lydo, trangThai);

	}

	public void XoadulieuTablemodel() {
		while (tableCT_HoaDon.getRowCount() > 0) {
			tablemodelDoitra.removeRow(0);
		}
	}
	// Phương thức để thiết lập JFrame toàn màn hình
    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }

}
