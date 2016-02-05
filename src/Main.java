import java.util.*;

public class Main {

    public static void main(String[] args) {
        Timer time = new Timer();
        BestFitStorage bestFit = new BestFitStorage();
        FirstFitStorage forstFit = new FirstFitStorage();
        WorstFitStorage worstFit = new WorstFitStorage();
        int jobNumber = 0;
        while (time.getTime() <= 5000) {
            Job upcomingJob = Job.randJob(jobNumber);
            jobNumber++;
            time.incrementTime();
        }
    }
}
