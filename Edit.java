package project;
import java.awt.Frame; 

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Edit extends BookManagements implements ActionListener{
	MyFrame frame3 = new MyFrame();
	JButton eGenre = new JButton("�帣");
	JButton ePub = new JButton("���ǻ�");
	JButton eAut = new JButton("�۰�");
	JButton eDate = new JButton("���� ����");
	JButton eRate = new JButton("����");
	JButton eConfirm = new JButton("Ȯ��");
	JButton eCancel = new JButton("���");
	
	private JTextField tGenre;
	private JTextField tPub;
	private JTextField tAut;
	private JTextField tDate;
	private JTextField tRate;
	int index ;
	String genre=null, pub=null, aut=null, date=null, rate=null;
	public Edit(int index) {
		frame3.getContentPane().setEnabled(false);
		frame3.setTitle("����");
		frame3.setSize(409, 295);
		frame3.setLocation(550, 350);
		frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
		
		this.index = index - 1;
		
		JLabel lblNewLabel = new JLabel("����");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 10, 47, 23);
		frame3.getContentPane().add(lblNewLabel);
		
		eGenre.setBounds(275, 33, 105, 25);
		frame3.getContentPane().add(eGenre);
		
		ePub.setBounds(275, 63, 105, 25);
		frame3.getContentPane().add(ePub);
		
		eAut.setBounds(275, 123, 105, 25);
		frame3.getContentPane().add(eAut);
		
		eDate.setBounds(275, 153, 105, 25);
		frame3.getContentPane().add(eDate);
		
		eRate.setBounds(275, 183, 105, 25);
		frame3.getContentPane().add(eRate);
		
		eConfirm.setBounds(61, 222, 105, 25);
		frame3.getContentPane().add(eConfirm);
		
		eCancel.setBounds(218, 222, 105, 25);
		frame3.getContentPane().add(eCancel);
		
		JLabel genre = new JLabel("�帣 : ");
		genre.setBounds(12, 43, 57, 15);
		frame3.getContentPane().add(genre);
		
		JLabel pub = new JLabel("���ǻ� : ");
		pub.setBounds(4, 73, 57, 15);
		frame3.getContentPane().add(pub);
		
		JLabel aut = new JLabel("�۰� : ");
		aut.setBounds(12, 133, 83, 15);
		frame3.getContentPane().add(aut);
		
		JLabel date = new JLabel("���� ���� : ");
		date.setBounds(12, 163, 83, 15);
		frame3.getContentPane().add(date);
		
		JLabel rate = new JLabel("���� : ");
		rate.setBounds(12, 193, 43, 15);
		frame3.getContentPane().add(rate);
		
		tGenre = new JTextField();
		tGenre.setEditable(false);
		tGenre.setBounds(50, 40, 208, 21);
		frame3.getContentPane().add(tGenre);
		tGenre.setColumns(10);
		
		tPub = new JTextField();
		tPub.setEditable(false);
		tPub.setColumns(10);
		tPub.setBounds(50, 70, 208, 21);
		frame3.getContentPane().add(tPub);
		
		tAut = new JTextField();
		tAut.setEditable(false);
		tAut.setColumns(10);
		tAut.setBounds(73, 130, 185, 21);
		frame3.getContentPane().add(tAut);
		
		tDate = new JTextField();
		tDate.setEditable(false);
		tDate.setColumns(10);
		tDate.setBounds(73, 160, 85, 21);
		frame3.getContentPane().add(tDate);
		
		tRate = new JTextField();
		tRate.setEditable(false);
		tRate.setColumns(10);
		tRate.setBounds(73, 190, 85, 21);
		frame3.getContentPane().add(tRate);
		
		tGenre.setText(list.get(this.index).getGenre());
		tPub.setText(list.get(this.index).getPub());
		tAut.setText(list.get(this.index).getAut());
		tDate.setText(list.get(this.index).getDate());
		tRate.setText(list.get(this.index).getRate());

		frame3.setVisible(true);
		eGenre.addActionListener(this);
		ePub.addActionListener(this);
		eAut.addActionListener(this);
		eRate.addActionListener(this);
		eDate.addActionListener(this);
		eConfirm.addActionListener(this);
		eCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int check;
		if(e.getSource() == eGenre){
			check = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?\n" + 
					"�帣 : " + tGenre.getText() ,"�޽���", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				genre = JOptionPane.showInputDialog("������ �帣�� �Է��ϼ���", list.get(this.index).getGenre());
				tGenre.setText(genre);
				if(genre == null){
					tGenre.setText(list.get(this.index).getGenre());
				}
			}
		}else if(e.getSource() == ePub){
			check = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?\n" + 
					"���ǻ� : " + tPub.getText() ,"�޽���", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				pub = JOptionPane.showInputDialog("������ ���ǻ縦 �Է��ϼ���", list.get(this.index).getPub());
				tPub.setText(pub);
				if(pub == null){
					tPub.setText(list.get(this.index).getPub());
				}
			}
		}else if(e.getSource() == eAut){
			check = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?\n" + 
					"�۰� : " + tAut.getText() ,"�޽���", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				aut = JOptionPane.showInputDialog("������ �۰��� �Է��ϼ���", list.get(this.index).getAut());
				tAut.setText(aut);
				if(aut == null){
					tAut.setText(list.get(this.index).getAut());
				}
			}
		}
		else if(e.getSource() == eDate){
			check = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?\n" + 
					"���� ���� : " + tDate.getText() ,"�޽���", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				date = JOptionPane.showInputDialog("������ ���� ������ �Է��ϼ���", list.get(this.index).getDate());
				tDate.setText(date);
				if(date == null){
					tDate.setText(list.get(this.index).getDate());
				}
			}
		}
		else if(e.getSource() == eRate){
			check = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?\n" + 
					"���� : " + tRate.getText() ,"�޽���", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				rate = JOptionPane.showInputDialog("������ ������ �Է��ϼ���", list.get(this.index).getRate());
				tRate.setText(rate);
				if(rate == null){
					tRate.setText(list.get(this.index).getRate());
				}
			}
		}
		if(e.getSource() == eConfirm){
			if( genre != null){
				list.get(this.index).setGenre(this.genre);
			}
			if( pub != null){
				list.get(this.index).setPub(this.pub);
			}
			if( aut != null){
				list.get(this.index).setAut(this.aut);
			}
			if( date != null){
				list.get(this.index).setRate(this.date);
			}
			if( rate != null){
				list.get(this.index).setRate(this.rate);
			}
			frame3.dispose();
			Managements m = new Managements();
		}else if(e.getSource() == eCancel){
			frame3.dispose();
			Managements m = new Managements();
		}
		
	}
}
