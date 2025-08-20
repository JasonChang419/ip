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
            if (Objects.equals(text, "list")) {
                myList.display();
            } else {
                myList.add(text);
            }
            text = input.nextLine();
        }
        input.close();
        System.out.println(goodbye);
    }
}