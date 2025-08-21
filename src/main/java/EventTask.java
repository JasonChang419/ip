public class EventTask extends task{
    String start;
    String end;

    public EventTask(String name, String start, String end) throws ChatbotException {
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
