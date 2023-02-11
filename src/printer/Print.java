package printer;
import components.Clock;
import components.Processor;
import components.Task;

import java.util.ArrayList;
import java.util.List;

public class Print implements ISummary , IReport{
    private String line;
    private final List<String> lines = new ArrayList<>();
    private final Clock clock = Clock.getInstance();

    private static final String RESET = "\u001B[0m";

    public void assigningReport(Processor processor , Task task ){
        String green = "\u001B[32m";
        line = green + "-The task with id -> " + task.id() +
                ", has been assigned to the processor with id -> " + processor.getId();
        lines.add(RESET + line + ", at " + clock.getCurrentSecond() + "s ." + green);
        line += ", the processor isn't available right now!." + RESET;
        System.out.println(line);
    }

    public void waitingReport(Processor processor){
        String red = "\u001B[31m";
        line = red + "-The processor with id -> " + processor.getId() + " is still not available as it" +
                " is still working on the task with id -> " + processor.getTask().id() + RESET;
        System.out.println(line);
    }

    public void finishingReport(Processor processor){
        String orange = "\u001B[38;5;208m";
        line =  orange + "-The processor with id -> " + processor.getId() + " is now available " +
                "after completing the task with id -> " + processor.getPreviousTask().id() + RESET;
        System.out.println(line);
    }

    public void nothingToReport(){
        line = "-There are no tasks available to assign at this moment.";
        System.out.println(line + "\n");
    }

    public void printSummary(){
        System.out.println("\t============== At the end  ==============");
        String cyan = "\u001B[36m";
        System.out.println(cyan + "-This is a clear and concise summary of the simulation" +
                "\nresults. The focus on the creation of every task and its assigned" +
                "\nprocessor will help you better understand the behavior of the CPU" +
                "\nduring the simulation.\n" + RESET);
        for(String s : lines){
            System.out.println(s);
        }
    }
}
