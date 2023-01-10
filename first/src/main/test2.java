package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JButtonClass extends JFrame implements ActionListener, ListSelectionListener{
	
        JLabel jl1 = new JLabel("방속국주관");
        JLabel jl2 = new JLabel("탤런트선발대회");
        JLabel jl3 = new JLabel("잘한 코너들은");
       
        
        
        JList jlist1=new JList(wichi);
        JButton jb1 = new JButton("매운 소스 햄버거 : 5000");
        JButton jb2 = new JButton("더블 비프 햄버거 : 7000");
        JButton jb3 = new JButton("야채새우햄버거   : 4500");
        JButton jb4 = new JButton("세겹토마토햄버거 : 5500");
        JButton jb5 = new JButton("주문합니다.");
        JButton jb6 = new JButton("취소합니다.");
        
        
     
        int hap=0;
        int cnt=0;
        
        public JButtonClass() {//생성자-start
                setLayout(new GridLayout(0,2,50,50)); // 격자로 배치하는 Layout
                                                        //(행,열) 
                                                        //border - 경계선
                                                        //padding - 글씨와 경계선 사이의 거리
                                                        //(상,우,하,좌) 시계방향
                                                        //(20) 모든방향
                                                        //(20,30) 상하=>20 우좌=>20
                                                        //margin -> border와 border사이 여백
                jl1.setFont(new Font("굴림",Font.BOLD,25));
                jl2.setFont(new Font("굴림",Font.BOLD,25));
                jl3.setFont(new Font("굴림",Font.BOLD,25));
                jb1.setFont(new Font("굴림",Font.BOLD,15));
                jb2.setFont(new Font("굴림",Font.BOLD,15));
                jb3.setFont(new Font("굴림",Font.BOLD,15));
                jb4.setFont(new Font("굴림",Font.BOLD,15));
                jb5.setFont(new Font("굴림",Font.BOLD,15));
                jb6.setFont(new Font("굴림",Font.BOLD,15));
                
                jb5.setBackground(Color.orange);
                jb6.setBackground(Color.yellow);
                
                jb1.addActionListener(this);
                jb2.addActionListener(this);
                jb3.addActionListener(this);
                jb4.addActionListener(this);
                jb5.addActionListener(this);
                jb6.addActionListener(this);
                
                jlist1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                jlist1.addListSelectionListener(this);//
                
                add(jl1);
                add(jl2);
                add(jl3);
                add(jb1);
                add(jb2);
                add(jb3);
                add(jb4);
                add(jb5);
                add(jb6);
                add(jlist1);
                
                
                setSize(700,700);
                setVisible(true);
        }//생성자-entd

        @Override
        public void valueChanged(ListSelectionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource()==jlist1) {
                        int index1=jlist1.getSelectedIndex();//선택된 index
                        String indexElement1=(String)jlist1.getModel().getElementAt(index1);
                        JOptionPane.showMessageDialog(null, indexElement1+"선택하셨군요");
                                                                        //출력시 화면 정가운데 출력
                if(index1==0) {
                        hap=hap-1000;
                        }
                }
        }//if-end

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource()==jb1) {//5000원짜리 매운 소스 햄버거
                        joomoon1+=jb1.getText()+"\n";
                        hap=hap+5000;
                        cnt++;
                }
                if(e.getSource()==jb2) { 
                        joomoon1+=jb2.getText()+"\n";
                        hap=hap+7000;
                        cnt++;
                }
                if(e.getSource()==jb3) {
                        joomoon1+=jb3.getText()+"\n";
                        hap=hap+4500;
                        cnt++;
                }
                if(e.getSource()==jb4) {
                        joomoon1+=jb4.getText()+"\n";
                        hap=hap+5500;
                        cnt++;
                }
                if(e.getSource()==jb5) {
                        String msg1 =joomoon1+"총금액:"+String.valueOf(hap)+"원"+"\n"+"총주문수량:"+String.valueOf(cnt)+"개";
                        JOptionPane.showConfirmDialog(jb5, msg1,"확인하세요",JOptionPane.YES_NO_OPTION);
                                                                                // jb5버튼의 중앙에 새 창을 띄운다
                                                                                //     내용,   창 타이틀,  Yes or No
                        joomoon1="";  //초기화 
                        hap=0; 
                        cnt=0;
                }
                if(e.getSource()==jb6) {
                        joomoon1="";
                        hap=0;
                        cnt=0;
                        JOptionPane.showMessageDialog(jb6, "취소되었습니다");
                }
        }
}

public class GoodBurger {
        public static void main(String[] args) {
                new JButtonClass();//
        }
}
