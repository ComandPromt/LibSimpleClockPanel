package com.company.digital;

import java.awt.Color;
import java.awt.Font;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class TextDate extends JPanel implements Runnable {

	JLabel diaSemana;

	String textoMes;

	String hora;

	Language idioma;

	JLabel dia;

	JLabel mes;

	LocalDate ld;

	Locale l;

	DayOfWeek dow;

	Calendar now;

	int month;

	int size;

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public void serLeftColor(Color color) {

		diaSemana.setForeground(color);

	}

	public void serRightColor(Color color) {

		dia.setForeground(color);

		mes.setForeground(color);

	}

	public void setFont(String font) {

		diaSemana.setFont(new Font(font, Font.PLAIN, size));

	}

	public TextDate() {

		this(Color.WHITE, Color.BLACK, false, 20);

	}

	public TextDate(Color background, Color foreground, boolean english, int textSize) {

		this.size = textSize;

		mes = new JLabel("");

		dia = new JLabel();

		Language language = Language.SPANISH;

		if (english) {

			language = Language.ENGLISH;

		}

		this.idioma = language;

		textoMes = "";

		diaSemana = new JLabel("");

		diaSemana.setHorizontalAlignment(JTextField.CENTER);

		dia.setHorizontalAlignment(JTextField.CENTER);

		mes.setHorizontalAlignment(JTextField.CENTER);

		add(diaSemana);

		dia.setFont(new Font("Dialog", Font.PLAIN, textSize));

		mes.setFont(new Font("Dialog", Font.PLAIN, textSize));

		textSize += 5;

		diaSemana.setFont(new Font("Dialog", Font.PLAIN, textSize));

		diaSemana.setBackground(background);

		diaSemana.setForeground(foreground);

		dia.setBackground(background);

		dia.setForeground(foreground);

		mes.setBackground(background);

		mes.setForeground(foreground);

		setBackground(background);

		JPanel panel = new JPanel();

		panel.setBackground(background);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		add(panel);

		panel.add(dia);

		JSeparator separator = new JSeparator();

		separator.setBackground(foreground);

		separator.setForeground(foreground);

		panel.add(separator);

		panel.add(mes);

		new Thread(this).start();

	}

	public void run() {

		while (true) {

			now = Calendar.getInstance();

			month = now.get(Calendar.MONTH);

			month++;

			ld = LocalDate.of(Integer.valueOf(now.get(Calendar.YEAR)), Integer.valueOf(month),
					Integer.valueOf(now.get(Calendar.DAY_OF_MONTH)));

			dow = ld.getDayOfWeek();

			switch (idioma) {

			default:

			case ENGLISH:

				l = Locale.UK;

				break;

			case SPANISH:

				l = new Locale("es", "ES");

				break;

			}

			diaSemana.setText(dow.getDisplayName(TextStyle.FULL, l) + " ");

			dia.setText("" + now.get(Calendar.DAY_OF_MONTH));

			if (month <= 9) {

				mes.setText(" " + month);

			}

			else {

				mes.setText("" + month);

			}

		}

	}

}
