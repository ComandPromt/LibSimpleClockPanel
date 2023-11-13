package com.company.digital;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimpleDate extends JPanel implements Runnable {

	JLabel date;

	Calendar now;

	int size;

	private String separator;

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public void setFont(Font font) {

		try {

			date.setFont(font);

		}

		catch (Exception e) {

		}

	}

	public SimpleDate() {

		this(Color.WHITE, Color.BLACK, 20);

	}

	public String getSeparator() {

		return separator;

	}

	public void setSeparator(String separator) {

		this.separator = separator;

	}

	public SimpleDate(Color background, Color foreground, int textSize) {

		separator = " / ";

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

			date.setText(" " + day + separator + (month + 1) + separator + year);

		}

	}

}
