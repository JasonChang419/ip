package johnchatbot.task;

public class TaskStub extends Task{
    public TaskStub() {
        super("stub description");
    }

    @Override
    public String toSave() {
        return "STUB | 0 | stub description";
    }
}
