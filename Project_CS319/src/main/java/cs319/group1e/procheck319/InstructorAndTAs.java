package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import java.util.List;
import java.util.Random;
import java.nio.charset.Charset;

public class InstructorAndTAs implements User {

    //Properties
    private String userName;
    private String userSurname;
    private String password;
    @Id
    private int userId;
    private String email;
    private String type;

    private Calendar calendar;
    private Project project;
    private Class aClass;
    private String classKey;

    //Default Constructor
    public InstructorAndTAs() {
    }

    public InstructorAndTAs(String userName, String userSurname, String password, int userId, String email, String type) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
    }

    /**
     * Constructor
     * @param userName
     * @param userSurname
     * @param password
     * @param userId
     * @param email
     * @param type
     * @param calendar
     * @param project
     * @param aClass
     * @param classKey
     */
    public InstructorAndTAs(String userName, String userSurname, String password, int userId, String email, String type, Calendar calendar, Project project, Class aClass, String classKey) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.calendar = calendar;
        this.project = project;
        this.aClass = aClass;
        this.classKey = classKey;
    }

    //Getters
    public Calendar getCalendar() {
        return calendar;
    }

    public Project getProject() {
        return project;
    }

    public Class getaClass() {
        return aClass;
    }

    public String getClassKey() {
        return classKey;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    //Setters
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
        OPERATIONS OF INSTRUCTORANDTAS
    */

}
