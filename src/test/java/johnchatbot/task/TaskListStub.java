package johnchatbot.task;

public class TaskListStub extends TaskList {
    Task task;


    @Override
    public String add(Task task) {
        this.task = task;
        return this.task.toString();
    }

    @Override
    public Task[] toArray() {
        return new TaskStub[]{(TaskStub) task};
    }

    public Task getTask() {
        return this.task;
    }
}
