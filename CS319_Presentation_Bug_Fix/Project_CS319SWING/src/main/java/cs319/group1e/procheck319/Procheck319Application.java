package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Thread.sleep;

@SpringBootApplication
@Component
public class Procheck319Application {
    private static StudentRepository studentRepository;
    private static GroupRepository groupRepository;
    private static ClassRepository classRepository;
    private static InstructorAndTAsRepository instructorAndTAsRepository;

    public static NoGroupGUI noGroupDashboard;
    public static LoginRegisterGUI loginRegisterGUIScreen;
    public static InstructorGUI instructorScreen;
    public static GroupGUI groupDashboard;
    public static PopUpPeerReview popUpPeerReview;
    public static ReviewArtifact reviewArtifact;

    public Procheck319Application(StudentRepository studentRepository, GroupRepository groupRepository,
                                  ClassRepository classRepository, InstructorAndTAsRepository instructorAndTAsRepository){
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.classRepository = classRepository;
        this.instructorAndTAsRepository = instructorAndTAsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Procheck319Application.class, args);
        System.setProperty("java.awt.headless", "false"); //Disables headless
        //***********************************************************************************************************************************************************************
        System.out.println("\n\n****************SELAMLAR******************\n\n ");

        /*
        classRepository.deleteAll();
        Class erayClass = new Class("A", "CS",0, 319);
        classRepository.save(erayClass);

        User bedo = new Student("Bedirhan", "Sakinoglu" , "bedo123", 21801, "bedisakinoglu@gmail.com","student");
        User gok = new Student("Gokhan", "Tas" , "fener", 21802, "gokhan@gmail.com","student");
        User tutku = new Student("Utku","Sezer", "sebo", 21803, "darnque@gmail.com","student");
        User lara = new Student("Lara", "Fenerci", "yes", 21804, "lara@ug.bilkent.edu.tr","student");
        User kim = new Student("Kimya","Ghasem", "kimya", 21805, "kimya@ug.bilkent.edu.tr","student");

        erayClass.addStudentId(bedo.getUserId());
        erayClass.addStudentId(gok.getUserId());
        erayClass.addStudentId(tutku.getUserId());
        erayClass.addStudentId(lara.getUserId());
        erayClass.addStudentId(kim.getUserId());

        classRepository.save(erayClass);

        this.studentRepository.deleteAll();
        List<Student> users = Arrays.asList((Student) bedo, (Student) gok, (Student) tutku,(Student) lara, (Student) kim);
        List<Student> users2 = Arrays.asList( (Student) kim);
        this.studentRepository.saveAll(users);

        Group newGroup = new Group(5);
        newGroup.addGroupMember((Student) bedo);
        newGroup.addGroupMember((Student) gok);
        newGroup.addGroupMember((Student) lara);

        this.groupRepository.deleteAll();
        this.groupRepository.save(newGroup);
         */

        //----------------------------------------------------------------------
        if(instructorAndTAsRepository.findAll().size() < 3) {
            InstructorAndTAs tuzun = new InstructorAndTAs("eray", "tuzun", "12345", 345, "tuzun@gmail.com", "instructor");
            InstructorAndTAs jabrayilzade = new InstructorAndTAs("elgun", "jabrayilzade", "8886", 315, "jabrayilzade@gmail.com", "instructor");
            InstructorAndTAs tuna = new InstructorAndTAs("erdem", "tuna", "12345", 305, "tuna@gmail.com", "instructor");
            Class erayClass = tuzun.createClass("CS319", 319);
            tuzun.setClass(erayClass.getClassId());
            tuna.setClass(erayClass.getClassId());
            jabrayilzade.setClass(erayClass.getClassId());
            Project p =  erayClass.getProject();
            p.setMaxGroupSize(5);
            p.setDeadline("10.01.2021");
            classRepository.save(erayClass);

            //-----------------------------Adding student and instructor-----------------------------
            Student s1 = new Student("ayşe", "fe", "123", 400, "ayse@gmail.com", "student");
            Student s2 = new Student("fatma", "fe", "123", 401, "fatma@gmail.com", "student");
            Student s3 = new Student("hayriye", "fe", "123", 402, "hayriye@gmail.com", "student");
            Student s4 = new Student("figen", "fe", "123", 403, "figen@gmail.com", "student");
            Student s5 = new Student("lale", "fe", "123", 404, "lale@gmail.com", "student");
            Student s6 = new Student("doga", "fe", "123", 405, "example@gmail.com", "student");
            Student s7 = new Student("aslı", "fe", "123", 406, "example@hotmail.com", "student");
            Student s8 = new Student("ömer", "fe", "123", 407, "flckvdl", "student");
            Student s9 = new Student("fadik", "fe", "123", 408, "fdaal", "student");
            Student s10 = new Student("leman", "fe", "123", 409, "fdssl", "student");
            Student s11 = new Student("furkan", "fe", "123", 410, "fdfgl", "student");
            Student s12 = new Student("mali", "fe", "123", 411, "fdlfd", "student");
            Student s13 = new Student("leonard", "fe", "123", 412, "fdlfg", "student");
            Student s14 = new Student("lara", "fe", "1234", 413, "fdltı", "student");
            Student s15 = new Student("mehmet", "se", "123", 414, "fal", "student");

            erayClass.addStudentId(s1.getUserId());
            erayClass.addStudentId(s2.getUserId());
            erayClass.addStudentId(s3.getUserId());
            erayClass.addStudentId(s4.getUserId());
            erayClass.addStudentId(s5.getUserId());
            erayClass.addStudentId(s6.getUserId());
            erayClass.addStudentId(s7.getUserId());
            erayClass.addStudentId(s8.getUserId());
            erayClass.addStudentId(s9.getUserId());
            erayClass.addStudentId(s10.getUserId());
            erayClass.addStudentId(s11.getUserId());
            erayClass.addStudentId(s12.getUserId());
            erayClass.addStudentId(s13.getUserId());
            erayClass.addStudentId(s14.getUserId());
            erayClass.addStudentId(s15.getUserId());

            erayClass.addInstructorAndTAId(tuzun.getUserId());
            erayClass.addInstructorAndTAId(jabrayilzade.getUserId());
            erayClass.addInstructorAndTAId(tuna.getUserId());

            List<Student> users = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15);

