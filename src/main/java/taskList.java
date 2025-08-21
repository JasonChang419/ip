public class taskList {
    static int count = 0;
    private final task[] list;

    public taskList() {
        this.list = new task[100];
    }

    public void add(task input) {
        System.out.println("Understood. Added the following task:\n" +
                "     " + input);
        list[count] = input;
        count += 1;
        System.out.println("There are " + count + " items on the list.");
    }

    public void display() {
        for (int i = 0; list[i] != null; i++) {
            System.out.println((i + 1) + "." + list[i].toString());
        }
    }

    public void mark(int index) throws ChatbotException{
        if (index >= count || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list[index].mark();
        }
    }

    public void unmark(int index) throws ChatbotException{
        if (index >= count || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list[index].unmark();
        }
    }

}
