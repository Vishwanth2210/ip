package arthur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for MainWindow. Provides the layout for the other controls.
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

    private Arthur arthur;

    private final Image userImage = new Image(
            this.getClass().getResourceAsStream("/images/User.png"));
    private final Image arthurImage = new Image(
            this.getClass().getResourceAsStream("/images/Arthur.png"));

    /**
     * Loads the scrollPane and welcome message upon initialisation.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(DialogBox.getAurthurDialog(new Ui().showWelcome(), arthurImage));
    }

    public void setArthur(Arthur a) {
        arthur = a;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Arthur's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = arthur.run(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getAurthurDialog(response, arthurImage)
        );
        userInput.clear();
    }
}
