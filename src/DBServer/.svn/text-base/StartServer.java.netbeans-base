/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBServer;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.messaging.*;
import java.util.GregorianCalendar;
/**
 *
 * @author alos
 */
public class StartServer implements ServerConfiguration, MessageRecipient {
 
    /**
     * setting the value to true denotes that the server should be closed
     */
    private boolean stop = false;

    /**
     * starts a db4o server using the configuration from
     * {@link ServerConfiguration}.
     */
    public static void main(String[] args) {
        new StartServer().runServer();
    }

    /**
     * opens the ObjectServer, and waits forever until close() is called
     * or a StopServer message is being received.
     */
    private void runServer() {
        synchronized (this) {
             Configuration config = Db4o.newConfiguration();
            config.objectClass(GregorianCalendar.class).storeTransientFields(true);
            ObjectServer db4oServer = Db4o.openServer(config,FILE, PORT);
            db4oServer.grantAccess(USER, PASS);
            // Using the messaging functionality to redirect all
            // messages to this.processMessage
            db4oServer.ext().configure().clientServer().setMessageRecipient(this);
            

            // to identify the thread in a debugger
            Thread.currentThread().setName(this.getClass().getName());

            // We only need low priority since the db4o server has
            // it's own thread.
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            try {
                if (!stop) {
                    // wait forever for notify() from close()
                    this.wait(Long.MAX_VALUE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            db4oServer.close();
        }
    }//end of run server

     public void processMessage(MessageContext context, Object message) {
        if (message instanceof StopServer) {
            close();
        }
    }

    /**
     * closes this server.
     */
    public void close() {
        synchronized (this) {
            stop = true;
            this.notify();
        }
    }
}
