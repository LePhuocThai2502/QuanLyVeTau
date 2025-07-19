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
import java.io.FileOutputStream;
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
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.QuanLyDoiTra_DAO;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.PhieuDoiTra;

import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QLyHDDoiTra_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JTextField textField;
	private JTable tableDonDoiTra;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private QuanLyDoiTra_DAO qlydondoitra_DAO;
	private DefaultTableModel tablemodelDT;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnTrV;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnTrV_1;
	private JRadioButton rdbtnNewRadioButton_1;
	private DefaultTableModel tablemodelVeTauDoiTra;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable tableVeTauDT;
	private DefaultTableModel tablemodelVeTauDT;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLyHDDoiTra_GUI frame = new QLyHDDoiTra_GUI();
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
	public QLyHDDoiTra_GUI() throws IOException {
		setTitle("Quản lý hóa đơn đổi trả ");
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

		// khoi tao dao
		qlydondoitra_DAO = new QuanLyDoiTra_DAO();

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

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1_1);

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

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Quản lý đơn đổi trả ");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\JavaProject\\QuanLyBanVeTau\\icons\\9929177_management_innovation_learn_plan_professional_icon.png"));
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
				searchAndDisplayHDDTByCode();
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

		tableDonDoiTra = new JTable();
		tableDonDoiTra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableDonDoiTra.getSelectedRow();
				String maHD = tablemodelDT.getValueAt(row, 1).toString();

				String manv = qlydondoitra_DAO.getmaNV(maHD);
				textField_2.setText(manv);

				String tennv = qlydondoitra_DAO.gettenNV(manv);
				textField_8.setText(tennv);

				textField_4.setText(tablemodelDT.getValueAt(row, 1).toString());
				textField_1.setText(tablemodelDT.getValueAt(row, 0).toString());

				if (row != -1) {
					Object dateValue = tablemodelDT.getValueAt(row, 2);
					if (dateValue instanceof java.sql.Date) {
						// Chuyển đổi java.sql.Date sang java.util.Date
						java.util.Date utilDate = new java.util.Date(((java.sql.Date) dateValue).getTime());
						dateChooser.setDate(utilDate);
					} else if (dateValue instanceof java.util.Date) {
						// Nếu đã là java.util.Date
						dateChooser.setDate((java.util.Date) dateValue);
					} else {
						// Nếu không phải là một đối tượng Date hợp lệ
						System.out.println("Giá trị ngày không hợp lệ.");
					}
				}

				String loai = tablemodelDT.getValueAt(row, 3).toString();
				if ("Đổi".equalsIgnoreCase(loai)) {
					rdbtnNewRadioButton_1.setSelected(true);
					rdbtnTrV_1.setEnabled(false);
				} else {
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnTrV_1.setSelected(true);
				}

				try {
					String maKH = qlydondoitra_DAO.getMaKHByCode(maHD);
					textField_6.setText(maKH);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					String maKHang = textField_6.getText();
					String tenKH = qlydondoitra_DAO.getTenKHtuMaKH(maKHang);
					textField_7.setText(tenKH);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String maphieuDT = tablemodelDT.getValueAt(row, 0).toString();
				String lydo = qlydondoitra_DAO.getLyDo(maphieuDT);
				textField_3.setText(lydo);

				double tienhoan = 0.0;
				boolean istra = "Trả".equalsIgnoreCase(loai);
				if (istra) {
					try {
						tienhoan = qlydondoitra_DAO.getTienHoan(maphieuDT);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

				// Định dạng giá trị tiền hoàn
				DecimalFormat df = new DecimalFormat("#,###.##");
				String formattedTienHoan = df.format(tienhoan) + " ₫";

				textField_5.setText(formattedTienHoan);

				// hien ve tren bang chi tiet ve
				TableModel mainTableModel = tableDonDoiTra.getModel();
				DefaultTableModel detailTableModel = getInvoiceDetailsTableModel(mainTableModel, row);
				tableVeTauDT.setModel(detailTableModel);

				// rdn button
				String trangThai = tablemodelDT.getValueAt(row, 4).toString();
				if (trangThai.equals("Đang chờ")) {
					rdbtnTrV.setEnabled(true);
					rdbtnNewRadioButton.setEnabled(true);
				} else {
					// Nếu không phải là "Đang chờ", vô hiệu hóa cả hai radio button
					rdbtnTrV.setEnabled(false);
					rdbtnNewRadioButton.setEnabled(false);
				}
				// Kiểm tra nếu radio button "Đã xác nhận" hoặc "Từ chối" đã được chọn
				if (trangThai.equals("Đã xác nhận")) {
					rdbtnTrV.setSelected(true);
					rdbtnNewRadioButton.setSelected(false);
				} else if (trangThai.equals("Đã từ chối")) {
					rdbtnNewRadioButton.setSelected(true);
					rdbtnTrV.setSelected(false);
				} else {
					// Nếu là "Đang chờ", không chọn bất kỳ radio button nào
					rdbtnTrV.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}

			}
		});
		tableDonDoiTra.setRowHeight(35);
		tableDonDoiTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tableDonDoiTra);
		tableDonDoiTra.setModel(tablemodelDT = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn đổi trả", "Mã hóa đơn", "Ngày đổi trả", "Loại", "Trạng thái" }));

		// doc du lieu tu database vao table
		DocdulieudatabasevaoTable();

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chi ti\u1EBFt \u0111\u01A1n \u0111\u1ED5i tr\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panel_3.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 2;
		gbc_verticalStrut_4.gridy = 0;
		panel_5.add(verticalStrut_4, gbc_verticalStrut_4);

		Component verticalStrut_18 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_18 = new GridBagConstraints();
		gbc_verticalStrut_18.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_18.gridx = 2;
		gbc_verticalStrut_18.gridy = 1;
		panel_5.add(verticalStrut_18, gbc_verticalStrut_18);

		JLabel lblNewLabel_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 2;
		panel_5.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_5.add(textField_2, gbc_textField_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_2.gridx = 0;
		gbc_lblNewLabel_1_2_2.gridy = 3;
		panel_5.add(lblNewLabel_1_2_2, gbc_lblNewLabel_1_2_2);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 3;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 3;
		panel_5.add(textField_8, gbc_textField_8);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_2_1.gridy = 4;
		panel_5.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel_5.add(textField_4, gbc_textField_4);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Mã hóa đơn ĐT:");
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_3.gridx = 0;
		gbc_lblNewLabel_1_2_1_3.gridy = 5;
		panel_5.add(lblNewLabel_1_2_1_3, gbc_lblNewLabel_1_2_1_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panel_5.add(textField_1, gbc_textField_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày đổi trả:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1.gridy = 6;
		panel_5.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);

		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 4;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.anchor = GridBagConstraints.NORTH;
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 6;
		panel_5.add(dateChooser, gbc_dateChooser);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 7;
		panel_5.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);

		rdbtnTrV = new JRadioButton("Xác nhận");

		rdbtnTrV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnTrV = new GridBagConstraints();
		gbc_rdbtnTrV.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTrV.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTrV.gridx = 3;
		gbc_rdbtnTrV.gridy = 7;
		panel_5.add(rdbtnTrV, gbc_rdbtnTrV);

		rdbtnNewRadioButton = new JRadioButton("Từ chối");

		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 7;
		panel_5.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		// Khởi tạo ButtonGroup
		ButtonGroup buttonGroup = new ButtonGroup();
		// Thêm các radio button vào ButtonGroup
		buttonGroup.add(rdbtnTrV);
		buttonGroup.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Loại:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1.gridy = 8;
		panel_5.add(lblNewLabel_1_2_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1);

		rdbtnTrV_1 = new JRadioButton("Trả vé ");
		rdbtnTrV_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnTrV_1 = new GridBagConstraints();
		gbc_rdbtnTrV_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTrV_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTrV_1.gridx = 3;
		gbc_rdbtnTrV_1.gridy = 8;
		panel_5.add(rdbtnTrV_1, gbc_rdbtnTrV_1);

		rdbtnNewRadioButton_1 = new JRadioButton("Đổi vé");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 4;
		gbc_rdbtnNewRadioButton_1.gridy = 8;
		panel_5.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		// Khởi tạo ButtonGroup
		ButtonGroup buttonGroup2 = new ButtonGroup();
		// Thêm các radio button vào ButtonGroup
		buttonGroup2.add(rdbtnTrV_1);
		buttonGroup2.add(rdbtnNewRadioButton_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 9;
		panel_5.add(verticalStrut, gbc_verticalStrut);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 7;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 10;
		panel_5.add(scrollPane_1, gbc_scrollPane_1);

		tableVeTauDT = new JTable();
		tableVeTauDT.setRowHeight(30);
		tableVeTauDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(tableVeTauDT);
		tableVeTauDT.setModel(tablemodelVeTauDT = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Đơn giá trước thuế", "Đơn giá sau thuế", "Số lượng" }));

		JLabel lblNewLabel_1_2_1_1_1_1_1_2 = new JLabel("Mã KH:");
		lblNewLabel_1_2_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1_1_2.gridy = 17;
		panel_5.add(lblNewLabel_1_2_1_1_1_1_1_2, gbc_lblNewLabel_1_2_1_1_1_1_1_2);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 4;
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 17;
		panel_5.add(textField_7, gbc_textField_7);

		JLabel lblNewLabel_1_2_1_1_1_1_1_2_1 = new JLabel("Tên KH:");
		lblNewLabel_1_2_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1_1_2_1.gridy = 18;
		panel_5.add(lblNewLabel_1_2_1_1_1_1_1_2_1, gbc_lblNewLabel_1_2_1_1_1_1_1_2_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 4;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 18;
		panel_5.add(textField_6, gbc_textField_6);

		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Lý do:");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1_1.gridy = 19;
		panel_5.add(lblNewLabel_1_2_1_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 19;
		panel_5.add(textField_3, gbc_textField_3);

		JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("Tiền hoàn:");
		lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1_1_1.gridy = 20;
		panel_5.add(lblNewLabel_1_2_1_1_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1_1_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 20;
		panel_5.add(textField_5, gbc_textField_5);

		Component verticalStrut_19 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_19 = new GridBagConstraints();
		gbc_verticalStrut_19.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_19.gridx = 2;
		gbc_verticalStrut_19.gridy = 21;
		panel_5.add(verticalStrut_19, gbc_verticalStrut_19);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_7.gridx = 2;
		gbc_verticalStrut_7.gridy = 22;
		panel_5.add(verticalStrut_7, gbc_verticalStrut_7);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_1 = new JButton("Lưu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().equals("") || textField_1.getText().equals("")
						|| dateChooser.getDate() == null || textField_3.getText().equals("")
						|| textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Bạn cần nhập đầy đủ thông tin");
				} else {
					PhieuDoiTra phieudt = revertfromtxt();
					qlydondoitra_DAO.updateVTau(phieudt);
					JOptionPane.showMessageDialog(panel, "Cập nhật phiếu đổi trả thành công!!");

				}

				generatePDF();
				xoatrang();

				XoadulieuTablemodel();
				DocdulieudatabasevaoTable();
			}
		});
		btnNewButton_1
				.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\285657_floppy_guardar_save_icon.png"));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new TitledBorder(null, "L\u1ECDc th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(178, 34, 34)));
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Đã xác nhận", "Đã từ chối", "Đang chờ" }));
		panel_4.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "Đổi", "Trả" }));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(comboBox_1);

		JButton btnNewButton_2 = new JButton("Lọc");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchandisplayPhieuDTbycode();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\40778_filter_icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(btnNewButton_2);

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

	// doc du lieu tu database phieudoitra
	public void DocdulieudatabasevaoTable() {
		List<PhieuDoiTra> list = qlydondoitra_DAO.getalltbDoiTra();
		for (PhieuDoiTra phieuDoiTra : list) {
			String maPhieuDT = phieuDoiTra.getMaPhieuDT();
			String maHD = phieuDoiTra.getHoaDon().getMaHD();
			Date thoigianphieudt = phieuDoiTra.getThoiGianTaoDonDT();
			// Chuyển đổi giá trị boolean loai thành chuỗi tương ứng
			String loai;
			if (phieuDoiTra.isLoai()) {
				loai = "Trả";
			} else {
				loai = "Đổi";
			}

			// Chuyển đổi trạng thái thành chuỗi tương ứng
			String trangthai;
			switch (phieuDoiTra.getTrangThai()) {
			case DANG_CHO:
				trangthai = "Đang chờ";
				break;
			case DA_XAC_NHAN:
				trangthai = "Đã xác nhận";
				break;
			case DA_TU_CHOI:
				trangthai = "Đã từ chối";
				break;
			default:
				trangthai = "Unknown";
			}

			tablemodelDT.addRow(new Object[] { maPhieuDT, maHD, thoigianphieudt, loai, trangthai });
		}

	}

	// ham tim kiem theo ma hddt

	private void searchAndDisplayHDDTByCode() {
		// Lấy mã Chuyến tàu từ TextField
		String maHoaDonDT = textField.getText().trim();
		// Xóa dữ liệu hiện tại của bảng
		tablemodelDT.setRowCount(0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM PhieuDoiTra WHERE maPhieuDT = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHoaDonDT);

			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = stmt.executeQuery();
			boolean found = false;
			while (rs.next()) {
				Date ngaydoitra = rs.getDate("thoiGianTaoDonDT");

				String loai;
				if (rs.getBoolean("loai")) {
					loai = "Trả";
				} else {
					loai = "Đổi";
				}

				Object[] row = { rs.getString("maPhieuDT"), rs.getString("maHD"), ngaydoitra, loai,
						rs.getString("trangThai") };
				tablemodelDT.addRow(row); // Thêm hàng mới vào bảng
				found = true;
				textField.requestFocus();

			}
			if (!found) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn đổi trả có mã " + maHoaDonDT);
				textField.setText("");
				DocdulieudatabasevaoTable();
				textField.requestFocus();

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(tableDonDoiTra,
					"Đã xảy ra lỗi khi tìm kiếm hóa đơn đổi trả!" + ex.getMessage());
		}
	}

	public void XoadulieuTablemodel() {
		while (tableDonDoiTra.getRowCount() > 0) {
			tablemodelDT.removeRow(0);
		}
	}

	// Hàm để lấy thông tin chi tiết hóa đơn và thêm vào table model
	public DefaultTableModel getInvoiceDetailsTableModel(TableModel mainTableModel, int selectedRow) {
		// Lấy mã hóa đơn từ table model chính
		Object invoiceCode = tableDonDoiTra.getValueAt(selectedRow, 0);

		// Tạo table model chi tiết hóa đơn
		String[] columnNames = { "Mã Vé", "Giá vé trước thuế", "Giá vé sau thuế", "Số Lượng" };
		DefaultTableModel detailTableModel = new DefaultTableModel(columnNames, 0);

		// Lấy danh sách chi tiết hóa đơn từ cơ sở dữ liệu
		List<Object[]> invoiceItems = qlydondoitra_DAO.getInvoiceItemsByCodeFromDatabase(invoiceCode);

		// Thêm dữ liệu vào table model chi tiết hóa đơn
		for (Object[] item : invoiceItems) {
			detailTableModel.addRow(item);
		}

		return detailTableModel;
	}

	public PhieuDoiTra revertfromtxt() {
		String maphieuDT = textField_1.getText();
		String maHD = textField_4.getText();
		HoaDon hoadon = new HoaDon(maHD);
		java.util.Date thoigiantaoPhieuDT = dateChooser.getDate();
		Date thoigiantaophieu = new Date(thoigiantaoPhieuDT.getTime());

		boolean tra = false;
		// Kiểm tra trạng thái của JRadioButton để thiết lập giá trị cho tra
		if (rdbtnNewRadioButton_1.isSelected()) {
			tra = false; // doi
		} else if (rdbtnTrV_1.isSelected()) {
			tra = true; // tra
		}

		double tongtien = 0.0;
		try {
			// Lấy giá trị từ textField_6 và chuyển đổi từ chuỗi sang double
			tongtien = Double.parseDouble(textField_5.getText().replaceAll("[₫,]", ""));
		} catch (NumberFormatException e) {
			// Xử lý nếu giá trị không thể chuyển đổi thành double
			e.printStackTrace();
		}

		String lydo = textField_3.getText();

		// Truyền giá trị từ enum TrangThai
		PhieuDoiTra.TrangThai trangThai;
		if (rdbtnTrV.isSelected()) {
			trangThai = PhieuDoiTra.TrangThai.DA_XAC_NHAN; // Xác nhận
		} else if (rdbtnNewRadioButton.isSelected()) {
			trangThai = PhieuDoiTra.TrangThai.DA_TU_CHOI; // Từ chối
		} else {
			trangThai = PhieuDoiTra.TrangThai.DANG_CHO; // Mặc định là Đang chờ
		}

		return new PhieuDoiTra(maphieuDT, hoadon, thoigiantaophieu, tra, tongtien, lydo, trangThai);

	}

	public void xoatrang() {
		textField_2.setText("");
		textField_8.setText("");
		textField_4.setText("");
		textField_1.setText("");
		dateChooser.setDate(null);
		rdbtnTrV.setSelected(false);
		rdbtnNewRadioButton.setSelected(false);
		rdbtnTrV_1.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_3.setText("");

		textField_2.requestFocus();

	}

	// ham loc thong tin trong bang

	private void searchandisplayPhieuDTbycode() {
		// Lay cac gia tri tim kiem
		boolean result = false;
		String trangThaiDDT = null;

		String loai = comboBox_1.getSelectedItem().toString().trim();
		String trangthai = comboBox.getSelectedItem().toString().trim();

		// Kiểm tra xem tất cả các trường tìm kiếm có trống không
		if (loai.isEmpty() && trangthai.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một trường tìm kiếm.");
			return;
		}

		if (loai.equals("Đổi")) {
			result = false;
		} else if (loai.equals("Trả")) {
			result = true;
		} else {

		}

		if (trangthai.equals("Đã xác nhận")) {
			trangThaiDDT = "DA_XAC_NHAN";
		} else if (trangthai.equals("Đã từ chối")) {
			trangThaiDDT = "DA_TU_CHOI";
		} else if (trangthai.equals("Đang chờ")) {
			trangThaiDDT = "DANG_CHO";
		} else {

		}
		// Xóa dữ liệu hiện tại của bảng
		tablemodelDT.setRowCount(0);

		// Tạo câu truy vấn dựa trên các trường tìm kiếm có giá trị
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM PhieuDoiTra WHERE 1=1");
		List<Object> params = new ArrayList<>(); // Danh sách các tham số trong câu truy vấn

		if (!loai.isEmpty()) {
			sqlBuilder.append(" AND loai = ?");
			params.add(result);
		}
		if (!trangthai.isEmpty()) {
			sqlBuilder.append(" AND trangThai LIKE ?");
			params.add("%" + trangThaiDDT + "%");
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
					String Loai = null;
					boolean loaiDT = rs.getBoolean("loai");
					if (loaiDT) {
						Loai = "Trả";
					} else {
						Loai = "Đổi";
					}
					String trangThaiDonDT = null;
					String TThai = rs.getString("trangThai");
					if (TThai.equals("DA_XAC_NHAN")) {
						trangThaiDonDT = "Đã xác nhận";
					} else if (TThai.equals("DA_TU_CHOI")) {
						trangThaiDonDT = "Đã từ chối";
					} else {
						trangThaiDonDT = "Đang chờ";
					}

					Object[] row = { rs.getString("maPhieuDT"), rs.getString("maHD"), rs.getDate("thoiGianTaoDonDT"),
							Loai, trangThaiDonDT };
					tablemodelDT.addRow(row); // Thêm hàng mới vào bảng
					found = true;
				}
				if (!found) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy đơn đổi trả phù hợp với tiêu chí tìm kiếm.");
					DocdulieudatabasevaoTable(); // Hiển thị lại dữ liệu đầy đủ
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(tableDonDoiTra, "Đã xảy ra lỗi khi tìm kiếm  đơn đổi trả!" + ex.getMessage());
		}

	}

	// Ham xuat hoa Don PDF
	public void generatePDF() {
		try {
			Document document = new Document();
			String filePath = "HoaDonDoiTraVeTau.pdf";
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();

			// Thêm content của PDF
			BaseFont unicodeFont = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			com.itextpdf.text.Font font = new com.itextpdf.text.Font(unicodeFont, 14);

			// Lấy thông tin từ JTable
			String maHoaDon = textField_4.getText(); // Lấy mã hóa đơn từ textfield3

			java.util.Date ngayLapHoaDon = dateChooser.getDate(); // Lấy ngày lập hóa đơn từ textfield4
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String ngayLapHoaDonDT = sdf.format(ngayLapHoaDon);

			String tenNV = textField_8.getText();
			String tongTienHoan = textField_5.getText();
			String tenKH = textField_7.getText();
			String lyDo = textField_3.getText();
			String trangThai = null;
			if (rdbtnTrV.isSelected()) {
				trangThai = "Đã xác nhận";
			} else {
				trangThai = "Đã từ chối";
			}

			String loaidon = null;
			if (rdbtnTrV_1.isSelected()) {
				loaidon = "Trả vé";
			} else {
				loaidon = "Đổi vé";
			}

			// Tạo bảng
			PdfPTable table = new PdfPTable(5); // Tạo bảng với 4 cột
			table.setWidthPercentage(100);
			// Đặt chiều rộng của các cột
			float[] columnWidths = { 15, 15, 10, 10, 10 };
			table.setWidths(columnWidths);

			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			// Thêm tiêu đề của các cột
			table.addCell(new PdfPCell(new Phrase("Mã vé", font)));
			table.addCell(new PdfPCell(new Phrase("Đơn giá", font)));
			table.addCell(new PdfPCell(new Phrase("VAT", font)));
			table.addCell(new PdfPCell(new Phrase("Số lượng", font)));
			table.addCell(new PdfPCell(new Phrase("Thành tiền", font)));

			// Lấy dữ liệu từ JTable và thêm vào bảng trong tài liệu PDF
			for (int i = 0; i < tableVeTauDT.getRowCount(); i++) {
				String maVe = tableVeTauDT.getValueAt(i, 0).toString(); // Lấy mã vé từ JTable
				String donGia = tableVeTauDT.getValueAt(i, 1).toString(); // Lấy đơn giá từ JTable
				String cleaneddonGia = donGia.replaceAll("[^\\d.]", "");

				String donGiaVAT = tableVeTauDT.getValueAt(i, 2).toString();
				String cleanedVAT = donGiaVAT.replaceAll("[^\\d.]", "");

				String soLuong = tableVeTauDT.getValueAt(i, 3).toString(); // Lấy số lượng từ JTable

				double thanhTien = Double.parseDouble(cleanedVAT) * Integer.parseInt(soLuong); // Tính thành tiền

				// Định dạng thành tiền sang định dạng tiền Việt
				DecimalFormat decimalFormat = new DecimalFormat("#,### ₫");
				double donGiaValue = Double.parseDouble(cleaneddonGia);
				String dongiaFormatted = decimalFormat.format(donGiaValue);
				double donGiaVATValue = Double.parseDouble(cleanedVAT);
				String dongiaVATFormatted = decimalFormat.format(donGiaVATValue);
				String thanhTienFormatted = decimalFormat.format(thanhTien);
				// Thêm dòng dữ liệu vào bảng
				table.addCell(new PdfPCell(new Phrase(maVe)));
				table.addCell(new PdfPCell(new Phrase(dongiaFormatted)));
				table.addCell(new PdfPCell(new Phrase(dongiaVATFormatted)));
				table.addCell(new PdfPCell(new Phrase(soLuong)));
				table.addCell(new PdfPCell(new Phrase(thanhTienFormatted)));
			}

			// Thêm các thông tin khác vào tài liệu PDF

			document.add(new Paragraph("\n"));
			Paragraph title = new Paragraph("HOA DON DOI TRA VE TAU", new com.itextpdf.text.Font(
					com.itextpdf.text.Font.FontFamily.HELVETICA, 25, Font.BOLD, BaseColor.BLUE));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			document.add(
					new Paragraph("______________________________________________________________________________"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Mã HD: 								" + maHoaDon, font));
			document.add(new Paragraph("Ngày lập HDDT: 						" + ngayLapHoaDonDT, font));
			document.add(new Paragraph("Khách hàng: 						" + tenKH, font));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(table);

			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Nhân viên bán hàng: 				" + tenNV, font));
			document.add(new Paragraph("Tổng tiền: 							" + tongTienHoan, font));
			document.add(
					new Paragraph("______________________________________________________________________________"));
			document.add(new Paragraph("\n"));

			document.add(new Paragraph("Loại đơn: 						" + loaidon, font));
			document.add(new Paragraph("Lý do: 						" + lyDo, font));
			document.add(new Paragraph("Trạng thái: 				" + trangThai, font));
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
