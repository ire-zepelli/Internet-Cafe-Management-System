package auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ControlAccess {
    public static boolean Authenticate(String username, String password) throws FileNotFoundException{
        File file = new File("userData.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            //if user is found
            if(username.equals(scan.nextLine())){
                //check if the same ang password
                if(password.equals(scan.nextLine())){
                    LocalDateTime time = LocalDateTime.now();
                    String log = "User : " + username + "| Access Time: " + time + "\n";

                    try {
                        FileWriter write = new FileWriter("history.txt");
                        write.append(log);
                        write.close();
                    } catch (Exception e) {
                        System.out.println("Something went wrong!");
                    }
                    
                    return true;
                }              
            }
            scan.close();
        }

        return false;
    }
}