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
    public String add(Task input) {
        list.add(input);
        return("Understood. Added the following Task:\n"
                + "     " + input.toString() + "\n"
                + "There are " + list.size() + " items on the list.");
    }

    /**
     * Adds a task to the task list without printing any messages.
     * @param input Task to be added.
     */
    public String silentAdd(Task input) {
        list.add(input);
        return "";
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
    public String delete(int index) {
        Task removed = list.get(index);
        list.remove(index);
        return("Understood. Removed the following Task:\n"
                + "     " + removed.toString() + "\n"
                + "There are now " + list.size() + " items on the list.");
    }

    /**
     * Displays every task currently on the list
     * in accordance with its string representation.
     */
    public String display() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            output.append((i + 1) + "." + list.get(i).toString() + "\n");
        }
        return output.toString();
    }

    /**
     * Marks the task at the given index as done.
     * @param index Index of task to be marked.
     */
    public String mark(int index) throws ChatbotException {
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            return list.get(index).mark();
        }
    }

    /**
     * Marks the task at the given index as not done.
     * @param index Index of task to be unmarked.
     */
    public String unmark(int index) throws ChatbotException {
        if (index >= list.size() || index < 0) {
            throw new ChatbotException("That entry does not exist.");
        } else {
            return list.get(index).unmark();
        }
    }

    /**
     * Returns the task at the given index.
     * @param index Index of task to be retrieved.
     */
    public Task getTask(int index) {
        return this.list.get(index);
    }

    /**
     * Searches the task list for all tasks that contain
     * the specified keyword.
     * @param keyword Keyword to search for in task names.
     */
    public String findTasks(String keyword) {
        StringBuilder output = new StringBuilder();
        output.append("Here are the tasks that contain that keyword: \n");
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Task current = list.get(i);
            String name = current.getName();
            if (name.contains(keyword)) {
                output.append((i + 1)).append(". ").append(current.toString()).append("\n");
                count++;
            }
        }
        if (count == 0) {
            output.append("Unfortunately, there are no tasks "
                    + "that contain that keyword.");
        }
        return output.toString();
    }


}
