package components.simulation;

import components.*;
import components.comparator.ByCreation;
import components.comparator.ByPriority;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.PriorityQueue;

public class Simulator {
    private PriorityQueue<Task> creationTasks;
    private PriorityQueue<Task> priorityTasks;
    private Processor[]processors;
    private Clock clock;
    private final InputHandler input;

    public Simulator() throws FileNotFoundException {
        input = InputHandler.getInstance();
        intiClock();
        intiProcessor();
        intiTask();
    }

    public void intiProcessor(){
        input.collectProcessorInput();
        processors = new Processor[input.numOfProcessors];
        for(int i = 1; i <= input.numOfProcessors ; i++){
            processors[i-1] = new Processor(i);
        }
    }
    public void intiClock(){
        clock = Clock.getInstance();
        input.collectClockInput();
        clock.setAllDuration(input.clockCycle);
    }
    public void intiTask() throws FileNotFoundException {
        List<Task> taskList = input.collectTaskInput();
        creationTasks = new PriorityQueue<>(new ByCreation());
        creationTasks.addAll(taskList);
    }

    public void run() throws InterruptedException {
        System.out.println("\nRunning...\n");
        priorityTasks = new PriorityQueue<>(new ByPriority());
        Schedule schedule = new Schedule();
        schedule.setProcessors(processors);
        while(!clock.isOver()){
            findPriorityTasks();
            schedule.setPriorityQueue(priorityTasks);
            System.out.println("\t============== at second " + clock.getCurrentSecond() + " ============");
            schedule.scheduleTask();
            clock.tick();
        }
        schedule.getReport().printSummary();
    }

    public void findPriorityTasks(){
        for(int i = 0 ; i < creationTasks.size() ; i++){
            if(creationTasks.peek().creationTime() == clock.getCurrentSecond()){
                priorityTasks.add(creationTasks.poll());
            }
        }
    }

}
