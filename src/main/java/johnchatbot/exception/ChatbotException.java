package johnchatbot.exception;

/**
 * General exception for chatbot related exceptions
 * Thrown when user attempts to input text that does
 * is not an existing command or attempts to
 * modify a task index that does not exist
 */
public class ChatbotException extends Exception {

    public ChatbotException(String message) {
        super(message);
    }
}
