package com.company.dates;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDate extends JPanel implements Runnable {

	JLabel date;

	Calendar now;

	int size;

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public void setFont(String font) {

		date.setFont(new Font(font, Font.BOLD, size));

	}

	public SimpleDate(Color background, Color foreground, int textSize) {

		this.size = textSize;

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

			now = Calendar.getInstance();

			int month = now.get(Calendar.MONTH);

			int day = now.get(Calendar.DAY_OF_MONTH);

			int year = now.get(Calendar.YEAR);

			date.setText(" " + day + " / " + (month + 1) + " / " + year + " ");

		}

	}

}
