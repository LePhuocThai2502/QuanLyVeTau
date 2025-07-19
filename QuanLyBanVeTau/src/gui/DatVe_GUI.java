package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
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
import javax.swing.JDialog;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.BanVe_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.CT_HoaDon;
import entity.ChuyenTau;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.VeTau;
import net.sf.jasperreports.components.iconlabel.IconLabelComponent;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DatVe_GUI extends JFrame {
	private static int soLuongHoaDon = 1;
	private static int soLuongKhachHang = 1;
	private static DefaultTableModel tableModelxlydontam1;
	private static DefaultTableModel tableModelxlydontam2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTextField textField;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private BanVe_DAO datve_dao;
	private DefaultTableModel tablemodel2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_6;
	private JTextField textField_10;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextField textField_11;
	private JComboBox comboBox;
	private KhachHang_DAO khachHang_Dao;
	private JComboBox comboBox_1;
	private NhanVien_DAO nhanVien_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatVe_GUI frame = new DatVe_GUI();
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
	public DatVe_GUI() throws IOException {
		setTitle("Trang đặt vé ");
		setName("\r\n");
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

		// khoi tao DAO
		datve_dao = new BanVe_DAO();
		khachHang_Dao = new KhachHang_DAO();
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

		Component horizontalStrut = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);

		JMenu mnNewMenu = new JMenu("Đặt Vé");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_3);

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

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_4);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_5);

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

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_6);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_7);

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

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_8);

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_9);

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

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_10);

		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_11);

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

		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_12);

		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_13);

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

		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_14);

		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_15);

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

		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_16);

		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_17);

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

		Component horizontalStrut_18 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_18);

		Component horizontalStrut_19 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_19);

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Đặt Vé Tàu ");
		lblNewLabel.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49627_ticket_tix_icon.png"));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
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

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSale();

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\299068_add_sign_icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(178, 34, 34));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String value = textField_7.getText();
				textField_8.setText(value);
			}
		});
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

		table = new JTable();
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		table.setModel(tablemodel2 = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Mã chuyến tàu", "Số lượng", "Giá vé", "Giá trước thuế", "Thành tiền" }));

//		//doc du lieu tu database vao table
		// DocdulieudatabasevaoTableHDon();

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_1 = new JButton("THANH TOÁN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Them Khach Hang vao 1 Hoa Don
//				if (textField_1.getText().equals("") || textField_2.getText().equals("")
//						|| textField_10.getText().equals("") || textField_11.getText().equals("")) {
//					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin khách hàng");
//				} else {
//					textField_1.setText(autoMa());
//					KhachHang kh = revertKHfromTxt();
//					datve_dao.addKhachHangMoi(kh);
//				}

				// Ham Xuat Hoa Don
				if (comboBox.getSelectedItem().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("") || textField_6.getText().equals("")
						|| textField_8.getText().equals("") || comboBox_1.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin để xuất hóa đơn !!");
				} else {
					HoaDon hoadon = null;
					KhachHang kh = null;
					try {

						// kh = revertKHfromTxt();
						hoadon = revertHoaDonfromTxt();

					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					textField_3.setText(datve_dao.taoMaHoaDonTuDong());
					setTextFieldCurrentDate(textField_4);
					datve_dao.addHoaDon(hoadon, tablemodel2);

					JOptionPane.showMessageDialog(panel, "Thêm hóa đơn thành công!!");
				}

				// In hoa don
				generatePDF();
				XoaTrang();

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\4288566_banking_bill_card_credit_expenditure_icon.png"));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("HỦY ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có xác nhận hủy hóa đơn này không?", "Xác nhận",
						JOptionPane.YES_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					tablemodel2.setRowCount(0);
					textField.requestFocus();
				} else {

				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\1398919_close_cross_incorrect_invalid_x_icon.png"));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1_1.setBackground(new Color(178, 34, 34));
		panel_6.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Xóa 1 Vé ");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\118917_edit_clear_icon.png"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				tablemodel2.removeRow(row);
			}
		});
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1_1_1.setBackground(new Color(178, 34, 34));
		panel_6.add(btnNewButton_1_1_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_3.add(panel_4, BorderLayout.NORTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 0;
		panel_4.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBox = new JComboBox<String>();
		ArrayList<KhachHang> maKH = khachHang_Dao.getalltbQLKhachHang();
		for (KhachHang khachHang : maKH) {
			comboBox.addItem(khachHang.getMaKH());
		}

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_4.add(comboBox, gbc_comboBox);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		panel_4.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel_2 = new JLabel("Họ và tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel_4.add(textField_2, gbc_textField_2);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 0;
		gbc_verticalStrut_11.gridy = 5;
		panel_4.add(verticalStrut_11, gbc_verticalStrut_11);

		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 6;
		panel_4.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.gridwidth = 5;
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 6;
		panel_4.add(textField_10, gbc_textField_10);

		Component verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_12.gridx = 0;
		gbc_verticalStrut_12.gridy = 8;
		panel_4.add(verticalStrut_12, gbc_verticalStrut_12);

		JLabel lblNewLabel_1_2_2 = new JLabel("Email:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_2.gridx = 0;
		gbc_lblNewLabel_1_2_2.gridy = 9;
		panel_4.add(lblNewLabel_1_2_2, gbc_lblNewLabel_1_2_2);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.gridwidth = 5;
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 2;
		gbc_textField_11.gridy = 9;
		panel_4.add(textField_11, gbc_textField_11);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 0;
		gbc_verticalStrut_10.gridy = 10;
		panel_4.add(verticalStrut_10, gbc_verticalStrut_10);

		JLabel lblNewLabel_1_2_1 = new JLabel("Giới tính:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_2_1.gridy = 11;
		panel_4.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 11;
		panel_4.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 4;
		gbc_rdbtnNewRadioButton_1.gridy = 11;
		panel_4.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_3.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 0;
		panel_5.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_1_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel_5.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		// Tao maHD tu dong
		textField_3 = new JTextField();
		textField_3.setText(datve_dao.taoMaHoaDonTuDong());

		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_5.add(textField_3, gbc_textField_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 2;
		panel_5.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày lập HD:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		panel_5.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		// Tao ngayLapHD tu dong
		textField_4 = new JTextField();
		setTextFieldCurrentDate(textField_4);

		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_5.add(textField_4, gbc_textField_4);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 4;
		panel_5.add(verticalStrut_5, gbc_verticalStrut_5);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 5;
		panel_5.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		comboBox_1 = new JComboBox<String>();
		ArrayList<NhanVien> listmanv = nhanVien_dao.getalltbQLNhanVien();
		for (NhanVien nhanVien : listmanv) {
			comboBox_1.addItem(nhanVien.getMaNV());
		}

		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 5;
		panel_5.add(comboBox_1, gbc_comboBox_1);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 6;
		panel_5.add(verticalStrut_6, gbc_verticalStrut_6);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 7;
		panel_5.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 7;
		panel_5.add(textField_6, gbc_textField_6);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 9;
		panel_5.add(verticalStrut_2, gbc_verticalStrut_2);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 0;
		gbc_verticalStrut_8.gridy = 11;
		panel_5.add(verticalStrut_8, gbc_verticalStrut_8);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tiền khách phải trả:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 12;
		panel_5.add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 2;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 12;
		panel_5.add(textField_8, gbc_textField_8);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 0;
		gbc_verticalStrut_7.gridy = 14;
		panel_5.add(verticalStrut_7, gbc_verticalStrut_7);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Tiền khách đưa:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 15;
		panel_5.add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.gridwidth = 2;
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 15;
		panel_5.add(textField_9, gbc_textField_9);

		Component verticalStrut_13 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_13 = new GridBagConstraints();
		gbc_verticalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_13.gridx = 0;
		gbc_verticalStrut_13.gridy = 17;
		panel_5.add(verticalStrut_13, gbc_verticalStrut_13);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 3;
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 22;
		panel_5.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_8.rowHeights = new int[] { 0, 0 };
		gbl_panel_8.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		JLabel lblNewLabel_3 = new JLabel("Tổng tiền:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_8.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textField_7 = new JTextField();

		textField_7.setBorder(null);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 0;
		panel_8.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

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

		// ham combobox khach hang
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maKH = comboBox.getSelectedItem().toString();

				try {
					String hotenKh = khachHang_Dao.gettenKHbyCode(maKH);
					textField_2.setText(hotenKh);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					String sdt = khachHang_Dao.getsdtbyCode(maKH);
					textField_10.setText(sdt);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					String email = khachHang_Dao.getEmailByCode(maKH);
					textField_11.setText(email);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					boolean gioitinh = khachHang_Dao.getPhaiByCode(maKH);
					if (!gioitinh) {
						rdbtnNewRadioButton.setSelected(false);
						rdbtnNewRadioButton_1.setSelected(true);
					} else {
						rdbtnNewRadioButton.setSelected(true);
						rdbtnNewRadioButton_1.setSelected(false);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// ham combobox nhan vien:
		comboBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maNV = comboBox_1.getSelectedItem().toString();

				try {
					String tenNV = nhanVien_dao.gettenByCode(maNV);
					textField_6.setText(tenNV);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	// Ham tinh tong thanh tien truoc thue
	private double calculateTotal() {
		double total = 0.0;
		for (int i = 0; i < tablemodel2.getRowCount(); i++) {
			double thanhTien = (double) tablemodel2.getValueAt(i, 5); // Cột 4 là cột chứa thành tiền
			total += thanhTien; // Cộng giá trị của mỗi hàng vào tổng
		}
		return total;
	}

	// Ham tinh tong thanh tien sau thue
	private double calculateTotalVAT() {
		double vatRate = 0.1; // Tỷ lệ VAT là 10%
		double totalWithoutVAT = 0.0;
		double totalWithVAT = 0.0;
		double total = 0.0;
		for (int i = 0; i < tablemodel2.getRowCount(); i++) {
			double thanhTien = (double) tablemodel2.getValueAt(i, 5); // Cột 4 là cột chứa thành tiền
			totalWithoutVAT += thanhTien; // Cộng giá trị của mỗi hàng vào tổng
		}
		double vatAmount = totalWithoutVAT * vatRate;
		totalWithVAT = totalWithoutVAT + vatAmount;
		return totalWithVAT;
	}

	// Thêm phương thức để cập nhật giá trị tổng vào JTextField
	private void updateTotal() {
		double total = calculateTotal(); // Gọi phương thức tính tổng
		// Hiển thị tổng trong JTextField
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(localeVN);
		String formattedAmountVN = currencyFormatVN.format(total);
		textField_7.setText(String.valueOf(formattedAmountVN));
	}

	// ham them ve tau vao danh sach ve can them vao hoa don:
	public void addSale() {
		String ticketCode = textField.getText();
		boolean found = false;
		// Duyệt qua các hàng trong JTable để kiểm tra xem mã vé đã tồn tại chưa
		for (int i = 0; i < tablemodel2.getRowCount(); i++) {
			if (tablemodel2.getValueAt(i, 0).equals(ticketCode)) { // Cột 0 là cột chứa mã vé
				found = true;
				// Nếu mã vé đã tồn tại, tăng số lượng lên 1 và cập nhật lại JTable
				int currentQuantity = (int) tablemodel2.getValueAt(i, 2);
				// tablemodel2.setValueAt(currentQuantity + 1, i, 2); // Cột 2 là cột chứa số lượng
				JOptionPane.showMessageDialog(this, "Mã vé đã tồn tại trong danh sách!", "Thông báo", JOptionPane.WARNING_MESSAGE);
				
				// tinh thanh tien
				double giaVe = (double) tablemodel2.getValueAt(i, 3); // Lấy giá vé từ cột 3
				double thanhTien = giaVe * (currentQuantity + 1); // Tính toán thành tiền
				tablemodel2.setValueAt(thanhTien, i, 4); // Cột 4 là cột chứa thành tiền

				// Tính toán giá vé sau VAT
				double giaVeSauVAT = giaVe * 1.1; // Tính giá vé sau VAT 10%
				// Tính toán thành tiền sau VAT
				double thanhTienSauVAT = giaVeSauVAT * (currentQuantity + 1); // Tính toán thành tiền
				tablemodel2.setValueAt(thanhTienSauVAT, i, 5); // Cột 6 là cột chứa thành tiền sau VAT

				break;

			}
		}

		if (!found) {
			// Lấy danh sách vé từ DAO
			ArrayList<VeTau> danhSachVeTau = datve_dao.getAllTbVeTau();
			// Tìm vé có mã tương ứng trong danh sách vé
			VeTau selectedTicket = null;
			for (VeTau veTau : danhSachVeTau) {
				if (veTau.getMaVe().equals(ticketCode)) {
					selectedTicket = veTau;
					break;
				}
			}
			if (selectedTicket != null) {
				// format gia ve
				DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
				// Nếu tìm thấy vé, thêm thông tin về vé vào JTable
				double giavesauthue = selectedTicket.getGiaVe() * 1.1; // Tính giá vé sau VAT 10%
				Object[] rowData = { selectedTicket.getMaVe(), selectedTicket.getChuyenTau().getMaChuyenTau(), 1,
						selectedTicket.getGiaVe(), selectedTicket.getGiaVe(), giavesauthue }; // Mặc định số lượng là 1
				tablemodel2.addRow(rowData);
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy vé!!");
			}

		}
		updateTotal();
		textField.setText("");
	}

	// auto ngay lap hoadon
	public static void setTextFieldCurrentDate(JTextField textField) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
		String currentDate = sdf.format(new Date()); // Lấy ngày tháng hiện tại dưới dạng chuỗi
		textField.setText(currentDate); // Đặt ngày tháng hiện tại vào JTextField
	}

	// Phương thức để lưu danh sách vé và mã hóa đơn vào danh sách hóa đơn lưu tạm
	public void saveInvoice(DefaultTableModel tableModelxlydontam1) {
		String maHoaDon = textField_3.getText(); // mã hóa đơn
		String ngayxuatHD = textField_4.toString();// ngày lập HD
		String tenKH = textField_2.getText(); // tên KH
		// Lặp qua các hàng trong bảng hiện tại để lấy thông tin về các vé và thêm chúng
		// vào bảng mới kèm với mã hóa đơn
		for (int i = 0; i < tablemodel2.getRowCount(); i++) {
			String maVe = (String) tablemodel2.getValueAt(i, 0); // Lấy mã vé từ cột 0
			int soLuong = (int) tablemodel2.getValueAt(i, 2); // Lấy số lượng từ cột 2
			double giaVe = (double) tablemodel2.getValueAt(i, 3); // Lấy giá vé từ cột 3
			double thanhTien = (double) tablemodel2.getValueAt(i, 4); // Lấy thành tiền từ cột 4

			// Thêm thông tin vé và mã hóa đơn vào bảng mới
			Object[] rowData = { maHoaDon, ngayxuatHD, tenKH, maVe, soLuong, giaVe, thanhTien };
			// Thêm dòng mới vào bảng mới
			tableModelxlydontam1.addRow(rowData);
			tableModelxlydontam1.fireTableDataChanged();
		}
		JOptionPane.showMessageDialog(this, "Đã lưu danh sách vé vào hóa đơn lưu tạm " + maHoaDon);
	}

	public HoaDon revertHoaDonfromTxt() throws ParseException {
		String maHD = textField_3.getText();
		String ngaylapHD = textField_4.getText();
		java.sql.Date ngayXuatHD = java.sql.Date.valueOf(ngaylapHD);
		String tenNV = comboBox_1.getSelectedItem().toString();
		String maKH = comboBox.getSelectedItem().toString();
		// tien
		String tong = textField_8.getText();
		String cleanMoney = tong.replaceAll("[₫,.\\s]", "");
		double moneyValue = NumberFormat.getInstance().parse(cleanMoney).doubleValue();
		Double thanhtien = Double.valueOf(moneyValue);
		return new HoaDon(maHD, ngayXuatHD, new NhanVien(tenNV), new KhachHang(maKH), thanhtien);
	}

	public void XoaTrang() {
		textField_9.setText("");
		textField_8.setText("");
		textField_6.setText("");

		textField_2.setText("");
		textField_10.setText("");
		textField_11.setText("");
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		tablemodel2.setRowCount(0);
		textField_3.setText(datve_dao.taoMaHoaDonTuDong());
		comboBox.requestFocus();
	}

	public String autoMa() {
		String str;
		int ma = datve_dao.getMaKH();
		str = "KH" + String.format("%04d", ma);
		return str;
	}

	// Ham xuat hoa Don PDF
	public void generatePDF() {
		try {
			Document document = new Document();
			String filePath = "HoaDonBanVe.pdf";
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();

			// Thêm content của PDF
			BaseFont unicodeFont = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			com.itextpdf.text.Font font = new com.itextpdf.text.Font(unicodeFont, 14);

			// Lấy thông tin từ JTable
			String maHoaDon = textField_3.getText(); // Lấy mã hóa đơn từ textfield3
			String ngayLapHoaDon = textField_4.getText(); // Lấy ngày lập hóa đơn từ textfield4
			String tenNV = textField_6.getText();
			String tongTien = textField_8.getText();
			String tenKH = textField_2.getText();
			String sdtKH = textField_10.getText();

			// Tạo bảng
			PdfPTable table = new PdfPTable(6); // Tạo bảng với 4 cột
			table.setWidthPercentage(100);
			// Đặt chiều rộng của các cột
			float[] columnWidths = { 15, 15, 10, 10, 10, 10 };
			table.setWidths(columnWidths);

			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			// Thêm tiêu đề của các cột
			table.addCell(new PdfPCell(new Phrase("Mã vé", font)));
			table.addCell(new PdfPCell(new Phrase("Mã Chuyến tàu", font)));
			table.addCell(new PdfPCell(new Phrase("Số lượng", font)));
			table.addCell(new PdfPCell(new Phrase("Đơn giá", font)));
			table.addCell(new PdfPCell(new Phrase("VAT", font)));
			table.addCell(new PdfPCell(new Phrase("Thành tiền", font)));

			// Lấy dữ liệu từ JTable và thêm vào bảng trong tài liệu PDF
			for (int i = 0; i < tablemodel2.getRowCount(); i++) {
				String maVe = tablemodel2.getValueAt(i, 0).toString(); // Lấy mã vé từ JTable
				String maChuyenTau = tablemodel2.getValueAt(i, 1).toString(); // Lấy mã chuyến tàu từ JTable
				String soLuong = tablemodel2.getValueAt(i, 2).toString(); // Lấy số lượng từ JTable

				String donGia = tablemodel2.getValueAt(i, 3).toString(); // Lấy đơn giá từ JTable

				String donGiaVAT = tablemodel2.getValueAt(i, 5).toString();

				double thanhTien = Double.parseDouble(donGiaVAT) * Integer.parseInt(soLuong); // Tính thành tiền

				// Định dạng thành tiền sang định dạng tiền Việt
				DecimalFormat decimalFormat = new DecimalFormat("#,### ₫");

				double donGiaValue = Double.parseDouble(donGia);
				String dongiaFormatted = decimalFormat.format(donGiaValue);

				double donGiaVATValue = Double.parseDouble(donGiaVAT);
				String dongiaVATFormatted = decimalFormat.format(donGiaVATValue);

				String thanhTienFormatted = decimalFormat.format(thanhTien);

				// Thêm dòng dữ liệu vào bảng
				table.addCell(new PdfPCell(new Phrase(maVe)));
				table.addCell(new PdfPCell(new Phrase(maChuyenTau)));
				table.addCell(new PdfPCell(new Phrase(soLuong)));
				table.addCell(new PdfPCell(new Phrase(dongiaFormatted)));
				table.addCell(new PdfPCell(new Phrase(dongiaVATFormatted)));
				table.addCell(new PdfPCell(new Phrase(thanhTienFormatted)));
			}

			// Thêm các thông tin khác vào tài liệu PDF

			document.add(new Paragraph("\n"));
			Paragraph title = new Paragraph("HOA DON THANH TOAN VE TAU", new com.itextpdf.text.Font(
					com.itextpdf.text.Font.FontFamily.HELVETICA, 25, Font.BOLD, BaseColor.BLUE));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			document.add(
					new Paragraph("______________________________________________________________________________"));

			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Mã HD: 								" + maHoaDon, font)); // Thêm mã hóa đơn vào
																									// tài liệu
			document.add(new Paragraph("Ngày lập HD: 						" + ngayLapHoaDon, font)); // Thêm ngày lập
																										// hóa đơn vào
																										// tài liệu

			document.add(new Paragraph("Khách hàng: 						" + tenKH, font)); // Thêm mã hóa đơn vào
																								// tài liệu
			document.add(new Paragraph("Số điện thoại: 						" + sdtKH, font)); // Thêm mã hóa đơn vào
																								// tài liệu

			// Thêm bảng vào tài liệu
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(table);
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Nhân viên bán hàng: 				" + tenNV, font)); // Thêm mã hóa đơn vào
																								// tài liệu
			document.add(new Paragraph("Tổng tiền: 							" + tongTien, font)); // Thêm mã hóa đơn vào
																									// tài liệu

			document.add(new Paragraph("\n"));
			document.add(
					new Paragraph("______________________________________________________________________________"));
			Paragraph title1 = new Paragraph("Tổng đài hỗ trợ: 19006067 ", font);
			title1.setAlignment(Element.ALIGN_CENTER);
			document.add(title1);

			Paragraph title2 = new Paragraph(
					"Lưu ý: Hóa đơn chỉ xuất trong ngày. Quý khách vui lòng liên hệ thu ngân để được hỗ trợ nếu cần in lại hóa đơn ",
					font);
			title2.setAlignment(Element.ALIGN_CENTER);
			document.add(title2);

			Paragraph title3 = new Paragraph("Cám ơn quý khách. Hẹn gặp lại ", font);
			title3.setAlignment(Element.ALIGN_CENTER);
			document.add(title3);

			// Đóng tài liệu
			document.close();

			// Mở file PDF đã tạo
			Desktop.getDesktop().open(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Phương thức để thiết lập JFrame toàn màn hình
    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }

}
