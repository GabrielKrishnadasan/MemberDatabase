package src;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JobApplicationGUI extends JFrame {
    private ArrayList<JobApplication> jobArray = new ArrayList<JobApplication>();

    private JTextField companyNameField;
    private JTextField jobNameField;
    private JTextField salaryField;
    private JTextField applicationDateField;
    private JTextField startDateField;
    private JTextField websiteField;
    private JTextField applicationLinkField;
    private JTextArea displayArea;

    public JobApplicationGUI() {
        setTitle("Job Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(1, 2));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Company Name
        inputPanel.add(new JLabel("Company Name:"));
        companyNameField = new JTextField();
        inputPanel.add(companyNameField);

        // Job Name
        inputPanel.add(new JLabel("Job Name:"));
        jobNameField = new JTextField();
        inputPanel.add(jobNameField);

        // Salary
        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        // Application Date
        inputPanel.add(new JLabel("Application Date:"));
        applicationDateField = new JTextField();
        inputPanel.add(applicationDateField);

        // Start Date
        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        inputPanel.add(startDateField);

        // Website Used
        inputPanel.add(new JLabel("Website Used:"));
        websiteField = new JTextField();
        inputPanel.add(websiteField);

        // Link to Application
        inputPanel.add(new JLabel("Link to Application:"));
        applicationLinkField = new JTextField();
        inputPanel.add(applicationLinkField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveJobData();
                displayJobArray();
            }
        });
        inputPanel.add(saveButton);

        getContentPane().add(inputPanel);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(new JScrollPane(displayArea));

        String companyName;
        String jobName;
        double salary;
        String applicationDate;
        String startDate;
        String website;
        String link;

        try {
            String filePath = "JobApps.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                companyName = bufferedReader.readLine();
                jobName = bufferedReader.readLine();
                salary = Double.parseDouble(bufferedReader.readLine());
                applicationDate = bufferedReader.readLine();
                startDate = bufferedReader.readLine();
                website = bufferedReader.readLine();
                link = bufferedReader.readLine();
                jobArray.add(new JobApplication(companyName, jobName, salary, applicationDate, startDate, website, link));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayJobArray();
        setVisible(true);
    }

    private void displayJobArray() {
        String details = "";
        for (JobApplication item : jobArray) {
           details += "Company Name: " + item.getCompanyName() + "\n"
                    + "Job Name: " + item.getJobName() + "\n"
                    + "Salary: " + item.getSalary() + "\n"
                    + "Application Date: " + item.getApplicationDate() + "\n"
                    + "Start Date: " + item.getStartDate() + "\n"
                    + "Website Used: " + item.getJobWebsiteUsed() + "\n"
                    + "Link to Application: " + item.getLinkToApplication() + "\n\n";
        }
        displayArea.setText(details);
    }

    private void saveJobData() {
        String companyName = companyNameField.getText();
        String jobName = jobNameField.getText();
        String salary = salaryField.getText();
        String applicationDate = applicationDateField.getText();
        String startDate = startDateField.getText();
        String website = websiteField.getText();
        String applicationLink = applicationLinkField.getText();

        if (!companyName.isEmpty() && !jobName.isEmpty() && !salary.isEmpty()
                && !applicationDate.isEmpty() && !startDate.isEmpty()
                && !website.isEmpty() && !applicationLink.isEmpty()) {
            jobArray.add(new JobApplication(companyName, jobName, Double.parseDouble(salary), applicationDate, startDate, website, applicationLink));

            
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JobApplicationGUI();
            }
        });
    }
}
