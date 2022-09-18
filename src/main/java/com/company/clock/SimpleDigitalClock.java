package com.company.clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDigitalClock extends JPanel implements Runnable {

	private JLabel bb = new JLabel();

	private String timeString = "";

	public void setFont(Font font) {

		if (bb != null) {

			bb.setFont(font);
		}

	}

	public JPanel getPanel() {

		return this;

	}

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public SimpleDigitalClock(Color background, Color foreground, int textSize) {

		setBackground(background);

		bb = new JLabel();

		bb.setFont(new Font("Arial", Font.BOLD, textSize));

		bb.setOpaque(true);

		bb.setBorder(null);

		bb.setHorizontalAlignment(JTextField.CENTER);

		bb.setBackground(background);

		bb.setForeground(foreground);

		add(bb);

		new Thread(this).start();

	}

	public void run() {

		try {

			while (true) {

				Calendar cal = Calendar.getInstance();

				SimpleDateFormat formatter = new SimpleDateFormat(" hh : mm : ss aa ");

				Date date = cal.getTime();

				timeString = formatter.format(date);

				printTime();

			}

		}

		catch (Exception e) {

		}

	}

	public void printTime() {

		if (timeString.contains("p")) {

			timeString = timeString.replace("p. m.", "pm");

		}

		else {

			timeString = timeString.replace("a. m.", "am");

		}

		bb.setText(timeString);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
