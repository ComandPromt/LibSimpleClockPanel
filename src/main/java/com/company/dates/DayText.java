package com.company.dates;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DayText extends JLabel {

	private Color dia;

	private Color colorPoligono;

	private Font fuente;

	private Calendar now;

	private String textDia;

	private String mes;

	private Color rellenoDeBola;

	private Color bordeDeBola;

	private Color colorDeLinea;

	private Thread thread;

	private boolean start;

	private boolean english;

	private int grosor;

	public int getGrosor() {

		return grosor;

	}

	public void setGrosor(int grosor) {

		this.grosor = grosor;

	}

	public Color getColorPoligono() {

		return colorPoligono;

	}

	public void setColorPoligono(Color colorPoligono) {

		this.colorPoligono = colorPoligono;

	}

	public Color getColorDeLinea() {

		return colorDeLinea;

	}

	public void setColorDeLinea(Color colorDeLinea) {

		this.colorDeLinea = colorDeLinea;

	}

	public Color getBordeDeBola() {

		return bordeDeBola;

	}

	public void setBordeDeBola(Color bordeDeBola) {

		this.bordeDeBola = bordeDeBola;

	}

	public Color getRellenoDeBola() {

		return rellenoDeBola;

	}

	public void setRellenoDeBola(Color rellenoDeBola) {

		this.rellenoDeBola = rellenoDeBola;

	}

	public boolean isEnglish() {

		return english;

	}

	public void setEnglish(boolean english) {

		this.english = english;

	}

	public void setStart(boolean start) {

		this.start = start;

	}

	public DayText() {

		grosor = 3;

		colorDeLinea = Color.BLACK;

		colorPoligono = Color.WHITE;

		rellenoDeBola = Color.WHITE;

		bordeDeBola = Color.BLACK;

		start = true;

		textDia = "";

		fuente = new Font("Dialog", Font.PLAIN, 20);

		setFont(fuente);

		dia = Color.BLACK;

		setBackground(Color.WHITE);

		init();

	}

	private void sleep() {

		try {

			Thread.sleep(500);

		}

		catch (Exception e) {

		}

	}

	private void init() {

		thread = new Thread(new Runnable() {

			public void run() {

				while (start) {

					now = Calendar.getInstance();

					textDia = "" + now.get(Calendar.DAY_OF_MONTH);

					if (Integer.parseInt(textDia) < 10) {

						textDia = "0" + textDia;

					}

					mes = "" + (now.get(Calendar.MONTH) + 1);

					switch (Integer.parseInt(mes)) {

					case 1:

						if (english) {

							mes = "JANUARY";

						}

						else {

							mes = "ENERO";

						}

						break;

					case 2:

						if (english) {

							mes = "FEBRUARY";

						}

						else {

							mes = "FEBRERO";

						}

						break;

					case 3:

						if (english) {

							mes = "MARCH";

						}

						else {

							mes = "MARZO";

						}

						break;

					case 4:

						if (english) {

							mes = "APRIL";

						}

						else {

							mes = "ABRIL";

						}

						break;

					case 5:

						if (english) {

							mes = "MAY";

						}

						else {

							mes = "MAYO";

						}

						break;

					case 6:

						if (english) {

							mes = "JUNE";

						}

						else {

							mes = "JUNIO";

						}

						break;

					case 7:

						if (english) {

							mes = "JULY";

						}

						else {

							mes = "JULIO";

						}

						break;

					case 8:

						if (english) {

							mes = "AUGUST";

						}

						else {

							mes = "AGOSTO";

						}

						break;

					case 9:

						if (english) {

							mes = "SEPTEMBER";

						}

						else {

							mes = "SEPTIEMBRE";

						}

						break;

					case 10:

						if (english) {

							mes = "OCTOBER";

						}

						else {

							mes = "OCTUBRE";

						}

						break;

					case 11:

						if (english) {

							mes = "NOVEMBER";

						}

						else {

							mes = "NOVIEMBRE";

						}

						break;

					default:

						if (english) {

							mes = "DECEMBER";

						}

						else {

							mes = "DICIEMBRE";

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

	@Override
	public void setFont(Font font) {

		super.setFont(font);

		getFont().deriveFont(Font.PLAIN, 20);

	}

	public void setDia(Color dia) {

		this.dia = dia;

		repaint();

	}

	@Override
	public void paint(Graphics g) {

		float uno = 0.1428571429f;

		float dos = 0.1666f;

		float tres = 0.25f;

		float pico = 0.375f;

		g.setColor(getBackground());

		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(rellenoDeBola);

		g.fillOval(1, 1, Math.round(getWidth() * dos), Math.round(getHeight() * 0.2857142857f));

		g.setColor(bordeDeBola);

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(grosor));

		g.drawOval(1, 1, Math.round(getWidth() * dos), Math.round(getHeight() * 0.2857142857f));

		int[] puntosX = { Math.round(getWidth() * tres), Math.round(getWidth() * 0.5f), Math.round(getWidth() * 0.5f),
				Math.round(getWidth() * pico), Math.round(getWidth() * tres) };

		int[] puntosY = { Math.round(getHeight() * uno),

				Math.round(getHeight() * uno), Math.round(getHeight() * 0.7142857143f), Math.round(getHeight() * 0.5f),
				Math.round(getHeight() * 0.7142857143f) };

		g.setColor(colorPoligono);

		g2.fillPolygon(puntosX, puntosY, 5);

		g.setColor(colorDeLinea);

		g.drawLine(Math.round(getWidth() * dos), Math.round(getHeight() * uno), getWidth(),
				Math.round(getHeight() * uno));

		g.setColor(dia);

		g.setFont(getFont());

		g.drawString(textDia, Math.round(getWidth() * 0.335f), Math.round(getHeight() * 0.35714f));

		g.setColor(getForeground());

		g.drawString(mes, Math.round(getWidth() * 0.54166f), Math.round(getHeight() * 0.35714f));

	}

}
