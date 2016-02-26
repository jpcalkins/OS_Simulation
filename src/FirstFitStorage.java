/**
 * Created by Jacob on 2/5/16.
 */
public class FirstFitStorage extends StorageStrategy {
    public void startComputer(){
        Job firstJob = Job.randJob();
        addJob(firstJob);
        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
        ejectFromMemory(processQueue.poll());
        generateJobs();
    }
    public void addJob(Job incomingJob){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).size >= incomingJob.size && !memory.get(i).occupied){
                Block temp = memory.get(i).addJobToBlock(incomingJob);
                if(temp != null){
                    memory.add(i+1, temp);
                }
                processQueue.add(incomingJob.timeStamp);
                return;
            }
        }
        readyQueue.add(incomingJob);
    }
}
