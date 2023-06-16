package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public static void main(String[] args) {
        JobApplication[] jobArray = new JobApplication[3];
        String companyName;
        String jobName;
        double salary;
        String applicationDate;
        String startDate;
        String website;
        String link;
        int counter = 0;

        try {
            String filePath = "JobApps.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                companyName = bufferedReader.readLine();
                jobName = bufferedReader.readLine();
                salary = Double.parseDouble(bufferedReader.readLine());
                applicationDate = bufferedReader.readLine();
                startDate = bufferedReader.readLine();
                website = bufferedReader.readLine();
                link = bufferedReader.readLine();
                jobArray[counter] = new JobApplication(companyName, jobName, salary, applicationDate, startDate, website, link);
                counter++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < jobArray.length; i++) {
            jobArray[i].printDetails();
        }
    }
}
