package components;

import enumaration.AvailabilityStates;

public class Processor {
    private final int id;
    private int remainingSeconds = -1;
    private Task task = null;
    private Task previousTask = null;
    private AvailabilityStates states = AvailabilityStates.AVAILABLE;

    public int getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public Processor(int id) {
        this.id = id;
    }

    public void assignTask(Task task){
        this.task = task;
        this.remainingSeconds = task.executionTime();
        states = AvailabilityStates.UNAVAILABLE;
    }

    public void removeTask(){
        previousTask = task;
        task = null;
        states = AvailabilityStates.AVAILABLE;
        remainingSeconds = -1;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", remainingSeconds=" + remainingSeconds +
                ", task=" + task +
                ", states=" + states +
                '}';
    }
    public boolean isOver(){
        if(remainingSeconds == 0){
            removeTask();
            return true;
        }
        return false;
    }

    public void decreaseRemSec(){
        remainingSeconds -= (remainingSeconds == -1 ? 0 : 1);
    }

    public boolean isAvailable(){
        return states.equals(AvailabilityStates.AVAILABLE);
    }

    public Task getPreviousTask() {
        return previousTask;
    }

}
