package me.feuerente.DAO;

import me.feuerente.UserSearchProperty;
import me.feuerente.entity.User;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * In memory implementation of the {@link UserDAO} interface.
 */
public class MemoryUserDAO implements UserDAO {

    private final List<User> savedUsers;
    private int nextID = 0;

    public MemoryUserDAO() {
        this.savedUsers = new LinkedList<>();
        this.nextID = 0;
    }

    @Override
    public int insertUser(User user) {
        int id = nextID;
        user.setId(id);
        savedUsers.add(user);

        System.out.println("Inserted: " + user.toString());

        calcNextID();
        return id;
    }

    /**
     * Calculate the id that will be given to the next user that is inserted.
     * <p>
     * The id is incremented every time. So ids of deleted users can not be used
     * to create a new user.
     */
    private void calcNextID() {
        this.nextID++;
    }

    @Override
    public boolean deleteUser(User user) {
        int idToDelete = user.getId();
        for (User curUser : savedUsers) {
            if (curUser.getId() == idToDelete) {
                savedUsers.remove(curUser);

                System.out.println("Deleted: " + user.toString());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findUsersByProperty(UserSearchProperty searchProperty, Object searchValue) {
        switch (searchProperty) {
            case ID:
                return findUsersById((int) searchValue);
            case FIRST_NAME:
                return findUsersByFirstName((String) searchValue);
            case LAST_NAME:
                return findUsersByLastName((String) searchValue);
            case HEIGHT:
                return findUsersByHeight((int) searchValue);
            case BIRTHDAY:
                return findUsersByBirthday((LocalDate) searchValue);
            default:
                System.err.println("Unknown search property!");
                return Collections.emptyList();
        }
    }

    private List<User> findUsersByBirthday(LocalDate birthday) {
        List<User> result = new LinkedList<>();
        for (User curUser : savedUsers) {
            if (curUser.getBirthday().equals(birthday)) {
                result.add(curUser);
            }
        }
        return result;
    }

    private List<User> findUsersByLastName(String lastName) {
        List<User> result = new LinkedList<>();
        for (User curUser : savedUsers) {
            if (curUser.getFirstName().equals(lastName)) {
                result.add(curUser);
            }
        }
        return result;
    }

    private List<User> findUsersByHeight(int height) {
        List<User> result = new LinkedList<>();
        for (User curUser : savedUsers) {
            if (curUser.getHeightInCM() == height) {
                result.add(curUser);
            }
        }
        return result;
    }

    private List<User> findUsersByFirstName(String firstName) {
        List<User> result = new LinkedList<>();
        for (User curUser : savedUsers) {
            if (curUser.getFirstName().equals(firstName)) {
                result.add(curUser);
            }
        }
        return result;
    }

    private List<User> findUsersById(int id) {
        List<User> result = new LinkedList<>();
        for (User curUser : savedUsers) {
            if (curUser.getId() == id) {
                result.add(curUser);
            }
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return new LinkedList<>(savedUsers);
    }
}
