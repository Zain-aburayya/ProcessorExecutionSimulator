package components.simulation;
import components.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputHandler {
    int clockCycle;
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
            taskList.add(new Task(id , creationTime , executionTime , priority));
        }
        return taskList;
    }
}
