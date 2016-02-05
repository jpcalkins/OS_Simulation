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
    public Timer timer;

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
