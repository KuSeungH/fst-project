package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import main.mainmala;
import models.Member;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class JoinFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrame frame = new JoinFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	// 프레임 
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 회원가입 라벨 
		lblJoin = new JLabel("회원가입");
		Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
		lblJoin.setFont(f1); 
		lblJoin.setBounds(159, 41, 101, 20);
		contentPane.add(lblJoin);
		
		// PW 라벨 
		JLabel lblUsername = new JLabel("PW");
		lblUsername.setBounds(69, 163, 69, 20);
		contentPane.add(lblUsername);
		
		// ID 라벨 
		JLabel label = new JLabel("ID");
		label.setBounds(69, 113, 69, 20);
		contentPane.add(label);
		
		// 이름 라벨 
		JLabel lblName = new JLabel("name");
		lblName.setBounds(69, 210, 69, 20);
		contentPane.add(lblName);
		
		//Email 라벨
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(69, 257, 69, 20);
		contentPane.add(lblEmail);
		
		// 전화번호 라벨 
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(69, 304, 69, 20);
		contentPane.add(lblPhone);
		
		
		// 아이디 입력창 
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(159, 106, 186, 35);
		contentPane.add(tfUsername);
		
		// PW입력창 (정보안보이게)
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(159, 156, 186, 35);
		contentPane.add(passwordField);
		
		// 이름 입력창 
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(159, 203, 186, 35);
		contentPane.add(tfName);
		
		// Email 입력창 
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(159, 250, 186, 35);
		contentPane.add(tfEmail);
		
		// 전화번호 입력창 
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(159, 297, 186, 35);
		contentPane.add(tfPhone);
		
		// 회원가입완료버튼 
		joinCompleteBtn = new JButton("회원가입완료");
		joinCompleteBtn.setBounds(206, 394, 139, 29);
		contentPane.add(joinCompleteBtn);
		
		// 매장 이벤트에 관한 광고 수령에 대한 체크 박스 
		textField = new JTextField();
		textField.setText("매장소식에대해 광고 수령 ");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(159, 344, 186, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(69, 356, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
	
		
		setVisible(true);
		//회원가입완료 액션
		joinCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Member member = new Member();
				member.setUsername(tfUsername.getText());
				member.setPassword(passwordField.getText());
				member.setName(tfName.getText());
				member.setEmail(tfEmail.getText());
				member.setPhone(tfPhone.getText());
				
				MemberDao dao = MemberDao.getInstance();
				int result = dao.save(member);
				
				if(result == 1) { // 회원가입 성공 메시지 
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					contentPane.add(joinCompleteBtn);
				
					// 다시 로그인 창으로 이동 
					dispose();
					setVisible(false) ;
					new LoginFrame().setVisible(true) ;
				}else { // 회원가입 실패 메시지 
					JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.");
					
					contentPane.add(joinCompleteBtn);
				
					// 다시 로그인 창으로 이동 
					dispose();
					setVisible(false) ;
					new LoginFrame().setVisible(true) ;
				}	
			}
		});

	}
};

