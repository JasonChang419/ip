package johnchatbot.chatbot;
import johnchatbot.task.TaskList;

import java.util.Objects;
import java.util.Scanner;

public class Ui {
    Scanner input = new Scanner(System.in);
    final String GOODBYE_MESSAGE = "Farewell. I look forward to our next meeting.";
    TaskList tasks;
    Storage storage;

    public Ui(TaskList tasks, Storage storage) {
        this.tasks = tasks;
        this.storage = storage;
    }

    public void run() {
        System.out.println("Hello. I am John Chatbot, the chatbot.\n"
                + "How can I help you?\n"
                + "\n");
        String text = input.nextLine().trim();
        Parser parser = new Parser(tasks);
        while (!Objects.equals(text, "bye")) {
            parser.parse(text);
            text = input.nextLine();
        }
        input.close();
        storage.saveToFile("save/save.txt");
        System.out.println(GOODBYE_MESSAGE);
    }
}
