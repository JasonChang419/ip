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
    Parser parser;

    public JohnChatbot() {
        this.tasks = new TaskList();
        this.storage = new Storage(tasks);
        storage.loadFromFile(new File("save/save.txt"));
        Task.setSystemOn();
        this.parser = new Parser(tasks);
    }


    public String getResponse(String input) {
        assert parser != null : "No parser object";
        assert storage != null : "No storage object";
        if (Objects.equals(input, "bye")) {
            this.parser.setBye();
            System.out.println("Checkpoint");
            String saveMessage  = storage.saveToFile("save/save.txt");
            assert Objects.equals(saveMessage, "Save complete") : "Save failed";
            return(saveMessage + " \n" + GOODBYE_MESSAGE);
        }
        return parser.parse(input);
    }

    public String getCommandType() {
        return this.parser.getCommandType();
    }
}
