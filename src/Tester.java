package src;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Tester {
    public static void main(String[] args)
    {
        JobApplication test = new JobApplication("Google", "Software Developer", 20000, "6/15/23", "6/16/23", "LinkedIn", "Placeholder");
        

        JobApplication[] jobArray = new JobApplication[3];
        jobArray[0] = test;
        jobArray[1] = new JobApplication();
        jobArray[2] = new JobApplication("Netflix", "Cybersecurity", 30000, "6/15/23", "6/16/23", "Handshake", "Placeholder");


        try {
            String filePath = "JobApps.txt";
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < jobArray.length; i++) {
                bufferedWriter.write("\nJob Application " + (i + 1) + "\n");
                bufferedWriter.write(jobArray[i].writeToFile());
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
