package me.mohamadtofigh.combosystem.utils.connection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Connection {
    public static boolean isInternetAvailable() {
        try {
            Socket socket = new Socket();
            boolean bool;
            try {
                socket.connect(new InetSocketAddress("google.com", 80), 3000);
                bool = true;
            } catch (Throwable t) {
                try {
                    socket.close();
                } catch (Throwable th) {
                    t.addSuppressed(th);
                }
                throw t;
            }
            socket.close();
            return bool;
        } catch (IOException var0) {
            return false;
        }
    }
}
