import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FinanceTrackerGUI {
    static double balance = 0;
    static DefaultListModel<String> model = new DefaultListModel<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Personal Finance Tracker");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField descField = new JTextField();
        JTextField amtField = new JTextField();
        JButton addIncome = new JButton("Add Income");
        JButton addExpense = new JButton("Add Expense");
        JList<String> list = new JList<>(model);
        JLabel balLabel = new JLabel("Balance: ₹0.0");

        descField.setBounds(30, 20, 320, 25);
        amtField.setBounds(30, 50, 320, 25);
        addIncome.setBounds(30, 90, 140, 30);
        addExpense.setBounds(210, 90, 140, 30);
        list.setBounds(30, 130, 320, 250);
        balLabel.setBounds(30, 400, 200, 25);

        frame.add(descField);
        frame.add(amtField);
        frame.add(addIncome);
        frame.add(addExpense);
        frame.add(list);
        frame.add(balLabel);

        ActionListener handler = e -> {
            try {
                double amt = Double.parseDouble(amtField.getText());
                String desc = descField.getText();
                if (desc.isEmpty()) throw new Exception();

                if (e.getSource() == addIncome) {
                    balance += amt;
                    model.addElement("Income: " + desc + " | ₹" + amt);
                } else {
                    balance -= amt;
                    model.addElement("Expense: " + desc + " | ₹" + amt);
                }

                balLabel.setText("Balance: ₹" + balance);
                descField.setText("");
                amtField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input");
            }
        };

        addIncome.addActionListener(handler);
        addExpense.addActionListener(handler);

        frame.setVisible(true);
    }
}
