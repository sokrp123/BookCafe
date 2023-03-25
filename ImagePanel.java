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
		// �ΰ��� ����� ����� ������ ������ ��
		setLayout(null); // �ʿ��� ������Ʈ���� �츮�� ���ϴ� ���� �������� �ְ� ���ִ°�
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); // �׷��� �ҷ�����
	}

	public Dimension getDim() {
		return new Dimension(img.getWidth(null) + 10, img.getHeight(null) + 45);
	}
}