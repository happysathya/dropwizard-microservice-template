package org.happysathya;

import java.net.ServerSocket;

public class BaseRouteForTest {

    public static int findFreePort() {
        try {
            ServerSocket socket = new ServerSocket(0);
            int result = socket.getLocalPort();
            socket.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
