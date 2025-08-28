package johnchatbot.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {
    LocalDate deadline;

    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = LocalDate.parse(deadline);
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (By: " +
                deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
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
        return "D" + space +  completeStatus
                + space + super.getName()
                + space + this.deadline;
    }

}
