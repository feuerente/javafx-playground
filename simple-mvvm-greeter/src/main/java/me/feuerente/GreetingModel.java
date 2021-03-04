package me.feuerente;

/**
 * This class represents a greeting.
 */
public class GreetingModel {

    private String greeting;

    /**
     * Class constructor.
     */
    public GreetingModel() {
        greeting = "Hello!";
    }

    /**
     * Creates a greeting using a specified name.
     *
     * @param name the name to be used in the greeting
     */
    public void generateGreetingByName(final String name) {
        greeting = "Hello " + name + "!";
    }

    /**
     * Creates a greeting.
     */
    public void generateGreeting() {
        greeting = "Hello!";
    }

    /**
     * Returns the greeting.
     *
     * @return the current greeting
     */
    public String getGreeting() {
        return greeting;
    }
}
