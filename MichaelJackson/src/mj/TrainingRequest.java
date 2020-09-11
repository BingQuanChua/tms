package mj;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TrainingRequest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 22);
	Font f2 = new Font(Font.DIALOG, Font.PLAIN, 20);
	/**
	 * 
	 */
	public TrainingRequest(String name, int number) {
		
		setPreferredSize(new Dimension(800, 60));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		//////////// one single request ////////////
		// will create an individual class later
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(f2);
		label.setBounds(12, 6, 56, 50);
		add(label);
		label.setText(number+".");
				
		JButton profileButton = new JButton(name);
		profileButton.setFont(f1);
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileButton.setBorder(null);
		profileButton.setBackground(SystemColor.menu);
		profileButton.setFocusPainted(false);
		profileButton.setBounds(75, 1, 450, 58);
		add(profileButton);

		JButton acceptButton = new JButton("Accept");
		acceptButton.setFont(f2);
		acceptButton.setBackground(new Color(205,133,63));
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		acceptButton.setBounds(537, 10, 120, 40);
		add(acceptButton);
		
		JButton rejectButton = new JButton("Reject");
		rejectButton.setFont(f2);
		rejectButton.setBackground(new Color(205,133,63));
		rejectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rejectButton.setBounds(669, 10, 120, 40);
		add(rejectButton);
		
		JButton background = new JButton();
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 60);
		add(background);
		//////////// end of one single request ////////////

	}
}