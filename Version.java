package project;
import java.awt.Frame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.TextArea;

public class Version extends Frame {
	MyFrame frame2 = new MyFrame();
	
	public Version()
	{
		frame2.setTitle("��������");
		frame2.setSize(200, 166);
		frame2.setLocation(550, 350);
		frame2.setDefaultCloseOperation(frame2.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("������ : 2��");
		lblNewLabel.setBounds(12, 10, 160, 27);
		frame2.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("������, �̻���, ������, ��ƿ�");
		label.setBounds(12, 38, 200, 27);
		frame2.getContentPane().add(label);
		
		JLabel label_1 = new JLabel( "���α׷� ���� : v1.0");
		label_1.setBounds(12, 66, 160, 27);
		frame2.getContentPane().add(label_1);
		frame2.setVisible(true);
	
	}
}
