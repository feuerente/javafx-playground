package me.feuerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the code behind the hello view.
 * The hello view consists of the FXML definition in hello.fxml, the view-model in {@link HelloViewModel}
 * and this class which binds the two together.
 */
public class HelloView implements Initializable {

    private final HelloViewModel helloViewModel;

    @FXML
    private TextField tfName;

    @FXML
    private Label lblGreeting;

    /**
     * Class constructor. Instantiates the ViewModel.
     */
    public HelloView() {
        this.helloViewModel = new HelloViewModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindViewModel();
    }

    private void bindViewModel() {
        this.tfName.textProperty().bindBidirectional(helloViewModel.userNameProperty());
        this.lblGreeting.textProperty().bind(helloViewModel.greetingTextProperty());
    }

    @FXML
    public void greetUser(ActionEvent actionEvent) {
        helloViewModel.greetUser();
    }
}
