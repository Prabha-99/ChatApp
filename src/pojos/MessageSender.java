
package pojos;

import Client.Client;
import Interfaces.MainInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class MessageSender implements Runnable {
    
    private final Client client;
    private final MainInterface mainInterface;

    public MessageSender(Client client, MainInterface mainInterface) {
        this.client = client;
        this.mainInterface = mainInterface;
    }

    @Override
    public void run() {
        try{
             
             Client client = new Client("");
             
             while(true){
                 String chatContent;//Local variable
                 chatContent=mainInterface.getChatField();//Storing the text which user types in the chatField
                 client.sendMessage(chatContent);//sending that content through client's 'sendMessage' method
             }
         }catch(NotBoundException | RemoteException e){
         }
    }
    
    
}
