package project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class BookMark extends JFrame {

	private static List<Books> bookMarkList = new ArrayList<Books>();
	private JPanel contentsPanel = null; // 주 컨텐츠패널 : 리스트를 보여주는 패널
	private JScrollPane scrollPane = null;
	MyFrame frame6 = new MyFrame();

	public BookMark() {

		frame6.setLayout(null); // 프레임 레이아웃 설정
		frame6.setResizable(false); // 창크기 조절 불가
		frame6.setLocationRelativeTo(null); // 화면 가운데
		frame6.getContentPane().setEnabled(false);
		frame6.setSize(468, 368);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // x 버튼눌렀을 때 이 창만 꺼짐.
		frame6.setVisible(true);

		// 해드패널 : 제목, 저자 , 상세/해제
		JPanel headPanel = new JPanel();
		headPanel.setBounds(5, 5, 448, 25);
		headPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2)); // 테두리
		headPanel.setBackground(Color.PINK);
		headPanel.setLayout(new GridLayout(0, 3, 0, 0));
		headPanel.add(new JLabel("제목"));
		headPanel.add(new JLabel("저자"));
		headPanel.add(new JLabel("                       상세/해제", JLabel.LEFT));
		frame6.add(headPanel); // 프레임에 추가

		// 주 컨텐츠패널 : 리스트를 보여주는 패널
		makeContentsPanel();

		// 새로고침 버튼
		JButton refreshButton = new JButton("");
		refreshButton.setBounds(400, 215, 54, 54);
		setButtonProperty(refreshButton);
		refreshButton.addActionListener(e -> refreshBookMarkList());
		frame6.add(refreshButton);

		refreshBookMarkList();
	}

	private void makeContentsPanel() {
		contentsPanel = new JPanel();

		contentsPanel.setBounds(5, 30, 448, 185);
		contentsPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		contentsPanel.setBackground(SystemColor.activeCaption);
		contentsPanel.setLayout(new BoxLayout(contentsPanel, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(contentsPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(5, 30, 448, 185);
		frame6.add(scrollPane); // 프레임에 추가
	}

	private void setButtonProperty(JButton btn) {
		ImageIcon imgIcon = new ImageIcon("./src/project/Image Soures/Refresh.jpg"); // 상대경로로 수정함
		Image img = imgIcon.getImage();
		btn.setIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		imgIcon = new ImageIcon("./src/project/Image Soures/RefreshPressed.jpg"); // 상대경로로 수정함
		img = imgIcon.getImage();
		btn.setPressedIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		imgIcon = new ImageIcon("./src/project/Image Soures/RefreshRollover.jpg"); // 상대경로로 수정함
		img = imgIcon.getImage();
		btn.setRolloverIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		btn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정 (하늘색?푸르스름한거제거)
		btn.setBorderPainted(false); // 버튼테두리 설정
		btn.setFocusPainted(false); // 버튼 포커스 표시

	}

	private void addBookPanel(Books book, JButton lookUpButton, JButton removeButton) {
		
		for (int i = 0; i <= bookMarkList.size() - 1; i++) {
			book = bookMarkList.get(i);

			JPanel bookPanel = new JPanel(); // 주 컨텐츠 패널에 들어갈 하나의 그릇 패널
			bookPanel.setBackground(Color.YELLOW);
			bookPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			bookPanel.setLayout(new BorderLayout());
			contentsPanel.add(bookPanel); // 주 컨테츠패널에 추가.

			JLabel titleLabel = new JLabel(book.getName()); // 리스트에서 제목가져오기
			bookPanel.add(titleLabel, BorderLayout.WEST); // 그릇패널에 추가

			JLabel authorLabel = new JLabel(book.getAut(), JLabel.CENTER); // 저자 가져오기
			bookPanel.add(authorLabel, BorderLayout.CENTER); // 그릇패널에 추가

			JPanel funtionPanel = new JPanel(); // 그릇 패널에 들어갈 기능패널
			funtionPanel.setLayout(new BoxLayout(funtionPanel, BoxLayout.Y_AXIS));
			lookUpButton = new JButton("상세");
			removeButton = new JButton("삭제");
			funtionPanel.add(lookUpButton);
			funtionPanel.add(removeButton);
			bookPanel.add(funtionPanel, BorderLayout.EAST);
			lookUpButton.setActionCommand(Integer.toString(i)); // i 가 곧 인덱스번호니까. i를 이용해 버튼마다 액션코맨드설정해 버튼 식별
			removeButton.setActionCommand(Integer.toString(i));

			lookUpButton.addActionListener(e -> lookUpBook(Integer.parseInt(e.getActionCommand())));
			removeButton.addActionListener(e -> removeBook(Integer.parseInt(e.getActionCommand())));
		}
	}

	private void refreshBookMarkList() {
		Books book = null;
		JButton lookUpButton = null;
		JButton removeButton = null;
		frame6.remove(scrollPane);
		makeContentsPanel();
		addBookPanel(book, lookUpButton, removeButton);
		frame6.revalidate();
		frame6.repaint();
	}

	private void lookUpBook(int index) {
		Books book = bookMarkList.get(index);
		new BookInfo(book.getName());
	}

	private void removeBook(int index) {
		bookMarkList.remove(index);
		refreshBookMarkList();
	}

	public static int searchBook(Books book) {
		int returnValue = 0; // 유:1 , 무:0

		for (Books bk : bookMarkList) {
			if ((bk.getName().equals(book.getName())) && (bk.getAut().equals(book.getAut()))) {
				returnValue = 1;
				break;
			}
		}
		return returnValue;
	}

	public static void addBookMarkList(String title, String author, String publisher, String genre, String rating) {
		Books NewBook = new Books(title, author, publisher, genre, rating);

		if (searchBook(NewBook) == 0)
			bookMarkList.add(NewBook); // 진짜추가.
		else
			JOptionPane.showMessageDialog(null, "이미 등록되어 있습니다", "알림", JOptionPane.INFORMATION_MESSAGE); // 중복있다고 알람띄우기
	}

}