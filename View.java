package HW7z1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JLabel errorLabel;
    private Presenter presenter;

    public View() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 200);

        num1Field = new JTextField(10);
        add(num1Field);

        num2Field = new JTextField(10);
        add(num2Field);

        addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        add(divideButton);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);

        errorLabel = new JLabel();
        add(errorLabel);

        presenter = new Presenter(this, new Model());
    }

    public double getNum1() throws NumberFormatException {
        return Double.parseDouble(num1Field.getText());
    }

    public double getNum2() throws NumberFormatException {
        return Double.parseDouble(num2Field.getText());
    }

    public void setResult(double result) {
        resultField.setText(Double.toString(result));
    }

    public void setError(String message) {
        errorLabel.setText(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        errorLabel.setText("");
        try {
            double num1 = getNum1();
            double num2 = getNum2();
            String operation = e.getActionCommand();
            presenter.calculate(operation, num1, num2);
        } catch(NumberFormatException ex) {
            setError("Invalid input");
        } catch(IllegalArgumentException ex) {
            setError(ex.getMessage());
        }
    }
}
