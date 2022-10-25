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

	final int width;

	final int height;

	public Color numberColor;

	private Color hourColor;

	private Color minuteColor;

	private Color secondsColor;

	private Color borderColor;

	private Color centerColor;

	private Color backgroundColor;

	private int secondX, secondY, minuteX, minuteY, hourX, hourY;

	private int hour, minute, second;

	public void setNumberColor(Color numberColor) {

		this.numberColor = numberColor;

	}

	public ClockPanel(Color backgroundColor, Color hour, Color minute, Color second, Color number, Color borderColor,
			Color centerColor, int width, int height) {

		this.backgroundColor = backgroundColor;

		this.centerColor = centerColor;

		this.borderColor = borderColor;

		this.hourColor = hour;

		this.minuteColor = minute;

		this.secondsColor = second;

		this.numberColor = number;

		this.width = width;

		this.height = height;

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

		calendar = Calendar.getInstance();

		this.second = calendar.get(Calendar.SECOND);

		this.minute = calendar.get(Calendar.MINUTE);

		this.hour = calendar.get(Calendar.HOUR);

		this.secondX = (int) ((width / 2) + sin(second) * ((width / 2) - 10));

		this.secondY = (int) ((height / 2) - cos(second) * ((height / 2) - 10));

		this.minuteX = (int) ((width / 2) + sin(minute) * ((width / 2) - 10));

		this.minuteY = (int) ((height / 2) - cos(minute) * ((height / 2) - 10));

		this.hourX = (int) ((width / 2) + Math.sin(Math.toRadians(hour * 30 + minute * 0.5)) * ((width * 90) / 360));

		this.hourY = (int) ((height / 2) - Math.cos(Math.toRadians(hour * 30 + minute * 0.5)) * ((height * 90) / 360));

		g.setColor(backgroundColor);

		g.fillOval(0, 0, width, height);

		g.setColor(borderColor);

		g.drawOval(0, 0, width, height);

		g.setColor(numberColor);

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(2));

		int x = (width / 2);

		int y = (height / 2) - 7;

		for (int i = 0; i < 60; i++) {

			int r = (width * 160) / 360;

			if (i % 5 == 0) {

				if (i % 15 == 0) {

					r = (width * 120) / 360;

				}

				else {

					r = (width * 140) / 360;

				}

			}

			int x1 = (int) (x + sin(i) * r);

			int y1 = (int) (x - cos(i) * r);

			int x2 = (int) (x + sin(i) * y);

			int y2 = (int) (x - cos(i) * y);

			g.drawLine(x1, y1, x2, y2);

		}

		g.setColor(hourColor);

		g.drawLine((width / 2), (height / 2), hourX, hourY);

		g.setColor(minuteColor);

		g.drawLine((width / 2), (height / 2), minuteX, minuteY);

		g.setColor(secondsColor);

		g.drawLine((width / 2), (height / 2), secondX, secondY);

		g.setColor(centerColor);

		g.fillOval((width / 2) - 7, (height / 2) - 5, 15, 15);

	}

	private double sin(int num) {

		return Math.sin(Math.toRadians(6 * num));

	}

	private double cos(int num) {

		return Math.cos(Math.toRadians(6 * num));

	}

	public void setHourColor(Color hourColor) {

		this.hourColor = hourColor;

	}

	public void setMinuteColor(Color minuteColor) {

		this.minuteColor = minuteColor;

	}

	public void setSecondsColor(Color secondsColor) {

		this.secondsColor = secondsColor;

	}

}
