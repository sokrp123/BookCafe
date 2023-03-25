package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BookSearch extends Managements implements ActionListener {

	MyFrame frame5 = new MyFrame();
	JButton sName = new JButton("å ����");
	JButton sGenre = new JButton("�帣");
	JButton sAut = new JButton("�۰�");
	JButton sAll = new JButton("��ü å");
	JButton sCancel = new JButton("���");
	JButton sDetail = new JButton("");
	String bookname;
	ImageIcon icon;
	public BookSearch() {
		super("�ϼ�ġ'��'������");
		System.out.println("�ϼ�ġ'��'������");
		
	}
	public BookSearch(String str) {
		super("�ϼ�ġ������");
		System.out.println("�ϼ�ġ������");
		
		icon = new ImageIcon("./src/project/Image Soures/serchPanel.jpg"); // ����� ������
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel search = new JPanel() {	//���� ū �гο� �̹��� �ֱ�
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	            super.paintComponent(g);
	        }
	    };
	    
	    search.setBounds(10, 10, 1174, 720);
	    frame5.getContentPane().add(search);
	    search.setLayout(null);
	    
		frame5.setTitle("å �˻�");
		frame5.setBounds(1280, 1280, 1280, 720);
		frame5.setLocation(500, 300);
		frame5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame5.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("�˻�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(354, 3, 43, 32);
		frame5.getContentPane().add(lblNewLabel);

		sName.setBounds(940, 110, 176, 70);
		//frame5.getContentPane().add(sName);
		search.add(sName);
		sName.setIcon(new ImageIcon("./src/project/Image Soures/å ����.jpg")); // ����η� ������

		sGenre.setBounds(940, 212, 176, 70);
		sGenre.setIcon(new ImageIcon("./src/project/Image Soures/�帣.jpg")); // ����η� ������
		//frame5.getContentPane().add(sGenre);
		search.add(sGenre);
		
		sAut.setBounds(940, 299, 176, 70);
		sAut.setIcon(new ImageIcon("./src/project/Image Soures/�۰�.jpg"));
		//frame5.getContentPane().add(sAut);
		search.add(sAut);
		
		sAll.setBounds(940, 386, 176, 70);
		sAll.setIcon(new ImageIcon("./src/project/Image Soures/��ü å.jpg"));
		//frame5.getContentPane().add(sAll);
		search.add(sAll);

		sCancel.setBounds(940, 480, 176, 70);
		sCancel.setIcon(new ImageIcon("./src/project/Image Soures/���.jpg"));
		//frame5.getContentPane().add(sCancel);
		search.add(sCancel);

		//frame5.getContentPane().add(sDetail);
		search.add(sDetail);
		sDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BookInfo bi = new BookInfo(bookname);
			}
		});

		JList list_1 = new JList();
		list_1.setBounds(242, 48, 1, 1);
		frame5.getContentPane().add(list_1);

		frame5.setVisible(true);

		sName.addActionListener(this);
		sGenre.addActionListener(this);
		sAut.addActionListener(this);
		sAll.addActionListener(this);
		sCancel.addActionListener(this);
		sDetail.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int dataCnt = 1;
		String[] genreCollection = null;
		String nameCode = null;

		if (e.getSource() == sName) {
			String name = JOptionPane.showInputDialog("�˻��� ������ �Է��ϼ���");
			if (name == null) {
				return;
			}
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					if (name.equals(list.get(i).getName())) {
						sDetail.setText(list.get(i).getName());
						sDetail.setForeground(Color.white);
						sDetail.setBounds(306, 170, 610, 43);
						sDetail.setBackground(Color.gray);
						bookname = sDetail.getText();
						break;

					}
					dataCnt++;
				}
				if (dataCnt == list.size() + 1) {
					JOptionPane.showMessageDialog(this, "��ġ�ϴ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(this, "��ϵ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (e.getSource() == sGenre) {
			int cnt = 0;
			String genre = JOptionPane.showInputDialog("�˻��� �帣�� �Է��ϼ���");
			if (genre == null) {
				return;
			}
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					if (genre.equals(list.get(i).getGenre())) {
						cnt++;
						bookname = sDetail.getText();
					}
				}
				if (cnt > 1) {
					genreCollection = new String[cnt];
					int namecnt = 0;
					for (int i = 0; i < list.size(); i++) {
						if (genre.equals(list.get(i).getGenre())) {
							genreCollection[namecnt] = list.get(i).getName() + ". " + list.get(i).getGenre() + ". "
									+ list.get(i).getAut();
							namecnt++;
							bookname = sDetail.getText();
						}
					}
					 nameCode = (String) JOptionPane.showInputDialog(this, "���� �̸��� �����մϴ�.\n", "�޽���",
					 
							JOptionPane.INFORMATION_MESSAGE, null, genreCollection, genreCollection[0]);
					if (nameCode == null) {
						return;
					}
					int idx = nameCode.indexOf('.');
					nameCode = nameCode.substring(0, idx);
					for (int i = 0; i < list.size(); i++) {
						if ((nameCode.equals(list.get(i).getName()))) {
							sDetail.setText(list.get(i).getName());
							sDetail.setBounds(306, 170, 610, 43);
							bookname = sDetail.getText();
							break;
						}
					}
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (genre.equals(list.get(i).getGenre())) {
							sDetail.setText("å ���� : " + list.get(i).getName());
							sDetail.setText(list.get(i).getName());
							sDetail.setBounds(306, 170, 610, 43);
							bookname = sDetail.getText();
							break;
						}
						dataCnt++;
					}
					if (dataCnt == list.size() + 1) {
						JOptionPane.showMessageDialog(this, "��ġ�ϴ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "��ϵ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sAut) {
			String author = JOptionPane.showInputDialog("�˻��� �۰��� �Է��ϼ���");
			if (author == null) {
				return;
			}
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					if (author.equals(list.get(i).getAut())) {
						sDetail.setText("å ���� : " + list.get(i).getName());
						sDetail.setText(list.get(i).getName());
						sDetail.setBounds(306, 170, 610, 43);
						bookname = sDetail.getText();
						break;
					}
					dataCnt++;
				}
				if (dataCnt == list.size() + 1) {
					JOptionPane.showMessageDialog(this, "��ġ�ϴ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "��ϵ� å�� �����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sAll) {
			AllSearch al = new AllSearch();
		} else if (e.getSource() == sCancel) {
			frame5.dispose();
			super.MmStart();
		}
	}
}