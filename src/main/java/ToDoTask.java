public class ToDoTask extends task{
    public ToDoTask(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}


