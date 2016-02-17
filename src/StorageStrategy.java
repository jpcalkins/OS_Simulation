/**
 * Created by Jacob on 2/5/16.
 */
import java.lang.reflect.Array;
import java.util.*;

public class StorageStrategy {
    public Measurement stats;
    public Timer time;
    public ArrayList<Block> memory;

    public StorageStrategy(){
        this.stats = new Measurement();
        this.memory = new ArrayList<Block>();
        memory.add(new Block(1800));
        memory.add(new Block(new Job(200, 0, 0, false)));
    }
    public Block getLargestOpenBlock(){
        Block largestOpenBlock = memory.get(0);
        for(int i=1; i<memory.size()-1; i++){
            if(memory.get(i).size > largestOpenBlock.size && memory.get(i).occupied){
                largestOpenBlock = memory.get(i);
            }
        }
        return largestOpenBlock;
    }
    public Block getLargestBlock(){
        Block largestBlock = memory.get(0);
        for(int i=1; i<memory.size()-1; i++){
            if(memory.get(i).size > largestBlock.size){
                largestBlock = memory.get(i);
            }
        }
        return largestBlock;
    }
    public void addJob(Job incomingJob){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).size >= incomingJob.size && !memory.get(i).occupied){
                //addJobToBlock returns a new empty block if block where job was placed wasn;t completely filled.
                Block temp = memory.get(i).addJobToBlock(incomingJob);
                if(temp != null){
                    memory.add(i+1, temp);
                }
                break;
            }
        }
    }
}
