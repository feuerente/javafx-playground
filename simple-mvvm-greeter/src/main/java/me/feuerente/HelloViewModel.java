package me.feuerente;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents the view-model for the hello view.
 */
public class HelloViewModel {

    private final GreetingModel greetingModel;

    StringProperty userName = new SimpleStringProperty();
    StringProperty greetingText = new SimpleStringProperty();

    public HelloViewModel() {
        this.greetingModel = new GreetingModel();
    }

    public void greetUser() {
        updateGreetingModel();
        updateGreetingDisplay();
    }

    private void updateGreetingDisplay() {
        greetingTextProperty().setValue(greetingModel.getGreeting());
    }

    private void updateGreetingModel() {
        if (userName.isNotEmpty().get()) {
            greetingModel.generateGreetingByName(userName.get());
        } else {
            greetingModel.generateGreeting();
        }
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public String getGreetingText() {
        return greetingText.get();
    }

    public void setGreetingText(String greetingText) {
        this.greetingText.set(greetingText);
    }

    public StringProperty greetingTextProperty() {
        return greetingText;
    }
}
