package com.company.clock;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.company.MaterialDigitalClock.Language;

public class TextClock extends JPanel implements Runnable {

	JLabel hour;

	JLabel mes;

	String textoMes;

	JLabel dia;

	String hora = "";

	JLabel pm;

	Language idioma;

	JLabel minuto;

	private JSeparator separator_1;

	public void setBorderColor(Color color) {

		setBackground(color);

	}

	public TextClock(Color background, Color foreground, Language language, int textSize) {

		dia = new JLabel("");

		minuto = new JLabel("");

		this.idioma = language;

		pm = new JLabel();

		textoMes = "";

		mes = new JLabel("Ene");

		hour = new JLabel("");

		hour.setHorizontalAlignment(JTextField.CENTER);

		add(hour);

		JPanel panel = new JPanel();

		add(panel);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();

		panel.add(panel_1);

		panel_1.add(minuto);

		pm.setFont(new Font("Tahoma", Font.BOLD, textSize));

		panel_1.add(pm);

		JSeparator separator = new JSeparator();

		panel.add(separator);

		separator_1 = new JSeparator();

		panel.add(separator_1);

		JPanel panel_2 = new JPanel();

		panel.add(panel_2);

		mes.setFont(new Font("Tahoma", Font.BOLD, textSize));

		panel_2.add(mes);

		dia.setFont(new Font("Tahoma", Font.BOLD, textSize));

		panel_2.add(dia);

		textSize *= 2;

		hour.setFont(new Font("Tahoma", Font.BOLD, textSize));

		textSize -= textSize / 3;

		minuto.setFont(new Font("Tahoma", Font.BOLD, textSize));

		panel.setBackground(background);

		mes.setBackground(background);

		dia.setBackground(background);

		hour.setBackground(background);

		mes.setForeground(foreground);

		dia.setForeground(foreground);

		hour.setForeground(foreground);

		minuto.setBackground(background);

		minuto.setForeground(foreground);

		pm.setBackground(background);

		pm.setForeground(foreground);

		setBackground(background);

		panel_1.setBackground(background);

		panel_2.setBackground(background);

		separator.setBackground(foreground);

		separator_1.setBackground(foreground);

		separator.setForeground(foreground);

		separator_1.setForeground(foreground);

		new Thread(this).start();

	}

	public void run() {

		while (true) {

			Calendar now = Calendar.getInstance();

			int month = now.get(Calendar.MONTH);

			int day = now.get(Calendar.DAY_OF_MONTH);

			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");

			Date date = now.getTime();

			hora = formatter.format(date);

			if (hora.contains("p")) {

				pm.setText("pm");

			}

			else {

				pm.setText("am");

			}

			if (hora.substring(0, 1).equals("0")) {

				hora = hora.substring(1, 2);

			}

			else {

				hora = hora.substring(0, 2);

			}

			hour.setText(hora);

			dia.setText("" + day);

			month++;

			minuto.setText(formatter.format(date).substring(3, 5));

			switch (month) {

			case 1:

				switch (idioma) {

				case SPANISH:

					textoMes = "Ene";

					break;

				case ENGLISH:

					textoMes = "Jan";

					break;

				}

				break;

			case 2:

				switch (idioma) {

				case SPANISH:

				case ENGLISH:

					textoMes = "Feb";

					break;

				}

				break;

			case 3:

				switch (idioma) {

				case SPANISH:

					textoMes = "Mar";

					break;

				case ENGLISH:

					textoMes = "Mar";

					break;

				}

				break;

			case 4:

				switch (idioma) {

				case SPANISH:

					textoMes = "Abr";

					break;

				case ENGLISH:

					textoMes = "Apr";

					break;

				}

				break;

			case 5:

				switch (idioma) {

				case SPANISH:

				case ENGLISH:

					textoMes = "May";

					break;

				}

				break;

			case 6:

				switch (idioma) {

				case SPANISH:
				case ENGLISH:

					textoMes = "Jun";

					break;

				}

				break;

			case 7:

				switch (idioma) {

				case SPANISH:
				case ENGLISH:

					textoMes = "Jul";

					break;

				}

				break;

			case 8:

				switch (idioma) {

				case SPANISH:

					textoMes = "Ago";

					break;

				case ENGLISH:

					textoMes = "Aug";

					break;

				}

				break;

			case 9:

				switch (idioma) {

				case SPANISH:
				case ENGLISH:

					textoMes = "Sep";

					break;

				}

				break;

			case 10:

				switch (idioma) {

				case SPANISH:

				case ENGLISH:

					textoMes = "Oct";

					break;

				}

				break;

			case 11:

				switch (idioma) {

				case SPANISH:
				case ENGLISH:

					textoMes = "Nov";

					break;

				}

				break;

			case 12:

				switch (idioma) {

				case SPANISH:

					textoMes = "Dic";

					break;

				case ENGLISH:

					textoMes = "Dec";

					break;

				}

				break;

			}

			mes.setText(textoMes);

		}

	}

}
