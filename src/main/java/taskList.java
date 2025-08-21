import java.util.ArrayList;

public class taskList {
    static int count = 0;
    private final ArrayList<task> list;

    public taskList() {

        this.list = new ArrayList<>(100);
    }

    public void add(task input) {
        System.out.println("Understood. Added the following task:\n" +
                "     " + input);
        list.add(input);
        System.out.println("There are " + list.size() + " items on the list.");
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i).toString());
        }
    }

    public void mark(int index) throws ChatbotException{
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list.get(index).mark();
        }
    }

    public void unmark(int index) throws ChatbotException{
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list.get(index).unmark();
        }
    }

}
