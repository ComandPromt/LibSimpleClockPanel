package com.company.digital;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MaterialDigitalClock extends JPanel {

	public enum Language {

		ENGLISH, SPANISH;

	}

	public MaterialDigitalClock() {

		this(Color.WHITE, Color.BLACK, 20, false, 2);

	}

	public MaterialDigitalClock(int type) {

		this(Color.WHITE, Color.BLACK, 20, false, type);

	}

	public MaterialDigitalClock(Color background, Color foreground, int textSize, boolean english, int type) {

		if (background == null) {

			background = Color.WHITE;

		}

		if (foreground == null) {

			foreground = Color.BLACK;

		}

		if (textSize < 1) {

			textSize = 1;

		}

		JPanel panel;

		switch (type) {

		case 2:

			panel = new TextClock(background, foreground, english, textSize);

			break;

		case 3:

			panel = new SimpleDate(background, foreground, textSize);

			break;

		case 4:

			panel = new SimpleDateText(background, foreground, textSize);

			break;

		case 5:

			panel = new TextDate(background, foreground, english, textSize);

			break;

		case 6:

			panel = new MaterialDate(background, foreground, english, textSize);

			break;

		default:

			panel = new SimpleDigitalClock(background, foreground, textSize);

			break;

		}

		add(panel);

	}

}
