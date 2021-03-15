package me.feuerente;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.feuerente.DAO.DAOFactory;
import me.feuerente.DAO.DAOFactoryType;
import me.feuerente.DAO.UserDAO;
import me.feuerente.entity.User;

import java.time.LocalDate;

/**
 * Represents the View-Model of the user view.
 */
public class UserViewModel {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final IntegerProperty heightInCM = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>();
    private final StringProperty searchQuery = new SimpleStringProperty();

    private final ObservableList<UserTableRow> userData = FXCollections.observableArrayList();
    private final ObjectProperty<UserTableRow> selectedItem;

    private final UserDAO userDAO;

    /**
     * Class constructor.
     */
    public UserViewModel() {
        DAOFactory memoryFactory = DAOFactory.getDAOFactory(DAOFactoryType.MEMORY);
        this.userDAO = memoryFactory.getUserDAO();

        this.selectedItem = new SimpleObjectProperty<>();
    }

    public void addUser() {
        User newUser = new User(getFirstName(), getLastName(), getHeightInCM(), getBirthday());
        this.userDAO.insertUser(newUser);
        showAllUsers();
    }

    public void removeUser() {
        User user = new User();
        user.setId(selectedItem.getValue().getId());
        this.userDAO.deleteUser(user);
        showAllUsers();
    }

    public void search() {
    }

    public void showAllUsers() {
        userData.clear();
        for (User user : userDAO.findAll()) {
            userData.add(new UserTableRow(user));
        }
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getHeightInCM() {
        return heightInCM.get();
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM.set(heightInCM);
    }

    public IntegerProperty heightInCMProperty() {
        return heightInCM;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getSearchQuery() {
        return searchQuery.get();
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery.set(searchQuery);
    }

    public StringProperty searchQueryProperty() {
        return searchQuery;
    }

    public ObservableList<UserTableRow> getUserData() {
        return userData;
    }

    public UserTableRow getSelectedItem() {
        return selectedItem.get();
    }

    public void setSelectedItem(UserTableRow selectedItem) {
        this.selectedItem.set(selectedItem);
    }

    public ObjectProperty<UserTableRow> selectedItemProperty() {
        return selectedItem;
    }
}
