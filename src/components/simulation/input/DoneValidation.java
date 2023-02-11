package components.simulation.input;

public class DoneValidation extends Validator{
    @Override
    public boolean Check(int creationTime, int executionTime, int priority) {
        return true;
    }
}
