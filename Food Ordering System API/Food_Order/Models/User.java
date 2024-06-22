package Food_Order.Models;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;
    //Constructor

    public User(String email, String username, String password, String role,String id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.id=id;
    }

    // Getter And Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
