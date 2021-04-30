package cs319.group1e.procheck319;

import java.util.*;

public class Class {
    private String classKey;
    private List<Student> students;
    private List<InstructorAndTAs> instructorAndTAs;
    private List<Group> groups;
    private String className;
    private List<Double> averages;
    private Project project;
    private List<Announcement> announcementList;
    private Map<String, List<Submission>> groupSubmissions;
    private Boolean groupFormation;

    public Class() {
        this.announcementList = new ArrayList<>();
    }

    public Class(String classKey, String className){
        this.classKey = classKey;
        this.className = className;
        this.project =  new Project();
        this.instructorAndTAs = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.students = new ArrayList<>();
        this.averages = new ArrayList<>();
        this.groupSubmissions = new HashMap<>() ;
        this.announcementList = new ArrayList<>();
    }

    public Class(String classKey, String className, List<Student> students, List<InstructorAndTAs> instructorAndTAs, List<Group> groups, List<Double> averages, Project project, List<Announcement> announcementList, Map<String, List<Submission>> groupSubmissions, Boolean groupFormation) {
        this.classKey = classKey;
        this.students = students;
        this.instructorAndTAs = instructorAndTAs;
        this.groups = groups;
        this.className = className;
        this.averages = averages;
        this.project = new Project();
        this.announcementList = announcementList;
        this.groupSubmissions = groupSubmissions;
        this.groupFormation = groupFormation;
    }

    //Getters
    public String getClassKey() {
        return classKey;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<InstructorAndTAs> getInstructorAndTAs() {
        return instructorAndTAs;
    }

    public List<Group> getGroups() {
        return groups;
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

    //Setters
    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setInstructorAndTAs(List<InstructorAndTAs> instructorAndTAs) {
        this.instructorAndTAs = instructorAndTAs;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
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

    /**
      If there are students without group then this method will form groups randomly
     */
    public boolean formRandomGroups(){
        Date date =  new Date();
        //gathering students without group
        //if(date.after(project.getGroupFormationDeadline())) {

            //Merges groups with student number less than the half of the max size
            boolean flag = false;
            int indexOfGroupToReform = 0;

            for (int i = 0; i < groups.size(); i++) {
                if ( groups.get(i).getStudentList().size() <= project.getMaxGroupSize() / 2 && flag == false ) {
                    indexOfGroupToReform = i;
                    flag = true;
                }
                else if ( groups.get(i).getStudentList().size() <= project.getMaxGroupSize() / 2 && flag == true ){
                    int listSize = groups.get(i).getStudentList().size();
                    for( int t = 0 ; t < listSize ; t++ ) {
                        groups.get(indexOfGroupToReform).addGroupMember(groups.get(i).getStudentList().get(0));
                        groups.get(i).removeGroupMember(groups.get(i).getStudentList().get(0));
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
                Group g = new Group();
                addGroup(g);
                g.setMaxGroupSize(project.getMaxGroupSize());
                for(int j = 0; j < project.getMaxGroupSize(); j++){
                    g.addGroupMember(singles.get(index));
                    index += 1;
                }
                groups.add(g);
            }

            //Adds remaining students with the min-sized group
            int indexOfMinGroup = 0;
            int minSize = Integer.MAX_VALUE;

            for( int t = 0 ; t < studentNumberToDistribute ; t++ ) {
                minSize = Integer.MAX_VALUE;
                for (int i = 0; i < groups.size(); i++) {
                    if (groups.get(i).getStudentList().size() < minSize) {
                        minSize = groups.get(i).getStudentList().size();
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
    public boolean addStudent(Student student){
        students.add(student);
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
    public boolean addGroup(Group group){
        groups.add(group);
        group.setGroupId(groups.indexOf(group));
        return true;
    }

    public Group getGroupOfAStudent( Student s ){
        for( int i = 0 ; i < groups.size() ; i++ ){
            if(s.getGroupId() == groups.get(i).getGroupId() ){
                return groups.get(i);
            }
        }
        return null;
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
      Returns a random group from the group list
     */
    public Group getRandomGroup(){
        Random rand = new Random();
        Group randomGroup = groups.get(rand.nextInt(groups.size()));
        return randomGroup;
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
    public void addAnnouncement(Announcement announcement){
        this.getAnnouncementList().add(announcement);
        for(int i = 0; i < getGroups().size(); i++){
            getGroups().get(i).getAnnouncementList().add(announcement);
        }
    }
}
