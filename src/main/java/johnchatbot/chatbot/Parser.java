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
                if (inputArray.length == 1) {
                    throw new ChatbotException("Sorry, the description of a todo cannot be empty.");
                } else {
                    return tasks.add(new ToDoTask(inputArray[1]));
                }
            }

            case "deadline": {
                if (inputArray.length == 1) { //ensure that a description exists
                    throw new ChatbotException("Sorry, the description of a deadline cannot be empty.");
                } else {
                    String[] substring = inputArray[1].split("/by ", 2);
                    if (substring.length == 1) { //ensure a deadline exists
                        throw new ChatbotException("Please enter a deadline.");
                    } else {
                        String description = substring[0];
                        String date = substring[1];
                        return tasks.add(new DeadlineTask(description, date));
                    }

                }

            }

            case "event": {
                if (inputArray.length == 1) { //ensure that a description exists
                    throw new ChatbotException("Sorry, the description of an event cannot be empty.");
                } else {
                    String[] substring = inputArray[1].split("/", 3);
                    if (substring.length != 3) { //ensure that both a start and end time exists
                        throw new ChatbotException("Start or end is missing");
                    } else {
                        String description = substring[0];
                        String start = substring[1].substring(5);
                        String end = substring[2].substring(3);
                        return tasks.add(new EventTask(description, start, end));
                    }

                }

            }

            case "find": {
                if (inputArray.length == 1) {
                    throw new ChatbotException("Please enter a keyword to search for.");
                } else {
                    String keyword = text.substring(5);
                    return tasks.findTasks(keyword);
                }
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


}
