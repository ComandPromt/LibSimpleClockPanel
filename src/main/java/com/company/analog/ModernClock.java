package com.company.analog;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComponent;

import shadow.ShadowRenderer;

@SuppressWarnings("serial")
public class ModernClock extends JComponent {

	private BufferedImage background;

	private ModelTime time = new ModelTime();

	private Thread thread;

	private boolean start = true;

	private Color hourColor1;

	private Color hourColor2;

	private Color minuteColor1;

	private Color minuteColor2;

	private Color secondColor;

	private Color centerColor;

	private Color lineMinute1;

	private Color lineMinute2;

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	public void setTime(ModelTime time) {
		this.time = time;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public void setHourColor1(Color hourColor1) {
		this.hourColor1 = hourColor1;
	}

	public void setHourColor2(Color hourColor2) {
		this.hourColor2 = hourColor2;
	}

	public void setMinuteColor1(Color minuteColor1) {
		this.minuteColor1 = minuteColor1;
	}

	public void setMinuteColor2(Color minuteColor2) {
		this.minuteColor2 = minuteColor2;
	}

	public void setSecondColor(Color secondColor) {
		this.secondColor = secondColor;
	}

	public void setCenterColor(Color centerColor) {
		this.centerColor = centerColor;
	}

	public void setLineMinute1(Color lineMinute1) {
		this.lineMinute1 = lineMinute1;
	}

	public void setLineMinute2(Color lineMinute2) {
		this.lineMinute2 = lineMinute2;
	}

	public ModernClock() {

		this.hourColor1 = Color.MAGENTA;

		this.hourColor2 = Color.BLACK;

		this.minuteColor1 = Color.MAGENTA;

		this.minuteColor2 = Color.BLACK;

		this.secondColor = Color.ORANGE;

		this.centerColor = Color.BLUE;

		this.lineMinute1 = Color.RED;

		this.lineMinute2 = Color.BLACK;

		initTime();

		init();

		setBackground(Color.WHITE);

	}

	private void init() {

		thread = new Thread(new Runnable() {

			public void run() {

				while (start) {

					initTime();

					repaint();

					sleep();

				}

			}

		});

		thread.start();

	}

	private void initTime() {

		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");

		String t = df.format(new Date());

		time.setHour(Integer.valueOf(t.split(":")[0]));

		time.setMinute(Integer.valueOf(t.split(":")[1]));

		time.setSeconds(Integer.valueOf(t.split(":")[2]));

	}

	private void sleep() {

		try {

			Thread.sleep(500);

		}

		catch (Exception e) {

		}

	}

	@Override
	public void paint(Graphics grphcs) {

		Graphics2D g2 = (Graphics2D) grphcs;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = getWidth();

		int height = getHeight();

		int size = Math.min(width, height);

		int x = (width - size) / 2;

		int y = (height - size) / 2;

		int centerX = width / 2;

		int centerY = height / 2;

		g2.drawImage(background, x, y, null);

		drawMinute(g2, centerX, centerY, size / 2);

		drawHour(g2, centerX, centerY, size / 2 - 14);

		drawSeconds(g2, centerX, centerY, size / 2);

		int centerSize = 10;

		g2.setColor(centerColor);

		g2.fillOval(centerX - centerSize / 2, centerY - centerSize / 2, centerSize, centerSize);

		g2.dispose();

	}

	private void createBackground() {

		int width = getWidth();

		int height = getHeight();

		int size = Math.min(width, height);

		int shadowSize = 10;

		background = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = background.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(createCircle(size, shadowSize), 0, 0, null);

		int s = size / 2;

		g2.drawImage(createCircle(s, 6), s / 2, s / 2, null);

		drawPoint(g2, size, size);

		g2.dispose();

	}

	private void drawPoint(Graphics2D g2, int width, int height) {

		int centerX = width / 2;

		int centerY = height / 2;

		float angle = 90;

		int space = 360 / 12;

		for (int i = 1; i <= 12; i++) {

			int r = width / 2;

			int s;

			if (i % 3 == 0) {

				g2.setColor(lineMinute1);

				g2.setStroke(new BasicStroke(2f));

				s = 25;

			}

			else {

				g2.setColor(lineMinute2);

				g2.setStroke(new BasicStroke(1f));

				s = 20;

			}

			Point locationStart = getLocationOf(angle - (space * i), r - s);

			Point locationEnd = getLocationOf(angle - (space * i), r - 15);

			g2.drawLine(centerX + locationStart.x, centerY - locationStart.y, centerX + locationEnd.x,
					centerY - locationEnd.y);

		}

	}

	private void drawSeconds(Graphics2D g2, int centerX, int centerY, int size) {

		float angle = (360 / -60 * time.getSeconds()) + 90;

		Point point = getLocationOf(angle, size - 18);

		Point pointStart = getLocationOf(angle + 180, 20);

		g2.setColor(secondColor);

		g2.drawLine(centerX, centerY, centerX + point.x, centerY - point.y);

		g2.drawLine(centerX, centerY, centerX + pointStart.x, centerY - pointStart.y);

		g2.fillOval(centerX + pointStart.x - 2, centerY - pointStart.y - 2, 5, 5);

	}

	private void drawHour(Graphics2D g, int centerX, int centerY, int size) {

		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = img.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		float angle = (360 / -12 * time.getHour()) + 90;

		double t = 30 * ((time.getMinute() * 100 / 60) / 100f);

		angle -= t;

		float angleLeft = angle + 90;

		float angleRight = angle - 90;

		float angleCircle = angle + 180;

		Point point = getLocationOf(angle, size - 35);

		Point pointLeft = getLocationOf(angleLeft, 7);

		Point pointRight = getLocationOf(angleRight, 7);

		Point pointCircle = getLocationOf(angleCircle, 15);

		g2.setColor(hourColor2);

		Path2D.Float p = new Path2D.Float();

		p.moveTo(centerX + pointLeft.x, centerY - pointLeft.y);

		p.lineTo(centerX + point.x, centerY - point.y);

		p.lineTo(centerX + pointRight.x, centerY - pointRight.y);

		p.curveTo(centerX + pointRight.x, centerY - pointRight.y, centerX + pointCircle.x, centerY - pointCircle.y,
				centerX + pointLeft.x, centerY - pointLeft.y);

		g2.fill(p);

		g2.setComposite(AlphaComposite.SrcAtop);

		g2.setColor(hourColor1);

		g2.fillOval(centerX - size / 2, centerY - size / 2, size, size);

		g.drawImage(new ShadowRenderer(5, 0.3f, hourColor2).createShadow(img), -4, -4, null);

		g.drawImage(img, 0, 0, null);

		g2.dispose();

	}

	private void drawMinute(Graphics2D g, int centerX, int centerY, int size) {

		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = img.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		float angle = (360 / -60 * time.getMinute()) + 90;

		float angleLeft = angle + 90;

		float angleRight = angle - 90;

		float angleCircle = angle + 180;

		Point point = getLocationOf(angle, size - 35);

		Point pointLeft = getLocationOf(angleLeft, 7);

		Point pointRight = getLocationOf(angleRight, 7);

		Point pointCircle = getLocationOf(angleCircle, 15);

		g2.setColor(minuteColor2);

		Path2D.Float p = new Path2D.Float();

		p.moveTo(centerX + pointLeft.x, centerY - pointLeft.y);

		p.lineTo(centerX + point.x, centerY - point.y);

		p.lineTo(centerX + pointRight.x, centerY - pointRight.y);

		p.curveTo(centerX + pointRight.x, centerY - pointRight.y, centerX + pointCircle.x, centerY - pointCircle.y,
				centerX + pointLeft.x, centerY - pointLeft.y);

		g2.fill(p);

		g2.setComposite(AlphaComposite.SrcAtop);

		g2.setColor(minuteColor1);

		g2.fillOval(centerX - size / 2, centerY - size / 2, size, size);

		g.drawImage(new ShadowRenderer(5, 0.3f, Color.BLACK).createShadow(img), -4, -4, null);

		g.drawImage(img, 0, 0, null);

		g2.dispose();

	}

	private BufferedImage createCircle(int size, int shadowSize) {

		BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = img.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(getBackground());

		g2.fillOval(shadowSize, shadowSize, size - shadowSize * 2, size - shadowSize * 2);

		g2.drawImage(new ShadowRenderer(shadowSize, 0.3f, new Color(50, 50, 50)).createShadow(img), -shadowSize,
				-shadowSize, null);

		g2.dispose();

		return img;

	}

	private Point getLocationOf(float angle, int size) {

		double x = Math.cos(Math.toRadians(angle)) * size;

		double y = Math.sin(Math.toRadians(angle)) * size;

		return new Point((int) x, (int) y);

	}

	@Override

	public void setBounds(int i, int i1, int i2, int i3) {

		super.setBounds(i, i1, i2, i3);

		createBackground();

	}

}
