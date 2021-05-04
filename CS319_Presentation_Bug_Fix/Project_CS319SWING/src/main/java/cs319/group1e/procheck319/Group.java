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
    @Id
    private int groupId;
    private List<Integer> studentIdList;
    private List<Submission> groupSubmissionList;
    private List<Assignment> groupAssignmentList;
    private List<Announcement> announcementList;
    public int maxGroupSize;
    private Calendar calendar;
    private double progress;
    private List<Request> requests;
    private int artifactReviewsCount;
    private int classId;
    //private List<Invitation> invitations;

    //Default Constructor
    public Group() {
        studentIdList = new ArrayList<>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        announcementList = new ArrayList<>();
        groupAssignmentList = new ArrayList<>();
        this.artifactReviewsCount = 0;
    }

    public Group( int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
        studentIdList = new ArrayList<>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        announcementList = new ArrayList<>();
        groupAssignmentList = new ArrayList<>();
        this.artifactReviewsCount = 0;
    }

    public Group( int groupId, int maxGroupSize) {
        this.groupId = groupId;
        this.maxGroupSize = maxGroupSize;
        this.studentIdList = new ArrayList<>();
        this.groupSubmissionList = new ArrayList<Submission>();
        this.requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        this.announcementList = new ArrayList<>();
        groupAssignmentList = new ArrayList<>();
        this.artifactReviewsCount = 0;
    }

    //Constructor
    public Group(List<Student> studentList, List<Submission> groupSubmissionList, List<Assignment> groupAssignmentList, List<Announcement> announcementList, int maxGroupSize, Calendar calendar, double progress, List<Request> requests, List<Invitation> invitations) {
        //this.groupId = groupId;
        this.studentIdList = studentIdList;
        this.groupSubmissionList = groupSubmissionList;
        this.groupAssignmentList = groupAssignmentList;
        this.maxGroupSize = maxGroupSize;
        this.calendar = calendar;
        this.progress = progress;
        this.requests = requests;
        //this.invitations = invitations;
        this.announcementList = announcementList;
        this.artifactReviewsCount = 0;
    }

    //SETTERS
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setStudentList(List<Integer> studentList) {
        this.studentIdList = studentIdList;
    }

    public void setGroupSubmissionList(List<Submission> groupSubmissionList) {
        this.groupSubmissionList = groupSubmissionList;
    }

    public void setGroupAssignmentList(List<Assignment> groupAssignmentList) {
        this.groupAssignmentList = groupAssignmentList;
    }

    public void setArtifactReviewsCount(int artifactReviewsCount) {
        this.artifactReviewsCount = artifactReviewsCount;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    //public void setInvitations(List<Invitation> invitations) {
    //    this.invitations = invitations;
    //}

    //GETTERS
    public int getGroupId() {
        return groupId;
    }

    public int getClassId() {
        return classId;
    }

    public int getArtifactReviewsCount() {
        return artifactReviewsCount;
    }

    public List<Integer> getStudentIdList() {
        return studentIdList;
    }

    public List<Submission> getGroupSubmissionList() {
        return groupSubmissionList;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
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

    public double getProgress() {
        return progress;
    }

    public List<Request> getRequests() {
        return requests;
    }

    //public List<Invitation> getInvitations() {
    //    return invitations;
    //}

    /*
        OPERATIONS OF GROUP
    */

    /**
    To check if the group is full or not
      Returns true if the group's studentList is full
      Returns false if the group's studentList is not full
     */
    public boolean isFull(){
        if(studentIdList.size() <= maxGroupSize){
                return false;
        }
        return true;
    }

    /**
      Calculating the progress of a group according to their submissions and assignments
     */
    public void calculateProgress(){ //yüzdelik hesaplayak
        double progressOfGroup;
        progressOfGroup = ((double)(groupSubmissionList.size()) / (double)(groupAssignmentList.size()))*100;
        this.progress = progressOfGroup;
    }

    /**
      Adding a student to a group if group is not full
     */
    public boolean addGroupMember(Student student){
        if(isFull()){
            return false;
        }else{
            this.studentIdList.add(student.getUserId());
            student.setGroupMember(true);
            student.setGroupId(groupId);
            return true;
        }
    }
    /**
     Adding a student to a group whether the group reached the max size or not
     Will be used in some exceptional cases
     */
    public boolean addGroupMemberException(Student student){
        studentIdList.add(student.getUserId());
        student.setGroupMember(true);
        student.setGroupId(groupId);
        return true;
    }


    /**
      Removing a group member if group
     */
    public boolean removeGroupMember(Student student){
        if(studentIdList.size() == 0) {
            return false;
        }
        else {
            System.out.println(studentIdList);
            for(int i = 0; i < studentIdList.size(); i++){
                if(studentIdList.get(i) == student.getUserId()){
                    studentIdList.remove(i);
                    student.setGroupId(-1);
                    student.setGroupMember(false);
                }
            }
            return true;
        }
    }

    /**
      Group calendar is edited TODO?
     */
    public void editCalendar(Calendar calendar){

    }

    public void addAnnouncement( Announcement announcement ){
        announcementList.add(announcement);
    }

    //To get a random artifact submission
    public Submission getRandomGroupArtifact(Assignment assignment){
        Random rand = new Random();
        if(assignment.getSubmissionList().size() <= 0) {
            return null;
        }
        else {
            int randomIndex = rand.nextInt(assignment.getSubmissionList().size());
            int minCount = Integer.MAX_VALUE;
            boolean flag;

            if(assignment.getSubmissionList().size() == 0){
                return null;
            }
            else{
                for( int i = 0 ; i < assignment.getSubmissionList().size() ; i++ ){
                    if( minCount > assignment.getSubmissionList().get(i).getArtifactReviewCount() && groupId != assignment.getSubmissionList().get(i).getGroupId()){
                        minCount = assignment.getSubmissionList().get(i).getArtifactReviewCount();
                    }
                }

                while( assignment.getSubmissionList().get(randomIndex).getArtifactReviewCount() != minCount ){
                    randomIndex = rand.nextInt(assignment.getSubmissionList().size());
                }

                System.out.println( "Group Id : " + assignment.getSubmissionList().get(randomIndex).getGroupId() );
                System.out.println(assignment.getSubmissionList().get(randomIndex).getArtifactReviewCount());

                this.artifactReviewsCount++;
                assignment.getSubmissionList().get(randomIndex).setArtifactReviewCount( assignment.getSubmissionList().get(randomIndex).getArtifactReviewCount() + 1 );
                return assignment.getSubmissionList().get(randomIndex);
            }
        }
    }

    //TODO To display artifact reviews submitted for an assignment submitted by the group PS: parametre int subNo'ydu sub yaptım
    public List<ArtifactReview> showArtifactReviewsDoneByOthers( Submission sub ){
        return sub.getArtifactReviews();
    }


    public String toString(){
        String groupP ="GROUP " +String.valueOf(this.getGroupId())+":\t";
        for(int i = 0;i<this.getStudentIdList().size();i++){
            groupP = groupP + " " + this.getStudentIdList().get(i)+"\t";
        }
        return groupP;
    }


    //To upload peer review for students

    /*
    public boolean uploadPeerReview(PeerReview peerReview){

    }
    */
}
