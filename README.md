
# LibSimpleClockPanel

![Preview](previews/1.gif)

![Preview](previews/2.gif)

![Preview](previews/3.gif)

- Use

~~~java

	Clock test= new Clock();

	SimpleClockPanel panel = new SimpleClockPanel(1f, Color.BLUE, Color.GREEN, Color.ORANGE, Color.BLACK,
				new Color(255, 78, 83));

	ClockPanel panel_1 = new ClockPanel(Color.BLUE, Color.GREEN, Color.ORANGE, Color.WHITE, new Color(255, 78, 83),
			200, 200);
	
	MaterialDigitalClock panel_2 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH, 1);
	
	MaterialDigitalClock panel_2_1 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH, 2);
	
	MaterialDigitalClock panel_2_1_1 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH, 3);
	
	MaterialDigitalClock panel_2_1_1_1 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH, 4);
	
	MaterialDigitalClock panel_2_1_1_2 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH, 5);
	
	MaterialDigitalClock panel_2_1_1_2_1 = new MaterialDigitalClock(Color.BLUE, Color.GREEN, 20, Language.SPANISH,
			6);
	
	ClockFace panel = new ClockFace();

	panel.setRomano(false);
	
~~~

~~~java

import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ActionEvent;

import java.io.IOException;

import javax.swing.GroupLayout;

import javax.swing.GroupLayout.Alignment;

import javax.swing.JFrame;

import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.event.ChangeEvent;

import com.company.analog.Clock;

import com.company.analog.ClockFace;

import com.company.analog.ClockPanel;

import com.company.analog.SimpleClockPanel;

@SuppressWarnings("all")

public class Ventana extends javax.swing.JFrame {

	public Ventana() throws IOException {

		setAlwaysOnTop(true);

		setTitle("Test");

		initComponents();

		setVisible(true);

	}

	public static void main(String[] args) {

		try {

			new Ventana().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	public void initComponents() throws IOException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		ClockFace panel = new ClockFace(Color.GRAY, Color.MAGENTA, Color.CYAN);

		panel.setBackground(Color.WHITE);

		panel.setForeground(Color.BLACK);

		panel.setRomano(false);

		ClockFace panel_1 = new ClockFace(Color.GRAY, Color.MAGENTA, Color.CYAN);

		panel_1.setRomano(true);

		Clock panel_1_1 = new Clock(Color.WHITE, Color.RED, Color.WHITE, Color.GREEN, Color.WHITE, Color.ORANGE,
				Color.PINK, Color.YELLOW, Color.ORANGE);

		SimpleClockPanel panel_1_2 = new SimpleClockPanel(1f, Color.BLUE, Color.GREEN, Color.ORANGE, Color.BLACK,
				new Color(255, 78, 83));

		SimpleClockPanel panel_1_2_1 = new SimpleClockPanel(1.0f, Color.BLUE, Color.GREEN, Color.ORANGE, Color.BLACK,
				new Color(255, 78, 83));

		panel_1_2_1.setRomano(true);

		ClockPanel panel_1_2_2 = new ClockPanel(Color.WHITE, Color.BLUE, Color.GREEN, Color.ORANGE, Color.GRAY,
				Color.RED, Color.BLACK, 150, 150);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1_2_2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(8)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(panel_1_2_1, GroupLayout.PREFERRED_SIZE, 116,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(163, Short.MAX_VALUE)));
		
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_2_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addGap(45)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1_2_1, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(18).addComponent(panel_1_1,
										GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(350, Short.MAX_VALUE)));

		getContentPane().setLayout(layout);

		setSize(new Dimension(677, 724));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}
	
}

~~~