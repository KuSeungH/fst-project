package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.SwingConstants;

public class hwmainmala extends JFrame {

	private JPanel contentPane;
	private JTextField txtMain;
	private JButton btnMara1;
	private JButton btnMara2;
	private JButton btnMara3;
	private JLabel lblMaratang;
	private JLabel lblMap1;
	private JLabel lblMap2;
	private JLabel lblMap3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hwmainmala frame = new hwmainmala();
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
	// 회원용 마라탕주문 프레임 
	public hwmainmala() {
		setTitle("1\uBC88\uD654\uBA74&\uB9F5\uAE30\uC120\uD0DD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMain = new JTextField();
		txtMain.setHorizontalAlignment(SwingConstants.CENTER);
		txtMain.setForeground(new Color(255, 0, 0));
		txtMain.setBackground(new Color(192, 192, 192));
		txtMain.setFont(new Font("Dialog", Font.BOLD, 44));
		txtMain.setText(" 놀지마라 회원"); // 인사말
		txtMain.setBounds(250, 40, 300, 70);
		contentPane.add(txtMain);
		txtMain.setColumns(10);
		
		JLabel lblMenuChoice = new JLabel("MENU Choice"); // 메뉴 초이스 라벨
		lblMenuChoice.setFont(new Font("굴림", Font.BOLD, 14));
		lblMenuChoice.setBounds(201, 70, 111, 15);
		contentPane.add(lblMenuChoice);
		
		// 마라탕(1단계) : 12,000회원 전용 
		btnMara1 = new JButton("\uB9C8\uB77C\uD0D5(1\uB2E8\uACC4) : 12,000\uC6D0");
		btnMara1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMara1.setForeground(Color.YELLOW);
		btnMara1.setFont(new Font("굴림", Font.BOLD, 14));
		btnMara1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose( ) ;
				setVisible(false) ;
				new hwChoice().setVisible(true) ;  // 매장/포장 선택창으로 
			}
		});
		btnMara1.setBackground(new Color(255, 105, 180));
		btnMara1.setBounds(250, 165, 300, 50);
		contentPane.add(btnMara1);
		
		// 마라탕(2단계) :12,000회원 전용 
		btnMara2 = new JButton("\uB9C8\uB77C\uD0D5(2\uB2E8\uACC4) : \r\n12,000\uC6D0");
		btnMara2.setForeground(Color.ORANGE);
		btnMara2.setFont(new Font("굴림", Font.BOLD, 14));
		btnMara2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose() ;
				setVisible(false) ; 
				new hwChoice().setVisible(true) ;  // 매장/포장 선택창으로 
			}
		});
		btnMara2.setBackground(new Color(255, 20, 147));
		btnMara2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMara2.setBounds(250, 265, 300, 50);
		contentPane.add(btnMara2);
		
		// 마라탕(3단계) : 12,000회원 전용 
		btnMara3 = new JButton("\uB9C8\uB77C\uD0D5(3\uB2E8\uACC4) : 12,000\uC6D0");
		btnMara3.setForeground(Color.RED);
		btnMara3.setFont(new Font("굴림", Font.BOLD, 14));
		btnMara3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose() ;
				setVisible(false) ;
				new hwChoice().setVisible(true) ;  // 매장/포장 선택창으로 
			}
		});
		btnMara3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMara3.setBackground(new Color(255, 0, 0));
		btnMara3.setBounds(250, 365, 300, 50);
		contentPane.add(btnMara3);
		
		String path = "/Users/kuseunghyun/Downloads/gourmet-gb2d7f526b_1920.jpg"; // String path 새 변수 만들고  = "이미지 주소넣기"
		Image Mara = new ImageIcon(path).getImage(); // 이미지 변수명 정하기.
		
																	// 높이, 넓이, 사진의 화질
		lblMaratang = new JLabel(new ImageIcon(Mara.getScaledInstance(70, 70, Mara.SCALE_SMOOTH)));
		lblMaratang.setBounds(100, 40, 70, 70);
		contentPane.add(lblMaratang);
		
		String path1 = "/Users/kuseunghyun/Downloads/chile-g393a1cde6_1920.jpg";
		Image map1 = new ImageIcon(path1).getImage();
		
		lblMap1 = new JLabel(new ImageIcon(map1.getScaledInstance(70, 50, map1.SCALE_SMOOTH)));
		lblMap1.setBounds(100, 165, 70, 50);
		contentPane.add(lblMap1);
		
		String path2 = "/Users/kuseunghyun/Downloads/pepperoni-g1309a9fcf_1920.jpg";
		Image map2 = new ImageIcon(path2).getImage();
		
		lblMap2 = new JLabel(new ImageIcon(map2.getScaledInstance(70, 50, map2.SCALE_SMOOTH)));
		lblMap2.setBounds(100, 265, 70, 50);
		contentPane.add(lblMap2);
		
		String path3 =  "/Users/kuseunghyun/Downloads/chili-peppers-g44b54c5d1_1920.jpg";
		Image map3 = new ImageIcon(path3).getImage();
		
		lblMap3 = new JLabel(new ImageIcon(map3.getScaledInstance(70, 50, map3.SCALE_SMOOTH)));
		lblMap3.setBounds(100, 365, 70, 50);
		contentPane.add(lblMap3);
		
		
		
		
		}
	
	
	}



