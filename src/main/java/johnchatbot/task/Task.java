package johnchatbot.task;

/**
 * Represents a task added to the
 * task list by the user.
 */

public abstract class Task {
    private static boolean systemOn = false;
    private final String name;
    private boolean done;

    /**
     * Creates a task
     * @param name Description or name of the task
     */
    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    /**
     * Marks the task as done.
     */
    public String mark() {
        this.done = true;
        if (systemOn) {
            return("Nice! I've marked this Task as done:\n "
                    + this.toString());
        }
        return "";
    }

    /**
     * Marks the task as not done.
     */
    public String unmark() {
        this.done = false;
        return ("OK, I've marked this Task as not done yet:\n"
        + this.toString());
    }

    /**
     * Provides a string representation of the task
     * that includes whether it is done and its description/name.
     */
    @Override
    public String toString() {
        if (done) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    public boolean isDone() {
        return this.done;
    }

    public String getName() {
        return this.name;
    }

    /**
     * systemOn is initialized as false to prevent
     * statements from being printed while storage
     * loads from the save file. After loading is complete,
     * systemOn needs to be set to true to start printing
     * statements again.
     */
    public static void setSystemOn() {
        systemOn = true;
    }

    public static boolean isSystemOn() {
        return systemOn;
    }

    /**
     * Provides a string representation of the task
     * when saving to a file.
     */
    public abstract String toSave();


}
