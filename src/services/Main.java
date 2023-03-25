
package services;

import pojos.Users;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ToMain tomain = new ToMain();
        List<Users> users = tomain.getUserDetails();
        
        for(Users user : users){
            System.out.println(
                    "Profile_Image: " + user.getProfileImage() +
                    ", Nickname: " + user.getNickName());
        }
    }
}
