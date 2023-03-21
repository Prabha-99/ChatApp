/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subscrib;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HANSANI
 */
public class chat {
      private List<User> subscribers;

    public chat() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public void notifyAllSubscribers(String message) {
        for (User user : subscribers) {
            user.receiveMessage(message);
        }
    }
    
}
