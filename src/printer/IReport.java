package printer;

import components.Processor;
import components.Task;

public interface IReport {
    default public void assigningReport(Processor processor , Task task ){
        String green = "\u001B[32m";
        String line = green + "-The task with id -> " + task.id() +
                ", has been assigned to the processor with id -> " + processor.getId();
        Print.lines.add(Print.RESET + line + ", at " +Print.clock.getCurrentSecond() + "s ." + green);
        line += ", the processor isn't available right now!." + Print.RESET;
        System.out.println(line);
    }
    default public void finishingReport(Processor processor){
        String orange = "\u001B[38;5;208m";
        String line =  orange + "-The processor with id -> " + processor.getId() + " is now available " +
                "after completing the task with id -> " + processor.getPreviousTask().id() + Print.RESET;
        System.out.println(line);
    }
    default public void waitingReport(Processor processor){
        String red = "\u001B[31m";
        String line = red + "-The processor with id -> " + processor.getId() + " is still not available as it" +
                " is still working on the task with id -> " + processor.getTask().id() + Print.RESET;
        System.out.println(line);
    }

    void nothingToReport();

}
