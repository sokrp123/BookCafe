package project;
import java.awt.Image;   
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.FileReader;


public class BookManagements extends MyFrame{
	static ArrayList<Books> list = new ArrayList<Books>(); 
	MyFrame frame = new MyFrame();
	JFileChooser f = new JFileChooser();
	FileNameExtensionFilter ff;
	ImageIcon icon;
	
	
	public BookManagements() {
		System.out.println("�ϸŴ�����Ʈ������");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
	  
		JMenu menu1 = new JMenu("����");
		menuBar.add(menu1);
		
		JMenuItem menu5Item = new JMenuItem("�����ϱ�");
		menu1.add(menu5Item);
		
		JMenuItem menu3Item = new JMenuItem("�ҷ�����");
		menu1.add(menu3Item);
		
		JMenuItem menu4Item = new JMenuItem("�����ϱ�");
		menu1.add(menu4Item);
		
		JMenuItem menu1Item = new JMenuItem("����");
		menu1.add(menu1Item);
		
		JMenu menu2 = new JMenu("����");
		menuBar.add(menu2);
		
		JMenuItem menu2Item = new JMenuItem("��������");
		menu2.add(menu2Item);

		menu1Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});

		menu2Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Version va = new Version();
			}
		});
		
		ff = new FileNameExtensionFilter("�ؽ�Ʈ����(.txt)", "txt");
		
		menu3Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  f.setCurrentDirectory(new File("./src/project/books")); // ����η� ������
				  f.addChoosableFileFilter(ff);
				  System.out.println("ddddddddaa");
				  int file = f.showOpenDialog(null);
				  if (file != f.APPROVE_OPTION) {
				    return;
				 }
				 String filePath = f.getSelectedFile().getPath(); 
				 if(filePath != null){
					fileLoad(filePath); 
				 }
			}
		});
		
		menu4Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 f.setCurrentDirectory(new File("./src/project/books")); // ����η� ������
				 f.setFileSelectionMode(f.FILES_AND_DIRECTORIES);  
				 f.addChoosableFileFilter(ff);
				 int file = f.showSaveDialog(null);
				 if (file == f.APPROVE_OPTION) {
				  String type = ff.getDescription().substring(6, 10);
				  String savepathname = f.getSelectedFile().getAbsolutePath()+type;
				  fileSave(savepathname);
				 }else{
					 return;
				 }
			}
		});
		
		menu5Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 list.clear();
			}
		});

	}
	
	public void MmStart(){
		
		icon = new ImageIcon("./src/project/Image Soures/����â(����).jpg"); // ����η� ������
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel background = new JPanel() {	//���� ū �гο� �̹��� �ֱ�
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	            super.paintComponent(g);
	        }
	    };
	    
	    background.setBounds(10, 10, 1174, 720);
	    frame.getContentPane().add(background);
	    background.setLayout(null);
	  
	    
		frame.setTitle("����� ����");
		frame.setBounds(100, 100, 1200, 720);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton bt1 = new JButton("å ���");
		bt1.setIcon(new ImageIcon("./src/project/Image Soures/å���(Ŭ��)_ū��ư.jpg"));		// ����η� ������
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BookRegister mr = new BookRegister();
			}
		});
		
		bt1.setBounds(50, 306, 230, 97);
		//frame.getContentPane().add(bt1);
		background.add(bt1);
		
		JButton bt2 = new JButton("");
		bt2.setIcon(new ImageIcon("./src/project/Image Soures/å����(Ŭ��)_ū����.jpg")); // ����η� ������
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Managements mg = new Managements();
			}
		});
		bt2.setBounds(330, 306, 230, 97);
		//frame.getContentPane().add(bt2);
		background.add(bt2);

		JButton bt3 = new JButton("å �˻�");
		bt3.setIcon(new ImageIcon("./src/project/Image Soures/å�˻�(Ŭ��)_ū��ư.jpg")); // ����η� ������
		
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BookSearch ms = new BookSearch("");
			}	
		});
		bt3.setBounds(610, 306, 230, 97);
		//frame.getContentPane().add(bt3);
		background.add(bt3);
		
		JButton bt4 = new JButton("");
		bt4.setIcon(new ImageIcon("./src/project/Image Soures/���ã��.jpg"));// ����η� ������
		bt4.setBounds(900, 306, 230, 97);
		background.add(bt4);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookMark bm = new BookMark();
			}
		});
		
	}
	
	public void fileLoad(String path){
		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;
		
		try{
				//list.clear();
				fi = new FileInputStream(path);
				isr = new InputStreamReader(fi);
				bfr = new BufferedReader(isr);
				String str = null;
				while((str = bfr.readLine())!= null){
					Books m = new Books();
					st = new StringTokenizer(str,",");
					m.setName(st.nextToken());
					m.setAut(st.nextToken());
					m.setPub(st.nextToken());
					m.setDate(st.nextToken());
					m.setGenre(st.nextToken());
					m.setRate(st.nextToken());

					list.add(m);
				}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				fi.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave(String path){
		 FileWriter fw = null;
	
		 try{
		   fw = new FileWriter(path);
		   for(int i=0; i<list.size(); i++){
			   fw.write(list.get(i).getName());
			   fw.write(",");
			   fw.write(list.get(i).getAut());
			   fw.write(",");
			   fw.write(list.get(i).getPub());
			   fw.write(",");
			   fw.write(list.get(i).getDate());
			   fw.write(",");
			   fw.write(list.get(i).getGenre());
			   fw.write(",");
			   fw.write(list.get(i).getRate());
			   fw.write("\r\n");
			  
		   }       
	    }catch (Exception e) {
	    	e.printStackTrace();
	   }finally{
			try{
				fw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
