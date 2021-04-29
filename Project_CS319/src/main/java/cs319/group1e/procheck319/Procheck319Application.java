package cs319.group1e.procheck319;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class Procheck319Application {

    public static void main(String[] args) {
        SpringApplication.run(Procheck319Application.class, args);

        //Adding student and instructor
        Student s1 = new Student("ayşe","fe","3243",432,"fdl","student");
        Student s2 = new Student("fatma","fe","3243",432,"fdl","student");
        Student s3 = new Student("hayriye","fe","3243",432,"fdl","student");
        Student s4 = new Student("figen","fe","3243",432,"fdl","student");
        Student s5 = new Student("lale","fe","3243",432,"fdl","student");
        Student s6 = new Student("doga","fe","3243",432,"fdl","student");
        Student s7 = new Student("aslı","fe","3243",432,"fdl","student");
        Student s8 = new Student("ömer","fe","3243",432,"fdl","student");
        Student s9 = new Student("fadik","fe","3243",432,"fdl","student");
        Student s10 = new Student("leman","fe","3243",432,"fdl","student");
        Student s11 = new Student("furkan","fe","3243",432,"fdl","student");
        Student s12 = new Student("mali","fe","3243",432,"fdl","student");
        Student s13 = new Student("leonard","fe","3243",432,"fdl","student");
        Student s14 = new Student("lara","fe","3243",432,"fdl","student");
        InstructorAndTAs tuzun = new InstructorAndTAs("eray","tuzun","4590",345,"lkfgb","instructor");

        //creating class
        Class c = tuzun.createClass("CS319");
        String classKey = c.getClassKey();
        //creating project
        Project p = c.getProject();
        p.setMaxGroupSize(5);

        Assignment assignment1 = new Assignment();
        assignment1.setAssignmentNo(1);
        assignment1.setTitle("README Document");
        assignment1.setVisibility(true);
        assignment1.setWeight(5);
        assignment1.setDeadline(2021, 1, 3);
        ;
        p.createAssignment(assignment1);

        Assignment assignment2 = new Assignment();
        assignment2.setAssignmentNo(2);
        assignment2.setTitle("Analysis Report Iteration 1");
        assignment2.setVisibility(true);
        assignment2.setWeight(0);
        assignment2.setDeadline(2022, 1, 6);

        p.createAssignment(assignment2);

        Assignment assignment3 = new Assignment();
        assignment3.setAssignmentNo(3);
        assignment3.setTitle("Design Report Iteration 1");
        assignment3.setVisibility(true);
        assignment3.setDeadline(2021, 4, 6);
        assignment3.setWeight(0);

        p.createAssignment(assignment3);

        Assignment assignment4 = new Assignment();
        assignment4.setAssignmentNo(4);
        assignment4.setTitle("Analysis Report Iteration 2");
        assignment4.setVisibility(true);
        assignment4.setWeight(25);
        assignment4.setDeadline(2021, 5, 3);
        p.createAssignment(assignment4);

        Assignment assignment5 = new Assignment();
        assignment5.setAssignmentNo(5);
        assignment5.setTitle("Design Report Iteration 2");
        assignment5.setVisibility(true);
        assignment5.setDeadline(2021, 11, 26);
        assignment5.setWeight(35);

        p.createAssignment(assignment5);

        c.addInstructorAndTAs(tuzun);
        // classkey dogru girilirse eger
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);
        c.addStudent(s5);
        c.addStudent(s6);
        c.addStudent(s7);
        c.addStudent(s8);
        c.addStudent(s9);
        c.addStudent(s10);
        c.addStudent(s11);
        c.addStudent(s12);
        c.addStudent(s13);
        c.addStudent(s14);

        // group formation begins
        Group g1 = new Group();
        g1.setMaxGroupSize(p.getMaxGroupSize());
        g1.addGroupMember(s1);
        g1.addGroupMember(s5);

        Group g2 = new Group();
        g2.setMaxGroupSize(p.getMaxGroupSize());
        g2.addGroupMember(s2);
        g2.addGroupMember(s3);
        g2.addGroupMember(s4);

        Group g3 = new Group();
        g3.setMaxGroupSize(p.getMaxGroupSize());
        g3.addGroupMember(s6);
        g3.addGroupMember(s7);
        g3.addGroupMember(s8);

        Group g4 = new Group();
        g4.setMaxGroupSize(p.getMaxGroupSize());
        g4.addGroupMember(s14);
        c.addGroup(g1);
        c.addGroup(g2);
        c.addGroup(g3);
        c.addGroup(g4);

        System.out.println("--------------------BEFORE GROUP FORMATION DEADLINE-----------------------");
        for( int i = 0 ; i < 4 ; i++ ){
            System.out.println( i + " : " + c.getGroups().get(i));
        }
        System.out.println("-------------------------------------");
        c.formRandomGroups();
        System.out.println("---------------AFTER GROUP FORMATION DEADLINE------------------");
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println( i + " : " + c.getGroups().get(i));
        }

        System.out.println("---------------ASSIGNMENT and SUBMISSION------------------");
        //Adds the assignment list to all groups
        for(int i = 0; i < c.getGroups().size(); i++){
            c.getGroups().get(i).setGroupAssignmentList(c.getProject().getAssignmentList());
        }

        /////////////////////////////////////////////////////////////
        Submission s1SubToAs1 = new Submission( assignment1 );
        Submission s2SubToAs1 = new Submission( assignment1 );
        Submission s6SubToAs1 = new Submission( assignment1 );
        Submission s9SubToAs1 = new Submission( assignment1 );

        s1.addSubmission(s1SubToAs1,assignment1);
        s2.addSubmission(s2SubToAs1,assignment1);
        s6.addSubmission(s6SubToAs1,assignment1);
        s9.addSubmission(s9SubToAs1,assignment1);
        //////////////////////////////////////////////////////////////
        Submission s1SubToAs3 = new Submission( assignment3 );
        Submission s2SubToAs3 = new Submission( assignment3 );
        Submission s6SubToAs3 = new Submission( assignment3 );
        Submission s9SubToAs3 = new Submission( assignment3 );

        s1.addSubmission(s1SubToAs3,assignment3);
        s2.addSubmission(s2SubToAs3,assignment3);
        s6.addSubmission(s6SubToAs3,assignment3);
        s9.addSubmission(s9SubToAs3,assignment3);

        //////////////////////////////////////////////////////////////
        Submission s1SubToAs2 = new Submission( assignment2 );
        Submission s2SubToAs2 = new Submission( assignment2 );
        Submission s6SubToAs2 = new Submission( assignment2 );
        Submission s9SubToAs2 = new Submission( assignment2 );

        s1.addSubmission(s1SubToAs2,assignment2);
        s2.addSubmission(s2SubToAs2,assignment2);
        s6.addSubmission(s6SubToAs2,assignment2);
        s9.addSubmission(s9SubToAs2,assignment2);
        ///////////////////////////////////////////////////////////////

        for(int i = 0; i < c.getGroups().get(0).getGroupAssignmentList().size(); i++){
            Assignment assign = c.getProject().getAssignmentList().get(i);
            System.out.println("Deadline şu: " + assign.getDeadline() + " " );
        }

        System.out.println("LARA BURADA " + s5.getStudentGroup().getGroupSubmissionList().get(0).getTitle());

        System.out.println("---------------INSTRUCTOR FEEDBACK------------------"); //GRADE VERMİYİ DAHAAAAA
        /*
            assignment1 ---> s1SubToAs1     s2SubToAs1     s3SubToAs1      s4SubToAs1
            assignment2 ---> s1SubToAs2     s2SubToAs2     s3SubToAs2      s4SubToAs2
            assignment3 ---> s1SubToAs3     s2SubToAs3     s3SubToAs3      s4SubToAs3
            assignment4 --->
            assignment5 --->
         */
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("yaaani daha iyi olabilirdi sizden daha iyisini beklerdim...PU");
        feedbacks.add("aferim len size keretalar");
        feedbacks.add("on numara beş yıldız demek isterdim ama PU");
        feedbacks.add("olay yerindeyim rıza baba ama olay yok gibi..");
        for(int i = 0; i < c.getProject().getAssignmentList().size(); i++){
            for(int j = 0; j < c.getProject().getAssignmentList().get(i).getSubmissionList().size(); j++){
                InstructorFeedback instructorFeedback = tuzun.giveFeedback(feedbacks.get(j));
                c.getProject().getAssignmentList().get(i).getSubmissionList().get(j).setFeedback(instructorFeedback);
            }
        }

        for(int i = 0; i < c.getProject().getAssignmentList().size(); i++){
            System.out.println("****"+c.getProject().getAssignmentList().get(i).getTitle()+"****");
            for(int j = 0; j < c.getProject().getAssignmentList().get(i).getSubmissionList().size(); j++){
                System.out.println(c.getProject().getAssignmentList().get(i).getSubmissionList().get(j).getFeedback());
            }
        }
        //gruplara yapılmış instructor feedbackleri görmek
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("Group "+i);
            for(int j = 0; j < c.getGroups().get(i).getGroupSubmissionList().size(); j++){
                System.out.println("**"+c.getGroups().get(i).getGroupSubmissionList().get(j).getTitle()+"**");
                System.out.println(c.getGroups().get(i).getGroupSubmissionList().get(j).getFeedback());
            }
        }

        //--------------------PEER REVIEW-----------------------
        System.out.println("--------------------PEER REVIEW-----------------------");
        // peer review available ise
        List<Integer> arr0 = new ArrayList<Integer>();
        arr0.add(1);
        arr0.add(3);
        arr0.add(1);
        arr0.add(2);
        PeerReview pr0 = new PeerReview(arr0);
        ArrayList arr1 = new ArrayList<Integer>();
        arr1.add(5);
        arr1.add(5);
        arr1.add(5);
        arr1.add(5);
        PeerReview pr1 = new PeerReview(arr1);
        ArrayList arr2 = new ArrayList<Integer>();
        arr2.add(5);
        arr2.add(3);
        arr2.add(4);
        arr2.add(1);
        PeerReview pr2 = new PeerReview(arr2);
        ArrayList arr3 = new ArrayList<Integer>();
        arr3.add(5);
        arr3.add(5);
        arr3.add(4);
        arr3.add(4);
        PeerReview pr3 = new PeerReview(arr3);
        List<PeerReview> prList = new ArrayList<PeerReview>();
        prList.add(pr0);
        prList.add(pr1);
        prList.add(pr2);
        prList.add(pr3);

        /*
        0 :  ayşe lale lara
        1 :  fatma hayriye figen
        2 :  doga aslı ömer
        3 :  fadik leman furkan mali leonard
         */
        for(int j = 0; j < c.getGroups().get(1).getStudentList().size(); j++){
            for(int i =0;i<c.getGroups().get(1).getStudentList().size(); i++){
                if(c.getGroups().get(1).getStudentList().get(j) == (c.getGroups().get(1).getStudentList().get(i))){
                    continue;
                }
                c.getGroups().get(1).getStudentList().get(j).reviewPeer(prList.get(i),c.getGroups().get(1).getStudentList().get(i));
            }
        }

        for(int i = 0; i < c.getGroups().get(1).getStudentList().size(); i++){
            for(int j = 0; j < c.getGroups().get(1).getStudentList().get(i).getPeerReviews().size(); j++){
                System.out.println(c.getGroups().get(1).getStudentList().get(i).getPeerReviews().get(j));
            }
        }

        //--------------------Artifact Review -----------------------

        System.out.println("\n----------------Artifact Review--------------------\n");

        Submission sub = s1.reviewArtifact("bunu beğenmedim canım dostlarım" );

        System.out.println("ARTIFACT REVIEW: " + sub.getArtifactReviews().get(0));


    }


}
