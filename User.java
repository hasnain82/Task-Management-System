public class User{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String toString(){
        return username+", "+password;
    }

    public static User fromString(String line){
        String[] parts = line.split(",");
        return new User(parts[0], parts[1]);
    }
}