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
    public Block(int size, boolean occupied){
        this.size = size;
        this.occupied = occupied;
    }
    public Block(Job job){
        this.size = job.size;
        this.job = job;
        this.occupied = true;
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
            return new Block(prevSize - job.size);
        }else{
            return null;
        }
    }
    public int compareTo(Block other){
        return Integer.compare(this.size, other.size);
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public boolean isOccupied(){
        return occupied;
    }
}
