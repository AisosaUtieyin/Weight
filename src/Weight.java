import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Weight extends JFrame implements ActionListener {
	private JLabel pounds = new JLabel("Pounds");
	private JTextField text = new JTextField(25);
	private JButton convert = new JButton("Convert");
	private JTextArea result = new JTextArea(10, 10);
	final private double k = 2.205;
	private int counter= 0;

	public Weight() {
		super("Weight Converter");
		setLayout(new FlowLayout());
		add(pounds);
		add(text);
		text.setEditable(true);
		add(convert);
		convert.addActionListener(this);
		add(result);
		setSize(300, 250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == convert) {
			String outcome = text.getText();
			int poundResult = convertToInt(outcome);
			double kgResult = convert(poundResult);
			String r = convertToString(kgResult);
			if(counter>0) {
				result.setText("");
				result.append(r);
			}
			else {
				result.append(r);
			}
			
			
			counter++;

		}

	}

	public String convertToString(double a) {
		try {

			String x = Double.toString(a);
			return x;

		} catch (NumberFormatException nfe) {

			System.out.println("NumberFormatException: " + nfe.getMessage());
			return null;
		}

	}

	public double convert(int a) {
		double kg = (a / k);
		return kg;

	}

	public int convertToInt(String x) {
		try {
			int y = Integer.parseInt(x.trim());
			return y;
		} catch (NumberFormatException nfe) {

			System.out.println("NumberFormatException: " + nfe.getMessage());
			return (Integer) null;
		}

	}

	public static void main(String[] args) {
		Weight test = new Weight();
	}

}