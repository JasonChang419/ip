package johnchatbot.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import johnchatbot.chatbot.JohnChatbot;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.Objects;

/**
 * Controller for the main GUI.
 */

public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private JohnChatbot johnChatbot;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog("Hello. I am John Chatbot, the chatbot.\n"
                        + "How can I help you?\n"
                        + "\n", dukeImage, "")
        );
    }

    /** Injects the Duke instance */
    public void setJohnChatbot(JohnChatbot d) {
        johnChatbot = d;
    }
/*
    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = johnChatbot.getResponse(input);
        String commandType = johnChatbot.getCommandType();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage, commandType)
        );
        if (Objects.equals(input, "bye")) {
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // 5-second pause
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
        userInput.clear();
    }
}

