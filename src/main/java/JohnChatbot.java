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
            String[] words = text.split(" ", 2);
            switch (words[0]) {
                case "list":
                    myList.display();
                    break;
                case "mark":
                    myList.mark(Integer.parseInt(words[1]) - 1);
                    break;
                case "unmark":
                    myList.unmark(Integer.parseInt(words[1]) - 1);
                    break;
                case "todo":
                    myList.add(new ToDoTask(text));
                    break;
                case "deadline":

                default:
                    myList.add(new task(text));
                    break;
            }
            text = input.nextLine();

        }
        input.close();
        System.out.println(goodbye);
    }
}