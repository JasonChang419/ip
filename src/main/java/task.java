public class task {
    private final String name;
    private boolean done;

    public task (String name) {
        this.name = name;
        this.done = false;
    }

    public void mark() {
        this.done = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this.toString());
    }

    public void unmark() {
        this.done = false;
        System.out.println("OK, I've marked this task as not done yet:");
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


}
