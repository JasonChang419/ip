package johnchatbot.chatbot;

import johnchatbot.exception.ChatbotException;
import johnchatbot.task.DeadlineTask;
import johnchatbot.task.EventTask;
import johnchatbot.task.Task;
import johnchatbot.task.TaskList;
import johnchatbot.task.ToDoTask;

/**
 * Represents the text parser which recognizes specific
 * inputs from the user to carry out various commands
 */
public class Parser {
    static final String helpMessage = "Hello. This is John Chatbot, the task manager chatbot.\n"
            + "I currently support the following tasks:\n"
            + "-todo {description}: adds a task with a brief description/name\n"
            + "-deadline {/by YYYY-MM-DD}: adds a task with a dated deadline\n"
            + "-event {/from YYYY-MM-DD HHmm /to YYYY-MM-DD HHmm}: adds a task with"
            + " a starting and ending date and time\n"
            + "-mark {index}: marks the task at the given index as done\n"
            + "-unmark {index}: marks the task at the given index as not done\n"
            + "-delete {index}: removes the task at the given index\n"
            + "-list: lists all tasks currently on the task list\n"
            + "-find {keyword}: displays all tasks that contain the specified keyword\n"
            + "-help: brings up this help message";
    private final TaskList tasks;
    private String commandType;

    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * This method is how the chatbot parses string inputs entered
     * into the chatbot.
     * Currently, supports the following commands:
     * -todo {description}: adds a task with a brief description/name
     * -deadline {/by YYYY-MM-DD}: adds a task with a dated deadline
     * -event {/from YYYY-MM-DD HHmm /to YYYY-MM-DD HHmm}: adds a task with
     * a starting and ending date and time
     * -mark {index}: marks the task at the given index as done
     * -unmark {index}: marks the task at the given index as not done
     * -delete {index}: removes the task at the given index
     * -list: lists all tasks currently on the task list
     * -find {keyword}: displays all tasks that contain the specified keyword
     *
     * @param text String that is inputted by the user to be parsed
     */
    public String parse(String text) {
        Task.setSystemOn();
        assert this.tasks != null : "Task List must be initialized";
        try {
            String[] inputArray = text.split(" ", 2);
            this.commandType = inputArray[0];
            switch (commandType) {
            case "": {
                throw new ChatbotException("Please enter something.");
            }
            case "list": {
                return tasks.display();
            }
            case "mark": {
                return tasks.mark(Integer.parseInt(inputArray[1]) - 1);
            }
            case "unmark": {
                return tasks.unmark(Integer.parseInt(inputArray[1]) - 1);
            }
            case "delete": {
                return tasks.delete(Integer.parseInt(inputArray[1]) - 1);
            }
            case "todo": {
                return handleTodo(inputArray);
            }
            case "deadline": {
                return handleDeadline(inputArray);
            }
            case "event": {
                return handleEvent(inputArray);
            }
            case "find": {
                return handleFind(inputArray, text);
            }
            case "help": {
                return helpMessage;
            }
            default:
                throw new ChatbotException("I'm afraid I do not understand what that means.");
            }
        } catch (ChatbotException e) {
            return e.getMessage();
        }
    }

    /**
     * This method returns the first word from the latest
     * input that represents the type of command
     */

    public String getCommandType() {
        return this.commandType;
    }

    private String handleTodo(String[] inputArray) throws ChatbotException {
        if (inputArray.length == 1) {
            throw new ChatbotException("Sorry, the description of a todo cannot be empty.");
        } else {
            return tasks.add(new ToDoTask(inputArray[1]));
        }
    }

    private String handleDeadline(String[] inputArray) throws ChatbotException {
        if (inputArray.length == 1) { //ensure that a description exists
            throw new ChatbotException("Sorry, the description of a deadline cannot be empty.");
        }
        String[] substring = inputArray[1].split("/by ", 2);
        if (substring.length == 1) { //ensure a deadline exists
            throw new ChatbotException("Please enter a deadline.");
        }
        String description = substring[0];
        String date = substring[1];
        return tasks.add(new DeadlineTask(description, date));
    }

    private String handleEvent(String[] inputArray) throws ChatbotException {
        //ensure that a description exists
        if (inputArray.length == 1) {
            throw new ChatbotException("Sorry, the description of an event cannot be empty.");
        }
        String[] substring = inputArray[1].split("/", 3);
        //ensure that both a start and end time exists
        if (substring.length != 3) {
            throw new ChatbotException("Start or end is missing");
        }
        String description = substring[0];
        String start = substring[1].substring(5);
        String end = substring[2].substring(3);
        return tasks.add(new EventTask(description, start, end));
    }

    private String handleFind(String[] inputArray, String text) throws ChatbotException {
        if (inputArray.length == 1) {
            throw new ChatbotException("Please enter a keyword to search for.");
        } else {
            String keyword = text.substring(5);
            return tasks.findTasks(keyword);
        }
    }
    public void setBye() {
        this.commandType = "bye";
    }
}
