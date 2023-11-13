package com.company.dates;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FechaDia extends JLabel {

	private boolean mes;

	private String month;

	private String diaSemana;

	private String texto;

	private float margen;

	private boolean english;

	private int grosor;

	private Thread thread;

	private String textDia;

	private boolean start;

	private Calendar now;

	private Font fuente;

	private Color borde;

	private Color circulo;

	private Color bordeCirculo;

	public Color getBordeCirculo() {

		return bordeCirculo;

	}

	public void setBordeCirculo(Color bordeCirculo) {

		this.bordeCirculo = bordeCirculo;

	}

	public void setStart(boolean start) {

		this.start = start;

	}

	public boolean isMes() {

		return mes;

	}

	public void setMes(boolean mes) {

		this.mes = mes;

	}

	public boolean isEnglish() {

		return english;

	}

	public void setEnglish(boolean english) {

		this.english = english;

	}

	public int getGrosor() {

		return grosor;

	}

	public void setGrosor(int grosor) {

		this.grosor = grosor;

	}

	public FechaDia() {

		this(false, false);

	}

	public FechaDia(boolean mes, boolean english) {

		setBackground(new Color(220, 220, 220));

		bordeCirculo = Color.BLACK;

		borde = Color.GRAY;

		circulo = new Color(255, 204, 245);

		texto = "";

		textDia = "";

		start = true;

		fuente = new Font("Dialog", Font.PLAIN, 20);

		grosor = 3;

		this.mes = mes;

		this.english = english;

		setFont(fuente);

		setSize(200, 75);

		init();

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

					month = "" + (now.get(Calendar.MONTH) + 1);

					if (mes) {

						switch (Integer.parseInt(month)) {

						case 1:

							if (english) {

								margen = 0.33f;

								month = "JANUARY";

							}

							else {

								margen = 0.38f;

								month = "ENERO";

							}

							break;

						case 2:

							if (english) {

								margen = 0.29f;

								month = "FEBRUARY";

							}

							else {

								margen = 0.32f;

								month = "FEBRERO";

							}

							break;

						case 3:

							margen = 0.36f;

							if (english) {

								month = "MARCH";

							}

							else {

								month = "MARZO";

							}

							break;

						case 4:

							margen = 0.4f;

							if (english) {

								month = "APRIL";

							}

							else {

								month = "ABRIL";

							}

							break;

						case 5:

							if (english) {

								margen = 0.45f;

								month = "MAY";

							}

							else {

								margen = 0.4f;

								month = "MAYO";

							}

							break;

						case 6:

							if (english) {

								margen = 0.43f;

								month = "JUNE";

							}

							else {

								margen = 0.4f;

								month = "JUNIO";

							}

							break;

						case 7:

							if (english) {

								margen = 0.45f;

								month = "JULY";

							}

							else {

								margen = 0.43f;

								month = "JULIO";

							}

							break;

						case 8:

							if (english) {

								margen = 0.35f;

								month = "AUGUST";

							}

							else {

								margen = 0.34f;

								month = "AGOSTO";

							}

							break;

						case 9:

							if (english) {

								margen = 0.26f;

								month = "SEPTEMBER";

							}

							else {

								margen = 0.25f;

								month = "SEPTIEMBRE";

							}

							break;

						case 10:

							margen = 0.32f;

							if (english) {

								month = "OCTOBER";

							}

							else {

								month = "OCTUBRE";

							}

							break;

						case 11:

							if (english) {

								margen = 0.27f;

								month = "NOVEMBER";

							}

							else {

								margen = 0.25f;

								month = "NOVIEMBRE";

							}

							break;

						default:

							margen = 0.28f;

							if (english) {

								month = "DECEMBER";

							}

							else {

								month = "DICIEMBRE";

							}

							break;

						}

						texto = month;

					}

					else {

						switch (Integer.parseInt(diaSemana)) {

						case 1:

							if (english) {

								margen = 0.33f;

								diaSemana = "SUNDAY";

							}

							else {

								margen = 0.3f;

								diaSemana = "DOMINGO";

							}

							break;

						case 2:

							if (english) {

								margen = 0.33f;

								diaSemana = "MONDAY";

							}

							else {

								margen = 0.37f;

								diaSemana = "LUNES";

							}

							break;

						case 3:

							if (english) {

								margen = 0.33f;

								diaSemana = "TUESDAY";

							}

							else {

								margen = 0.35f;

								diaSemana = "MARTES";

							}

							break;

						case 4:

							if (english) {

								margen = 0.235f;

								diaSemana = "WEDNESDAY";

							}

							else {

								margen = 0.27f;

								diaSemana = "MIÉRCOLES";

							}

							break;

						case 5:

							if (english) {

								margen = 0.29f;

								diaSemana = "THURSDAY";

							}

							else {

								margen = 0.37f;

								diaSemana = "JUEVES";

							}

							break;

						case 6:

							if (english) {

								margen = 0.37f;

								diaSemana = "FRIDAY";

							}

							else {

								margen = 0.34f;

								diaSemana = "VIERNES";

							}

							break;

						default:

							if (english) {

								margen = 0.29f;

								diaSemana = "SATURDAY";

							}

							else {

								margen = 0.35f;

								diaSemana = "SÁBADO";

							}

							break;

						}

						texto = diaSemana;

					}

					repaint();

					sleep();

				}

			}

		});

		thread.start();

	}

	public Color getBorde() {

		return borde;

	}

	public void setBorde(Color borde) {

		this.borde = borde;

	}

	public Color getCirculo() {

		return circulo;

	}

	public void setCirculo(Color circulo) {

		this.circulo = circulo;

	}

	@Override
	public void paint(Graphics g) {

		setSize(200, 75);

		float uno = 0.09f;

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(grosor));

		g.setColor(getBackground());

		g.fillRect(Math.round(getWidth() * uno), 0, Math.round(getWidth() * 0.8571428571f), getHeight() - 1);

		g.setColor(borde);

		g.drawRect(Math.round(getWidth() * uno), 0, Math.round(getWidth() * 0.8571428571f), getHeight() - 1);

		g.setColor(circulo);

		g.fillOval(0, Math.round(getHeight() * 0.25f), Math.round(getHeight() * 0.5f), Math.round(getHeight() * 0.5f));

		g.setColor(bordeCirculo);

		g.drawOval(0, Math.round(getHeight() * 0.25f), Math.round(getHeight() * 0.5f), Math.round(getHeight() * 0.5f));

		g.setFont(getFont());

		g.setColor(getForeground());

		g.drawString(textDia, Math.round(getWidth() * 0.035f), Math.round(getHeight() * 0.6f));

		g.drawString(texto, Math.round(getWidth() * margen), Math.round(getHeight() * 0.6f));

	}

}
