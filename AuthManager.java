import java.io.*;
import java.util.*;

public class AuthManager {
    private ArrayList<User> users = new ArrayList<>();
    private static final String USER_FILE = "users.txt";

    public AuthManager(){
        loadUsersFromFile();
    }

    private void loadUsersFromFile(){
        try(BufferedReader br= new BufferedReader(new FileReader(USER_FILE))){
            String line;
            while((line = br.readLine()) != null){
                users.add(User.fromString(line));
            }
        } catch(IOException e){

        }
    }

    private void saveUsersToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))){
            for(User u:users){
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException E){
            System.out.println("Error save file.");
        }
    }

    public boolean registerUser(String username, String password){
        for(User u:users){
            if(u.getUsername().equals(username)){
                return false;
            }
        }
        users.add(new User(username, password));
        saveUsersToFile();
        return true;
    }
    public User loginUser(String username, String password){
        for(User u:users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
