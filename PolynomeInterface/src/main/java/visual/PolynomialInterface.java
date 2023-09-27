package visual;

import org.model.Polynomial;
import service.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PolynomialInterface {
    static Polynomial firstPolynomial;
    static Polynomial secondPolynomial;

    static double x;

    private static void validate(String[] numbers){
        try {
            for(String s: numbers)
                if(!Calculator.isNumeric(s))
                    throw new MyException("You have inserted the wrong data!");
        } catch (MyException exception){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Something is wrong with the input!");
        }
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        JPanel firstPanel = new JPanel(new GridLayout(2,2));
        JPanel secondPanel = new JPanel(new GridLayout(2,2));
        JPanel xPanel = new JPanel();
        JPanel factorPanel = new JPanel();

        firstPanel.setBounds(0, 0, 800, 75);
        firstPanel.setBackground(new Color(0x71aeeb));

        secondPanel.setBounds(0, 75, 800, 75);
        secondPanel.setBackground(new Color (0x71aeeb));

        xPanel.setBounds(0,150, 800, 75);
        xPanel.setBackground(new Color(0x71aeeb));

        factorPanel.setBounds(0, 320, 400,100);
        factorPanel.setBackground(new Color(0x123456));

        JLabel firstPolynomialCoefficientsLabel = new JLabel("Give us the coefficients separated by a space: ");
        firstPolynomialCoefficientsLabel.setVisible(true);

        JLabel secondPolynomialCoefficientsLabel = new JLabel("Give us the coefficients separated by a space: ");
        secondPolynomialCoefficientsLabel.setVisible(true);

        JLabel firstPolynomialPowersLabel = new JLabel("Give us the powers of X separated by a space: ");
        firstPolynomialPowersLabel.setVisible(true);

        JLabel secondPolynomialPowersLabel = new JLabel("Give us the powers of X separated by a space: ");
        secondPolynomialPowersLabel.setVisible(true);

        JLabel xLabel = new JLabel("Provide the x for the polynomials: ");
        xLabel.setVisible(true);

        JTextField firstPolynomialCoefficientsField = new JTextField();
        firstPolynomialCoefficientsField.setColumns(10);
        firstPolynomialCoefficientsField.setVisible(true);

        JTextField firstPolynomialPowersField = new JTextField();
        firstPolynomialPowersField.setColumns(10);
        firstPolynomialPowersField.setVisible(true);

        JTextField secondPolynomialCoefficientsField = new JTextField();
        secondPolynomialCoefficientsField.setColumns(10);
        secondPolynomialCoefficientsField.setVisible(true);

        JTextField secondPolynomialPowersField = new JTextField();
        secondPolynomialPowersField.setColumns(10);
        secondPolynomialPowersField.setVisible(true);

        JTextField xField = new JTextField();
        xField.setColumns(10);
        xField.setVisible(true);

        JTextField factorField = new JTextField();
        factorField.setColumns(10);
        factorField.setVisible(false);

        Button confirmationButton = new Button("Confirm");
        confirmationButton.setBounds(510,350, 75,25);
        confirmationButton.setBackground(new Color(0x71aeeb));

        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(xPanel);
        frame.add(confirmationButton);

        firstPanel.add(firstPolynomialCoefficientsLabel);
        firstPanel.add(firstPolynomialCoefficientsField);
        firstPanel.add(firstPolynomialPowersLabel);
        firstPanel.add(firstPolynomialPowersField);

        secondPanel.add(secondPolynomialCoefficientsLabel);
        secondPanel.add(secondPolynomialCoefficientsField);
        secondPanel.add(secondPolynomialPowersLabel);
        secondPanel.add(secondPolynomialPowersField);

        xPanel.add(xLabel);
        xPanel.add(xField);

        final JLabel firstResult = new JLabel();
        firstResult.setVisible(false);
        firstResult.setOpaque(true);
        firstResult.setBackground(new Color(0x79bafc));

        final JLabel secondResult = new JLabel();
        secondResult.setVisible(false);
        secondResult.setOpaque(true);
        secondResult.setBackground(new Color(0x79bafc));

        final JLabel operationLabel = new JLabel();
        operationLabel.setVisible(false);
        operationLabel.setOpaque(true);
        operationLabel.setBackground(new Color(0x79bafc));

        final JLabel evaluationLabel = new JLabel();
        evaluationLabel.setVisible(false);
        evaluationLabel.setOpaque(true);
        evaluationLabel.setBackground(new Color(0x79bafc));

        final JLabel factorLabel = new JLabel("Provide a factor with which to perform the operation: ");
        factorLabel.setVisible(false);
        factorLabel.setBackground(new Color(0x79bafc));
        factorLabel.setOpaque(true);


        JPanel resultPanel = new JPanel();
        resultPanel.setBounds(0, 225, 800, 75);
        resultPanel.setBackground(new Color(0x123456));
        resultPanel.setLayout(new GridLayout(4,1));
        frame.add(resultPanel);

        resultPanel.add(secondResult);
        resultPanel.add(firstResult);
        resultPanel.add(operationLabel);
        resultPanel.add(evaluationLabel);

        frame.setVisible(true);

        JPanel buttonPanel = new JPanel(new GridLayout(6,1));
        buttonPanel.setBounds(600, 320, 110,200);
        buttonPanel.setBackground(new Color(0x123456));

        Button additionButton = new Button("Add");
        additionButton.setSize(75, 25);
        additionButton.setBackground(new Color(0x63b1ff));
        Button subtractionButton = new Button ("Subtract");
        subtractionButton.setSize(75, 25);
        subtractionButton.setBackground(new Color(0x5ca5ed));
        Button normalDivisionButton = new Button("Divide by");
        normalDivisionButton.setSize(75, 25);
        normalDivisionButton.setBackground(new Color(0x5699db));
        Button polynomialDivisionButton = new Button("Divide polynomial");
        polynomialDivisionButton.setSize(75, 25);
        polynomialDivisionButton.setBackground(new Color(0x508ecc));
        Button normalMultiplication = new Button("Multiply by");
        normalMultiplication.setSize(75, 25);
        normalMultiplication.setBackground(new Color(0x3f7dba));
        Button polynomialMultiplication = new Button("Multiply polynomial");
        polynomialMultiplication.setSize(75,25);
        polynomialMultiplication.setBackground(new Color(0x3971a8));

        Button factorbutton = new Button("Confirm");
        factorbutton.setVisible(false);

        additionButton.setVisible(false);
        subtractionButton.setVisible(false);
        normalDivisionButton.setVisible(false);
        polynomialDivisionButton.setVisible(false);
        normalMultiplication.setVisible(false);
        polynomialMultiplication.setVisible(false);

        buttonPanel.add(additionButton);
        buttonPanel.add(subtractionButton);
        buttonPanel.add(normalDivisionButton);
        buttonPanel.add(polynomialDivisionButton);
        buttonPanel.add(normalMultiplication);
        buttonPanel.add(polynomialMultiplication);

        factorPanel.add(factorLabel);
        factorPanel.add(factorField);

        frame.add(buttonPanel);
        frame.add(factorPanel);

        
        confirmationButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorLabel.setVisible(false);
                factorField.setVisible(false);
                String coefficients = firstPolynomialCoefficientsField.getText();
                String[] usefulCoefficients = coefficients.split("( )+");
                PolynomialInterface.validate(usefulCoefficients);
                String powers = firstPolynomialPowersField.getText();
                String[] usefulPowers = powers.split(" +");
                PolynomialInterface.validate(usefulPowers);
                firstPolynomial = new Polynomial(usefulCoefficients, usefulPowers);

                coefficients = secondPolynomialCoefficientsField.getText();
                usefulCoefficients = coefficients.split("( )+");
                PolynomialInterface.validate(usefulCoefficients);
                powers = secondPolynomialPowersField.getText();
                usefulPowers = powers.split(" +");
                PolynomialInterface.validate(usefulPowers);
                secondPolynomial = new Polynomial(usefulCoefficients, usefulPowers);

                String tempX = xField.getText();
                try {
                    if(!Calculator.isNumeric(tempX))
                        throw new MyException("X is not a number");
                } catch (MyException myException) {
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "X is not a number!");
                }
                x = Double.parseDouble(tempX);

                firstResult.setText("The first polynomial: " + firstPolynomial.toString(x));
                secondResult.setText("The second polynomial: " + secondPolynomial.toString(x));

                firstResult.setVisible(true);

                secondResult.setVisible(true);

                additionButton.setVisible(true);
                subtractionButton.setVisible(true);
                normalDivisionButton.setVisible(true);
                polynomialDivisionButton.setVisible(true);
                normalMultiplication.setVisible(true);
                polynomialMultiplication.setVisible(true);
            }
        });

        additionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorLabel.setVisible(false);
                factorField.setVisible(false);
                Polynomial temp = Calculator.add(firstPolynomial, secondPolynomial, x);
                operationLabel.setText("The addition of the two:\n " + temp.toString(x));
                evaluationLabel.setText("Which evaluates to:\n " + Calculator.evaluate(temp, x));
                operationLabel.setOpaque(true);
                operationLabel.setBackground(new Color(0x79bafc));
                evaluationLabel.setOpaque(true);
                evaluationLabel.setBackground(new Color(0x79bafc));
                operationLabel.setVisible(true);
                evaluationLabel.setVisible(true);
            }
        });

        subtractionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorLabel.setVisible(false);
                factorField.setVisible(false);
                Polynomial temp = Calculator.subtract(firstPolynomial, secondPolynomial, x);
                operationLabel.setText("The remainder of the two:\n " + temp.toString(x));
                evaluationLabel.setText("Which evaluates to:\n " + Calculator.evaluate(temp, x));
                operationLabel.setOpaque(true);

                evaluationLabel.setOpaque(true);

                operationLabel.setVisible(true);
                evaluationLabel.setVisible(true);
            }
        });

        normalDivisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evaluationLabel.setVisible(false);
                factorLabel.setVisible(true);
                factorLabel.setBackground(new Color(0x79bafc));
                factorLabel.setOpaque(true);
                factorField.setVisible(true);
                if(!factorField.getText().isBlank()){
                    try {
                        if(!Calculator.isNumeric(factorField.getText()))
                            throw new MyException("Factor is not a number");
                    } catch (MyException myException) {
                        JFrame jFrame = new JFrame();
                        JOptionPane.showMessageDialog(jFrame, "Factor is not a number!");
                    }
                    double factor = Double.parseDouble(factorField.getText());
                    operationLabel.setVisible(true);
                    operationLabel.setOpaque(true);
                    operationLabel.setText("The second polynomial divided by " + factor + ":\n " + Calculator.regularDivision(secondPolynomial, factor).toString(x));
                }
            }
        });

        normalMultiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evaluationLabel.setVisible(false);
                factorLabel.setVisible(true);

                factorField.setVisible(true);
                if(!factorField.getText().isBlank()){
                    try {
                        if(!Calculator.isNumeric(factorField.getText()))
                            throw new MyException("Factor is not a number");
                    } catch (MyException myException) {
                        JFrame jFrame = new JFrame();
                        JOptionPane.showMessageDialog(jFrame, "Factor is not a number!");
                    }
                    double factor = Double.parseDouble(factorField.getText());
                    operationLabel.setVisible(true);

                    operationLabel.setText("The second polynomial multiplied by " + factor + ":\n " + Calculator.regularMultiplication(secondPolynomial, factor).toString(x));
                }
            }
        });

        polynomialDivisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorLabel.setVisible(false);
                factorField.setVisible(false);
                evaluationLabel.setVisible(false);
                ArrayList<Polynomial> result = Calculator.polynomialDivision(firstPolynomial, secondPolynomial, x);
                operationLabel.setText("The quotient: " + result.get(0).toString(x) +"\n The remainder: " + result.get(1).toString(x));
                operationLabel.setVisible(true);
            }
        });

        polynomialMultiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorLabel.setVisible(false);
                factorField.setVisible(false);
                evaluationLabel.setVisible(false);
                operationLabel.setText("The produce of the two:\n " + Calculator.polynomialMultiplication(firstPolynomial, secondPolynomial).toString(x));
                operationLabel.setVisible(true);
            }
        });
    }
}
