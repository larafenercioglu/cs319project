package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.nio.charset.Charset;

@Document("InstructorsAndTAs")
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
    private int classId;
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
     * @param classId
     * @param classKey
     */
    public InstructorAndTAs(String userName, String userSurname, String password, int userId, String email, String type, Calendar calendar, Project project, int classId, String classKey) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.calendar = calendar;
        this.project = project;
        this.classId = classId;
        this.classKey = classKey;
    }

    //Getters
    public Calendar getCalendar() {
        return calendar;
    }

    public Project getProject() {
        return project;
    }

    public int getaClass() {
        return classId;
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

    public void setClass(int classId) {
        this.classId = classId;
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

    /**
     Instructor gets group's specific submission
     */
    public Submission getSubmission(Group group, int subNo){
        return group.getGroupSubmissionList().get(subNo-1);
    }

    /**
     Instructor gives feedback
     */
    public String giveFeedback(String context){
        return context;
    }

    /**
     Instructor grades a submission
     */
    /*
    public boolean gradeSubmission(Group group, int subNo, double grade){
        if(group.getGroupSubmissionList().get(subNo-1) == null){
            return false;
        }
        group.getGroupSubmissionList().get(subNo-1).setGrade(grade);
        return true;
    }*/

    public boolean gradeSubmission(Submission sub, double grade){
        sub.setGrade(grade);
        sub.setIsGraded(true);
        return true;
    }

    /**
     Instructor views the submission list of a specific group
     */
    public List<Submission> viewSubmission(List<Group> groups, int index){
        return groups.get(index-1).getGroupSubmissionList();
    }

    /**
     Instructor views the peer review list of a specified group's specified student
     */
    public List<PeerReview> viewPeerReviewsOfAStudent(Student aStudent){
        return aStudent.getPeerReviews();
    }

    /**
     Instructor views the artifact reviews of a group's submission
     */
    public List<ArtifactReview> viewArtifactReviews(List<Group> groups, int groupId, int subNo){
        return groups.get(groupId-1).getGroupSubmissionList().get(subNo-1).getArtifactReviews();
    }

    /**
     Instructor views a specific group
     */
    public Group viewGroup(List<Group> groups, int groupId){
        return groups.get(groupId-1);
    }

    /**
     Instructor creates an announcement
     */
    public Announcement announce(String context, String title, Class aClass, List<Group> groups){
        Announcement announcement = new Announcement(context, title, this.userName + " " + this.userSurname);
        aClass.getAnnouncementList().add(announcement);
        for(int i = 0 ; i < groups.size() ; i++){
            groups.get(i).getAnnouncementList().add(announcement);
        }
        return announcement;
    }

    public Announcement announceToAGroup(Group group, String context, String title){
        Announcement announcement = new Announcement(context, title + " - (Group" + group.getGroupId() + ")", this.userName + " " + this.userSurname);
        group.addAnnouncement( announcement );
        return announcement;
    }

    /**
     Instructor creates a class
     */
    public Class createClass(String className, int classId){
        Class aClass1 = new Class(createClassKey(), className ,classId);
        this.classId = classId;
        return aClass1;
    }

    /**
     Creating a random class key
     */
    public String createClassKey(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
    public String toString(){
        return "Instructor " + this.getUserName() + "\n" ;
    }
}
