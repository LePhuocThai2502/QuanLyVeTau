package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class AboutUs extends JFrame {
    

	public AboutUs() {
        setTitle("About Us");
        setSize(600, 570);
        setBackground(new Color(224,255,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		setLocationRelativeTo(null);
        
		JPanel pnContent = new JPanel();
        pnContent.setLayout(null);
        
        
        JPanel pnNorth = new JPanel();
        pnNorth.setBounds(0, 0, 586, 34);
        pnContent.add(pnNorth);
        pnNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel lblTitle = new JLabel("About System");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitle.setForeground(new Color(0, 135, 200));
		pnNorth.add(lblTitle);
        
		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(0, 34, 586, 445);
		pnContent.add(pnCenter);
        pnCenter.setLayout(null);
        
        JPanel pnImage = new JPanel();
        pnImage.setBounds(0, 0, 211, 448);
       // pnImage.setPreferredSize(new Dimension(200, 500));
        pnCenter.add(pnImage);
        
        ImageIcon originalIcon = new ImageIcon("C:\\JavaProject\\QuanLyBanVeTau\\images\\Nh… Ga.png");
        Image originalImage = originalIcon.getImage();

        int newWidth = 200;
        int newHeight = 500;
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        pnImage.setLayout(null);
        
                JLabel label = new JLabel(scaledIcon);
                label.setBounds(0, 0, 211, 438);
                pnImage.add(label);
        
        JPanel pNText = new JPanel();
        pNText.setBounds(205, 0, 381, 448);
        pnCenter.add(pNText);
        pNText.setLayout(null);
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(getForeground()),"Copyright (c) Train ticket management software");
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		Box b = Box.createVerticalBox();
		b.setEnabled(false);
		b.setBounds(10, 10, 361, 416);
		Box b1 = Box.createVerticalBox();
		Box b2 = Box.createVerticalBox();
		Box b3 = Box.createVerticalBox();;
		b.setBorder(titledBorder);
		
		b2.setBorder(BorderFactory.createTitledBorder("TTM General Policy License"));
		b3.setBorder(BorderFactory.createTitledBorder("Contact Us"));
		
		String text = "Version: 5.1.2 ";
		String text4 = "Build time: March 26 2024";
		String text1 = "The Train Ticket Management Software Policy outines the guidelines and procedures for the use of the train ticket\r\n"
				+ "		management software provided by the company.\r\n"
				+ "		This software is utilized for booking, managing, and tracking train tickets for business-related travel purposes. \r\n"
				+ "		Adherence to this policy is mandatory for all employees who have access to the train ticket management software.\n"
                ;

		String text2 = "Email: dhcn@iuh.edu.vn .";
		String text5 = " Address: 12 Nguyen Van Bao, Ward 4, District Go Vap, Ho Chi Minh City \r\n" ;
		
		JLabel txtVersion = new JLabel();
		txtVersion.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		JLabel txtBuildTime = new JLabel();
		txtBuildTime.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		JLabel txtChinhSach = new JLabel();
		txtChinhSach.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		JLabel txtLienHe = new JLabel();
		txtLienHe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		JLabel txtLienHe1 = new JLabel();
		txtLienHe1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		txtVersion.setText("<html>" + text + "</html>");
		txtBuildTime.setText("<html>" + text4 + "</html>");
		txtChinhSach.setText("<html>" + text1 + "</html>");
		txtLienHe.setText("<html>" + text2 + "</html>");
		txtLienHe1.setText("<html>" + text5 + "</html>");
		
		b1.add(txtVersion);
		b1.add(txtBuildTime);
		b2.add(txtChinhSach);
		b3.add(txtLienHe);
		b3.add(txtLienHe1);
		b.add(b1);
		//b.add(Box.createRigidArea(new Dimension(0, 10)));
		b.add(b2);
		//b.add(Box.createRigidArea(new Dimension(0, 1)));
		b.add(b3);
		pNText.add(b);
		//getContentPane().setLayout(null);
	
	
        
        
        JPanel pnSouth = new JPanel();
        pnSouth.setBounds(0, 479, 586, 34);
        pnContent.add(pnSouth);
        pnSouth.setLayout(null);
        
        JButton btnCheck = new JButton("Check For Update");
        btnCheck.setFont(new Font("Arial", Font.BOLD, 12));
        btnCheck.setBackground(new Color(30,144,255));
        btnCheck.setForeground(Color.WHITE);
        btnCheck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showOptionDialog(btnCheck,"Đây là phiên bản mới nhất của chúng tôi","", JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.INFORMATION_MESSAGE, 
                        null, 
                        new Object[]{"OK"}, 
                        "OK");
        	}
        });
        btnCheck.setBounds(229, 1, 180, 28);
        pnSouth.add(btnCheck);
        
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Arial", Font.BOLD, 12));
        btnClose.setBackground(new Color(30,144,255));
		btnClose.setForeground(Color.WHITE);
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnClose.setBounds(437, 1, 125, 29);
        pnSouth.add(btnClose);
        
        getContentPane().add(pnContent);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AboutUs();
            }
        });
    }
}


