import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Storage {
    TaskList taskList;

    public Storage(TaskList taskList) {
        this.taskList = taskList;
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
            for (Task task : taskList.toArray()) {
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
                            taskList.silentAdd(new ToDoTask(desc));
                            break;
                        }
                        case "D": {
                            String desc = taskSave[2];
                            String deadline = taskSave[3];
                            taskList.silentAdd(new DeadlineTask(desc, deadline));
                            break;
                        }
                        case "E": {
                            String desc = taskSave[2];
                            String start = taskSave[3];
                            String end = taskSave[4];
                            taskList.silentAdd(new EventTask(desc, start, end));
                            break;
                        }
                    }
                    if (isMarked) {
                        Task[] taskArray = taskList.toArray();
                        taskArray[taskList.size() - 1].mark();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
