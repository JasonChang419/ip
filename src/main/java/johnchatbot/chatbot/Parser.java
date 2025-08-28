package johnchatbot.chatbot;
import java.util.Arrays;
import java.util.Scanner;

import johnchatbot.exception.ChatbotException;
import johnchatbot.task.EventTask;
import johnchatbot.task.TaskList;
import johnchatbot.task.ToDoTask;
import johnchatbot.task.DeadlineTask;


public class Parser {
    TaskList tasks;
    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    public void parse(String text) {
        try {
            String[] inputArray = text.split(" ", 2);
            switch (inputArray[0]) {
                case "": {
                    throw new ChatbotException("Please enter something.");
                }

                case "list": {
                    tasks.display();
                    break;
                }

                case "mark": {
                    tasks.mark(Integer.parseInt(inputArray[1]) - 1);
                    break;
                }

                case "unmark": {
                    tasks.unmark(Integer.parseInt(inputArray[1]) - 1);
                    break;
                }

                case "delete": {
                    tasks.delete(Integer.parseInt(inputArray[1]) - 1);
                    break;
                }

                case "todo": {
                    if (inputArray.length == 1) {
                        throw new ChatbotException("Sorry, the description of a todo cannot be empty.");
                    } else {
                        tasks.add(new ToDoTask(inputArray[1]));
                        break;
                    }
                }

                case "deadline": {
                    if (inputArray.length == 1) {  //ensure that a description exists
                        throw new ChatbotException("Sorry, the description of a deadline cannot be empty.");
                    } else {
                        String[] substring = inputArray[1].split("/by ", 2);
                        if (substring.length == 1) { //ensure a deadline exists
                            throw new ChatbotException("Please enter a deadline.");
                        } else {
                            String description = substring[0];
                            String date = substring[1];
                            tasks.add(new DeadlineTask(description, date));
                            break;
                        }

                    }

                }

                case "event": {
                    if (inputArray.length == 1) {  //ensure that a description exists
                        throw new ChatbotException("Sorry, the description of an event cannot be empty.");
                    } else {
                        String[] substring = inputArray[1].split("/", 3);
                        if (substring.length != 3) { //ensure that both a start and end time exists
                            throw new ChatbotException("Start or end is missing");
                        } else {
                            String description = substring[0];
                            String start = substring[1].substring(5);
                            String end = substring[2].substring(3);
                            tasks.add(new EventTask(description, start, end));
                            break;
                        }

                    }

                }
                default:
                    throw new ChatbotException("I'm afraid I do not understand what that means.");
            }
        } catch (ChatbotException e) {
            System.out.println(e);
        }
    }


}
