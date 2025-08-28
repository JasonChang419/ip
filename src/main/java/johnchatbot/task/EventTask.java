package johnchatbot.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {
    LocalDateTime start;
    LocalDateTime end;

    public EventTask(String name, String start, String end) {
        super(name);
        start = start.trim();
        end = end.trim();
        if (!Task.systemOn) {
            this.start = LocalDateTime.parse(start);
            this.end = LocalDateTime.parse(end);
        } else {
            this.start = LocalDateTime.parse(start,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
            this.end = LocalDateTime.parse(end,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        }

    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " +
                start.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma"))
                + " to: " +
                end.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma"))
                + ")";
    }

    @Override
    public String toSave() {
        String space = " | ";
        String completeStatus;
        if (this.isDone()) {
            completeStatus = "1";
        } else {
            completeStatus = "0";
        }
        return "E" + space +  completeStatus
                + space + super.getName()
                + space + this.start
                + space + this.end;
    }

}
