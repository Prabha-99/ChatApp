/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subscrib;

/**
 *
 * @author HANSANI
 */
public class Main {
    
    public static void main(String[] args) {
        chat chat = new chat();
        User user1 = new User("John");
        User user2 = new User("Mary");

        chat.subscribe(user1);
        chat.subscribe(user2);

        chat.notifyAllSubscribers("Hello, everyone!");

        chat.unsubscribe(user2);

        chat.notifyAllSubscribers("Mary has left the chat.");

        User user3 = new User("Bob");
        chat.subscribe(user3);

        chat.notifyAllSubscribers("Welcome, Bob!");
    }
    
}
