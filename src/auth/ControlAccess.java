package auth;

public class ControlAccess {

    public static boolean Authenticate(String username, String password){

        if(username.equals("admin") && password.equals("admin")){
            return true;
        }
        return false;
    }
}