package com.company.digital;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimpleDigitalClock extends JPanel implements Runnable {

	private JLabel bb = new JLabel();

	private String timeString = "";

	private boolean formato24Horas;

	public boolean isFormato24Horas() {

		return formato24Horas;

	}

	public void setFormato24Horas(boolean formato24Horas) {

		this.formato24Horas = formato24Horas;

	}

	@Override
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

	public SimpleDigitalClock() {

		this(Color.WHITE, Color.BLACK, 20);

	}

	public SimpleDigitalClock(Color background, Color foreground, int textSize) {

		setBackground(background);

		bb = new JLabel();

		bb.setFont(new Font("Tahoma", Font.PLAIN, textSize));

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

				SimpleDateFormat formatter = new SimpleDateFormat("hh : mm : ss aa");

				Date date = cal.getTime();

				timeString = formatter.format(date);

				printTime();

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printTime() {

		if (formato24Horas) {

			if (timeString.contains("p")) {

				timeString = Integer.toString(12 + Integer.parseInt(timeString.substring(0, timeString.indexOf(" "))))
						+ timeString.substring(timeString.indexOf(" "), timeString.length());

			}

			else {

				timeString = Integer.toString(Integer.parseInt(timeString.substring(0, timeString.indexOf(" "))))
						+ timeString.substring(timeString.indexOf(" "), timeString.length());

			}

			timeString = timeString.substring(0, timeString.lastIndexOf(" "));

		}

		else {

			if (timeString.contains("p")) {

				timeString = timeString.replace("p. m.", "pm");

			}

			else {

				timeString = timeString.replace("a. m.", "am");

			}

		}

		bb.setText(timeString);

	}

}
