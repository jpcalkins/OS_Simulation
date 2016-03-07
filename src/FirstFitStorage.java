/**
 * a. Jacob Calkins
 * b. CS 4323
 * c. Simulation Project, Phase 1
 * d. Sarath Kumar Maddinani
 * e. Inherits from StorageStrategy
 * f. Class that implements a first-fit memory allocation strategy.
 */
public class FirstFitStorage extends StorageStrategy {
    //Traverses the memory list in order to find the first open block.
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
