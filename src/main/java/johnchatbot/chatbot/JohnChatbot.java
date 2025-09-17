package johnchatbot.chatbot;

import java.io.File;
import java.util.Objects;

import johnchatbot.task.Task;
import johnchatbot.task.TaskList;


/**
 * The main class representing the chatbot as a whole
 */

public class JohnChatbot {
    static final String GOODBYE_MESSAGE = "Farewell. I look forward to our next meeting.";
    //save file path as a constant suggested by ChatGPT
    static final String SAVE_FILE_PATH = "save/save.txt";
    TaskList tasks;
    Storage storage;
    Parser parser;

    public JohnChatbot() {
        this.tasks = new TaskList();
        this.storage = new Storage(tasks);
        storage.loadFromFile(new File(SAVE_FILE_PATH));
        Task.setSystemOn();
        this.parser = new Parser(tasks);
    }


    /**
     * Returns a String in response to an input String
     *
     * @param input String to be passed into parser
     * @return A String response
     */
    public String getResponse(String input) {
        assert parser != null : "No parser object";
        assert storage != null : "No storage object";
        //case insensitivity suggested by ChatGPT
        if (input.trim().equalsIgnoreCase("bye")) {
            this.parser.setBye();
            String saveMessage  = storage.saveToFile(SAVE_FILE_PATH);
            assert Objects.equals(saveMessage, "Save complete") : "Save failed";
            return(saveMessage + " \n" + GOODBYE_MESSAGE);
        }
        return parser.parse(input);
    }

    /**
     * Returns the type of the last command entered
     *
     * @return Type of command
     */
    public String getCommandType() {
        return this.parser.getCommandType();
    }
}
