import java.util.Collections;

/**
 * Created by Jacob on 2/5/16.
 */
public class BestFitStorage extends StorageStrategy {

    public void addJob(Job incomingJob){
        Collections.sort(memory);
//        for(int j=0; j<memory.size(); j++){
//            System.out.println("Size: " + memory.get(j).size + " Occupied: " + memory.get(j).occupied);
//        }
//        System.out.println();
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
