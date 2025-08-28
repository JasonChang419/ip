package johnchatbot.task;

import johnchatbot.exception.ChatbotException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class TaskList {
    private final ArrayList<Task> list;

    public TaskList() {

        this.list = new ArrayList<>(100);
    }

    public void add(Task input) {
        System.out.println("Understood. Added the following Task:\n" +
                "     " + input);
        list.add(input);
        System.out.println("There are " + list.size() + " items on the list.");
    }

    public void silentAdd(Task input) { //add tasks to list without printing
        list.add(input);
    }

    public Task[] toArray() {
        return (this.list.toArray(new Task[this.list.size()]));
    }

    public int size() {
        return list.size();
    }

    public void delete(int index) {
        System.out.println("Understood. Removed the following Task:\n" +
                "     " + list.get(index));
        list.remove(index);
        System.out.println("There are now " + list.size() + " items on the list.");
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i).toString());
        }
    }

    public void mark(int index) throws ChatbotException {
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
