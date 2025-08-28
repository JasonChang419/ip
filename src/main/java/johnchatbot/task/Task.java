package johnchatbot.task;

public abstract class Task {
    private final String name;
    private boolean done;
    public static boolean systemOn = false;

    public Task(String name){
        this.name = name;
        this.done = false;
    }

    public void mark() {
        this.done = true;
        if (systemOn) {
            System.out.println("Nice! I've marked this Task as done:");
            System.out.println(this.toString());
        }
    }

    public void unmark() {
        this.done = false;
        System.out.println("OK, I've marked this Task as not done yet:");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        if (done) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    public boolean isDone() {
        return this.done;
    }

    public String getName() {
        return this.name;
    }

    public static void SystemOn() {
        systemOn = true;
     }

    public abstract String toSave();


}
