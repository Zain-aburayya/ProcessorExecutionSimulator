package printer;

import components.Processor;
import components.Task;

public interface IReport {
    public void assigningReport(Processor processor , Task task );
    public void finishingReport(Processor processor);
    public void waitingReport(Processor processor);

    public void nothingToReport();

}
