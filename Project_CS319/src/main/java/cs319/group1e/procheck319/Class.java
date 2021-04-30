package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "OurSuperClass")
public class Class {

    private String classKey;
    @Id
    private int classId;
    private List<Integer> studentIdList;
    private List<InstructorAndTAs> instructorAndTAs;
    private List<Integer> groupIdList;
    private String className;
    private List<Double> averages;
    private Project project;
    private List<Announcement> announcementList;
    private Map<String, List<Submission>> groupSubmissions;
    private Boolean groupFormation;
    private static int groupCount;

    public Class() {
        this.announcementList = new ArrayList<>();
    }

    public Class(String classKey, String className, int groupCount, int classId){
        this.classKey = classKey;
        this.className = className;
        this.project =  new Project();
        this.instructorAndTAs = new ArrayList<>();
        this.groupIdList = new ArrayList<>();
        this.studentIdList = new ArrayList<>();
        this.averages = new ArrayList<>();
        this.groupSubmissions = new HashMap<>() ;
        this.announcementList = new ArrayList<>();
        this.groupCount = groupCount;
        this.classId = classId;
    }

    public Class(String classKey, String className, List<Integer> studentIdList, List<InstructorAndTAs> instructorAndTAs, List<Integer> groupIdList, List<Double> averages, Project project, List<Announcement> announcementList, Map<String, List<Submission>> groupSubmissions, Boolean groupFormation, int groupCount, int classId) {
        this.classKey = classKey;
        this.studentIdList = studentIdList;
        this.instructorAndTAs = instructorAndTAs;
        this.groupIdList = groupIdList;
        this.className = className;
        this.averages = averages;
        this.project = new Project();
        this.announcementList = announcementList;
        this.groupSubmissions = groupSubmissions;
        this.groupFormation = groupFormation;
        this.groupCount = groupCount;
        this.classId = classId;
    }

    //Getters
    public String getClassKey() {
        return classKey;
    }

    public List<Integer> getStudentIdList() {
        return studentIdList;
    }

    public List<InstructorAndTAs> getInstructorAndTAs() {
        return instructorAndTAs;
    }

    public List<Integer> getGroupIdList() {
        return groupIdList;
    }

    public String getClassName() {
        return className;
    }

    public List<Double> getAverages() {
        return averages;
    }

