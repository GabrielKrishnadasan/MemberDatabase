package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class applicationTrackerUI extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JButton addButton;
    private JTextArea displayArea;

    public applicationTrackerUI() {
        setTitle("Member Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new BorderLayout());

        // Create components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(3);
        addButton = new JButton("Add");
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(addButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Register event handlers
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                // Add code here to process the member data and add it to the database
                displayArea.append("Name: " + name + ", Age: " + age + "\n");
                nameField.setText("");
                ageField.setText("");
            }
        });
    }
}