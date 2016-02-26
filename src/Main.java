public class Main {

    public static Timer time = new Timer();
    public static BestFitStorage bestFit;
    public static FirstFitStorage firstFit;
    public static WorstFitStorage worstFit;

    public static void main(String[] args) {
        if (args[0].equals("b")) {
            bestFit = new BestFitStorage();
            bestFit.startComputer();
        } else if (args[0].equals("f")) {
            firstFit = new FirstFitStorage();
            firstFit.startComputer();
        } else if (args[0].equals("w")) {
            worstFit = new WorstFitStorage();
            worstFit.startComputer();
        } else {
            System.out.println("How to use program.");
        }
    }
        //int jobNumber = 0;
        //Queue<Job> readyQueue = new LinkedList<Job>();
//        Job firstJob = Job.randJob();
//        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
//        while (time.currentTime <= 5000) {
//            Job upcomingJob = Job.randJob();
//            int largestBlockSize = test.getLargestBlock().size;
//            //Checks that there is any possible block to place a job, checks if job was originated before the last event, & checks if any jobs are waiting for a block to empty its program.
//            //This will need to be dependent upon memory allocation procedure since some jobs will be ejected based upon how memory is filled while those same jobs will fit in others.
//            while(upcomingJob.size <= largestBlockSize && (upcomingJob.toa + time.previousTime) <= time.currentTime && readyQueue.peek() != null){
//                //Increments time before latest event
//                time.incrementPrevTime(upcomingJob.toa);
//                try {
//                    readyQueue.add(upcomingJob);
//                }catch(ConcurrentModificationException e){
//                    System.out.println("ConcurrentModificationException whatever that means.");
//                }
//                if(upcomingJob.size > test.getLargestOpenBlock().size){
//                    break;
//                }
//                upcomingJob = Job.randJob();
//            }
//            if(readyQueue.peek() != null){
//                readyQueue = processReadyQueue(readyQueue);
//            }
//            //time.returnToPresent();
//            //jobNumber++;
//            //addJobToMemory(upcomingJob);
//            //time.incrementCurrentTime(firstJob.duration);
//        }
//    public static Queue<Job> processReadyQueue(Queue<Job> input){
//        while(input.peek() != null && input.peek().size <= test.getLargestOpenBlock().size){
//            test.addJob(input.poll());
//        }
//       return input;
//    }
}
