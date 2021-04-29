package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Document(collection = "allGroups")
public class Group{
    /*
        ATTRIBUTES OF GROUP
    */
    private int groupId;
    private List<Student> studentList;
    private List<Submission> groupSubmissionList;
    private List<Assignment> groupAssignmentList;
    private int maxGroupSize;
    private Calendar calendar;
    private int progress;
    private List<Request> requests;
    private List<Invitation> invitations;

    //Default Constructor
    public Group(int groupId) {
        this.groupId = groupId;
        studentList = new ArrayList<Student>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        invitations = new ArrayList<Invitation>();
    }

    public Group(int groupId,  int maxGroupSize) {
        this.groupId = groupId;
        this.maxGroupSize = maxGroupSize;
        studentList = new ArrayList<Student>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        invitations = new ArrayList<Invitation>();
    }

    //Constructor
    public Group(int groupId, List<Student> studentList, List<Submission> groupSubmissionList, List<Assignment> groupAssignmentList, int maxGroupSize, Calendar calendar, int progress, List<Request> requests, List<Invitation> invitations) {
        this.groupId = groupId;
        this.studentList = new ArrayList<>();
        this.groupSubmissionList = groupSubmissionList;
        this.groupAssignmentList = groupAssignmentList;
        this.maxGroupSize = maxGroupSize;
        this.calendar = calendar;
        this.progress = progress;
        this.requests = requests;
        this.invitations = invitations;
    }

    //SETTERS
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setGroupSubmissionList(List<Submission> groupSubmissionList) {
        this.groupSubmissionList = groupSubmissionList;
    }

    public void setGroupAssignmentList(List<Assignment> groupAssignmentList) {
        this.groupAssignmentList = groupAssignmentList;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    //GETTERS
    public int getGroupId() {
        return groupId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Submission> getGroupSubmissionList() {
        return groupSubmissionList;
    }

    public List<Assignment> getGroupAssignmentList() {
        return groupAssignmentList;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getProgress() {
        return progress;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    /*
        OPERATIONS OF GROUP
    */

    /**
    To check if the group is full or not
      Returns true if the group's studentList is full
      Returns false if the group's studentList is not full
     */
    public boolean isFull(){
        if(studentList.size() <= maxGroupSize){
                return false;
        }
        return true;
    }


    /**
      Calculating the progress of a group according to their submissions and assignments
     */
    public void calculateProgress(){
        double progressOfGroup;
        progressOfGroup = (double)(groupSubmissionList.size()) / (double)(groupAssignmentList.size());
    }

    /**
      Adding a student to a group if group is not full
     */
    public boolean addGroupMember(Student student){
        if(isFull()){
            return false;
        }else{
            studentList.add(student);
            student.setGroupMember(true);
            student.setStudentGroup(this);
            return true;
        }
    }
    /**
     Adding a student to a group whether the group reached the max size or not
     Will be used in some exceptional cases
     */
    public boolean addGroupMemberException(Student student){
        studentList.add(student);
        student.setGroupMember(true);
        student.setStudentGroup(this);
        return true;
    }


    /**
      Removing a group member if group
     */
    public boolean removeGroupMember(Student student){
        if(studentList.size() == 0){
            return false;
        }else{
            studentList.remove(student);
            return true;
        }
    }

    /**
      Group calendar is edited TODO?
     */
    public void editCalendar(Calendar calendar){

    }

    //To get a random artifact submission
    public Submission getRandomGroupArtifact(Assignment assignment , ArtifactReview ar){
        Random rand = new Random();

        int randomIndex;
        boolean flag;

        if(assignment.getSubmissionList().size() == 0){
            return null;
        }
        else{
            do { //Check for if submission belongs to the group
                flag = true;
                System.out.println(assignment.getTitle());
                System.out.println(assignment.getSubmissionList().size());
                randomIndex = rand.nextInt(assignment.getSubmissionList().size()); //Assignment no eklenecek
                if( groupId == assignment.getSubmissionList().get(randomIndex).getGroupId() ){
                    flag = false;
                }
            }while( flag == false );

            assignment.getSubmissionList().get(randomIndex).getArtifactReviews().add(ar);
            return assignment.getSubmissionList().get(randomIndex);
        }
    }

    //TODO To display artifact reviews submitted for an assignment submitted by the group
    public List<ArtifactReview> showArtifactReviewsDoneByOthers( int subNo ){
        return null;
    }


    public String toString(){
        String groupP ="GROUP " +String.valueOf(this.getGroupId())+":\t";
        for(int i = 0;i<this.getStudentList().size();i++){
            groupP = groupP + " " + this.getStudentList().get(i)+"\t";
        }
        return groupP;
    }

    //To upload peer review for students

    /*
    public boolean uploadPeerReview(PeerReview peerReview){

    }
    */
}
