public class EventTask extends task{
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

}
