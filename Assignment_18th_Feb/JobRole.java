import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    abstract boolean isMatch(String resume);
}

class SoftwareEngineerRole extends JobRole {
    @Override
    boolean isMatch(String resume) {
        // Implement logic to check if the resume matches software engineer requirements
                return resume.toLowerCase().contains("java") || 
               resume.toLowerCase().contains("python") || 
               resume.toLowerCase().contains("c++") || 
               resume.toLowerCase().contains("algorithms") || 
               resume.toLowerCase().contains("data structures");
    }
}

class DataScientistRole extends JobRole {
    @Override
    boolean isMatch(String resume) {
        // Implement logic to check if the resume matches data scientist requirements
        // e.g., keywords like "machine learning", "deep learning", "statistics", "R", "Python"
        return resume.toLowerCase().contains("machine learning") || 
               resume.toLowerCase().contains("deep learning") || 
               resume.toLowerCase().contains("statistics") || 
               resume.toLowerCase().contains("r") || 
               resume.toLowerCase().contains("python");
    }
}

class ProductManagerRole extends JobRole {
    @Override
    boolean isMatch(String resume) {
        // Implement logic to check if the resume matches product manager requirements
               return resume.toLowerCase().contains("product roadmap") || 
               resume.toLowerCase().contains("user research") || 
               resume.toLowerCase().contains("market analysis") || 
               resume.toLowerCase().contains("agile");
    }
}

class Resume<T extends JobRole> {
    private String content;

    public Resume(String content) {
        this.content = content;
    }

    public boolean isMatch(T jobRole) {
        return jobRole.isMatch(content);
    }

    public String getContent() {
        return content;
    }
}

class ResumeScreeningSystem {
    public static <T extends JobRole> boolean screenResume(Resume<T> resume, T jobRole) {
        return resume.isMatch(jobRole);
    }

    public static void screenResumes(List<? extends JobRole> jobRoles, Resume<?> resume) {
        for (JobRole jobRole : jobRoles) {
            if (resume.isMatch(jobRole)) {
                System.out.println("Resume matches " + jobRole.getClass().getSimpleName());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineerRole> softwareEngineerResume = 
                new Resume("I have 5 years of experience in Java and Python. " +
                        "I am proficient in data structures and algorithms.");

        Resume<DataScientistRole> dataScientistResume = 
                new Resume("I have 2 years of experience in machine learning " +
                        "and deep learning using Python and R.");

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineerRole());
        jobRoles.add(new DataScientistRole());
        jobRoles.add(new ProductManagerRole());

        ResumeScreeningSystem.screenResumes(jobRoles, softwareEngineerResume);
        System.out.println();
        ResumeScreeningSystem.screenResumes(jobRoles, dataScientistResume); 
    }
}
