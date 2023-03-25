
package pojos;

import Client.Client;
import Interfaces.MainInterface;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;


public class MessageReceiver implements Runnable {
    
    private final Client client;
    private final MainInterface mainInterface;

    public MessageReceiver(Client client, MainInterface mainInterface) {
        this.client = client;
        this.mainInterface = mainInterface;
    }
    
    

    @Override
    public void run() {
        try{
            while(true){
                String message = client.receiveMessage();
                while (!message.isEmpty()) {
                    /*Once a new message is received, the SwingUtilities.invokeLater method is used to 
                    update the chat area in the mainInterface GUI with the new message. The invokeLater 
                    method ensures that this update is executed on the Swing event dispatch thread, which 
                    is the thread responsible for updating the GUI, rather than the background thread that 
                    this loop is running on. This is necessary to avoid potential issues with thread safety 
                    and GUI responsiveness.*/
                    
                    String finalMessage = message; // make a final copy for thread safety
                    SwingUtilities.invokeLater(() -> mainInterface.setChatArea(finalMessage,mainInterface.getChatArea()));
                    message = client.receiveMessage();
            }
        }
    }   catch (RemoteException ex) {
            System.out.println("Exception in MessageReceiver: " + ex.getMessage());
        }
    
    
    }
}
