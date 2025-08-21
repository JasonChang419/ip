import java.util.Objects;
import java.util.Scanner;

public class JohnChatbot {
    public static void main(String[] args) {
        taskList myList = new taskList();
        Scanner input = new Scanner(System.in);
        String goodbye = "Farewell. I look forward to our next meeting.";
        System.out.println("Hello. I am John Chatbot.\n"
                + "How can I help you?\n"
                + "\n");
        String text = input.nextLine();
        while (!Objects.equals(text, "bye")) {
            try {
                String[] words = text.split(" ", 2);
                switch (words[0]) {
                    case "" : {
                        throw new ChatbotException("Entry cannot be empty");
                    }
                    case "list": {
                        myList.display();
                        break;
                    }

                    case "mark": {
                        myList.mark(Integer.parseInt(words[1]) - 1);
                        break;
                    }

                    case "unmark": {
                        myList.unmark(Integer.parseInt(words[1]) - 1);
                        break;
                    }

                    case "todo": {
                        myList.add(new ToDoTask(text));
                        break;
                    }

                    case "deadline": {
                        String[] substring = text.split("/by" , 2);
                        String description = substring[0];
                        String date = substring[1];
                        myList.add(new DeadlineTask(description, date));
                        break;
                    }

                    case "event": {
                        String[] substring = text.split("/", 3);
                        String description = substring[0];
                        String start = substring[1].substring(5);
                        String end = substring[2].substring(3);
                        myList.add(new EventTask(description, start, end));
                        break;
                    }
                    default:
                        throw new ChatbotException("I'm afraid I do not understand what that means.");
                }
                text = input.nextLine();
            } catch (ChatbotException e) {
                System.out.println(e);
                text = input.nextLine();
            }
        }
        input.close();
        System.out.println(goodbye);
    }
}