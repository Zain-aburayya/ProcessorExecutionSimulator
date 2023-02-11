package components.comparator;

import components.Task;

import java.util.Comparator;

public class ByCreation implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.creationTime() - o2.creationTime();
    }
}
