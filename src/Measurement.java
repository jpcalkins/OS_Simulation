/**
 * Created by Jacob on 2/5/16.
 */
public class Measurement {
    public int avgTurnaround;
    public int avgWaitTime;
    public int avgProcessing;
    public int storageUtilization;
    public int fragmentation;
    public int avgHoleSize;
    public int rejectedJobs;

    public Measurement(){
        this.avgTurnaround = 0;
        this.avgWaitTime = 0;
        this.avgProcessing = 0;
        this.storageUtilization = 0;
        this.fragmentation = 0;
        this.avgHoleSize = 0;
        this.rejectedJobs = 0;
    }
    //For printing stats at 1000VTU intervals
    public void output1000(){
        System.out.println("Rejected Jobs:\t" + rejectedJobs);
        output100();
    }
    //For printing stats at 100VTU intervals
    public void output100(){
        System.out.println("Storage Utilization:\t" + storageUtilization +
        "\nExternal Fragmentation:\t" + fragmentation +
        "\nAverage Hole Size:\t" + avgHoleSize);
    }
    //For printing stats at 4000VTU timepoint
    public void output4000(){
        System.out.println("Average Turnaround Time:\t" + avgTurnaround +
        "\nWaiting Time:\t" + avgWaitTime +
        "\nAverage Processing Time:\t" + avgProcessing);
    }

    public int getAvgTurnaround() {
        return avgTurnaround;
    }

    public int getAvgWaitTime() {
        return avgWaitTime;
    }

    public int getAvgProcessing() {
        return avgProcessing;
    }

    public int getStorageUtilization() {
        return storageUtilization;
    }

    public int getFragmentation() {
        return fragmentation;
    }

    public int getAvgHoleSize() {
        return avgHoleSize;
    }

    public int getRejectedJobs() {
        return rejectedJobs;
    }
}
