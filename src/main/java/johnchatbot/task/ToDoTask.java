package johnchatbot.task;

public class ToDoTask extends Task {
    public ToDoTask(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
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
        return "T" + space +  completeStatus
                + space + super.getName();
    }
}


