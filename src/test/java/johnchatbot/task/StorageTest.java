package johnchatbot.task;

import johnchatbot.chatbot.Storage;
import johnchatbot.exception.ChatbotException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;


import java.io.File;

public class StorageTest {


    @Test
    public void saveToFileTest(){
        String pathName = "src/test/java/johnchatbot/save.txt";
        File path = new File(pathName);
        TaskList taskList = new TaskListStub();
        taskList.add(new TaskStub());
        Storage storage = new Storage(taskList);
        storage.saveToFile(pathName);
        Scanner scanner;
        try {
            scanner = new Scanner(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String output = scanner.nextLine();
        assertEquals("STUB | 0 | stub description",
                output);
    }
}
