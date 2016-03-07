/**
 * a. Jacob Calkins
 * b. CS 4323
 * c. Simulation Project, Phase 1
 * d. Sarath Kumar Maddinani
 * e. bestFit, firstFit, and worstfit are the different memory allocation strategies and are called based upon flags passed at program startup.
 * f. Main class that starts the "computer" with the desired memory allocation strategy.
 */
public class Main {

    public static BestFitStorage bestFit;
    public static FirstFitStorage firstFit;
    public static WorstFitStorage worstFit;

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("How to use program.");
        } else if (args[0].toLowerCase().equals("b")) {
            bestFit = new BestFitStorage();
            bestFit.startComputer();
        } else if (args[0].toLowerCase().equals("f")) {
            firstFit = new FirstFitStorage();
            firstFit.startComputer();
        } else if (args[0].toLowerCase().equals("w")) {
            worstFit = new WorstFitStorage();
            worstFit.startComputer();
        } else {
            System.out.println("How to use program.");
        }
    }
}
