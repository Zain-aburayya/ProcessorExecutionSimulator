package components;
import components.comparator.ByPriority;
import printer.Report;

import java.util.PriorityQueue;
public class Schedule {
    PriorityQueue<Task> priorityQueue = new PriorityQueue<>(new ByPriority());
    Processor []processors;
    Report report;
    public Report getReport() {
        return report;
    }
    public Schedule(){
        report = new Report();
    }

    public void setPriorityQueue(PriorityQueue<Task> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public void setProcessors(Processor[] processors) {
        this.processors = processors;
    }

    public void assigning(Processor p){
        Task task = priorityQueue.poll();
        assert task != null;
        p.assignTask(task);
        report.assigningReport(p , task);
    }

    public void scheduleTask(){
        if(priorityQueue.isEmpty()) {
            for(Processor p : processors) {
                p.decreaseRemSec();
                if(p.isOver())
                    report.finishingReport(p);
            }
            report.nothingToReport();
            return;
        }
        boolean assign = true;
        for(Processor p : processors){
            p.decreaseRemSec();
            if(priorityQueue.isEmpty())
                assign = false;
            if(p.isAvailable()){
                if(assign)
                    assigning(p);
            }
            else if(p.isOver()){
                report.finishingReport(p);
                if(assign)
                    assigning(p);
            }
            else{
                report.waitingReport(p);
            }
        }
        System.out.println();
    }
}
