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
    private Announcement announcementList;
    private Map<String, List<Submission>> groupSubmissions;
    private Boolean groupFormation;

    public Class() {
    }

    public Class(String classKey, String className){
        this.classKey = classKey;
        this.className = className;
    }

    public Class(String classKey, String className, List<Student> students, List<InstructorAndTAs> instructorAndTAs, List<Group> groups, List<Double> averages, Project project, Announcement announcementList, Map<String, List<Submission>> groupSubmissions, Boolean groupFormation) {
        this.classKey = classKey;
        this.students = students;
        this.instructorAndTAs = instructorAndTAs;
        this.groups = groups;
        this.className = className;
        this.averages = averages;
        this.project = project;
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

    public Announcement getAnnouncementList() {
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

    public void setAnnouncementList(Announcement announcementList) {
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
    //TODO YARIn
    public boolean formRandomGroups(){
        Date date =  new Date();
        //gathering students without group
        if(date.after(project.getGroupFormationDeadline())) {
            List<Student> singles = null;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).isGroupMember()) {
                    continue;
                }
                singles.add(students.get(i));
            }
            int index = 0;
            int groupNumbersToCreate = (singles.size() / project.getMaxGroupSize()); //olabilecek tam grup sayısı
            int studentNumberToDistribute = (singles.size() % project.getMaxGroupSize()); //Sayıları bir grup oluşturmayan öğrenci sayısı

            for(int i = 0; i < groupNumbersToCreate; i++){
                Group g = new Group();
                for(int j = 0; j < project.getMaxGroupSize(); j++){
                    g.addGroupMember(singles.get(index));
                    index += 1;
                }
                groups.add(g);
            }
            //TODO: başa kalan dona kalır   yarin bakalim!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            for(int i = 0; i < studentNumberToDistribute; i++){
                while(!groups.get(i).isFull()) {
                    groups.get(i).addGroupMember(singles.get(index));
                    index += 1;
                }
            }
            return true;
        }
        return false;
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
        return true;
    }

    /**
      Adding a group to the class
     */
    public boolean addGroup(Group group){
        groups.add(group);
        return true;
    }

    /**
      Calculates the average grade of a specific assignment
     */
    public double calculateAverage(Assignment assignment){
        int sum = 0;
        int length = assignment.getSubmissionList().size();
        for(int i = 0; i < length; i++){
            sum += assignment.getSubmissionList().get(i).getGrade();
        }
        return sum / length;
    }

    /**
      Returns a random group from the group list
     */
    public Group getRandomGroup(){ //TODO: burada parametre olarak group alıyodu ama saçma
        Random rand = new Random();
        Group randomGroup = groups.get(rand.nextInt(groups.size()));
        return randomGroup;
    }

    public boolean isUserValid(User user){ //TODO: gerek var mı buna? usermanager'da yapıyoz zaten
        return true;
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
}
