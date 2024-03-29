package com.company.analog;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SimpleClock extends JPanel {

	private Calendar calendar;

	private int x0 = 0;

	private int y0 = 0;

	private Timer timer;

	final int width;

	final int height;

	private Color numberColor;

	private Color hourColor;

	private Color minuteColor;

	private Color secondsColor;

	private Color circleColor;

	private int textSize;

	private float resize;

	private boolean romano;

	public void setNumberColor(Color numberColor) {

		this.numberColor = numberColor;

	}

	public void setRomano(boolean romano) {

		this.romano = romano;

	}

	public void setTextSize(int textSize) {

		this.textSize = textSize;

	}

	public SimpleClock() {

		this(2f);

	}

	public SimpleClock(float resize) {

		this.resize = resize;

		this.textSize = 14;

		this.hourColor = Color.BLACK;

		this.minuteColor = Color.BLACK;

		this.secondsColor = Color.BLACK;

		this.circleColor = Color.WHITE;

		this.numberColor = Color.BLACK;

		this.width = 100;

		this.height = 100;

		timer = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				repaint();

			}

		});

		timer.start();

	}

	public void setCircleColor(Color circleColor) {

		this.circleColor = circleColor;

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

	private String getRomanNumeral(int number) {

		switch (number) {

		case 1:
			return "I";

		case 2:
			return "II";

		case 3:
			return "III";

		case 4:
			return "IV";

		case 5:
			return "V";

		case 6:
			return "VI";

		case 7:
			return "VII";

		case 8:
			return "VIII";

		case 9:
			return "IX";

		case 10:
			return "X";

		case 11:
			return "XI";

		case 12:

		default:
			return "XII";

		}

	}

	@Override
	public void update(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.translate(5, 5);

		g2.scale(this.resize, this.resize);

		calendar = Calendar.getInstance();

		int hour = calendar.get(Calendar.HOUR);

		int minute = calendar.get(Calendar.MINUTE);

		int second = calendar.get(Calendar.SECOND);

		g.setColor(circleColor);

		g.fillOval(0, 0, width, height);

		int w = width;

		int h = height;

		int resto = 0;

		int wUno = 0;

		resto = textSize / 6;

		if (resto >= 4) {

			resto = (resto - 1) * 2;

		}

		g.setFont(new Font("Tahoma", Font.PLAIN, textSize));

		g.setColor(numberColor);

		String str;

		for (int i = 1; i <= 12; i++) {

			str = "" + i;

			if (romano) {

				str = getRomanNumeral(i);

			}

			switch (i) {

			case 1:

				wUno = w / 5;

				g.drawString(str, ((w / 2) + wUno) - 3, textSize + w / 15);

				break;

			case 2:
				g.drawString(str, (w / 2) + wUno + 10, textSize + wUno);

				break;

			case 3:

				g.drawString(str, w - 15, ((h / 2) + resto) + 4);

				break;

			case 4:

				g.drawString(str, w - 20, ((h / 2) + resto) + 25);

				break;

			case 5:

				g.drawString(str, ((w / 2) - resto) + 18, h - 10);

				break;

			case 6:

				g.drawString(str, ((w / 2) - resto) - 2, h - 5);

				break;

			case 7:

				g.drawString(str, ((w / 2) - resto) - 21, h - 10);

				break;

			case 8:

				g.drawString(str, ((w / 2) - resto) - 38, h - 23);

				break;

			case 9:

				g.drawString(str, 5, ((h / 2) + resto) + 4);

				break;

			case 10:

				g.drawString(str, ((w / 2) - (resto + (textSize / 6 + 2))) - 37, textSize + 22);

				break;

			case 11:

				g.drawString(str, ((w / 2) - (resto + (textSize / 6 + 2))) - 23, textSize + 7);

				break;

			case 12:

				g.drawString(str, ((w / 2) - (resto + (textSize / 6 + 2))) - 2, textSize);

				break;

			}

		}

		g.setColor(hourColor);

		drawLine(g, (hour + minute / 60.0) * 360 / 12 * Math.PI / 180, ((this.width / 2) - 20));

		g.setColor(minuteColor);

		drawLine(g, (minute + second / 60.0) * 360 / 60 * Math.PI / 180, ((this.width / 2) - 10));

		g.setColor(secondsColor);

		drawLine(g, second * 360 / 60 * Math.PI / 180, ((this.width / 2) - 5));

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

	public void drawLine(Graphics g, double radians, int length) {

		int x1 = (int) (x0 + length * Math.sin(radians));

		int y1 = (int) (y0 - length * Math.cos(radians));

		Graphics2D thick = (Graphics2D) g;

		if (length == ((this.width / 2) - 5)) {

			thick.setStroke(new BasicStroke(1));

		}

		else {

			thick.setStroke(new BasicStroke(2));

		}

		x0 = this.width / 2;

		y0 = this.height / 2;

		thick.draw(new Line2D.Float(x0, y0, x1, y1));

	}

}
