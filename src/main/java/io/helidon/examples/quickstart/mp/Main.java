package io.helidon.examples.quickstart.mp;

import java.io.IOException;
import java.util.logging.LogManager;

import io.helidon.microprofile.server.Server;

/**
 * Main method simulating trigger of main method of the server.
 */
public final class Main {

    /**
     * Cannot be instantiated.
     */
    private Main() { }

    /**
     * Application main entry point.
     * @param args command line arguments
     * @throws IOException if there are problems reading logging properties
     */
    public static void main(final String[] args) throws IOException {
        setupLogging();

        Server server = startServer();

        System.out.println("http://localhost:" + server.port() + "/greet");
    }

    /**
     * Start the server.
     * @return the created {@link Server} instance
     */
    static Server startServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        // and Application classes annotated as @ApplicationScoped
        return Server.create().start();
    }

    /**
     * Configure logging from logging.properties file.
     */
    private static void setupLogging() throws IOException {
        // load logging configuration
        LogManager.getLogManager().readConfiguration(
                Main.class.getResourceAsStream("/logging.properties"));
    }
}
