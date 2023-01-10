package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class hwChoice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblMae;
	private JLabel lblPo;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hwChoice frame = new hwChoice();
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
	//회원 매장포장 선택창 
	public hwChoice() {
		setTitle("2\uBC88\uD654\uBA74 & \uC2DD\uC0AC\uBC29\uBC95\uC120\uD0DD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.PINK);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		textField.setText("\uB9E4\uC7A5/\uD3EC\uC7A5");
		textField.setBounds(250, 10, 300, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// 회원 매장식사 주문창으로 
		String path = "/Users/kuseunghyun/Downloads/house-g660ffb6b7_1920.jpg";
		Image mae = new ImageIcon(path).getImage();
		
		JButton btnMae = new JButton(new ImageIcon(mae.getScaledInstance(300, 300, mae.SCALE_SMOOTH)));
		btnMae.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new hwbjumoon ( ).setVisible(true) ;
			}
		});
		btnMae.setBounds(100, 100, 300, 300);
		contentPane.add(btnMae);
		
		// 회원 포장식사 주문창으로 
		String path1= "/Users/kuseunghyun/Downloads/container-g2c94560bf_1920.jpg";
		Image po = new ImageIcon(path1).getImage();
		
		JButton btnPo = new JButton(new ImageIcon(po.getScaledInstance(300, 300, po.SCALE_SMOOTH)));
		btnPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new hwpobjumoon().setVisible(true) ;
			}
		});
		btnPo.setBounds(400, 100, 300, 300);
		contentPane.add(btnPo);
		
		lblMae = new JLabel("\uB9E4\uC7A5\uC2DD\uC0AC");
		lblMae.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMae.setForeground(Color.WHITE);
		lblMae.setBackground(Color.GRAY);
		lblMae.setBounds(220, 408, 86, 30);
		contentPane.add(lblMae);
		
		lblPo = new JLabel("\uD3EC\uC7A5");
		lblPo.setForeground(Color.WHITE);
		lblPo.setFont(new Font("굴림", Font.BOLD, 24));
		lblPo.setBackground(Color.GRAY);
		lblPo.setBounds(520, 408, 44, 30);
		contentPane.add(lblPo);
		
		// 포장시 1000원 할인문 설정 
		lblNewLabel = new JLabel("\uD3EC\uC7A5\uC2DC 1,000\uC6D0 \uD560\uC778");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(645, 500, 113, 15);
		contentPane.add(lblNewLabel);
	}

}