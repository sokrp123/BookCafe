package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class BookInfo extends BookSearch {
   String title, author, publisher, genre, rating;
   MyFrame frame6 = new MyFrame();
   
   
   protected JPanel contentPane;
   ImageIcon icon;
   
   public BookInfo(String bookname) {
   
      
      frame6.setVisible(true);
      
      Calendar cal = Calendar.getInstance();
      
     // File file = new File("C\\Javadev\\TeamProject_\\booksinfo\\" + bookname + ".txt");	//책 제목, 작가, 출판사, 장르, 출판 연도, 평점이 저장된 파일	
      File file = new File("./src/project/booksinfo/" + bookname + ".txt"); // 상대경로로 수정함	//책 제목, 작가, 출판사, 장르, 출판 연도, 평점이 저장된 파일	
      
      
      //icon = new ImageIcon("C\\Javadev\\TeamProject_\\booksinfo\\독서1.jpg");	//이미지 경로 저장
      icon = new ImageIcon("./src/project/Image Soures/독서1.jpg");	// 상대경로로 수정함 이미지 경로 저장
      
      Image img = icon.getImage();
      Image changeImg = img.getScaledInstance(740, 500, Image.SCALE_SMOOTH);
      ImageIcon changeIcon = new ImageIcon(changeImg);
            

      JPanel main_panel = new JPanel() {   //가장 큰 패널에 이미지 넣기
            public void paintComponent(Graphics g) {
                g.drawImage(changeIcon.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame6.setBounds(100, 100, 762, 556);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      main_panel.setBounds(5, 5, 740, 500);
      frame6.add(main_panel);
      main_panel.setLayout(null);
      
      JPanel bookInfo_panel = new JPanel();   //책 정보 패널
      bookInfo_panel.setBounds(10, 145, 720, 350);
      main_panel.add(bookInfo_panel);
      bookInfo_panel.setLayout(null);
      
      JLabel lblNewLabel_1 = new JLabel("작가 :");
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_1.setBounds(10, 30, 61, 28);
      bookInfo_panel.add(lblNewLabel_1);
      
      //
      JLabel lblNewLabel_1_1 = new JLabel("출판사 :");
      lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_1_1.setBounds(10, 80, 90, 28);
      bookInfo_panel.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_2 = new JLabel("장르 :");
      lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_1_2.setBounds(10, 180, 61, 28);
      bookInfo_panel.add(lblNewLabel_1_2);
      
      JLabel lblNewLabel_1_3 = new JLabel("평점 :");
      lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_1_3.setBounds(10, 230, 59, 28);
      bookInfo_panel.add(lblNewLabel_1_3);
      
      JLabel author_label = new JLabel("");
      author_label.setFont(new Font("굴림", Font.BOLD, 20));
      author_label.setBounds(70, 30, 200, 28);
      bookInfo_panel.add(author_label);
      
      JLabel publisher_label = new JLabel("");
      publisher_label.setFont(new Font("굴림", Font.BOLD, 20));
      publisher_label.setBounds(102, 80, 200, 28);
      bookInfo_panel.add(publisher_label);
      
      JLabel genre_label = new JLabel("");
      genre_label.setFont(new Font("굴림", Font.BOLD, 20));
      genre_label.setBounds(70, 180, 123, 28);
      bookInfo_panel.add(genre_label);
      
      JLabel rating_label = new JLabel("");
      rating_label.setFont(new Font("굴림", Font.BOLD, 20));
      rating_label.setBounds(70, 230, 98, 28);
      bookInfo_panel.add(rating_label);
      
      //
      JLabel lblNewLabel_1_3_1 = new JLabel("출판 연도 :");
      lblNewLabel_1_3_1.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_1_3_1.setBounds(10, 130, 120, 28);
      bookInfo_panel.add(lblNewLabel_1_3_1);
      
      JLabel publicationYear_label = new JLabel("");
      publicationYear_label.setFont(new Font("굴림", Font.BOLD, 20));
      publicationYear_label.setBounds(129, 130, 61, 28);
      bookInfo_panel.add(publicationYear_label);
      
      JPanel bookIntroduce_panel = new JPanel();   //책 소개 패널
      bookIntroduce_panel.setBounds(10, 145, 720, 350);
      main_panel.add(bookIntroduce_panel);
      bookIntroduce_panel.setLayout(null);
      
      TextArea textArea = new TextArea();
      textArea.setBounds(0, 0, 720, 350);
      textArea.setEditable(false);
      bookIntroduce_panel.add(textArea);
      
      ScrollPane scrollPane = new ScrollPane();
      scrollPane.setBounds(0, 0, 720, 350);
      bookIntroduce_panel.add(scrollPane);
      
      JPanel review_panel = new JPanel();   //감상평 패널
      review_panel.setBounds(10, 145, 720, 350);
      main_panel.add(review_panel);
      review_panel.setLayout(null);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(0, 0, 720, 200);
      review_panel.add(scrollPane_1);
      
      JTextArea commentRead_textarea = new JTextArea();   //댓글 확인 창
      scrollPane_1.setViewportView(commentRead_textarea);
      commentRead_textarea.setEditable(false);
      
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(10, 220, 520, 120);
      review_panel.add(scrollPane_2);
      
      JTextArea registration_textarea = new JTextArea();   //댓글 입력창
      scrollPane_2.setViewportView(registration_textarea);
      registration_textarea.setText("감상평을 입력하시오.");
      
      JButton registration_button = new JButton("등록");
      registration_button.setFont(new Font("굴림", Font.BOLD, 24));
      registration_button.setBounds(563, 251, 145, 71);
      review_panel.add(registration_button);
      
//      JLabel lblNewLabel = new JLabel("제목 :");
//      lblNewLabel.setForeground(SystemColor.info);
//      lblNewLabel.setFont(new Font("바탕체", Font.BOLD, 40));
//      lblNewLabel.setBounds(10, 5, 137, 56);
//      main_panel.add(lblNewLabel);
      
      JLabel bookTitle_label = new JLabel("책 제목");
      bookTitle_label.setForeground(SystemColor.info);
      bookTitle_label.setHorizontalAlignment(SwingConstants.CENTER);
      bookTitle_label.setFont(new Font("바탕체", Font.BOLD, 35));
      bookTitle_label.setBounds(10, 5, 700, 56);
      main_panel.add(bookTitle_label);
      
      /////////////////////////////////////////////////
      try {
         BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
         String line = br.readLine();
         
         bookTitle_label.setText(line);
         title = bookTitle_label.getText();
         line = br.readLine();
         author_label.setText(line);
         author = author_label.getText();
         line = br.readLine();
         publisher_label.setText(line);
         publisher = publisher_label.getText();
         line = br.readLine();
         publicationYear_label.setText(line);
         line = br.readLine();
         genre_label.setText(line);
         genre = genre_label.getText();
         line = br.readLine();
         rating_label.setText(line);
         rating = rating_label.getText();
         
         JButton addList_button = new JButton("즐겨찾기 추가");
         addList_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            addList_button.setText("즐겨찾기 완료");
            System.out.println(title + " " + author + " " + publisher);
          //추가시작 bookMark
			BookMark.addBookMarkList(title, author, publisher, genre, rating);
			int showBookMarkResult = JOptionPane.showConfirmDialog(null, "즐겨찾기 목록을 확인하시겠습니까?",null,JOptionPane.YES_NO_OPTION);
			if(showBookMarkResult == JOptionPane.YES_OPTION)
				new BookMark();
			//추가끝
            }
         });
         addList_button.setFont(new Font("굴림", Font.BOLD, 24));
         addList_button.setBounds(504, 9, 204, 81);
         bookInfo_panel.add(addList_button);
         //////////////////////////////////////////////////
      
         br.close();
         } catch (IOException e) {
            System.out.println("could not read the file");
            }
      
      /////////////////////////////////////////////////
      try {
         BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));

         String line = br.readLine();
         while(line != null) {
            line = br.readLine();
            if(line.indexOf("#") != -1) {
               line = br.readLine();
               while(line.indexOf("#") == -1){
                  textArea.append(line);
                  textArea.append("\n");
                  line = br.readLine();
                  }
            }
            if(line.indexOf("@") != -1) {
               line = br.readLine();
               while(line != null){
                  commentRead_textarea.append(line);
                  commentRead_textarea.append("\n");
                  line = br.readLine();
                  }
            }
         }
         br.close();
      } catch (IOException e) {
         System.out.println("could not read the file.");
      }
      //////////////////////////////////////////////////
      JButton bookInfo_button = new JButton("책 정보");
      bookInfo_button.setBackground(SystemColor.textHighlightText);
      bookInfo_button.setFont(new Font("궁서", Font.BOLD, 20));
      bookInfo_button.setBounds(0, 83, 190, 56);
      main_panel.add(bookInfo_button);
      
      JButton bookIntroduce_button = new JButton("책 소개");
      bookIntroduce_button.setBackground(SystemColor.control);
      bookIntroduce_button.setFont(new Font("궁서", Font.BOLD, 20));
      bookIntroduce_button.setBounds(189, 83, 190, 56);
      main_panel.add(bookIntroduce_button);
      
      JButton review_button = new JButton("감상평");
      review_button.setBackground(SystemColor.control);
      review_button.setFont(new Font("궁서", Font.BOLD, 20));
      review_button.setBounds(378, 83, 190, 56);
      main_panel.add(review_button);
      
      bookInfo_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            bookInfo_button.setBackground(SystemColor.textHighlightText);
            bookIntroduce_button.setBackground(SystemColor.control);
            review_button.setBackground(SystemColor.control);
            bookInfo_panel.setVisible(true);
            bookIntroduce_panel.setVisible(false);
            review_panel.setVisible(false);
         }
      });
      
      bookIntroduce_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            bookInfo_button.setBackground(SystemColor.control);
            bookIntroduce_button.setBackground(SystemColor.textHighlightText);
            review_button.setBackground(SystemColor.control);
            bookInfo_panel.setVisible(false);
            bookIntroduce_panel.setVisible(true);
            review_panel.setVisible(false);
         }
      });
      
      review_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            bookInfo_button.setBackground(SystemColor.control);
            bookIntroduce_button.setBackground(SystemColor.control);
            review_button.setBackground(SystemColor.textHighlightText);
            bookInfo_panel.setVisible(false);
            bookIntroduce_panel.setVisible(false);
            review_panel.setVisible(true);
         }
      });
      
      registration_button.addActionListener(new ActionListener() {   //등록 버튼 눌렀을 떄 파일에 입력
         public void actionPerformed(ActionEvent e) {
            JTextField tf = new JTextField(10);
            int result = JOptionPane.showConfirmDialog(null, "댓글은 삭제할 수 없습니다. 계속하시겠습니까?", "경고문", JOptionPane.YES_NO_OPTION);
            
            if(result == JOptionPane.CLOSED_OPTION)
               tf.setText("Just Closed without Selection");
            else if(result == JOptionPane.YES_OPTION) {
               tf.setText("Yes");
               try {
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  String datestr = sdf.format(cal.getTime());
                  
                  FileOutputStream output=new FileOutputStream(file, true);
                    OutputStreamWriter writer=new OutputStreamWriter(output,"utf-8");
                    BufferedWriter out=new BufferedWriter(writer);
                  
                  out.append("\n\n");
                  out.write(registration_textarea.getText());
                  out.append("\n");
                  out.write("- ye**50419  ");
                  out.write(datestr);
                  out.flush();   //이때까지 쓴 것을 저장?
                  out.close();   //이때까지 쓴 것을 저장? 하고 끝냄
                  commentRead_textarea.setText(null);
                  BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
   
                  String line = br.readLine();
                  while(line != null) {
                     line = br.readLine();
                     if(line.indexOf("@") != -1) {
                        line = br.readLine();
                        while(line != null){
                           commentRead_textarea.append(line);
                           commentRead_textarea.append("\n");
                           line = br.readLine();
                           }
                        break;
                     }
                  }
                  br.close();
               
               } catch (IOException e1) {
                  System.out.println("could not write text.");
               }
            }
            else
               tf.setText("No");
         }
      });
   }
}