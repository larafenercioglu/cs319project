package cs319.group1e.procheck319;

//import cs319.group1e.repositories.StudentRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student implements User {

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
    //private Group studentGroup;
    private List<Invitation> invitations;

    //Default Constructor
    public Student() {
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
        this.invitations = invitations;
        this.peerReviews = peerReviews;
        this.isGroupMember = isGroupMember;
        this.isRegisteredInClass = isRegisteredInClass;
        //this.studentGroup = studentGroup;
    }

    //Constructor for Seeder
    public Student(String userName, String userSurname, String password, int userId, String email, String type) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.invitations = new ArrayList<>();
        this.peerReviews = new ArrayList<>();
        this.groupId = -1;
        this.isGroupMember = false;
        this.isRegisteredInClass = false;
        //this.studentGroup = null;
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

    //public Group getStudentGroup() {
    //    return studentGroup;
    //}

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

    //public void setStudentGroup(Group studentGroup) {
    //    this.studentGroup = studentGroup;
    //}

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    /*
        OPERATIONS OF STUDENT
     */

    //PS: Student Register to Class Deleted

    /**
      Student forms a group on his/her own
     */
    public Group formAGroup(int id, int maxGroupSize){
        Group group = new Group(id, maxGroupSize);
        group.addGroupMember(this);
        return group;
    }

    /**
     * Student adds a submission to an assignment on behalf of group
     */
    public void addSubmission(Submission submission, Assignment assignment, Group studentGroup){
        submission.setGroupId( this.groupId );
        studentGroup.getGroupSubmissionList().add(submission);
        assignment.getSubmissionList().add(submission);
    }

    /**
     Student reviews a peer
     */
    /*
    public void reviewPeer(PeerReview pr, Student s){
        s.getPeerReviews().add(pr);
        System.out.println("PeerReview "+pr+" has been added to Student "+s);
    }
     */

    public void reviewPeer(Student s, int point1, int point2, int point3, int point4, int point5, String response1, String response2 ){
        if(this.groupId == s.getGroupId()){
            List<Integer> arrPoint = new ArrayList<Integer>();
            arrPoint.add(point1);
            arrPoint.add(point2);
            arrPoint.add(point3);
            arrPoint.add(point4);
            arrPoint.add(point5);
            List<String> arrText = new ArrayList<String>();
            arrText.add(response1);
            arrText.add(response2);
            PeerReview pr = new PeerReview(arrPoint, arrText);
            s.getPeerReviews().add(pr);
        }
    }

    //TODO: subNo karar verilecek
    public Submission reviewArtifact(String context, Group studentGroup){
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

    /**
      Student sends a request to a group
     */
    public Request sendRequest(Group group){ //TODO: BURAYA BAK Bİ HELEEEEEEEEEEEEEEE
        Request request = new Request(group.getGroupId(),this.userId);
        group.getRequests().add(request);
        return request;
    }

    /**
      Student views specific submission's feedback
     */
    public void viewFeedback(InstructorFeedback instructorFeedback){
        System.out.println(instructorFeedback);
    }

    /**
      Student views an artifact review
     */
    public void viewArtifactReview(ArtifactReview artifactReview){
        System.out.println(artifactReview);
    }

    /**
      Student views the invitation
     */
    public void viewInvitation(int index){
        System.out.println(this.getInvitations().get(index));
    }

    /**
        TODO
     */
    public boolean isDeadlineClose(Group studentGroup, int index){
        return true;
    }

    /**
      Student edits his/her belonging group TODO?
     */
    public void editGroupCalendar(Group studentGroup){
        studentGroup.editCalendar(studentGroup.getCalendar());
    }

    public void acceptRequest(Request req , Group receiverGroup, Student senderStudent){
        if(!receiverGroup.isFull()){
            receiverGroup.addGroupMember(senderStudent); //kabul edileni gruba kaydet
            receiverGroup.getRequests().remove(req);
        }
    }
    /**
     Student sends an invitation to a student on behalf of the group
     Student will get the studentId of the student that will be invited to this student's group
     */
    public Invitation sendInvitation(Student receiverStudent, Group senderGroup){ //TODO:Test case için değiştirildi, tekrar değişti
        if(!senderGroup.isFull()){
            Invitation invitation = new Invitation(receiverStudent.getUserId(),senderGroup.getGroupId());
            receiverStudent.addInvitation(invitation);
            //studentGroup.getInvitations().add(invitation);
            return invitation;
        }
        return null;
    }
    /**
      Adding invitation to the student
     */
    public void addInvitation(Invitation invitation){
        invitations.add(invitation);
    }

    /**
     Accept incoming invitation
     */
    public void acceptInvitation(Invitation inv, Group senderGroup){
        if(!senderGroup.isFull()){
            senderGroup.addGroupMember(this);
            //inv.getSender().getInvitations().remove(inv);
            this.getInvitations().remove(inv);
        }else {
            this.getInvitations().remove(inv);
            //senderGroup.getInvitations().remove(inv);
        }
    }

    /**
     Reject incoming invitation
     */
    public void rejectInvitation(Invitation inv) {
        this.getInvitations().remove(inv);
    }

    @Override
    public String toString(){
        return this.userName;
    }
}
