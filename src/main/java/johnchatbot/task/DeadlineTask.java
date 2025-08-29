package johnchatbot.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Represents a task that has a description and a deadline.
 */
public class DeadlineTask extends Task {
    LocalDate deadline;

    /**
     * Creates a deadline task, which has a description and a deadline.
     * @param name Description or name of the task
     * @param deadline When the task should be completed by, should be in
     *                 the form YYYY-MM-DD.
     */
    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = LocalDate.parse(deadline);
    }

    /**
     * Provides a string representation of the task
     * that is specific to a deadline task.
     */
    @Override
    public String toString() {
        return "[D] " + super.toString() + " (By: " +
                deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /**
     * Provides a string representation of the task
     * when saving to a file that is specific to a
     * deadline task.
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
        return "D" + space +  completeStatus
                + space + super.getName()
                + space + this.deadline;
    }

}
