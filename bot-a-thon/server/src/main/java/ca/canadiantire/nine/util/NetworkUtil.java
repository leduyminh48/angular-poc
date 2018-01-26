package ca.canadiantire.nine.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * @author Victor Letunovsky
 */
public final class NetworkUtil {

    private static final String LOCAL_HOST = "127.0.0.1";

    private static final String DEFAULT_PORT = "8080";

    /**
     * Prevent this class instantiation.
     */
    private NetworkUtil() {
    }

    public static String getHostname() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            return LOCAL_HOST;
        }
    }

    public static String getPort() {
        return Optional.ofNullable(System.getProperty("server.port")).orElse(DEFAULT_PORT);
    }
}
