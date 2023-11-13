package com.company.dates;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Calendar;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DiaAgenda extends JLabel {

	private int grosor;

	private Thread thread;

	private String textoMes;

	private boolean start;

	private String textDia;

	private Calendar now;

	private boolean english;

	private Color dia;

	private Color mes;

	private float margen;

	private String diaSemana;

	private Font fuente;

	public Color getMes() {

		return mes;

	}

	public void setMes(Color mes) {

		this.mes = mes;

	}

	@Override
	public void setFont(Font font) {

		super.setFont(font);

		getFont().deriveFont(Font.PLAIN, 20);

	}

	private void sleep() {

		try {

			Thread.sleep(500);

		}

		catch (Exception e) {

		}

	}

	public void setDia(Color dia) {

		this.dia = dia;

		repaint();

	}

	private void init() {

		thread = new Thread(new Runnable() {

			public void run() {

				while (start) {

					now = Calendar.getInstance();

					textDia = "" + now.get(Calendar.DAY_OF_MONTH);

					diaSemana = "" + now.get(Calendar.DAY_OF_WEEK);

					if (Integer.parseInt(textDia) < 10) {

						textDia = "0" + textDia;

					}

					textoMes = "" + (now.get(Calendar.MONTH) + 1);

					switch (Integer.parseInt(textoMes)) {

					case 1:

						if (english) {

							textoMes = "JAN";

						}

						else {

							textoMes = "ENE";

						}

						break;

					case 2:

						textoMes = "FEB";

						break;

					case 3:

						textoMes = "MAR";

						break;

					case 4:

						if (english) {

							textoMes = "APR";

						}

						else {

							textoMes = "ABR";

						}

						break;

					case 5:

						textoMes = "MAY";

						break;

					case 6:

						textoMes = "JUN";

						break;

					case 7:

						textoMes = "JUL";

						break;

					case 8:

						if (english) {

							textoMes = "AUG";

						}

						else {

							textoMes = "AGO";

						}

						break;

					case 9:

						textoMes = "SEPT";

						break;

					case 10:

						textoMes = "OCT";

						break;

					case 11:

						textoMes = "NOV";

						break;

					default:

						if (english) {

							textoMes = "DEC";

						}

						else {

							textoMes = "DIC";

						}

						break;

					}

					switch (Integer.parseInt(diaSemana)) {

					case 1:

						if (english) {

							margen = 0.23f;

							diaSemana = "SUNDAY";

						}

						else {

							margen = 0.15f;

							diaSemana = "DOMINGO";

						}

						break;

					case 2:

						if (english) {

							margen = 0.2f;

							diaSemana = "MONDAY";

						}

						else {

							margen = 0.28f;

							diaSemana = "LUNES";

						}

						break;

					case 3:

						if (english) {

							margen = 0.18f;

							diaSemana = "TUESDAY";

						}

						else {

							margen = 0.23f;

							diaSemana = "MARTES";

						}

						break;

					case 4:

						if (english) {

							margen = 0.05f;

							diaSemana = "WEDNESDAY";

						}

						else {

							margen = 0.1f;

							diaSemana = "MIÉRCOLES";

						}

						break;

					case 5:

						if (english) {

							margen = 0.12f;

							diaSemana = "THURSDAY";

						}

						else {

							margen = 0.25f;

							diaSemana = "JUEVES";

						}

						break;

					case 6:

						if (english) {

							margen = 0.27f;

							diaSemana = "FRIDAY";

						}

						else {

							margen = 0.21f;

							diaSemana = "VIERNES";

						}

						break;

					default:

						if (english) {

							margen = 0.13f;

							diaSemana = "SATURDAY";

						}

						else {

							margen = 0.22f;

							diaSemana = "SÁBADO";

						}

						break;

					}

					repaint();

					sleep();

				}

			}

		});

		thread.start();

	}

	public Color getDia() {

		return dia;

	}

	public DiaAgenda() {

		setBackground(Color.WHITE);

		grosor = 1;

		start = true;

		textDia = "";

		dia = Color.BLACK;

		mes = Color.BLACK;

		textoMes = "";

		init();

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				setSize(145, 160);

			}

		});

		setSize(145, 160);

		fuente = new Font("Dialog", Font.PLAIN, 20);

		setFont(fuente);

	}

	@Override
	public void paint(Graphics g) {

		setSize(145, 160);

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(grosor));

		int sumar = Math.round(getWidth() * 0.26f);

		int placeholder = Math.round(getWidth() * 0.125f);

		g2.setStroke(new BasicStroke(grosor));

		g.setColor(getBackground());

		g.fillRect(0, Math.round(getHeight() * 0.1f), getWidth() - 1, getHeight());

		g.setColor(Color.BLACK);

		g.drawArc(placeholder, 3, 40, sumar, 0, 180);

		g.drawArc(placeholder + sumar * 2, 3, 40, sumar, 0, 180);

		g.drawRect(0, Math.round(getHeight() * 0.1f), getWidth() - 1, getHeight() - 17);

		g.drawLine(0, Math.round(getHeight() * 0.5f), getWidth() - 1, Math.round(getHeight() * 0.5f));

		g.setFont(fuente);

		g.setColor(mes);

		g.drawString(textoMes, Math.round(getWidth() * 0.125f), Math.round(getHeight() * 0.35f));

		g.setColor(dia);

		g.drawString(textDia, Math.round(getWidth() * 0.7f), Math.round(getHeight() * 0.35f));

		g.setColor(getForeground());

		g.drawString(diaSemana, Math.round(getWidth() * margen), Math.round(getHeight() * 0.8f));

	}

}
