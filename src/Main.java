public class Main {

    //public static Timer time = new Timer();
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
