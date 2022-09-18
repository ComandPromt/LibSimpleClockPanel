package com.company;

import java.awt.Color;

import javax.swing.JPanel;

import com.company.clock.SimpleDigitalClock;
import com.company.clock.TextClock;
import com.company.dates.MaterialDate;
import com.company.dates.SimpleDate;
import com.company.dates.SimpleDateText;
import com.company.dates.TextDate;

@SuppressWarnings("serial")

public class MaterialDigitalClock extends JPanel {

	public enum Language {

		ENGLISH, SPANISH;

	}

	public MaterialDigitalClock(Color background, Color foreground, int textSize, Language language, int type) {

		JPanel panel;

		switch (type) {

		default:

		case 1:

			panel = new SimpleDigitalClock(background, foreground, textSize);

			break;

		case 2:

			panel = new TextClock(background, foreground, language, textSize);

			break;

		case 3:

			panel = new SimpleDate(background, foreground, textSize);

			break;

		case 4:

			panel = new SimpleDateText(background, foreground, textSize);

			break;

		case 5:

			panel = new TextDate(background, foreground, language, textSize);

			break;

		case 6:

			panel = new MaterialDate(background, foreground, language, textSize);

			break;

		}

		add(panel);

	}

}