    public Project getProject() {
        return project;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public Map<String, List<Submission>> getGroupSubmissions() {
        return groupSubmissions;
    }

    public Boolean getGroupFormation() {
        return groupFormation;
    }
    public int getClassId() {
        return classId;
    }

    //Setters
    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setStudentIdLists(List<Integer> students) {
        this.studentIdList = students;
    }

    public void setInstructorAndTAs(List<InstructorAndTAs> instructorAndTAs) {
        this.instructorAndTAs = instructorAndTAs;
    }

    public void setStudentIdList(List<Integer> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setAverages(List<Double> averages) {
        this.averages = averages;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public void setGroupSubmissions(Map<String, List<Submission>> groupSubmissions) {
        this.groupSubmissions = groupSubmissions;
    }

    public void setGroupFormation(Boolean groupFormation) {
        this.groupFormation = groupFormation;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     If there are students without group then this method will form groups randomly
     */
    public boolean formRandomGroups(List<Group> groups, Map<Integer,List<Student>> groupStudents, List<Student> students){
        Date date =  new Date();
        //gathering students without group
        //if(date.after(project.getGroupFormationDeadline())) {

        //Merges groups with student number less than the half of the max size
        boolean flag = false;
        int indexOfGroupToReform = 0;

        for (int i = 0; i < groups.size(); i++) {
            if ( groups.get(i).getStudentIdList().size() <= project.getMaxGroupSize() / 2 && flag == false ) {
                indexOfGroupToReform = i;
                flag = true;
            }
            else if ( groups.get(i).getStudentIdList().size() <= project.getMaxGroupSize() / 2 && flag == true ){
                int listSize = groups.get(i).getStudentIdList().size();
                for( int t = 0 ; t < listSize ; t++ ) {
                    //groups.get(indexOfGroupToReform).addGroupMember(groups.get(i).getStudentList().get(0));
                    groups.get(indexOfGroupToReform).addGroupMember(groupStudents.get(groups.get(indexOfGroupToReform).getGroupId()).get(0));
                    //groups.get(i).removeGroupMember(groups.get(i).getStudentList().get(0));
                    groups.get(i).removeGroupMember(groupStudents.get(groups.get(i).getGroupId()).get(0));
                }
                groups.remove(i);
                i = -1;
                flag = false;
            }
        }

        List<Student> singles = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).isGroupMember()) {
                continue;
            }
            singles.add(students.get(i));
        }

        int index = 0;
        int groupNumbersToCreate = 0;
        int studentNumberToDistribute = 0;

        if(flag){
            groupNumbersToCreate = (singles.size() / project.getMaxGroupSize()) - 1; //olabilecek tam grup sayısı
            studentNumberToDistribute = (singles.size() % project.getMaxGroupSize()) + project.getMaxGroupSize(); //Sayıları bir grup oluşturmayan öğrenci sayısı
        }
        else{
            groupNumbersToCreate = (singles.size() / project.getMaxGroupSize()); //olabilecek tam grup sayısı
            studentNumberToDistribute = (singles.size() % project.getMaxGroupSize()); //Sayıları bir grup oluşturmayan öğrenci sayısı
        }

        for(int i = 0; i < groupNumbersToCreate; i++){
            int newId = assignGroupId();
            Group g = new Group(newId, 5);

            g.setMaxGroupSize(project.getMaxGroupSize());
            for(int j = 0; j < project.getMaxGroupSize(); j++){
                g.addGroupMember(singles.get(index));
                index += 1;
            }
            groups.add(g);// en son return edilecek
        }

        //Adds remaining students with the min-sized group
        int indexOfMinGroup = 0;
        int minSize = Integer.MAX_VALUE;

        for( int t = 0 ; t < studentNumberToDistribute ; t++ ) {
            minSize = Integer.MAX_VALUE;
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getStudentIdList().size() < minSize) {
                    minSize = groups.get(i).getStudentIdList().size();
                    indexOfMinGroup = i;
                }
            }
            groups.get(indexOfMinGroup).addGroupMemberException(singles.get(index));
            index++;
        }
        return true;
        //}
        //return false;
    }

    /**
     Adding a student to the class
     */
    public boolean addStudentId(int studentId){
        studentIdList.add(studentId);
        return true;
    }

    /**
     Adding a instructor or TA to the class
     */
    public boolean addInstructorAndTAs(InstructorAndTAs instructorAndTA){
        instructorAndTAs.add(instructorAndTA);
        instructorAndTA.setaClass(this);
        return true;
    }

    /**
     Adding a group to the class
     */
    /*
    public boolean addGroupId(Group group){
        group.add(groupId);
        group.setGroupId(groups.indexOf(group));
        return true;
    }
    */

    /**
     Add new group id to the list
     */
    public boolean addGroupId(int groupId) {
        groupIdList.add(groupId);
        return true;
    }

    /**
     Give new group id to a group
     */
    public int assignGroupId(){
        groupCount++;
        return groupCount;
    }

    /**
     Calculates the average grade of a all assignments
     */
    public void calculateAllAverages(){
        for(int i = 0 ; i < project.getAssignmentList().size() ; i++ ){
            calculateAverageOfAnAssignment(project.getAssignmentList().get(i));
        }
    }

    /**
     Calculates the average grade of a specific assignment
     */
    public double calculateAverageOfAnAssignment(Assignment assignment){
        double average;
        int sum = 0;
        int length = assignment.getSubmissionList().size();
        int gradedLength = 0;

        if( length != 0 ) {
            for (int i = 0; i < length; i++) {
                if (assignment.getSubmissionList().get(i).getIsGraded()) {
                    sum += assignment.getSubmissionList().get(i).getGrade();
                    gradedLength++;
                }
            }
            if(gradedLength == 0){
                average = 0;
            }
            else {
                average = sum / gradedLength;
                assignment.setAverage(average);
            }
            return average;
        }
        return -1;
    }

    /**
     Returns a random group id  from the group list to get random group
     */
    public int getRandomGroupId(){
        Random rand = new Random();
        int randomGroupId = groupIdList.get(rand.nextInt(groupIdList.size()));
        return randomGroupId;
    }

    /**
     Checks if the group formation time has arrived
     */
    public boolean isGroupFormationEnabled(Project project){
        Date date =  new Date();
        if(date.before(project.getGroupFormationDeadline())){
            return true;
        }
        return false;
    }

    /**
     Adding announcement to the list and adding them to groups
     */
    public void addAnnouncement(Announcement announcement, Group group){
        this.getAnnouncementList().add(announcement);
        group.addAnnouncement(announcement);
    }
}
