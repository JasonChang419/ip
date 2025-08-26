public class DeadlineTask extends Task {
    String deadline;

    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (By:" + deadline + ")";
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
