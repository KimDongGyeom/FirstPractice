package lesson;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextConverter1 extends JFrame implements ActionListener {
	private JButton converBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
		
	public TextConverter1() {
		this.setTitle("텍스트 변환");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		converBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		converBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(converBtn);
		btnPanel.add(cancelBtn);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 변환버튼이 클릭되었다면
		 * 		좌측 textArea (textIn)의 텍스트를 읽어서
		 *	 	영어로 변환하고 그 변환된 결과를
		 *		우측 textArea (textOut)에 append
		 * 취소버튼이 클릭되었다면
		 * 		우측 (textOut)을 빈 문자열로 설정
		 */
		if (e.getSource() == converBtn) {
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
		} else {
			textOut.setText("");
		}
	}
	private String toEnglish(String korean) {
		// korean 문자열을 영어로 변환해서 반환...
		/*
		 * 텍스트 -> text  영어 -> english
		 */
		
		String result = null;
		result = result.replace("텍스트", "text");
		result = result.replace("영어", "english");
		return result;
	}
}