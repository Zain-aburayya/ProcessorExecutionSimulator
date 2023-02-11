package components.simulation.input;
import components.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputHandler {
    public int getClockCycle() {
        return clockCycle;
    }

    int clockCycle;

    public int getNumOfProcessors() {
        return numOfProcessors;
    }

    int numOfProcessors;
    Scanner input = new Scanner(System.in);
    private static InputHandler instance = null;
    private InputHandler(){}
    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    public void collectClockInput(){
        System.out.println("Enter how many Clock Cycle you have : ");
        clockCycle = input.nextInt();
    }
    public void collectProcessorInput(){
        System.out.println("Enter how many processors you have : ");
        numOfProcessors = input.nextInt(); input.nextLine();
    }
    public List<Task> collectTaskInput() throws FileNotFoundException {
        System.out.println("Enter the path you need read from : ");
        String filePath = input.nextLine();
        input = new Scanner(new File(filePath));
        List<Task> taskList = new ArrayList<>();
        int numOfTask = input.nextInt();
        for(int id = 1 ; id <= numOfTask ; id++){
            int creationTime = input.nextInt();
            int executionTime = input.nextInt();
            int priority = input.nextInt();
            Validator validator_1 = new CreationValidator();
            Validator validator_2 = new ExecutionValidator();
            Validator validator_3 = new PriorityValidator();
            Validator validator_4 = new DoneValidation();
            validator_1.setNextCheck(validator_2);
            validator_2.setNextCheck(validator_3);
            validator_3.setNextCheck(validator_4);
            if(validator_1.Check(creationTime,executionTime,priority)){
                taskList.add(new Task(id , creationTime , executionTime , priority));
            }
            else{
                throw new Error("There is an error with your input..");
            }
        }
        return taskList;
    }
}
