package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {

	private JTextField idField;
	private JTextField name_t;
	private JTextField id_t;
	private JTextField pass_t;
	private JTextField pla_t;
	private JTextField ple_t;
	private JTextField passFiled;
	MyFrame frame = new MyFrame();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	public Main() {
		initialize();
	}

	private void initialize() {

		frame.setBounds(1280, 1280, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("./src/project/Image Soures/login.jpg").getImage()); // ����η� ������
		frame.getContentPane().add(loginPanel, BorderLayout.SOUTH);
		// �α����г�������
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
//�α��ξ��̵��ʵ�
		idField = new JTextField();
		idField.setFont(new Font("�޸�����ü", Font.PLAIN, 17));
		idField.setBounds(83, 321, 260, 36);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
//�α��κ�й�ȣ�ʵ�
		passFiled = new JTextField();
		passFiled.setFont(new Font("�޸�����ü", Font.PLAIN, 17));
		passFiled.setColumns(10);
		passFiled.setBorder(null);
		passFiled.setBounds(83, 393, 260, 36);
		loginPanel.add(passFiled);
	
//�α��ι�ư
		JButton loginBtn = new JButton("");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �α��� ȭ������ �Ѿ�� ���� �̺�Ʈ
				try {
					System.out.println("login button");
					String s;
					String[] array;
					boolean isOK = false;
					BufferedReader bos = new BufferedReader(new FileReader("ȸ�����.txt"));
					while ((s = bos.readLine()) != null) {
						array = s.split("/");
						if (idField.getText().equals(array[1]) && passFiled.getText().equals(array[2])) {
							JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�.");
//						EventQueue.invokeLater(new Runnable() {
//							public void run() {
//								try {
//									mainScreen frame = new mainScreen();
//									frame.setVisible(true);
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//							}
//						});
							frame.dispose();
							// loginPanel.setVisible(false);
							BookManagements mm = new BookManagements();
							mm.MmStart();
							isOK = true;
							break;
						} else if (idField.getText().equals(array[0])) {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���.");
							break;
						} else if (!isOK) {
							JOptionPane.showMessageDialog(null, "�α����� �����ϼ̽��ϴ�.");
							break;
						}
					}
					bos.close();
				} catch (IOException E10) {
					E10.printStackTrace();
				}
			}
		});
		loginBtn.setBounds(189, 459, 170, 47);
		loginPanel.add(loginBtn);
		// ��ư�� �̹��� ����
		loginBtn.setIcon(new ImageIcon("./src/project/Image Soures/�α��ι�ư(��Ŭ��).jpg"));// ����η� ������
		loginBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/�α��ι�ư(Ŭ��).jpg"));// ����η� ������
		// �׵θ� ����
		loginBtn.setBorder(null);
		// ȸ�������г�make
		ImagePanel memPanel = new ImagePanel(
				new ImageIcon("./src/project/Image Soures/memPanel.jpg").getImage());
		// ȸ�������г�
		frame.getContentPane().add(memPanel, BorderLayout.NORTH);
		memPanel.setVisible(false);
		// ȸ�����Թ�ư
		JButton loginBtn2 = new JButton("");
		loginBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginPanel.setVisible(false);
				memPanel.setVisible(true);
			}
		});

		loginBtn2.setFont(new Font("����", Font.PLAIN, 11));
		loginBtn2.setBounds(51, 459, 134, 47);
		loginPanel.add(loginBtn2);
		loginBtn2.setBorder(null);
		loginBtn2.setIcon(new ImageIcon("./src/project/Image Soures/ȸ�����Թ�ư(��Ŭ��).jpg"));// ����η� ������
		loginBtn2.setPressedIcon(new ImageIcon("./src/project/Image Soures/ȸ�����Թ�ư(Ŭ��).jpg"));// ����η� ������

		// ȸ�������г�������
		frame.getContentPane().add(memPanel, BorderLayout.NORTH);

		name_t = new JTextField();
		name_t.setBounds(210, 132, 353, 38);
		memPanel.add(name_t);
		name_t.setColumns(10);

		id_t = new JTextField();
		id_t.setColumns(10);
		id_t.setBounds(210, 199, 353, 38);
		memPanel.add(id_t);

		pass_t = new JTextField();
		pass_t.setColumns(10);
		pass_t.setBounds(210, 266, 353, 38);
		memPanel.add(pass_t);

		pla_t = new JTextField();
		pla_t.setColumns(10);
		pla_t.setBounds(210, 332, 353, 38);
		memPanel.add(pla_t);

		ple_t = new JTextField();
		ple_t.setBounds(48, 450, 515, 224);
		memPanel.add(ple_t);
		ple_t.setColumns(10);

		// �����ư
		JButton saveBtn = new JButton("");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter mem = new BufferedWriter(new FileWriter("ȸ�����.txt", true));
					mem.write(name_t.getText() + "/");
					mem.write(id_t.getText() + "/");
					mem.write(pass_t.getText() + "\n");
					mem.close();
					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�. �α��� ȭ������ ���ư��ϴ�.");
					memPanel.setVisible(false);
					loginPanel.setVisible(true);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�.");
				}
			}
		});
		saveBtn.setIcon(new ImageIcon("./src/project/Image Soures/Ȯ��(��Ŭ��).jpg"));// ����η� ������
		saveBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/Ȯ��(Ŭ��).jpg"));// ����η� ������
		saveBtn.setBounds(262, 20, 136, 53);
		memPanel.add(saveBtn);
		saveBtn.setBorder(null); // �׵θ�����

		JButton exitBtn = new JButton("");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ҹ�ư");
				JOptionPane.showMessageDialog(null, "�α���ȭ������ ���ư��ϴ�.");
				memPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		exitBtn.setIcon(new ImageIcon("./src/project/Image Soures/���.jpg"));// ����η� ������
		exitBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/���(Ŭ��).jpg"));// ����η� ������
		exitBtn.setBounds(422, 20, 136, 53);
		memPanel.add(exitBtn);
		exitBtn.setBorder(null);
	}
}
