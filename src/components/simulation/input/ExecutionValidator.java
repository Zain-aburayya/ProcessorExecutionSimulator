package components.simulation.input;

public class ExecutionValidator extends Validator{
    @Override
    public boolean Check(int creationTime, int executionTime, int priority) {
        if(executionTime < 1)
            return false;
        return super.Check(creationTime, executionTime, priority);
    }
}
