public class EventTask extends task{

    public EventTask(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[E] " + super.toString();
    }

}
