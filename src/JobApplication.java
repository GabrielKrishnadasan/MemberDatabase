package src;

public class JobApplication {
    private String companyName;
    private String jobName;
    private double salary;
    private String applicationDate;
    private String startDate;
    private String jobWebsiteUsed;
    private String linkToApplication;

    public JobApplication() {
        this.companyName = "None";
        this.jobName = "None";
        this.salary = 0;
        this.applicationDate = "None";
        this.startDate = "None";
        this.jobWebsiteUsed = "None";
        this.linkToApplication = "None";
    }

    public JobApplication(String companyName, String jobName, double salary, String applicationDate, String startDate, String jobWebsiteUsed, String linkToApplication) {
        this.companyName = companyName;
        this.jobName = jobName;
        this.salary = salary;
        this.applicationDate = applicationDate;
        this.startDate = startDate;
        this.jobWebsiteUsed = jobWebsiteUsed;
        this.linkToApplication = linkToApplication;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getJobWebsiteUsed() {
        return jobWebsiteUsed;
    }

    public void setJobWebsiteUsed(String jobWebsiteUsed) {
        this.jobWebsiteUsed = jobWebsiteUsed;
    }

    public String getLinkToApplication() {
        return linkToApplication;
    }

    public void setLinkToApplication(String linkToApplication) {
        this.linkToApplication = linkToApplication;
    }

    public void printDetails() {
        System.out.println("Job Application Details:");
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Name: " + jobName);
        System.out.println("Salary: $" + salary);
        System.out.println("Application Date: " + applicationDate);
        System.out.println("Start Date: " + startDate);
        System.out.println("Job Website Used: " + jobWebsiteUsed);
        System.out.println("Link to Application: " + linkToApplication);
    }

    public String getDetails() {
        return "Company Name: " + companyName + "\n" + 
                "Job Name: " + jobName + "\n" + 
                "Salary: $" + salary + "\n" +
                "Application Date: " + applicationDate +
                "Start Date: " + startDate + " \n" +
                "Job Website Used: " + jobWebsiteUsed + "\n" + 
                "Link to Application " + linkToApplication;
    }
}
