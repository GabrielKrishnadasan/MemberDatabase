package src;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jobApplicationTrackerGUI extends JFrame {
    public jobApplicationTrackerGUI() {
        super("Job Application Tracker");
        setSize(300, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with BoxLayout for centered buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Create the input application button
        JButton inputButton = new JButton("Input Application");
        inputButton.setAlignmentX(CENTER_ALIGNMENT);
        inputButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle input application button click event
                // Add your logic for handling input application here
                System.out.println("Input Application button clicked");
            }
        });
        buttonPanel.add(inputButton);

        // Add some spacing between the buttons
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Create the view applications button
        JButton viewButton = new JButton("View Applications");
        viewButton.setAlignmentX(CENTER_ALIGNMENT);
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle view applications button click event
                // Add your logic for handling view applications here
                System.out.println("View Applications button clicked");
            }
        });
        buttonPanel.add(viewButton);

        add(buttonPanel);
    }
}