package project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		// 두개를 해줘야 사이즈가 실제로 변경이 됨
		setLayout(null); // 필요한 컴포넌트들을 우리가 원하는 곳에 절댓값으로 넣게 해주는것
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); // 그래픽 불러오기
	}

	public Dimension getDim() {
		return new Dimension(img.getWidth(null) + 10, img.getHeight(null) + 45);
	}
}