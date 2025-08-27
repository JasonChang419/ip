import java.io.File;

public class JohnChatbot {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        Storage storage = new Storage(tasks);
        Ui ui = new Ui(tasks, storage);
        try {
            storage.loadFromFile(new File("./save.txt"));
        } catch (ChatbotException e) {
            throw new RuntimeException(e);
        }
        Task.SystemOn();
        ui.run();
    }
}