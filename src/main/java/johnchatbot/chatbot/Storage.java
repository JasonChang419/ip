package johnchatbot.chatbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import johnchatbot.task.DeadlineTask;
import johnchatbot.task.EventTask;
import johnchatbot.task.Task;
import johnchatbot.task.TaskList;
import johnchatbot.task.ToDoTask;

/**
 * Represents the storage for the chatbot which
 * carries out saving and loading processes.
 */
public class Storage {
    private final TaskList taskList;

    public Storage(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Method for saving the current list of tasks to the specified
     * path. The method will attempt to save the task list to the
     * file specified by the path, or it will create a new file
     * if it does not already exist.
     *
     * @param path the relative path to the file to save the task list to
     */

    public String saveToFile(String path) {
        File save = new File(path);
        try {
            FileWriter writer = new FileWriter(path);
            if (!save.exists()) {
                save.createNewFile();
                return ("Creating new save.");
            }
            for (Task task : taskList.toArray()) {
                writer.write(task.toSave()
                        + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return("Save complete");
    }


    /**
     * Method for loading from a save file.
     * If a save file does not exist, it does nothing.
     *
     * @param save File object containing the path to the save file
     */
    public String loadFromFile(File save) {
        if (save.exists()) {
            StringBuilder output = new StringBuilder();
            output.append("Saved list detected.\n"
                    + "Loading from save." + System.lineSeparator());
            try {
                Scanner saveFile = new Scanner(save);
                while (saveFile.hasNext()) {
                    String[] taskSave = saveFile.nextLine().split(" \\| ");
                    boolean isMarked = Objects.equals(taskSave[1], "1");

                    switch (taskSave[0]) {
                    case "T": {
                        assert taskSave.length == 3 : "Failed to load todo task";
                        String desc = taskSave[2];
                        taskList.silentAdd(new ToDoTask(desc));
                        break;
                    }
                    case "D": {
                        assert taskSave.length == 4 : "Failed to load deadline task";
                        String desc = taskSave[2];
                        String deadline = taskSave[3];
                        taskList.silentAdd(new DeadlineTask(desc, deadline));
                        break;
                    }
                    case "E": {
                        assert taskSave.length == 5 : "Failed to load event task";
                        String desc = taskSave[2];
                        String start = taskSave[3];
                        String end = taskSave[4];
                        taskList.silentAdd(new EventTask(desc, start, end));
                        break;
                    }
                    default:
                    }

                    if (isMarked) {
                        Task[] taskArray = taskList.toArray();
                        assert taskArray != null && taskArray instanceof Task[]
                                : "Task List not converted to array";
                        taskArray[taskList.size() - 1].mark();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return output.toString();
        }
        return "";
    }

}
