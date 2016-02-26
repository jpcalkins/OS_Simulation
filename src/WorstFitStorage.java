/**
 * Created by Jacob on 2/5/16.
 */
public class WorstFitStorage extends StorageStrategy {
    public void startComputer(){
        Job firstJob = Job.randJob();
        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
        generateJobs();
    }
    public void addJob(Job job){

    }
}
