package johnchatbot.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that has a description, a start time,
 * and an end time.
 */
public class EventTask extends Task {
    private final LocalDateTime start;
    private final LocalDateTime end;

    /**
     * Creates an event task, which has a description, a start time,
     * and an end time.
     * @param name Description or name of the task
     * @param start When the event is to start, should be in
     *                 the form YYYY-MM-DD HHmm.
     * @param end When the event is to end, should be in
     *            the form YYYY-MM-DD HHmm.
     */
    public EventTask(String name, String start, String end) {
        super(name);
        start = start.trim();
        end = end.trim();
        if (!Task.isSystemOn()) {
            this.start = LocalDateTime.parse(start);
            this.end = LocalDateTime.parse(end);
        } else {
            this.start = LocalDateTime.parse(start,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
            this.end = LocalDateTime.parse(end,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        }

    }

    /**
     * Provides a string representation of the task
     * that is specific to an event task.
     *
     * @return String representation of task
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: "
                + start.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma"))
                + " to: "
                + end.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma"))
                + ")";
    }

    /**
     * Provides a string representation of the task
     * when saving to a file that is specific to an
     * event task.
     *
     * @return String representation of task save format.
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
        return "E" + space + completeStatus
                + space + super.getName()
                + space + this.start
                + space + this.end;
    }

}
