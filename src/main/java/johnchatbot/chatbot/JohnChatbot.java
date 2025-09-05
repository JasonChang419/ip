package johnchatbot.chatbot;

import java.io.File;
import java.util.Objects;

import johnchatbot.task.Task;
import johnchatbot.task.TaskList;


/**
 * The main class representing the chatbot as a whole
 * Only contains the main method for program entrypoint.
 */

public class JohnChatbot {
    static final String GOODBYE_MESSAGE = "Farewell. I look forward to our next meeting.";
    TaskList tasks;
    Storage storage;
    Ui ui;
    Parser parser;

    public JohnChatbot() {
        this.tasks = new TaskList();
        this.storage = new Storage(tasks);
        this.ui = new Ui(tasks, storage);
        storage.loadFromFile(new File("save/save.txt"));
        Task.setSystemOn();
        this.parser = new Parser(tasks);
    }


    public String getResponse(String input) {
        if (Objects.equals(input, "bye")) {
            String saveMessage  = storage.saveToFile("save/save.txt");
            return(saveMessage + " \n" + GOODBYE_MESSAGE);
        }
        return parser.parse(input);
    }

    public String getCommandType() {
        return this.parser.getCommandType();
    }


    /**
     * The main method for running the chatbot
     *
     * @param args Command-line arguments which are not used by the chatbot
     */
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        Storage storage = new Storage(tasks);
        Ui ui = new Ui(tasks, storage);
        storage.loadFromFile(new File("save/save.txt"));
        Task.setSystemOn();
        ui.run();
    }
}
