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

	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	MyFrame frame = new MyFrame();
	ButtonGroup bg = new ButtonGroup();
	ImageIcon icon;
	public BookRegister() {
		icon = new ImageIcon("./src/project/Image Soures/main.jpg"); 
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(1174, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JPanel main = new JPanel() {	//가장 큰 패널에 이미지 넣기
	        public void paintComponent(Graphics g) {
	            g.drawImage(changeIcon.getImage(), 0, 0, null);
	            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	        }
	    };
	    
	    main.setBounds(10, 10, 1174, 720);
	    frame.getContentPane().add(main);
	    main.setLayout(null);
	    
		frame.setTitle("책 등록");
		frame.setBounds(1280, 1280, 1280, 720);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		genre = new JTextField();
		genre.setColumns(10);
		genre.setBounds(470, 367, 569, 48);	//수정
		frame.getContentPane().add(genre);
		main.add(genre);	//수정
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(470, 449, 317, 55);	//수정
		frame.getContentPane().add(rate);
		main.add(rate);	//수정

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(980, 450, 165, 48);	//수정
		frame.getContentPane().add(date);
		main.add(date);	//수정

		pub = new JTextField();
		pub.setColumns(10);
		pub.setBounds(470, 197, 569, 48);	//수정
		frame.getContentPane().add(pub);
		main.add(pub);	//수정

		aut = new JTextField();
		aut.setColumns(10);
		aut.setBounds(470, 280, 569, 48);	//수정
		frame.getContentPane().add(aut);
		main.add(aut);	//수정
		
		bt1.setBounds(490, 525, 149, 67);
		frame.getContentPane().add(bt1);
		main.add(bt1);
		bt1.setIcon(new ImageIcon("./src/project/Image Soures/등록.jpg"));
		
		bt2.setBounds(710, 525, 149, 67);
		frame.getContentPane().add(bt2);
		main.add(bt2);
		bt2.setIcon(new ImageIcon("./src/project/Image Soures/취소.jpg"));
		bt2.setPressedIcon(new ImageIcon("./src/project/Image Soures/취소(클릭).jpg")); 
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
				JOptionPane.showMessageDialog(this, "책 제목을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memGenre.equals("")) {
				JOptionPane.showMessageDialog(this, "책 장르를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memPub.equals("")) {
				JOptionPane.showMessageDialog(this, "출판사를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memAut.equals("")) {
				JOptionPane.showMessageDialog(this, "작가 명을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memRate.equals("")) {
				JOptionPane.showMessageDialog(this, "평점을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memDate.equals("")) {	//수정
				JOptionPane.showMessageDialog(this, "출판 연도를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (memName.equals(list.get(i).getName())) {
						JOptionPane.showMessageDialog(this, "동일한 책이 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				int check = JOptionPane.showConfirmDialog(this,
						"입력한 내용이 맞습니까?\n" + "책 제목 : " + memName + "\n책 장르 : " + memGenre + "\n출판사 : " + memPub
								+ "\n작가 : " + memAut + "\n평점 : " + memRate + "\n출판 연도 : " + memDate,
						"메시지", JOptionPane.INFORMATION_MESSAGE);
				if (check == 0) {
					Books m = new Books();
					m.setName(memName);
					m.setAut(memAut);
					m.setPub(memPub);
					m.setDate(memDate);
					m.setGenre(memGenre);
					m.setRate(memRate);
					list.add(m);
					JOptionPane.showMessageDialog(this, "책이 등록되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					int check2 = JOptionPane.showConfirmDialog(this, "저장 하시겠습니까?");
					if (check2 == 0) {

						saveFile();
						count++;

					} else if (check2 == 1) {
						frame.setVisible(false);
						super.MmStart();
					}
					int check3 = JOptionPane.showConfirmDialog(this, "계속 입력하시겠습니까?");
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
