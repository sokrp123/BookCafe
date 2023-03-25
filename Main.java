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
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("./src/project/Image Soures/login.jpg").getImage()); // 상대경로로 설정함
		frame.getContentPane().add(loginPanel, BorderLayout.SOUTH);
		// 로그인패널프레임
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
//로그인아이디필드
		idField = new JTextField();
		idField.setFont(new Font("휴먼편지체", Font.PLAIN, 17));
		idField.setBounds(83, 321, 260, 36);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
//로그인비밀번호필드
		passFiled = new JTextField();
		passFiled.setFont(new Font("휴먼편지체", Font.PLAIN, 17));
		passFiled.setColumns(10);
		passFiled.setBorder(null);
		passFiled.setBounds(83, 393, 260, 36);
		loginPanel.add(passFiled);
	
//로그인버튼
		JButton loginBtn = new JButton("");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 로그인 화면으로 넘어가기 위한 이벤트
				try {
					System.out.println("login button");
					String s;
					String[] array;
					boolean isOK = false;
					BufferedReader bos = new BufferedReader(new FileReader("회원명단.txt"));
					while ((s = bos.readLine()) != null) {
						array = s.split("/");
						if (idField.getText().equals(array[1]) && passFiled.getText().equals(array[2])) {
							JOptionPane.showMessageDialog(null, "로그인이 되었습니다.");
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
							JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
							break;
						} else if (!isOK) {
							JOptionPane.showMessageDialog(null, "로그인이 실패하셨습니다.");
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
		// 버튼에 이미지 삽입
		loginBtn.setIcon(new ImageIcon("./src/project/Image Soures/로그인버튼(노클릭).jpg"));// 상대경로로 설정함
		loginBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/로그인버튼(클릭).jpg"));// 상대경로로 설정함
		// 테두리 제거
		loginBtn.setBorder(null);
		// 회원가입패널make
		ImagePanel memPanel = new ImagePanel(
				new ImageIcon("./src/project/Image Soures/memPanel.jpg").getImage());
		// 회원가입패널
		frame.getContentPane().add(memPanel, BorderLayout.NORTH);
		memPanel.setVisible(false);
		// 회원가입버튼
		JButton loginBtn2 = new JButton("");
		loginBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginPanel.setVisible(false);
				memPanel.setVisible(true);
			}
		});

		loginBtn2.setFont(new Font("굴림", Font.PLAIN, 11));
		loginBtn2.setBounds(51, 459, 134, 47);
		loginPanel.add(loginBtn2);
		loginBtn2.setBorder(null);
		loginBtn2.setIcon(new ImageIcon("./src/project/Image Soures/회원가입버튼(노클릭).jpg"));// 상대경로로 설정함
		loginBtn2.setPressedIcon(new ImageIcon("./src/project/Image Soures/회원가입버튼(클릭).jpg"));// 상대경로로 설정함

		// 회원가입패널프레임
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

		// 저장버튼
		JButton saveBtn = new JButton("");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter mem = new BufferedWriter(new FileWriter("회원명단.txt", true));
					mem.write(name_t.getText() + "/");
					mem.write(id_t.getText() + "/");
					mem.write(pass_t.getText() + "\n");
					mem.close();
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다. 로그인 화면으로 돌아갑니다.");
					memPanel.setVisible(false);
					loginPanel.setVisible(true);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하셨습니다.");
				}
			}
		});
		saveBtn.setIcon(new ImageIcon("./src/project/Image Soures/확인(노클릭).jpg"));// 상대경로로 설정함
		saveBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/확인(클릭).jpg"));// 상대경로로 설정함
		saveBtn.setBounds(262, 20, 136, 53);
		memPanel.add(saveBtn);
		saveBtn.setBorder(null); // 테두리제거

		JButton exitBtn = new JButton("");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소버튼");
				JOptionPane.showMessageDialog(null, "로그인화면으로 돌아갑니다.");
				memPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		exitBtn.setIcon(new ImageIcon("./src/project/Image Soures/취소.jpg"));// 상대경로로 설정함
		exitBtn.setPressedIcon(new ImageIcon("./src/project/Image Soures/취소(클릭).jpg"));// 상대경로로 설정함
		exitBtn.setBounds(422, 20, 136, 53);
		memPanel.add(exitBtn);
		exitBtn.setBorder(null);
	}
}
