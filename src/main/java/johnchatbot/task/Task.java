package johnchatbot.task;

/**
 * Represents a task added to the
 * task list by the user.
 */

public abstract class Task {
    private static boolean systemIsOn = false;
    private final String name;
    private boolean isDone;

    /**
     * Creates a task
     *
     * @param name Description or name of the task
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     *
     * @return Confirmation message with task details
     */
    public String mark() {
        this.isDone = true;
        if (systemIsOn) {
            return ("Nice! I've marked this Task as done:\n "
                    + this.toString());
        }
        assert this.isDone : "Task not marked successfully";
        return "";
    }

    /**
     * Marks the task as not done.
     *
     * @return Confirmation message with task details
     */
    public String unmark() {
        this.isDone = false;
        assert !this.isDone : "Task not unmarked successfully";
        return ("OK, I've marked this Task as not done yet:\n"
                + this.toString());
    }

    /**
     * Provides a string representation of the task
     * that includes whether it is done and its description/name.
     *
     * @return String representation of task
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Enables output from task operations after
     * loading of tasks into TaskList
     */
    public static void setSystemOn() {
        systemIsOn = true;
    }

    public static boolean isSystemOn() {
        return systemIsOn;
    }

    /**
     * Provides a string representation of the task
     * when saving to a file.
     *
     * @return String representation of task save format.
     */
    public abstract String toSave();


}
