package com.company.dates;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.company.MaterialDigitalClock.Language;

@SuppressWarnings("serial")
public class MaterialDate extends JPanel implements Runnable {

	JLabel diaSemana;

	Language idioma;

	JLabel mes;

	JLabel year;

	LocalDate ld;

	Locale l;

	Month dow;

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

		mes.setForeground(color);

		year.setForeground(color);

	}

	public void setFont(String font) {

		diaSemana.setFont(new Font(font, Font.BOLD, size));

	}

	public MaterialDate(Color background, Color foreground, Language language, int textSize) {

		this.size = textSize;

		year = new JLabel("");

		mes = new JLabel();

		this.idioma = language;

		diaSemana = new JLabel("");

		add(diaSemana);

		mes.setFont(new Font("Tahoma", Font.BOLD, textSize));

		year.setFont(new Font("Tahoma", Font.BOLD, textSize));

		textSize *= 2;

		diaSemana.setFont(new Font("Tahoma", Font.BOLD, textSize));

		diaSemana.setBackground(background);

		diaSemana.setForeground(foreground);

		mes.setBackground(background);

		mes.setForeground(foreground);

		year.setBackground(background);

		year.setForeground(foreground);

		year.setHorizontalAlignment(JTextField.CENTER);

		mes.setHorizontalAlignment(JTextField.CENTER);

		diaSemana.setHorizontalAlignment(JTextField.CENTER);

		setBackground(background);

		JPanel panel = new JPanel();

		panel.setBackground(background);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		add(panel);

		panel.add(mes);

		JSeparator separator = new JSeparator();

		separator.setBackground(foreground);

		separator.setForeground(foreground);

		panel.add(separator);

		panel.add(year);

		new Thread(this).start();

	}

	public void run() {

		while (true) {

			now = Calendar.getInstance();

			diaSemana.setText("" + now.get(Calendar.DAY_OF_MONTH));

			month = now.get(Calendar.MONTH);

			month++;

			ld = LocalDate.of(Integer.valueOf(now.get(Calendar.YEAR)), Integer.valueOf(month),
					Integer.valueOf(now.get(Calendar.DAY_OF_MONTH)));

			dow = ld.getMonth();

			switch (idioma) {

			default:

			case ENGLISH:

				l = Locale.UK;

				break;

			case SPANISH:

				l = new Locale("es", "ES");

				break;

			}

			mes.setText(dow.getDisplayName(TextStyle.FULL, l).toUpperCase());

			year.setText("" + now.get(Calendar.YEAR));

		}

	}

}
