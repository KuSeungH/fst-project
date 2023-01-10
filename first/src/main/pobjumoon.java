package main;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class pobjumoon {
    int count ;
    String show = "";
    int total= 14000; // 기본 마라탕값 지정 비회원 포장용 

    
    public pobjumoon() {
        // 디자인단
        // 프레임 설정단
    	// 비회원 포장용 
        JFrame frame = new JFrame("(배달)놀지마라 선택");
        frame.setBounds(0, 0, 900, 1000);
        frame.setBackground(Color.black);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 매인 주문창 
        Panel pNorth = new Panel();
        pNorth.setBackground(Color.black);
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(new Font("맑은 고딕", Font.BOLD, 18)); 
 
        // 배열 설정 부분
     // 매뉴 배열 
        String menu[] = { "추가","목이버섯", "팽이버섯", "라면사리", "중국당면", 
        		"돼지고기", "소고기", "양고기", "소시지", 
        		"청경채", "연근", "모듬채소", "감자", "음료수"};
        
     // 가격 배열 
        int price[] = { 15000, 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500,5000, 5500, 6000, 6500, 1200 };
     // 텍스트 설정 
        TextField suja[] = new TextField[menu.length];
        
        // 버튼 설정 
        JButton bt[] = new JButton[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        
        // 라벨 설정 
        Label l[] = new Label[menu.length];
        Label m[] = new Label[menu.length];
        
        // 사진 이미지 넣는 설정 
        ImageIcon icon[] = new ImageIcon[menu.length];
        Image Img[] = new Image[menu.length];
        Image changedIcon[] = new Image[menu.length];
        ImageIcon picture[] = new ImageIcon[menu.length];
       
    
 
        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {
 
            // 재료 버튼
        	
            bt[i] = new JButton(menu[i]);
            if (i < 7) {
                bt[i].setBounds(25 + i * 120, 50, 100, 100);
            } else {
                bt[i].setBounds(25 + (i -7) * 120, 250, 100, 100);
            }
            
            
     
            
            
            // 재료 이미지 크기에 맞게 추가 
            icon[0] =new ImageIcon("/Users/kuseunghyun/Downloads/gourmet-gb2d7f526b_1920.jpg");
            icon[1] =new ImageIcon("/Users/kuseunghyun/Downloads/nature-g960a77a49_1920.jpg");
            icon[2] =new ImageIcon("/Users/kuseunghyun/Downloads/noodles-g018775d73_1920.jpg");
            icon[3] =new ImageIcon("/Users/kuseunghyun/Downloads/noodles-gc03ab400d_1920.jpg");
           	icon[4] =new ImageIcon("/Users/kuseunghyun/Downloads/food-gdf0fa3fc9_1920.jpg");
        	icon[5] =new ImageIcon("/Users/kuseunghyun/Downloads/liver-g3cc09af2d_1920.jpg");
            icon[6] =new ImageIcon("/Users/kuseunghyun/Downloads/meat-ga43ea793f_1920.jpg");
            icon[7] =new ImageIcon("/Users/kuseunghyun/Downloads/mutton-g28925701f_1920.jpg");
            icon[8] =new ImageIcon("/Users/kuseunghyun/Downloads/sausage-gf20badafb_1920.jpg");
            icon[9] = new ImageIcon("/Users/kuseunghyun/Downloads/bok-choy-g09feccbef_1920.jpg");
            icon[10] =new ImageIcon("/Users/kuseunghyun/Downloads/lotus-root-g97dcf5417_1920.jpg");
            icon[11] =new ImageIcon("/Users/kuseunghyun/Downloads/host-greens-g23dbe8a0f_1920.jpg");
            icon[12] =new ImageIcon("/Users/kuseunghyun/Downloads/rosemary-potatoes-gbc0de87ae_1920.jpg");
            icon[13] =new ImageIcon("/Users/kuseunghyun/Downloads/coca-cola-g25770dc39_1280.jpg");
            
            Img[i] = icon[i].getImage();
            changedIcon[i] = Img[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            picture[i]= new ImageIcon(changedIcon[i]);
            bt[i].setIcon( picture[i]);
       
            	
            	
            
            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 메뉴이름
            m[i] = new Label(menu[i]);
        	m[i].setFont(font1);
        	m[i].setBounds(bt[i].getX() + 20, bt[i].getY() - 35, 100, 20);
            m[i].setForeground(Color.white);
        	
            // 가격
            l[i] = new Label(price[i] + "원");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);
            l[i].setForeground(Color.white);
            
            // 확인 버튼
            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
            
            pNorth.add(m[i]);
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
          
        }
     // 중앙 재료 추가화면 
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n   기본요금\t\t 		14000\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);
 
        // 마지막 선택 버튼 
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(255, 255, 215));
 
        Button bt1 = new Button("주문");
        Button bt2 = new Button("초기화");
        Button bt3 = new Button("닫기");
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);  
        
        
        
        // 주문버튼
        bt1.addActionListener(new ActionListener() {
 
        	@Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + "총 금액 : "+total+"원\n"+ " 주문되었습니다. \n 이용해주셔서 감사합니다. \n 조리되기까지 40분 소요됩니다.");
                
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   상품명        단가        수량        합계\n\n");
 
                }
            }
        });

     

    // 초기화 버튼
    bt2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < menu.length; i++) {
                bt[i].setEnabled(true);
                minus[i].setEnabled(false);
                plus[i].setEnabled(false);
                suja[i].setText("0");
                ta.setText("   상품명        단가        수량        합계\n   기본요금\t\t 		14000\n");
            }
        }
    });
    //bt3 닫기버튼
    bt3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    // 컴포넌트
    frame.getContentPane().add(pNorth, BorderLayout.NORTH);
    frame.getContentPane().add(ta, BorderLayout.CENTER);
    frame.getContentPane().add(pSouth, BorderLayout.SOUTH);
    frame.setVisible(true);
    
 // 이벤트단
    for (int i = 0; i < menu.length; i++) {
        int j = i;

         // 재료 버튼 이벤트
        bt[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minus[j].setEnabled(true);
                plus[j].setEnabled(true);
                bt[j].setEnabled(false);
                ok[j].setEnabled(true);

                count = 0;
            }
        });

        // "-" 버튼 이벤트
        minus[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0) {
                    count = count - 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                } else {
                    minus[j].setEnabled(false);
                }
            }
        });
        
        // "+" 버튼 이벤트
        plus[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                count = count + 1;
                suja[j].setText(count + "");
                ok[j].setEnabled(true);
                if (count > 0) {
                    minus[j].setEnabled(true);
                }
            }
        });
        //확인 버튼 이벤트
        ok[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show = bt[j].getActionCommand();
                ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                        + "원" + "\n");
                ok[j].setEnabled(false);
              total =   total+ price[j] * count;// 총합 금액 값 설정 
            }
        });
    }
    // 끄기
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
}
    
    
private String size(int i) {
		// TODO Auto-generated method stub
		return null;
	}


// 메인
public static void main(String[] args) {
    new pobjumoon();
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}

}
