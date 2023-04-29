import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {

    private JLabel heightLabel, weightLabel, bmiLabel, resultLabel;
    private JTextField heightField, weightField, bmiField;
    private JButton calculateButton, clearButton;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setLayout(new GridLayout(4, 2));
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heightLabel = new JLabel("Enter height (in meters):");
        weightLabel = new JLabel("Enter weight (in kilograms):");
        bmiLabel = new JLabel("Your BMI:");
        resultLabel = new JLabel("");

        heightField = new JTextField(10);
        weightField = new JTextField(10);
        bmiField = new JTextField(10);
        bmiField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(bmiLabel);
        add(bmiField);
        add(calculateButton);
        add(clearButton);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            bmiField.setText(String.format("%.2f", bmi));
            if (bmi < 18.5) {
                resultLabel.setText("Underweight");
            } else if (bmi < 25) {
                resultLabel.setText("Normal weight");
            } else if (bmi < 30) {
                resultLabel.setText("Overweight");
            } else {
                resultLabel.setText("Obese");
            }
        } else if (e.getSource() == clearButton) {
            heightField.setText("");
            weightField.setText("");
            bmiField.setText("");
            resultLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}

