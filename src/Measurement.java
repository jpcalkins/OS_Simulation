import java.util.ArrayList;

/**
 * Created by Jacob on 2/5/16.
 */
public class Measurement {
    public int rejectedJobs;
    public int totalJobs;
    public int totalWaitTime;
    public int totalProcessingTime;
    private final int TOTALMEMORY = 1800;
    private final int SMALLESTJOB = 50;

    public Measurement(){
        this.rejectedJobs = 0;
        this.totalJobs = 0;
        this.totalWaitTime = 0;
        this.totalProcessingTime = 0;
    }
    public int getAvgWait(){
        return totalWaitTime/totalJobs;
    }
    public int getAvgProcessing(){
        return totalProcessingTime/totalJobs;
    }
    public int getAvgTurnaround(){
        return (getAvgProcessing() + getAvgWait());
    }
    public int getStorageUtilization(){
        ArrayList<Block> memory = StorageStrategy.getMemory();
        int spaceOccupied = 0;
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).occupied){
                spaceOccupied += memory.get(i).size;
            }
        }
        return (int)(((double)spaceOccupied/(double)TOTALMEMORY)*100);
    }
    public int getExternalFragmentation(){
        ArrayList<Block> memory = StorageStrategy.getMemory();
        int fragmentation = 0;
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).size < SMALLESTJOB){
                fragmentation += memory.get(i).size;
            }
        }
        return fragmentation;
    }
    public int getAvgHoleSize(){
        ArrayList<Block> memory = StorageStrategy.getMemory();
        return (TOTALMEMORY/memory.size());
    }
    //For printing stats at 1000VTU intervals
    public void output1000(){
        System.out.println("Rejected Jobs:\t" + rejectedJobs);
        output100();
    }
    //For printing stats at 100VTU intervals
    public void output100(){
        System.out.println("Storage Utilization:\t" + getStorageUtilization() + "%" +
        "\nExternal Fragmentation:\t" + getExternalFragmentation() +
        "\nAverage Hole Size:\t" + getAvgHoleSize());
    }
    //For printing stats at 4000VTU timepoint
    public void output4000(){
        System.out.println("Printing stats for time point 4000 VTUs" +
        "\nAverage Turnaround Time:\t" + getAvgTurnaround() +
        "\nAverage Wait Time:\t" + getAvgWait() +
        "\nAverage Processing Time:\t" + getAvgProcessing());
        output1000();
    }
    //For printing stats at 5000VTU time point
    public void output5000(){
        System.out.println("Rejected Jobs:\t" + rejectedJobs);
    }
}
