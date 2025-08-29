package johnchatbot.task;

public class TaskListStub extends TaskList {
    Task task;


    @Override
    public void add(Task task) {
        this.task = task;
    }

    @Override
    public Task[] toArray() {
        return new TaskStub[]{(TaskStub) task};
    }

    public Task getTask() {
        return this.task;
    }
}
