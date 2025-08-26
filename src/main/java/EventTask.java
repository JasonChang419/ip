public class EventTask extends Task {
    String start;
    String end;

    public EventTask(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + start
                + " to: " + end + ")";
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
