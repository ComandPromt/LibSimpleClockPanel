package com.company.analog;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")

public class ClockPanel extends JPanel {

	private Calendar calendar;

	private Timer timer;

	private int width;

	private int height;

	private int ancho;

	private int alto;

	private int thickness;

	private Color numberColor;

	private Color hourColor;

	private Color minuteColor;

	private Color secondsColor;

	private Color borderColor;

	private boolean square;

	private Color centerColor;

	private Color backgroundColor;

	private Color fondo;

	private int secondX, secondY, minuteX, minuteY, hourX, hourY;

	private int hour, minute, second;

	public void setThickness(int thickness) {

		if (thickness < 1) {

			thickness = 1;

		}

		this.thickness = thickness;

	}

	public void setBorderColor(Color borderColor) {

		if (borderColor == null) {

			borderColor = Color.BLACK;

		}

		this.borderColor = borderColor;

	}

	@Override
	public void setBackground(Color bg) {

		if (bg == null) {

			bg = new Color(253, 77, 82);

		}

		fondo = bg;

	}

	public void setSquare(boolean square) {

		this.square = square;

	}

	public void setNumberColor(Color numberColor) {

		if (numberColor == null) {

			numberColor = Color.WHITE;

		}

		this.numberColor = numberColor;

	}

	public void setCenterColor(Color centerColor) {

		if (centerColor == null) {

			centerColor = Color.WHITE;

		}

		this.centerColor = centerColor;

	}

	@Override
	public void setForeground(Color fg) {

		if (fg == null) {

			fg = new Color(253, 77, 82);

		}

		this.backgroundColor = fg;

	}

	public ClockPanel() {

		this.backgroundColor = new Color(253, 77, 82);

		fondo = backgroundColor;

		this.centerColor = Color.WHITE;

		this.borderColor = Color.BLACK;

		this.hourColor = Color.BLACK;

		this.minuteColor = Color.BLACK;

		this.secondsColor = Color.BLACK;

		this.numberColor = Color.WHITE;

		width = 0;

		timer = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				repaint();

			}

		});

		timer.start();

	}

	@Override

	public Dimension getPreferredSize() {

		return new Dimension(this.width, this.height);

	}

	@Override

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		update(g);

	}

	@Override
	public void update(Graphics g) {

		width = getWidth();

		height = getHeight();

		if (width < height) {

			height = width;

		}

		if (height < width) {

			width = height;

		}

		setSize(width, height);

		if (ancho == 0) {

			ancho = width - 10;

			alto = height - 10;

		}

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(thickness));

		g2.setColor(fondo);

		g2.fillRect(0, 0, width, height);

		if (square) {

			g2.setColor(backgroundColor);

			g2.fillRect(5, 5, ancho, alto);

		}

		else {

			if (thickness > 1) {

				g2.setColor(borderColor);

				g2.drawOval(5, 5, ancho, alto);

			}

			g2.setColor(backgroundColor);

			g2.fillOval(5, 5, ancho, alto);

		}

		calendar = Calendar.getInstance();

		this.second = calendar.get(Calendar.SECOND);

		this.minute = calendar.get(Calendar.MINUTE);

		this.hour = calendar.get(Calendar.HOUR);

		this.secondX = (int) ((ancho / 2) + sin(second) * ((ancho / 2) - 10));

		this.secondY = (int) ((alto / 2) - cos(second) * ((alto / 2) - 10));

		this.minuteX = (int) ((ancho / 2) + sin(minute) * ((ancho / 2) - 10));

		this.minuteY = (int) ((alto / 2) - cos(minute) * ((alto / 2) - 10));

		this.hourX = (int) ((ancho / 2) + Math.sin(Math.toRadians(hour * 30 + minute * 0.5)) * ((ancho * 90) / 360));

		this.hourY = (int) ((alto / 2) - Math.cos(Math.toRadians(hour * 30 + minute * 0.5)) * ((alto * 90) / 360));

		g2.setColor(numberColor);

		int x = (ancho / 2);

		int y = (alto / 2) - 7;

		int x1;

		int y1;

		int x2;

		int y2;

		for (int i = 0; i < 60; i++) {

			int r = (ancho * 160) / 360;

			if (i % 5 == 0) {

				if (i % 15 == 0) {

					r = (ancho * 120) / 360;

				}

				else {

					r = (ancho * 140) / 360;

				}

			}

			x1 = (int) (x + sin(i) * r) + 5;

			y1 = (int) (x - cos(i) * r) + 5;

			x2 = (int) (x + sin(i) * y) + 5;

			y2 = (int) (x - cos(i) * y) + 5;

			g2.drawLine(x1, y1, x2, y2);

		}

		g2.setColor(hourColor);

		g2.drawLine((ancho / 2) + 5, (alto / 2) + 5, hourX + 5, hourY + 5);

		g2.setColor(minuteColor);

		g2.drawLine((ancho / 2) + 5, (alto / 2) + 5, minuteX + 5, minuteY + 5);

		g2.setColor(secondsColor);

		g2.drawLine((ancho / 2) + 5, (alto / 2) + 5, secondX + 5, secondY + 5);

		g2.setColor(centerColor);

		g2.fillOval((ancho / 2) - 2, (alto / 2), 15, 15);

	}

	private double sin(int num) {

		return Math.sin(Math.toRadians(6 * num));

	}

	private double cos(int num) {

		return Math.cos(Math.toRadians(6 * num));

	}

	public void setHourColor(Color hourColor) {

		if (hourColor == null) {

			hourColor = Color.BLACK;

		}

		this.hourColor = hourColor;

	}

	public void setMinuteColor(Color minuteColor) {

		if (minuteColor == null) {

			minuteColor = Color.BLACK;

		}

		this.minuteColor = minuteColor;

	}

	public void setSecondsColor(Color secondsColor) {

		if (secondsColor == null) {

			secondsColor = Color.BLACK;

		}

		this.secondsColor = secondsColor;

	}

}
