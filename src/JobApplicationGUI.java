package src;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

//Want to add a search button GK
//Better looking GUI GK
//Ability to delete files from display area GK

public class JobApplicationGUI extends JFrame {
    private ArrayList<JobApplication> jobArray = new ArrayList<JobApplication>();

    private JPanel inputPanel;

    private JButton introAddButton;
    private JButton introEditDeleteButton;
    private JButton introSearchButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton searchButton;

    private JTextField companyNameField;
    private JTextField jobNameField;
    private JTextField salaryField;
    private JTextField applicationDateField;
    private JTextField startDateField;
    private JTextField websiteField;
    private JTextField applicationLinkField;

    private JTextArea displayArea;

    private JLabel companyNameLabel;
    private JLabel jobNameLabel;
    private JLabel salaryLabel;
    private JLabel applicationDateLabel;
    private JLabel startDateLabel;
    private JLabel websiteLabel;
    private JLabel applicationLinkLabel;
    private JLabel displayAreaLabel;

    public JobApplicationGUI() {
        setTitle("Job Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new GridLayout(1, 2));

        inputPanel = new JPanel();

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(new JScrollPane(displayArea));

        setupIntroScreen();
        
        //Initializes variables for readin of the file
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

            //Reads in each line from the job app txt file, creating a job object for each job application, and adding them to the job array
            String line;
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

        //Displays the job array if there was anything in the job app txt file
        displayJobArray();
        setVisible(true);
    }

    private void setupIntroScreen() {
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        introAddButton = new JButton("Add");
        introAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeIntroScreen();
                setupAddScreen();
                //Add the actions for this button GK
            }
        });
        inputPanel.add(introAddButton);

        introEditDeleteButton = new JButton("Edit/Delete");
        introEditDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add the actions for this button GK
            }
        });
        inputPanel.add(introEditDeleteButton);

        introSearchButton = new JButton("Search");
        introSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add the actions for this button GK
            }
        });
        inputPanel.add(introSearchButton);

        getContentPane().add(inputPanel);
        setVisible(true);
    }

    private void removeIntroScreen() {
        inputPanel.removeAll();
        setVisible(true);
    }

    private void setupAddScreen() {
        inputPanel.setLayout(new GridLayout(8, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
    
        // Company Name
        companyNameLabel = new JLabel("Company Name:");
        inputPanel.add(companyNameLabel, constraints);
        companyNameField = new JTextField();
        inputPanel.add(companyNameField, constraints);

        constraints.gridy++;

        // Job Name
        jobNameLabel = new JLabel("Job Name:");
        inputPanel.add(jobNameLabel, constraints);
        jobNameField = new JTextField();
        inputPanel.add(jobNameField, constraints);

        constraints.gridy++;

        // Salary
        salaryLabel = new JLabel("Salary:");
        inputPanel.add(salaryLabel, constraints);
        salaryField = new JTextField();
        inputPanel.add(salaryField, constraints);

        constraints.gridy++;

        // Application Date
        applicationDateLabel = new JLabel("Application Date:");
        inputPanel.add(applicationDateLabel, constraints);
        applicationDateField = new JTextField();
        inputPanel.add(applicationDateField, constraints);

        constraints.gridy++;

        // Start Date
        startDateLabel = new JLabel("Start Date:");
        inputPanel.add(startDateLabel, constraints);
        startDateField = new JTextField();
        inputPanel.add(startDateField, constraints);

        constraints.gridy++;

        // Website Used
        websiteLabel = new JLabel("Website Used:");
        inputPanel.add(websiteLabel, constraints);
        websiteField = new JTextField();
        inputPanel.add(websiteField, constraints);

        constraints.gridy++;

        // Link to Application
        applicationDateLabel = new JLabel("Application Date:");
        inputPanel.add(applicationDateLabel, constraints);
        applicationLinkField = new JTextField();
        inputPanel.add(applicationLinkField, constraints);

        constraints.gridy++;

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveJobData();
                displayJobArray();
            }
        });
        inputPanel.add(saveButton, constraints);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAddScreen();
                setupIntroScreen();
            }
        });

        inputPanel.add(backButton, constraints);

        getContentPane().add(inputPanel);
        setVisible(true);
    }

    private void removeAddScreen() {
        inputPanel.removeAll();
        setVisible(true);
    }

    private void setupEditDeleteScreen() {
        
    }

    private void removeEditDeleteScreen() {

    }

    private void setupSearchScreen() {

    }

    private void removeSearchScreen() {

    }

    private void displayJobArray() {
        String details = "";
        //Loops through the job array and adds each job details to the details string, then displaying them in the displayArea
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

        //As long as each box has something in it when the user presses save, it will save the job
        //Can add better checkers here GK
        //Need to make it so when saving a valid job, the info is appended to the job file GK
        if (!companyName.isEmpty() && !jobName.isEmpty() && !salary.isEmpty()
                && !applicationDate.isEmpty() && !startDate.isEmpty()
                && !website.isEmpty() && !applicationLink.isEmpty()) {
            jobArray.add(new JobApplication(companyName, jobName, Double.parseDouble(salary), applicationDate, startDate, website, applicationLink));

            try {
                String filePath = "JobApps.txt";
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
                if(jobArray.size() == 1)
                {
                    bufferedWriter.write("\n");
                }
                for (int i = 0; i < jobArray.size(); i++) {
                    bufferedWriter.write("Job Application " + (i + 1) + "\n");
                    bufferedWriter.write(jobArray.get(i).writeToFile());
                    bufferedWriter.write("\n");
                }
    
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
