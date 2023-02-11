package components.simulation.input;

public abstract class Validator {
    Validator nextCheck = null;
    public void setNextCheck(Validator nextValidator){
        nextCheck = nextValidator;
    }
    public boolean Check(int creationTime , int executionTime , int priority){
        return nextCheck.Check(creationTime,executionTime,priority);
    }
}
