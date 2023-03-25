package project;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class BookRegister extends BookManagements implements ActionListener {
	protected JTextField genre;
	protected JTextField pub;
	protected JTextField aut;
	protected JTextField name;
	protected JTextField date;
	protected JTextField rate;

	int count = 0;

	JButton bt1 = new JButton("���");
	JButton bt2 = new JButton("���");
	MyFrame frame = new MyFrame();
	ButtonGroup bg = new ButtonGroup();
	ImageIcon icon;
	public BookRegister() {
		icon = new ImageIcon("./src/project/Image Soures/main.jpg"); 
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel main = new JPanel() {	//���� ū �гο� �̹��� �ֱ�
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	            super.paintComponent(g);
	        }
	    };
	    
	    main.setBounds(10, 10, 1174, 720);
	    frame.getContentPane().add(main);
	    main.setLayout(null);
	    
		frame.setTitle("å ���");
		frame.setBounds(1280, 1280, 1280, 720);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		genre = new JTextField();
		genre.setColumns(10);
		genre.setBounds(470, 367, 569, 48);	//����
		frame.getContentPane().add(genre);
		main.add(genre);	//����
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(470, 449, 317, 55);	//����
		frame.getContentPane().add(rate);
		main.add(rate);	//����

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(980, 450, 165, 48);	//����
		frame.getContentPane().add(date);
		main.add(date);	//����

		pub = new JTextField();
		pub.setColumns(10);
		pub.setBounds(470, 197, 569, 48);	//����
		frame.getContentPane().add(pub);
		main.add(pub);	//����

		aut = new JTextField();
		aut.setColumns(10);
		aut.setBounds(470, 280, 569, 48);	//����
		frame.getContentPane().add(aut);
		main.add(aut);	//����
		
		bt1.setBounds(490, 525, 149, 67);
		frame.getContentPane().add(bt1);
		main.add(bt1);
		bt1.setIcon(new ImageIcon("./src/project/Image Soures/���.jpg"));
		
		bt2.setBounds(710, 525, 149, 67);
		frame.getContentPane().add(bt2);
		main.add(bt2);
		bt2.setIcon(new ImageIcon("./src/project/Image Soures/���.jpg"));
		bt2.setPressedIcon(new ImageIcon("./src/project/Image Soures/���(Ŭ��).jpg")); 
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(470, 108, 569, 48);
		if (list.size() != 0) {
			name.setText((Integer.parseInt(list.get(list.size() - 1).getName()) + 1) + "");
		} else {
			name.setText("");
		}
		frame.getContentPane().add(name);
		main.add(name);
		
		frame.setVisible(true);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		boolean StringCheck = true;
		if (e.getSource() == bt1) {
			String memName = name.getText();
			String memGenre = genre.getText();
			String memPub = pub.getText();
			String memAut = aut.getText();
			String memRate = rate.getText();
			String memDate = date.getText();

			if (memName.equals("")) {
				JOptionPane.showMessageDialog(this, "å ������ �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else if (memGenre.equals("")) {
				JOptionPane.showMessageDialog(this, "å �帣�� �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else if (memPub.equals("")) {
				JOptionPane.showMessageDialog(this, "���ǻ縦 �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else if (memAut.equals("")) {
				JOptionPane.showMessageDialog(this, "�۰� ���� �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else if (memRate.equals("")) {
				JOptionPane.showMessageDialog(this, "������ �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else if (memDate.equals("")) {	//����
				JOptionPane.showMessageDialog(this, "���� ������ �Է��� �ּ���", "�޽���", JOptionPane.INFORMATION_MESSAGE);
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (memName.equals(list.get(i).getName())) {
						JOptionPane.showMessageDialog(this, "������ å�� �ֽ��ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				int check = JOptionPane.showConfirmDialog(this,
						"�Է��� ������ �½��ϱ�?\n" + "å ���� : " + memName + "\nå �帣 : " + memGenre + "\n���ǻ� : " + memPub
								+ "\n�۰� : " + memAut + "\n���� : " + memRate + "\n���� ���� : " + memDate,
						"�޽���", JOptionPane.INFORMATION_MESSAGE);
				if (check == 0) {
					Books m = new Books();
					m.setName(memName);
					m.setAut(memAut);
					m.setPub(memPub);
					m.setDate(memDate);
					m.setGenre(memGenre);
					m.setRate(memRate);
					list.add(m);
					JOptionPane.showMessageDialog(this, "å�� ��ϵǾ����ϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
					int check2 = JOptionPane.showConfirmDialog(this, "���� �Ͻðڽ��ϱ�?");
					if (check2 == 0) {

						saveFile();
						count++;

					} else if (check2 == 1) {
						frame.setVisible(false);
						super.MmStart();
					}
					int check3 = JOptionPane.showConfirmDialog(this, "��� �Է��Ͻðڽ��ϱ�?");
					if (check3 == 0) {
						name.setText(null);
						genre.setText(null);
						pub.setText(null);
						rate.setText(null);
						aut.setText(null);
						date.setText(null);
						bg.clearSelection();

					} else if (check3 == 1) {
						frame.setVisible(false);
						super.MmStart();
					}
				}

			}
		} else if (e.getSource() == bt2 || e.getSource() == bt1) {
			frame.dispose();
			super.MmStart();
		}
	}

	public void saveFile() {
		FileWriter fw = null;

		try {
			fw = new FileWriter(
					"./src/project/books/" + name.getText() + ".txt"); 
			fw.write(list.get(count).getName());
			fw.write("\n");
			fw.write(list.get(count).getAut());
			fw.write("\n");
			fw.write(list.get(count).getPub());
			fw.write("\n");
			fw.write(list.get(count).getDate());
			fw.write("\n");
			fw.write(list.get(count).getGenre());
			fw.write("\n");
			fw.write(list.get(count).getRate());
			fw.write("\r\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
