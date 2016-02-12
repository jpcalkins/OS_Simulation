/**
 * Created by Jacob on 2/5/16.
 */
public class BestFitStorage extends StorageStrategy {
    public void addJob(Job job){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).size >= job.size){
                Block temp = memory.get(i).addJobToBlock(job);
                if(temp != null){

                }
            }
        }
    }
}
