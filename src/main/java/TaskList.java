import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
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

    public void saveToFile() {
        String path = "./save.txt";
        File save = new File(path);
        try {
            FileWriter writer = new FileWriter(path);
            if (!save.exists()) {
                System.out.println("Creating new save.");
                save.createNewFile();
            }
            for (Task task : list) {
                writer.write(task.toSave()
                        + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Save complete");
    }

    public void loadFromFile(File save) throws ChatbotException {
        if (save.exists()) {
            System.out.println("Saved list detected.\n" +
                    "Loading from save." + System.lineSeparator());
            try {
                Scanner saveFile = new Scanner(save);
                while (saveFile.hasNext()) {
                    String[] taskSave = saveFile.nextLine().split(" \\| ");
                    boolean isMarked = Objects.equals(taskSave[1], "1");
                    switch(taskSave[0]) {
                        case "T": {
                            String desc = taskSave[2];
                            list.add(new ToDoTask(desc));
                            break;
                        }
                        case "D": {
                            String desc = taskSave[2];
                            String deadline = taskSave[3];
                            list.add(new DeadlineTask(desc, deadline));
                            break;
                        }
                        case "E": {
                            String desc = taskSave[2];
                            String start = taskSave[3];
                            String end = taskSave[4];
                            list.add(new EventTask(desc, start, end));
                            break;
                        }
                    }
                    if (isMarked) {
                        list.get(list.size() - 1).mark();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
