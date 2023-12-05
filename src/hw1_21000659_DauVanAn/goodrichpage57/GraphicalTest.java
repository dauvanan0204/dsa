package hw1_21000659_DauVanAn.goodrichpage57;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalTest extends JFrame {
    private JTextField nameTextField;
    private JTextField creditCardNumberTextField;
    private JTextField limitTextField;
    private JButton createButton;
    private JButton displayButton;

    private CreditCard creditCard;

    public GraphicalTest() {
        setTitle("Credit Card Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add name field
        add(new JLabel("Name:"));
        nameTextField = new JTextField();
        add(nameTextField);

        // Add credit card number field
        add(new JLabel("Credit Card Number:"));
        creditCardNumberTextField = new JTextField();
        add(creditCardNumberTextField);

        // Add limit field
        add(new JLabel("Limit:"));
        limitTextField = new JTextField();
        add(limitTextField);

        // Add create button
        createButton = new JButton("Create Credit Card");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String creditCardNumber = creditCardNumberTextField.getText();
                double limit = Double.parseDouble(limitTextField.getText());

                creditCard = new CreditCard(name, creditCardNumber, limit);
                JOptionPane.showMessageDialog(null, "Credit Card created successfully.");
            }
        });
        add(createButton);

        // Add display button
        displayButton = new JButton("Display Credit Card Info");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creditCard != null) {
                    JOptionPane.showMessageDialog(null, creditCard.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Please create a Credit Card first.");
                }
            }
        });
        add(displayButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GraphicalTest();
        });
    }
}

