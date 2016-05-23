package GUI;
import javax.swing.*;
import java.util.Random; //lösche
import java.awt.*;

public class Frame extends JFrame {

	private JTextArea textArea;
	private JFrame frame;

	public void GUI() {

		frame = new JFrame("ZugStimulato");
		JPanel panel = new JPanel();

		frame.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());

		textArea = new JTextArea();

		Font font = new Font("A", Font.BOLD, 15);
		textArea.setFont(font);
		textArea.setForeground(Color.BLACK);

		panel.add(textArea);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		frame.setVisible(true);

	}

	public void setText(String s) {
		textArea.setText(s);
	/*	Random r = new Random();														//Für geilö Lischt änktschn
		Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256),
				r.nextInt(256));
		textArea.setForeground(c);
	*/	frame.pack();
		frame.setLocationRelativeTo(null);
	}
}
