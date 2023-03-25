
package pojos;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class ChatServicesImpl extends UnicastRemoteObject implements ChatServices{
    
    private final List<String> messageList = new ArrayList<>();//Creating a Message List Object

    public ChatServicesImpl()throws RemoteException {//Default Constructor
    }
    
    
    
    //The "sendMessage" method adds a message to the server's list of messages
    @Override
    public void sendMessage(String message) throws RemoteException {
        messageList.add(message);
    }

    //This "receiveMessage" Returns the first message in the list, or an empty string if the list is empty.
    @Override
    public String receiveMessage() throws RemoteException {
        if (messageList.isEmpty()) {
            return "";
        }else {
            String message = messageList.get(0);
            messageList.remove(0);
            return message;
        }
    }
    
}
