package components.comparator;

import components.Task;

import java.util.Comparator;

public class ByPriority implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if(o1.priority() > o2.priority())
            return -1;
        if(o1.priority() < o2.priority())
            return 1;
        return o2.executionTime() - o1.executionTime();
    }
}
