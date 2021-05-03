package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "allUsers")
public interface User {

    //Properties
    String userName = "";
    String userSurname = "";
    String password = "";
    @Id
    int userId = 0;
    String email = "";
    String type = "";

    //Getters
    public String getUserName();
    public String getUserSurname();
    public String getPassword();
    public int getUserId();
    public String getEmail();
    public String getType();

    //Setters
    public void setUserName(String userName);
    public void setUserSurname(String userSurname);
    public void setPassword(String password);
    public void setUserId(int userId);
    public void setEmail(String email);
    public void setType(String type);
}
