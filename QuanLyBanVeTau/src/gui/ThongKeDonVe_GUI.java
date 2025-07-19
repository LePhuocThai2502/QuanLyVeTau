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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import connectDB.ConnectDB;
import dao.ThongKeDoanhThu_DAO;
import dao.ThongKeDonVe_DAO;
import entity.CT_HoaDon;
import entity.ChuyenTau;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ThongKeDonVe_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon icon;
	private Timer timer;
	private JPanel panelBieuDo;
	private JDateChooser dateChooser;
	private ThongKeDoanhThu_DAO tkdoanhthu_DAO;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable tableVeTauDaBan;
	private ThongKeDonVe_DAO tkdonve_Dao;
	private DefaultTableModel tablemodelVeTau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeDonVe_GUI frame = new ThongKeDonVe_GUI();
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
	public ThongKeDonVe_GUI() throws IOException {
		setTitle("Thống kê đơn vé");
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
		tkdonve_Dao = new ThongKeDonVe_DAO();

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
					TrangChuQuanLy_GUI qly = new TrangChuQuanLy_GUI();
					qly.setVisible(true);
					qly.setExtendedState(MAXIMIZED_BOTH);
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
					DatVe_GUI dv = new DatVe_GUI();
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
					HoaDonBan_GUI hd = new HoaDonBan_GUI();
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
					QLyHDDoiTra_GUI ql=new QLyHDDoiTra_GUI();
					ql.setVisible(true);
					ql.setExtendedState(MAXIMIZED_BOTH);
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
					QuanLyChuyenTau_GUI qlct=new QuanLyChuyenTau_GUI();
					qlct.setVisible(true);
					qlct.setExtendedState(MAXIMIZED_BOTH);
					
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
					ThongKeDoanhThu_GUI dt=new ThongKeDoanhThu_GUI();
					dt.setVisible(true);
					dt.setExtendedState(MAXIMIZED_BOTH);
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
				TrangDangNhap_GUI dn=new TrangDangNhap_GUI();
				dn.setVisible(true);
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

		// banner ảnh
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelLoc = new JPanel();
		panel.add(panelLoc, BorderLayout.NORTH);
		panelLoc.setLayout(new BorderLayout(0, 0));

		JPanel panel_Loc = new JPanel();
		panel_Loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_Loc.setBorder(new TitledBorder(null, "L\u1ECDc ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(178, 34, 34)));
		panelLoc.add(panel_Loc, BorderLayout.NORTH);
		panel_Loc.setLayout(new BoxLayout(panel_Loc, BoxLayout.X_AXIS));

		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_Loc.add(dateChooser);

		JButton btnNewButton = new JButton("Lọc ");
		btnNewButton.addActionListener(new ActionListener() {
			private DefaultTableModel tablekq;

			public void actionPerformed(ActionEvent e) {

				Date ngaylap = dateChooser.getDate();
				if (ngaylap == null) {
					// Nếu ngày chưa được chọn, hiển thị thông báo
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trước khi lọc dữ liệu!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				} else {
					java.sql.Date ngayTimKiem = new java.sql.Date(ngaylap.getTime());

					tablekq = tkdonve_Dao.getChiTietHoaDonByNgayLap(ngayTimKiem);
					tableVeTauDaBan.setModel(tablekq);

					// hien bieu do
					panelBieuDo.setVisible(true);
				}

			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setIcon(
				new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\9004811_search_find_magnifier_zoom_icon.png"));
		panel_Loc.add(btnNewButton);

		JPanel panel_VeTau = new JPanel();
		panelLoc.add(panel_VeTau, BorderLayout.CENTER);
		panel_VeTau.setLayout(new BoxLayout(panel_VeTau, BoxLayout.X_AXIS));

		JPanel panel_TableVeTau = new JPanel();
		panel_TableVeTau.setMaximumSize(new Dimension(42767, 42767));
		panel_TableVeTau.setBorder(new TitledBorder(null, "Danh s\u00E1ch v\u00E9 t\u00E0u b\u00E1n trong ng\u00E0y",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_VeTau.add(panel_TableVeTau);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		panel_TableVeTau.add(scrollPane);

		tableVeTauDaBan = new JTable();
		tableVeTauDaBan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableVeTauDaBan.getSelectedRow();

				// khoi tao tablemodel
				Date ngaylap = dateChooser.getDate();
				java.sql.Date ngayTimKiem = new java.sql.Date(ngaylap.getTime());
				DefaultTableModel tablemodelVeTau = tkdonve_Dao.getChiTietHoaDonByNgayLap(ngayTimKiem);
				tableVeTauDaBan.setModel(tablemodelVeTau);

				String mavetau = tablemodelVeTau.getValueAt(row, 0).toString();

				textField.setText(mavetau);

				try {
					String tenCT = tkdonve_Dao.getTenCTByCode(mavetau);
					textField_1.setText(tenCT);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					String tenlG = tkdonve_Dao.getTenLGByCode(mavetau);
					textField_2.setText(tenlG);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField_3.setText(tablemodelVeTau.getValueAt(row, 2).toString());
				textField_4.setText(tablemodelVeTau.getValueAt(row, 4).toString());
				textField_5.setText(tablemodelVeTau.getValueAt(row, 1).toString());

			}
		});
		tableVeTauDaBan.setPreferredScrollableViewportSize(new Dimension(600, 300));
		scrollPane.setViewportView(tableVeTauDaBan);
		tableVeTauDaBan.setRowHeight(25);
		tableVeTauDaBan.setModel(tablemodelVeTau = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã vé", "Số lượng", "Giá bán", "Giá bán VAT", "Tổng doanh thu" }));
		tableVeTauDaBan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// doc du lieu tu database vao table
		// DocdulieudatabasevaoTable();

		JPanel panel_ThongTinChiTiet = new JPanel();
		panel_ThongTinChiTiet.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel_VeTau.add(panel_ThongTinChiTiet);
		GridBagLayout gbl_panel_ThongTinChiTiet = new GridBagLayout();
		gbl_panel_ThongTinChiTiet.columnWidths = new int[] { 0, 0, 338, 338, 0, 338, 0, 0 };
		gbl_panel_ThongTinChiTiet.rowHeights = new int[] { 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_ThongTinChiTiet.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_ThongTinChiTiet.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_ThongTinChiTiet.setLayout(gbl_panel_ThongTinChiTiet);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		panel_ThongTinChiTiet.add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel lblNewLabel_1 = new JLabel("Mã vé:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_ThongTinChiTiet.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_ThongTinChiTiet.add(textField, gbc_textField);
		textField.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 2;
		panel_ThongTinChiTiet.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel_1_1 = new JLabel("Tên chuyến tàu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel_ThongTinChiTiet.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		panel_ThongTinChiTiet.add(textField_1, gbc_textField_1);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 4;
		panel_ThongTinChiTiet.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1_2 = new JLabel("Loại ghế:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 2;
		gbc_lblNewLabel_1_2.gridy = 5;
		panel_ThongTinChiTiet.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		panel_ThongTinChiTiet.add(textField_2, gbc_textField_2);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 2;
		gbc_verticalStrut_3.gridy = 6;
		panel_ThongTinChiTiet.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("Giá:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 2;
		gbc_lblNewLabel_1_2_1.gridy = 7;
		panel_ThongTinChiTiet.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 7;
		panel_ThongTinChiTiet.add(textField_3, gbc_textField_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 2;
		gbc_verticalStrut_4.gridy = 8;
		panel_ThongTinChiTiet.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Số lượng đã bán:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 9;
		panel_ThongTinChiTiet.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 9;
		panel_ThongTinChiTiet.add(textField_5, gbc_textField_5);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 2;
		gbc_verticalStrut_5.gridy = 10;
		panel_ThongTinChiTiet.add(verticalStrut_5, gbc_verticalStrut_5);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tổng doanh thu:");
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 2;
		gbc_lblNewLabel_1_2_1_1.gridy = 11;
		panel_ThongTinChiTiet.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 11;
		panel_ThongTinChiTiet.add(textField_4, gbc_textField_4);

		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_13.gridx = 0;
		gbc_horizontalStrut_13.gridy = 13;
		panel_ThongTinChiTiet.add(horizontalStrut_13, gbc_horizontalStrut_13);

		panelBieuDo = new JPanel();
		panelBieuDo.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA doanh thu ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel.add(panelBieuDo, BorderLayout.CENTER);

		// bieu do doanh thu
		TopTicketSales TopticketSalesChart = new TopTicketSales();
		ChartPanel chartPanel = TopticketSalesChart.createChartPanel();
		panelBieuDo.removeAll(); // Xóa các thành phần cũ trong panel
		panelBieuDo.add(chartPanel);
		panelBieuDo.setLayout(new BoxLayout(panelBieuDo, BoxLayout.X_AXIS));
		panelBieuDo.revalidate(); // Cập nhật layout của panel
		panelBieuDo.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Thống kê đơn vé");
		lblNewLabel.setIcon(new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\icons\\49628_tickets_tix_icon.png"));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		panel_1.add(lblNewLabel);

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

	// Phương thức để thiết lập JFrame toàn màn hình
	public void setFullScreen() {
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to toàn màn hình
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
	}

	// doc du lieu tu database
	public void DocdulieudatabasevaoTable() {
		List<CT_HoaDon> list = tkdonve_Dao.getalltbCTHoaDon();

		// Tạo một NumberFormat instance cho định dạng tiền tệ Việt Nam
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

		for (CT_HoaDon ct_HoaDon : list) {
			String mave = ct_HoaDon.getVeTau().getMaVe();
			int soluong = ct_HoaDon.getSoLuong();
			double giave = ct_HoaDon.getDonGiaTruocThue();
			double giaveVAT = ct_HoaDon.getDonGiaSauThue();

			// Tính tổng doanh thu cho mỗi hàng
			double tongDoanhThu = giaveVAT * soluong;

			// Định dạng tiền tệ
			String formattedGiave = currencyFormat.format(giave);
			String formattedGiaveVAT = currencyFormat.format(giaveVAT);
			String formattedTongDoanhThu = currencyFormat.format(tongDoanhThu);

			tablemodelVeTau
					.addRow(new Object[] { mave, soluong, formattedGiave, formattedGiaveVAT, formattedTongDoanhThu });
		}

	}

}
