package components.simulation.input;

public class PriorityValidator extends Validator{
    @Override
    public boolean Check(int creationTime, int executionTime, int priority) {
        if(priority < 0 || priority > 1)
            return false;
        return super.Check(creationTime, executionTime, priority);
    }
}
