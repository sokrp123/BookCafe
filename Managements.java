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
	JButton add = new JButton("å �߰�");
	JButton edit = new JButton("å ����");
	JButton delete = new JButton("å ����");
	JButton cancel = new JButton("���");
	JComboBox cb = new JComboBox();
	private final JTextArea memInfo = new JTextArea();
	ImageIcon icon;
	public Managements(String str) {
		System.out.println("�Ŵ�����Ʈ'��'������");
	}
	
	public Managements(){
		icon = new ImageIcon("./src/project/Image Soures/choicePanel.jpg"); //����η� ������
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel nagement = new JPanel() {	//���� ū �гο� �̹��� �ֱ�
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	            super.paintComponent(g);
	        }
	    };	    
	    nagement.setBounds(10, 10, 1174, 720);
	    frame2.getContentPane().add(nagement);
	    nagement.setLayout(null);
	    
		System.out.println("�Ŵ�����Ʈ������");
		frame2.setTitle("å ����");
		frame2.setBounds(1280, 1280, 1280, 720);
		frame2.setLocation(500, 300);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame2.setLocationRelativeTo(null);
	
		cb.setBounds(306, 170, 610, 43);
		cb.addItem("å�� �����ϼ���");
		for(int i=0; i<list.size(); i++){
			cb.addItem(list.get(i).getName() + ". " + list.get(i).getGenre());
		}
		//frame2.getContentPane().add(cb);
		nagement.add(cb);
		
		edit.setIcon(new ImageIcon("./src/project/Image Soures/å����.jpg"));//����η� ������
		edit.setBounds(930, 124, 149, 55);
		//frame2.getContentPane().add(edit);
		nagement.add(edit);
		
		delete.setIcon(new ImageIcon("./src/project/Image Soures/å����.jpg"));//����η� ������
		delete.setBounds(930, 213, 149, 55);
		//frame2.getContentPane().add(delete);
		nagement.add(delete);
		
		cancel.setIcon(new ImageIcon("./src/project/Image Soures/���.jpg"));//����η� ������
		cancel.setPressedIcon(new ImageIcon("./src/project/Image Soures/���(Ŭ��).jpg"));//����η� ������
		cancel.setBounds(930, 397, 149, 55);
		//frame2.getContentPane().add(cancel);
		nagement.add(cancel);
		
		memInfo.setEditable(false);
		memInfo.setBounds(306, 270, 326, 296);
		//frame2.getContentPane().add(memInfo);
		nagement.add(memInfo);
		
		add.setBounds(930, 305, 149, 55);
		add.setIcon(new ImageIcon("./src/project/Image Soures/å�߰�.jpg"));//����η� ������
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
			System.out.println("�Ŵ�����ƮitemStateChanged");
			int select = cb.getSelectedIndex()-1;
			memInfo.setText("å �̸� : "+list.get(select).getName() + "\n�帣 : "+ list.get(select).getGenre() 
				+ "\n���ǻ� : " + list.get(select).getPub()  + "\n�۰� : " + list.get(select).getAut()+ "\n���� ���� : " + list.get(select).getDate() + "\n���� : " + list.get(select).getRate());
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
