package components.simulation.input;

public class CreationValidator extends Validator{
    @Override
    public boolean Check(int creationTime, int executionTime, int priority) {
        if(creationTime < 1)
            return false;
        return super.Check(creationTime, executionTime, priority);
    }
}
