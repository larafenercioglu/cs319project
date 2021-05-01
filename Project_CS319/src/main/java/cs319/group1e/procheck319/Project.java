package cs319.group1e.procheck319;

import java.util.*;

public class Project {
    private Map<String,Boolean> availability;
    private  int maxGroupSize;
    private Date groupFormationDeadline; // Time
    private Date projectDeadline; //Time
    private Date peerReviewStartDate; //Time
    private Date peerReviewDeadline; // Time
    private ArrayList<Assignment> assignmentList;

    public Project() {
        assignmentList = new ArrayList<Assignment>();
    }

    public Project(Map<String, Boolean> availability, int maxGroupSize, Date groupFormationDeadline, Date projectDeadline, Date peerReviewStartDate, Date peerReviewDeadline, ArrayList<Assignment> assignmentList) {
        this.availability = availability;
        this.maxGroupSize = maxGroupSize;
        this.groupFormationDeadline = groupFormationDeadline;
        this.projectDeadline = projectDeadline;
        this.peerReviewStartDate = peerReviewStartDate;
        this.peerReviewDeadline = peerReviewDeadline;
        this.assignmentList = assignmentList;
    }

    //Getters
    public Map<String, Boolean> getAvailability() {
        return availability;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public Date getGroupFormationDeadline() {
        return groupFormationDeadline;
    }

    public Date getProjectDeadline() {
        return projectDeadline;
    }

    public Date getPeerReviewStartDate() {
        return peerReviewStartDate;
    }

    public Date getPeerReviewDeadline() {
        return peerReviewDeadline;
    }

    public ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    //Setters
    public void setAvailability(Map<String, Boolean> availability) {
        this.availability = availability;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public void setGroupFormationDeadline(Date groupFormationDeadline) {
        this.groupFormationDeadline = groupFormationDeadline;
    }

    public void setProjectDeadline(Date projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public void setPeerReviewStartDate(Date peerReviewStartDate) {
        this.peerReviewStartDate = peerReviewStartDate;
    }

    public void setPeerReviewDeadline(Date peerReviewDeadline) {
        this.peerReviewDeadline = peerReviewDeadline;
    }

    public void setAssignmentList(ArrayList<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    /**
     * Returns the remaining time to project in string format.
     * @return remaining time in string.
     */
    public String checkTime(){
        Date date =  new Date();
        int dayDifference = (int) (((date.getTime() - projectDeadline.getTime()) / (1000 * 60 * 60 * 24)) % 365);
        int hourDifference = (int) (((date.getTime() - projectDeadline.getTime()) / (1000 * 60 * 60)) % 24);
        int minDifference = (int) (((date.getTime() - projectDeadline.getTime()) / (1000 * 60)) % 60);

        return Integer.toString(dayDifference) + " days, " + Integer.toString(hourDifference) + " hours, " + Integer.toString(minDifference) + " minutes left.";
    }

    //TODO:assignmenti zaten parametre olarak aldiysak nasil createAssignment oluyor?
    public boolean createAssignment(Assignment assignment){
     assignmentList.add(assignment);
     return true;
    }

    public Assignment editAssignment(int AssignmentNo, Assignment editedAssignment){
        assignmentList.set(AssignmentNo,editedAssignment);
        return editedAssignment;
    }

    public boolean isPeerReviewAvailable(){
        Date date = new Date();
        if(date.after(peerReviewStartDate)&&date.before(peerReviewDeadline)){
            return true;
        }
        return false;
    }

}
