package johnchatbot.chatbot;
import java.io.File;
import johnchatbot.exception.ChatbotException;
import johnchatbot.task.TaskList;
import johnchatbot.task.Task;

/**
 * The main class representing the chatbot as a whole
 * Only contains the main method for program entrypoint.
 */

public class JohnChatbot {
    /**
     * The main method for running the chatbot
     *
     * @param args Command-line arguments which are not used by the chatbot
     */
    public static void main(String[] args)  {
        TaskList tasks = new TaskList();
        Storage storage = new Storage(tasks);
        Ui ui = new Ui(tasks, storage);
        storage.loadFromFile(new File("save/save.txt"));
        Task.SystemOn();
        ui.run();
    }
}