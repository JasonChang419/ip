package johnchatbot.task;


/**
 * Represents a task that only has a description
 */
public class ToDoTask extends Task {

    /**
     * Creates a to do task, which only has a description
     * @param name Description or name of the task
     */
    public ToDoTask(String name) {
        super(name);
    }

    /**
     * Provides a string representation of the task
     * that is specific to a to do task.
     */
    @Override
    public String toString() {
        return "[T] " + super.toString();
    }

    /**
     * Provides a string representation of the task
     * when saving to a file that is specific to a
     * to do task.
     */
    @Override
    public String toSave() {
        String space = " | ";
        String completeStatus;
        if (this.isDone()) {
            completeStatus = "1";
        } else {
            completeStatus = "0";
        }
        return "T" + space + completeStatus
                + space + super.getName();
    }
}


