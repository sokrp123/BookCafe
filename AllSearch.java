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
		frame5.setTitle("��ü å");
		frame5.setSize(868, 868);
		frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		frame5.setVisible(true);
		frame5.setLocationRelativeTo(null); // ȭ�� ���
	
		String[] column =  {
			"����", "�帣", "���ǻ�", "�۰�", "���� ����", "����"
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
		table.getColumn("����").setPreferredWidth(100);
		table.getColumn("�帣").setPreferredWidth(100);
		table.getColumn("���ǻ�").setPreferredWidth(100);
		table.getColumn("�۰�").setPreferredWidth(100);
		table.getColumn("���� ����").setPreferredWidth(100);
		table.getColumn("����").setPreferredWidth(50);
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
		
		icon = new ImageIcon("./src/project/Image Soures/����â(����).jpg"); // ����η� ������
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(868, 868, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel background = new JPanel() {	//���� ū �гο� �̹��� �ֱ�
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	            super.paintComponent(g);
	        }
	    };
	    background.setBounds(10, 10, 868, 868);
	    frame5.getContentPane().add(background);
	    background.setLayout(null);
	}
	
}
