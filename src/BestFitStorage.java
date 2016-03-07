/**
 * a. Jacob Calkins
 * b. CS 4323
 * c. Simulation Project, Phase 1
 * d. Sarath Kumar Maddinani
 * e. Inherits from StorageStrategy
 * f. Class that implements a best-fit memory allocation strategy.
 * g. Sorts memory blocks to make finding the proper open block easier.
 */
import java.util.Collections;

public class BestFitStorage extends StorageStrategy {
    //Sorts memory into ascending order based on block size, then traverses the list to find the first open block, giving me the smallest possible block to place the job.
    public void addJob(Job incomingJob){
        Collections.sort(memory);
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