            for(int i = 0; i < users.size() ; i++){
                users.get(i).setClassId(erayClass.getClassId());
            }



            studentRepository.saveAll(users);
            instructorAndTAsRepository.save(tuzun);
            instructorAndTAsRepository.save(jabrayilzade);
            instructorAndTAsRepository.save(tuna);
            classRepository.save(erayClass);

            System.out.println("---------------ASSIGMENT------------------");
            Assignment assignment1 = new Assignment();
            assignment1.setAssignmentNo(1);
            assignment1.setTitle("README Document");
            assignment1.setVisibility(true);
            assignment1.setWeight(5);
            assignment1.setDeadline(2021, 1, 3);
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

            List<Assignment> assignments = new ArrayList<>();
            assignments.add(assignment1);
            assignments.add(assignment2);
            assignments.add(assignment3);
            assignments.add(assignment4);
            assignments.add(assignment5);
            classRepository.save(erayClass);
            studentRepository.saveAll(users);

        }

        classRepository.findByClassId(319).setGroupCount( classRepository.findByClassId(319).getGroupIdList().size() );
        classRepository.save(classRepository.findByClassId(319));


        /*
        TEST CASE COPIED AND DELETED
         */

//*********************************************************************************************************************************************************************************
        loginRegisterGUIScreen = new LoginRegisterGUI( studentRepository,  instructorAndTAsRepository,  classRepository);
        noGroupDashboard = new NoGroupGUI( instructorAndTAsRepository, studentRepository, groupRepository, classRepository);

        instructorScreen = new InstructorGUI(studentRepository, instructorAndTAsRepository, groupRepository, classRepository);

        popUpPeerReview = new PopUpPeerReview(instructorAndTAsRepository, studentRepository, groupRepository,classRepository);

        loginRegisterGUIScreen.setVisible(true);

        //-----------------------------------------------------------
        while(loginRegisterGUIScreen.getGoTo() == null ) {
        }
        boolean flag = true;
        boolean ifSwitch = false;
        boolean newFlag = true;

        //LOGIN
        while(flag == true){
            System.out.println(loginRegisterGUIScreen.getGoTo());
            if (loginRegisterGUIScreen.getGoTo().equals("noGroupDashboard")) {
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                noGroupDashboard.setCurrentUser(studentRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                noGroupDashboard.setVisible(true);
                while(!noGroupDashboard.getCurrentUser().isGroupMember()){}
                ifSwitch = true;
                noGroupDashboard.setVisible(false);
                noGroupDashboard.dispose();
            }

            if (loginRegisterGUIScreen.getGoTo().equals("instructorDashboard")){
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                instructorScreen.setCurrentUser(instructorAndTAsRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                instructorScreen.setVisible(true);
                flag = false;
            }

            if (loginRegisterGUIScreen.getGoTo().equals("studentDashboard") || ifSwitch){
                groupDashboard = new GroupGUI( studentRepository,  groupRepository,  classRepository, studentRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                groupDashboard.setCurrentUser(studentRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                groupDashboard.setVisible(true);
                groupDashboard.repaint();
                groupDashboard.validate();

                while(newFlag) {
                    if(groupDashboard.getGoTo() != null) {

                        //Peer Review screen
                        if(groupDashboard.getGoTo().equals("PeerReview")) {
                            newFlag = false;
                            Student cur = groupDashboard.getCurrentUser();
                            int id = groupDashboard.getPeer();
                            popUpPeerReview.setCurrentUser(cur);
                            popUpPeerReview.setNewStudentId(id);
                            popUpPeerReview.setVisible(true);
                            popUpPeerReview.repaint();
                            popUpPeerReview.validate();
                        }

                        //Artifact Review screen
                        if(groupDashboard.getGoTo().equals("ArtifactReview")) {
                            Student cur = groupDashboard.getCurrentUser();
                            reviewArtifact.setCurrentUser(cur);
                            //cur.reviewArtifact(cur.getRandomArtifact(classRepository.findByClassId(319).getProject().getAssignmentList(), groupRepository.findByGroupId(users.get(0).getGroupId())), "bunu beğenmedim canım dostlarım");
                            reviewArtifact.setArtifactReviewGroupId(cur.getGroupId()); //BURADA BAŞKA GRUP OLMALI
                            reviewArtifact.setVisible(true);
                            reviewArtifact.repaint();
                            reviewArtifact.validate();
                        }
                    }
                }
                flag = false;
            }
        }
    }

}
