package johnchatbot.task;

import java.util.ArrayList;

import johnchatbot.exception.ChatbotException;



/**
 * Represents the collection of tasks managed
 * by the chatbot.
 * Is responsible for adding, deleting, marking,
 * and displaying tasks.
 */
public class TaskList {
    private final ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>(100);
    }

    /**
     * Adds a task to the task list and displays current no. of tasks.
     * @param input Task to be added.
     */
    public void add(Task input) {
        System.out.println("Understood. Added the following Task:\n"
                + "     " + input);
        list.add(input);
        System.out.println("There are " + list.size() + " items on the list.");
    }

    /**
     * Adds a task to the task list without printing any messages.
     * @param input Task to be added.
     */
    public void silentAdd(Task input) {
        list.add(input);
    }

    /**
     * Returns the task list as an array of tasks.
     */
    public Task[] toArray() {
        return (this.list.toArray(new Task[this.list.size()]));
    }

    /**
     * Returns the number of tasks in the list.
     */
    public int size() {
        return list.size();
    }

    /**
     * Removes the task at the specified index.
     * @param index Index of task to be deleted.
     */
    public void delete(int index) {
        System.out.println("Understood. Removed the following Task:\n"
                + "     " + list.get(index));
        list.remove(index);
        System.out.println("There are now " + list.size() + " items on the list.");
    }

    /**
     * Displays every task currently on the list
     * in accordance with its string representation.
     */
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i).toString());
        }
    }

    /**
     * Marks the task at the given index as done.
     * @param index Index of task to be marked.
     */
    public void mark(int index) throws ChatbotException {
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list.get(index).mark();
        }
    }

    /**
     * Marks the task at the given index as not done.
     * @param index Index of task to be unmarked.
     */
    public void unmark(int index) throws ChatbotException {
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            list.get(index).unmark();
        }
    }

    /**
     * Returns the task at the given index.
     * @param index Index of task to be retrieved.
     */
    public Task getTask(int index) {
        return this.list.get(index);
    }


}
