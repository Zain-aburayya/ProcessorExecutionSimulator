package components;
import components.comparator.ByPriority;
import printer.Print;

import java.util.PriorityQueue;
public class Schedule {
    PriorityQueue<Task> priorityQueue = new PriorityQueue<>(new ByPriority());
    Processor []processors;
    Print print;
    public Print getPrint() {
        return print;
    }
    public Schedule(){
        print = new Print();
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
        print.assigningReport(p , task);
    }

    public void scheduleTask(){
        if(priorityQueue.isEmpty()) {
            for(Processor p : processors) {
                p.decreaseRemSec();
                if(p.isOver())
                    print.finishingReport(p);
            }
            print.nothingToReport();
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
                print.finishingReport(p);
                if(assign)
                    assigning(p);
            }
            else{
                print.waitingReport(p);
            }
        }
        System.out.println();
    }
}
