package printer;
import components.Clock;
import components.Processor;
import components.Task;

import java.util.ArrayList;
import java.util.List;

public class Print implements ISummary , IReport{
    protected static final List<String> lines = new ArrayList<>();
    protected static final Clock clock = Clock.getInstance();
    protected static final String RESET = "\u001B[0m";

    public void nothingToReport(){
        String line = "-There are no tasks available to assign at this moment.";
        System.out.println(line + "\n");
    }
}
