import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator App");
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener(display));
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

class ButtonClickListener implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewCalculation = true;

    public ButtonClickListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            if (isNewCalculation) {
                display.setText(command);
                isNewCalculation = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("C")) {
            clear();
        } else if (command.equals("=")) {
            calculate();
        } else { // Operator
            if (!operator.isEmpty()) {
                calculate();
            }
            operator = command;
            firstNumber = Double.parseDouble(display.getText());
            isNewCalculation = true;
        }
    }

    private void clear() {
        display.setText("");
        operator = "";
        firstNumber = 0;
        isNewCalculation = true;
    }

    private void calculate() {
        if (!operator.isEmpty()) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Error");
                        clear();
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            firstNumber = result;
            operator = "";
            isNewCalculation = true;
        }
    }
}