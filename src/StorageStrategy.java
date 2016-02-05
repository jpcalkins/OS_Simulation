/**
 * Created by Jacob on 2/5/16.
 */
import java.util.*;

public class StorageStrategy {
    public Measurement stats;
    public Timer time;
    public ArrayList<Block> memory;

    public StorageStrategy(){
        this.stats = new Measurement();
        this.memory = new ArrayList<Block>();
        memory.add(new Block(1800));
        memory.add(new Block(new Job(200, 0, 0, 180, false)));
    }
}
