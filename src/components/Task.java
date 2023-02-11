package components;

public class Task {
    private final int id;
    private final int creationTime;
    private final int executionTime;
    private final int priority;

    public Task(int id, int creationTime, int executionTime, int priority) {
        this.id = id;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int id() {
        return id;
    }

    public int creationTime() {
        return creationTime;
    }

    public int executionTime() {
        return executionTime;
    }

    public int priority() {
        return priority;
    }

}
