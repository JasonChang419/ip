public class taskList {
    static int count = 0;
    private task[] list;

    public taskList() {
        this.list = new task[100];
    }

    public void add(String input) {
        System.out.println("added: " + input);
        list[count] = new task(input);
        count += 1;
    }

    public void display() {
        for (int i = 0; list[i] != null; i++) {
            System.out.println(i + "." + list[i]);
        }
    }

}
