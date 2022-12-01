
package socketchat;

import java.io.IOException;
import java.net.ServerSocket;
import link.Server;

/**
 *
 * @author Ni
 */
public class Socketchat {

    public static void main(String[] args) throws IOException {
       ServerSocket serverSocket= new ServerSocket(1234);
       Server server= new Server(serverSocket);
       server.run();
    }
    
}
