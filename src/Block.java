/**
 * Created by Jacob on 2/5/16.
 */
public class Block implements Comparable<Block> {
    public int size;
    public boolean occupied;
    public Job job;

    public Block(int size){
        this.size = size;
        this.occupied = false;
    }
    public void removeJob(){
        this.occupied = false;
        this.job = null;
    }
    public Block addJobToBlock(Job job){
        this.occupied = true;
        this.job = job;
        if(job.size < this.size){
            int prevSize = this.size;
            this.size = job.size;
            //returns new block of memory that is the remainder from added job
            return new Block(prevSize - job.size);
        }else{
            //job fit perfectly in block so no creation of new block necessary.
            return null;
        }
    }
    //comparable constructor so that I may compare block objects using <, >, =. This is necessary to keep an ordered list for best and worst fit allocation.
    public int compareTo(Block other){
        return Integer.compare(this.size, other.size);
    }
}
