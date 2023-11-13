
package com.company.analog;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ClockFace extends JPanel {

	private Stroke border;

	private Stroke secondHand;

	private Stroke minuteHand;

	private Stroke hourHand;

	private Stroke ticks;

	private boolean romano;

	private Color hourColor;

	private Color minuteColor;

	private Color secondColor;

	private Color fondo;

	public Color getFondo() {

		return fondo;
	}

	public void setFondo(Color fondo) {

		this.fondo = fondo;

	}

	public void setBorder(Stroke border) {

		this.border = border;

	}

	public void setSecondHand(Stroke secondHand) {

		this.secondHand = secondHand;

	}

	public void setMinuteHand(Stroke minuteHand) {

		this.minuteHand = minuteHand;

	}

	public void setHourHand(Stroke hourHand) {

		this.hourHand = hourHand;

	}

	public void setTicks(Stroke ticks) {

		this.ticks = ticks;

	}

	public void setHourColor(Color hourColor) {

		this.hourColor = hourColor;

	}

	public void setMinuteColor(Color minuteColor) {

		this.minuteColor = minuteColor;

	}

	public void setSecondColor(Color secondColor) {

		this.secondColor = secondColor;

	}

	public ClockFace() {

		setBackground(Color.WHITE);

		fondo = Color.WHITE;

		this.hourColor = Color.GRAY;

		this.minuteColor = Color.GRAY;

		this.secondColor = Color.BLACK;

		setPreferredSize(new Dimension(150, 150));

		setSize(new Dimension(150, 150));

		setOpaque(false);

		Timer timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				repaint();

			}

		});

		timer.setRepeats(true);

		timer.start();

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

		default:

			return "XII";

		}

	}

	private String getGregorianNumeral(int number) {

		return "" + number;

	}

	public boolean isRomano() {

		return romano;

	}

	public void setRomano(boolean romano) {

		this.romano = romano;

	}

	@Override

	protected void paintComponent(Graphics graphics) {

		paintFace(graphics, Math.min(getWidth(), getHeight()));

	}

	protected void paintFace(Graphics graphics, int size) {

		Point center = new Point(size / 2, size / 2);

		int radius = center.x;

		int margin = radius / 20;

		int w = size;

		border = new BasicStroke(Math.max(1f, w / 150f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		secondHand = new BasicStroke(Math.max(1f, w / 75f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		minuteHand = new BasicStroke(Math.max(1f, w / 38f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		hourHand = new BasicStroke(Math.max(1.5f, w / 20f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		ticks = new BasicStroke(1f);

		Graphics2D g = (Graphics2D) graphics.create();

		g.setColor(fondo);

		g.fillRect(0, 0, getWidth(), getHeight());

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		Color bg = getBackground();

		g.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue()));

		g.fill(new Ellipse2D.Float(0, 0, size, size));

		Font font = getFont();

		g.setFont(font.deriveFont(Font.PLAIN, size / 12));

		g.setStroke(border);

		g.draw(new Ellipse2D.Float(0, 0, size - 1, size - 1));

		g.draw(new Ellipse2D.Float(margin, margin, size - margin * 2 - 1, size - margin * 2 - 1));

		Calendar c = Calendar.getInstance();

		int minute = c.get(Calendar.MINUTE);

		int hour = c.get(Calendar.HOUR);

		int second = c.get(Calendar.SECOND);

		g.translate(center.x, center.y);

		g.setColor(getForeground());

		int numbers = radius * 3 / 4;

		for (int i = 0; i < 12; i++) {

			double theta = Math.PI * 2 * i / 12;

			String str = getRomanNumeral((i + 2) % 12 + 1);

			if (romano)

				str = getRomanNumeral((i + 2) % 12 + 1);

			else

				str = getGregorianNumeral((i + 2) % 12 + 1);

			Rectangle2D rect = g.getFontMetrics().getStringBounds(str, g);

			g.drawString(str, Math.round(numbers * Math.cos(theta) - rect.getWidth() / 2),

					Math.round(numbers * Math.sin(theta) + margin * 2));

		}

		for (int i = 0; i < 60; i++) {

			g.setColor(getForeground());

			g.setStroke(ticks);

			g.drawLine(radius - margin * 2, 0, radius - margin, 0);

			if ((i % 5) == 0) {

				g.drawLine(radius - margin * 3, 0, radius - margin, 0);

			}

			if ((i + 15) % 60 == minute) {

				g.setColor(minuteColor);

				g.setStroke(minuteHand);

				g.drawLine(0, 0, radius - margin * 4, 0);

			}

			if ((i + 15) % 60 == (hour * 5 + minute * 5 / 60)) {

				g.setColor(hourColor);

				g.setStroke(hourHand);

				g.drawLine(0, 0, radius / 2, 0);

			}

			if ((i + 15) % 60 == second) {

				g.setColor(secondColor);

				g.setStroke(secondHand);

				g.drawLine(0, 0, radius - margin * 4, 0);

			}

			g.rotate(Math.PI * 2 / 60);

		}

		g.dispose();

	}

}
