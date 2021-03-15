package me.feuerente.DAO;

import me.feuerente.UserSearchProperty;
import me.feuerente.entity.User;

import java.util.List;

/**
 * Interface that all UserDAOs must support.
 */
public interface UserDAO {

    /**
     * Insert User.
     *
     * @param user the User to be inserted
     * @return the ID of the newly created User; -1 if the User can't be created
     */
    int insertUser(User user);

    /**
     * Delete User.
     *
     * @param user the User to be deleted
     * @return true on successful deletion of the User; -1 otherwise
     */
    boolean deleteUser(User user);

    /**
     * Find Users who have a matching value in the property used for the search.
     *
     * @param searchProperty the property used for finding matching Users
     * @param searchValue    the Value matching Users must have is the property used for the search
     * @return a list of Users whe match the search criteria; an empty List if no matching Users are found
     */
    List<User> findUsersByProperty(UserSearchProperty searchProperty, Object searchValue);

    /**
     * Gets all Users.
     *
     * @return a list of all Users
     */
    List<User> findAll();
}
