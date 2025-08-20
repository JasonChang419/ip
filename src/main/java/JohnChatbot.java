import java.util.Objects;
import java.util.Scanner;

public class JohnChatbot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String goodbye = "Farewell. I look forward to our next meeting.";
        System.out.println("Hello. I am John Chatbot.\n"
                + "How can I help you?\n"
                + "\n");
        String text = input.nextLine();
        while (!Objects.equals(text, "bye")) {
            System.out.println(text);
            text = input.nextLine();
        }

    }
}
