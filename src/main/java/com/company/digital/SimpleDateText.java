package com.company.digital;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimpleDateText extends JPanel implements Runnable {

	JLabel date;

	SimpleDateFormat dateFormat;

	int size;

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public void setFont(String font, int size) {

		this.size = size;

		date.setFont(new Font(font, Font.PLAIN, size));

	}

	public SimpleDateText() {

		this(Color.WHITE, Color.BLACK, 20);

	}

	public SimpleDateText(Color background, Color foreground, int textSize) {

		this.size = textSize;

		dateFormat = new SimpleDateFormat(" dd - MMM - y ");

		setBackground(background);

		date = new JLabel("");

		date.setFont(new Font("Arial", Font.PLAIN, textSize));

		date.setOpaque(true);

		date.setBorder(null);

		date.setHorizontalAlignment(JTextField.CENTER);

		date.setBackground(background);

		date.setForeground(foreground);

		add(date);

		new Thread(this).start();

	}

	public void run() {

		while (true) {

			date.setText(dateFormat.format(Calendar.getInstance().getTime()));

		}

	}

}
