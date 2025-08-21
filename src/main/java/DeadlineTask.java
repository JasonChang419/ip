public class DeadlineTask extends task{
    String deadline;

    public DeadlineTask(String name, String deadline) throws ChatbotException {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (By:" + deadline + ")";
    }
}
