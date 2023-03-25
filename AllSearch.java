package project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class AllSearch extends BookManagements {
	MyFrame frame5 = new MyFrame();
	ImageIcon icon;
	
	//JComboBox cb2 = new JComboBox();
	
	public AllSearch() {
		frame5.setTitle("전체 책");
		frame5.setSize(868, 868);
		frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		frame5.setVisible(true);
		frame5.setLocationRelativeTo(null); // 화면 가운데
	
		String[] column =  {
			"제목", "장르", "출판사", "작가", "출판 연도", "평점"
		};
		Object[][] ob = new Object[list.size()][6];
		for(int i=0; i<list.size(); i++){
				ob[i][0] = list.get(i).getName();
				ob[i][1] = list.get(i).getGenre();
				ob[i][2] = list.get(i).getPub();
				ob[i][3] = list.get(i).getAut();
				ob[i][4] = list.get(i).getDate();
				ob[i][5] = list.get(i).getRate();

		}
		
		JTable table= new JTable(ob,column);
		/*
		table.getColumn("제묙").setPreferredWidth(100);
		table.getColumn("장르").setPreferredWidth(100);
		table.getColumn("출판사").setPreferredWidth(100);
		table.getColumn("작가").setPreferredWidth(100);
		table.getColumn("출판 연도").setPreferredWidth(100);
		table.getColumn("평점").setPreferredWidth(50);
		table.setRowHeight(25);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		*/
		table.setSize(660,387);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(660, 387);	
		scrollPane.setLocation(12, 10);
		scrollPane.setPreferredSize(new Dimension(369, 203));
		frame5.getContentPane().add(scrollPane);
		
		frame5.setVisible(true);
		
		icon = new ImageIcon("./src/project/Image Soures/선택창(수정).jpg"); // 상대경로로 수정함
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(868, 868, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel background = new JPanel() {	//가장 큰 패널에 이미지 넣기
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	        }
	    };
	    background.setBounds(10, 10, 868, 868);
	    frame5.getContentPane().add(background);
	    background.setLayout(null);
	}
	
}
