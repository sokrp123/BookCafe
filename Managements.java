package project;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Managements extends BookManagements  implements ActionListener, ItemListener {
	MyFrame frame2 = new MyFrame();
	JButton add = new JButton("책 추가");
	JButton edit = new JButton("책 수정");
	JButton delete = new JButton("책 삭제");
	JButton cancel = new JButton("취소");
	JComboBox cb = new JComboBox();
	private final JTextArea memInfo = new JTextArea();
	ImageIcon icon;
	public Managements(String str) {
		System.out.println("매니지먼트'빈'생성자");
	}
	
	public Managements(){
		icon = new ImageIcon("./src/project/Image Soures/choicePanel.jpg"); //상대경로로 수정함
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel nagement = new JPanel() {	//가장 큰 패널에 이미지 넣기
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	        }
	    };	    
	    nagement.setBounds(10, 10, 1174, 720);
	    frame2.getContentPane().add(nagement);
	    nagement.setLayout(null);
	    
		System.out.println("매니지먼트생성자");
		frame2.setTitle("책 관리");
		frame2.setBounds(1280, 1280, 1280, 720);
		frame2.setLocation(500, 300);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame2.setLocationRelativeTo(null);
	
		cb.setBounds(306, 170, 610, 43);
		cb.addItem("책을 선택하세요");
		for(int i=0; i<list.size(); i++){
			cb.addItem(list.get(i).getName() + ". " + list.get(i).getGenre());
		}
		//frame2.getContentPane().add(cb);
		nagement.add(cb);
		
		edit.setIcon(new ImageIcon("./src/project/Image Soures/책수정.jpg"));//상대경로로 수정함
		edit.setBounds(930, 124, 149, 55);
		//frame2.getContentPane().add(edit);
		nagement.add(edit);
		
		delete.setIcon(new ImageIcon("./src/project/Image Soures/책삭제.jpg"));//상대경로로 수정함
		delete.setBounds(930, 213, 149, 55);
		//frame2.getContentPane().add(delete);
		nagement.add(delete);
		
		cancel.setIcon(new ImageIcon("./src/project/Image Soures/취소.jpg"));//상대경로로 수정함
		cancel.setPressedIcon(new ImageIcon("./src/project/Image Soures/취소(클릭).jpg"));//상대경로로 수정함
		cancel.setBounds(930, 397, 149, 55);
		//frame2.getContentPane().add(cancel);
		nagement.add(cancel);
		
		memInfo.setEditable(false);
		memInfo.setBounds(306, 270, 326, 296);
		//frame2.getContentPane().add(memInfo);
		nagement.add(memInfo);
		
		add.setBounds(930, 305, 149, 55);
		add.setIcon(new ImageIcon("./src/project/Image Soures/책추가.jpg"));//상대경로로 수정함
		//frame2.getContentPane().add(add);
		nagement.add(add);
		
		add.addActionListener(this);
		edit.addActionListener(this);
		delete.addActionListener(this);
		cancel.addActionListener(this);
		cb.addItemListener(this);

		
		frame2.setVisible(true);
	}

	
	public void itemStateChanged(ItemEvent ie){
		if(cb.getSelectedIndex()!=0){
			System.out.println("매니지먼트itemStateChanged");
			int select = cb.getSelectedIndex()-1;
			memInfo.setText("책 이름 : "+list.get(select).getName() + "\n장르 : "+ list.get(select).getGenre() 
				+ "\n출판사 : " + list.get(select).getPub()  + "\n작가 : " + list.get(select).getAut()+ "\n출판 연도 : " + list.get(select).getDate() + "\n평점 : " + list.get(select).getRate());
		}else{
			memInfo.setText(null);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == edit){
			int select = cb.getSelectedIndex();
			Edit ed = new Edit(select);
			frame2.dispose();
		}else if(e.getSource() == delete){
			int select = cb.getSelectedIndex()-1;
			list.remove(select);
			cb.removeItemAt(select+1);
		}else if(e.getSource() == add){
			frame2.dispose();
			BookRegister mr = new BookRegister();
		}else if(e.getSource() == cancel){
			frame2.dispose();
			super.MmStart();
		}
	}
}
