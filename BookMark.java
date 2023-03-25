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
	private JPanel contentsPanel = null; // �� �������г� : ����Ʈ�� �����ִ� �г�
	private JScrollPane scrollPane = null;
	MyFrame frame6 = new MyFrame();

	public BookMark() {

		frame6.setLayout(null); // ������ ���̾ƿ� ����
		frame6.setResizable(false); // âũ�� ���� �Ұ�
		frame6.setLocationRelativeTo(null); // ȭ�� ���
		frame6.getContentPane().setEnabled(false);
		frame6.setSize(468, 368);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // x ��ư������ �� �� â�� ����.
		frame6.setVisible(true);

		// �ص��г� : ����, ���� , ��/����
		JPanel headPanel = new JPanel();
		headPanel.setBounds(5, 5, 448, 25);
		headPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2)); // �׵θ�
		headPanel.setBackground(Color.PINK);
		headPanel.setLayout(new GridLayout(0, 3, 0, 0));
		headPanel.add(new JLabel("����"));
		headPanel.add(new JLabel("����"));
		headPanel.add(new JLabel("                       ��/����", JLabel.LEFT));
		frame6.add(headPanel); // �����ӿ� �߰�

		// �� �������г� : ����Ʈ�� �����ִ� �г�
		makeContentsPanel();

		// ���ΰ�ħ ��ư
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
		frame6.add(scrollPane); // �����ӿ� �߰�
	}

	private void setButtonProperty(JButton btn) {
		ImageIcon imgIcon = new ImageIcon("./src/project/Image Soures/Refresh.jpg"); // ����η� ������
		Image img = imgIcon.getImage();
		btn.setIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		imgIcon = new ImageIcon("./src/project/Image Soures/RefreshPressed.jpg"); // ����η� ������
		img = imgIcon.getImage();
		btn.setPressedIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		imgIcon = new ImageIcon("./src/project/Image Soures/RefreshRollover.jpg"); // ����η� ������
		img = imgIcon.getImage();
		btn.setRolloverIcon(new ImageIcon(img.getScaledInstance(btn.getWidth() - 4, btn.getHeight() - 4, Image.SCALE_SMOOTH)));
		btn.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ���� (�ϴû�?Ǫ�������Ѱ�����)
		btn.setBorderPainted(false); // ��ư�׵θ� ����
		btn.setFocusPainted(false); // ��ư ��Ŀ�� ǥ��

	}

	private void addBookPanel(Books book, JButton lookUpButton, JButton removeButton) {
		
		for (int i = 0; i <= bookMarkList.size() - 1; i++) {
			book = bookMarkList.get(i);

			JPanel bookPanel = new JPanel(); // �� ������ �гο� �� �ϳ��� �׸� �г�
			bookPanel.setBackground(Color.YELLOW);
			bookPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			bookPanel.setLayout(new BorderLayout());
			contentsPanel.add(bookPanel); // �� �������гο� �߰�.

			JLabel titleLabel = new JLabel(book.getName()); // ����Ʈ���� ����������
			bookPanel.add(titleLabel, BorderLayout.WEST); // �׸��гο� �߰�

			JLabel authorLabel = new JLabel(book.getAut(), JLabel.CENTER); // ���� ��������
			bookPanel.add(authorLabel, BorderLayout.CENTER); // �׸��гο� �߰�

			JPanel funtionPanel = new JPanel(); // �׸� �гο� �� ����г�
			funtionPanel.setLayout(new BoxLayout(funtionPanel, BoxLayout.Y_AXIS));
			lookUpButton = new JButton("��");
			removeButton = new JButton("����");
			funtionPanel.add(lookUpButton);
			funtionPanel.add(removeButton);
			bookPanel.add(funtionPanel, BorderLayout.EAST);
			lookUpButton.setActionCommand(Integer.toString(i)); // i �� �� �ε�����ȣ�ϱ�. i�� �̿��� ��ư���� �׼��ڸǵ弳���� ��ư �ĺ�
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
		int returnValue = 0; // ��:1 , ��:0

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
			bookMarkList.add(NewBook); // ��¥�߰�.
		else
			JOptionPane.showMessageDialog(null, "�̹� ��ϵǾ� �ֽ��ϴ�", "�˸�", JOptionPane.INFORMATION_MESSAGE); // �ߺ��ִٰ� �˶�����
	}

}