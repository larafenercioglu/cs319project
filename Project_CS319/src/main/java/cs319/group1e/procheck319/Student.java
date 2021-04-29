package cs319.group1e.procheck319;

//import cs319.group1e.repositories.StudentRepository;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student implements User {
    //TODO: fonksiyonlar kontrol edilecek

    //Properties
    private String userName;
    private String userSurname;
    private String password;
    @Id
    private int userId;
    private String email;
    private String type;

    private int groupId;
    private List<PeerReview> peerReviews;
    private boolean isGroupMember;
    private boolean isRegisteredInClass;
    private Group studentGroup;
    private List<Invitation> invitations;

    //Default Constructor
    public Student() {
        invitations = new ArrayList<Invitation>();
        peerReviews = new ArrayList<PeerReview>();
    }

    //Constructor
    public Student(String userName, String userSurname, String password, int userId, String email, String type, int groupId, List<PeerReview> peerReviews, boolean isGroupMember, boolean isRegisteredInClass, Group studentGroup, List<Invitation> invitations) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.groupId = groupId;
        this.studentGroup = studentGroup;
        this.invitations = invitations;
        this.peerReviews = new ArrayList<>();
        this.isGroupMember = isGroupMember;
        this.isRegisteredInClass = isRegisteredInClass;
        this.studentGroup = studentGroup;
        this.invitations = new ArrayList<>();
    }

    //Constructor for Seeder
    public Student(String userName, String userSurname, String password, int userId, String email, String type) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        invitations = new ArrayList<Invitation>();
        peerReviews = new ArrayList<PeerReview>();
        this.groupId = -1;
        this.peerReviews = new ArrayList<>();
        this.isGroupMember = false;
        this.isRegisteredInClass = false;
        this.studentGroup = null;
        this.invitations = new ArrayList<>();
    }

    //Getters
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

    public int getGroupId() {
        return groupId;
    }

    public List<PeerReview> getPeerReviews() {
        return peerReviews;
    }

    public boolean isGroupMember() {
        return isGroupMember;
    }

    public boolean isRegisteredInClass() {
        return isRegisteredInClass;
    }

    public Group getStudentGroup() {
        return studentGroup;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    //Setters
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

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setPeerReviews(List<PeerReview> peerReviews) {
        this.peerReviews = peerReviews;
    }

    public void setGroupMember(boolean groupMember) {
        isGroupMember = groupMember;
    }

    public void setRegisteredInClass(boolean registeredInClass) {
        isRegisteredInClass = registeredInClass;
    }

    public void setStudentGroup(Group studentGroup) {
        this.studentGroup = studentGroup;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    /*
        OPERATIONS OF STUDENT
     */

    //PS: Student Register to Class Deleted

    //TODO: Gerek var mı
    /**
      Student forms a group on his/her own
     */
    public boolean formAGroup(int groupId, List<Student> studentList, List<Submission> groupSubmissionList, List<Assignment> groupAssignmentList, int maxGroupSize, Calendar calendar, int progress, List<Request> requests, List<Invitation> invitations){
        Group group = new Group( groupId, studentList, groupSubmissionList, groupAssignmentList, maxGroupSize, calendar, progress, requests, invitations );
        group.addGroupMember(this);
        return true;
    }

    /* OLD Version --------------------------------------------
      Student joins an already existed group
    public boolean joinAGroup(int groupId){

        return true;
    }
    */

    //TODO
    /**
     * Student adds a submission to an assignment on behalf of group
     */
    public void addSubmission(Submission submission, Assignment assignment){
        submission.setGroupId( this.groupId );
        studentGroup.getGroupSubmissionList().add(submission);
        assignment.getSubmissionList().add(submission);
    }

    /**
      Student reviews a peer
     */
    /**
     Student reviews a peer
     */
    public void reviewPeer(PeerReview pr, Student s){
        s.getPeerReviews().add(pr);
        System.out.println("PeerReview "+pr+" has been added to Student "+s);
    }

    /* PS: OLD VERSION --------------------------------------------------------------------------
    public Submission getRandomArtifact(int subNo){
        return null;
    }

    public void reviewArtifact(int subNo){
        Submission s = getRandomArtifact(subNo);
    }
    */
    //TODO: subNo karar verilecek
    public Submission reviewArtifact(String context){
        int index = -1;
        for( int i = 0; i < studentGroup.getGroupAssignmentList().size() ; i++ ){
            if(studentGroup.getGroupAssignmentList().get(i).isDeadlineOver() ){
                index = i;
            }
        }
        if( index == -1){}
        else {
            ArtifactReview ar = new ArtifactReview(context);
            Submission submission = studentGroup.getRandomGroupArtifact(studentGroup.getGroupAssignmentList().get(index) , ar);
            return submission;
        }
        return null;
    }

    public boolean equals(Student s) {
        if(this.getUserId() == s.getUserId() ){
            return true;
        }
        return false;
    }

    //-------------------------------------------------------------------------------------------------

    /**
     TODO
      Student sends a request to a group
     */
    public void sendRequest(Group group){
        Request request = new Request(group,this);
        group.getRequests().add(request);
    }

    /**
     TODO
      Student sends an invitation to a student on behalf of the group
      Student will get the studentId of the student that will be invited to this student's group
     */
    public void sendInvitation(int studentId){

    }

    /**
      Student views specific submission's feedback
     */
    public void viewFeedback(InstructorFeedback instructorFeedback){

    }

    /**
      Student views an artifact review
     */
    public void viewArtifactReview(ArtifactReview artifactReview){

    }

    /**
      Student views the invitation
     */
    public void viewInvitation(int index){

    }

    /**

     */
    public boolean isDeadlineClose(Group studentGroup, int index){
        return true;
    }

    /**
      Student edits his/her belonging group
     */
    public void editGroupCalendar(){
        studentGroup.editCalendar(studentGroup.getCalendar());
    }

    public void acceptRequest(Request req){
        if(!studentGroup.isFull()){
            studentGroup.addGroupMember(req.getSender());
            studentGroup.getRequests().remove(req);
        }
    }
    /**
      Adding invitation to the student
     */
    public void addInvitation(Invitation invitation){
        invitations.add(invitation);
    }
    public String toString(){
        return this.userName;
    }
}
