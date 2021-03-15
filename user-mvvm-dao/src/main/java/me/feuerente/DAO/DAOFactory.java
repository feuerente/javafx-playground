package me.feuerente.DAO;

/**
 * This class creates specific DAOFactories.
 */
public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(DAOFactoryType factoryType) {
        switch (factoryType) {
            case MEMORY:
                return new MemoryDAOFactory();
            default:
                return new MemoryDAOFactory();
        }
    }

    public abstract UserDAO getUserDAO();
}
