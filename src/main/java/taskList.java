public class taskList {
    static int count = 0;
    private task[] list;

    public taskList() {
        this.list = new task[100];
    }

    public void add(task input) {
        System.out.println("added: " + input);
        list[count] = input;
        count += 1;
    }

    public void display() {
        for (int i = 0; list[i] != null; i++) {
            System.out.println((i + 1) + "." + list[i].toString());
        }
    }

    public void mark(int index) {
        list[index].mark();
    }

    public void unmark(int index) {
        list[index].unmark();
    }

}
