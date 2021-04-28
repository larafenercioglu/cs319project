package cs319.group1e.procheck319;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Procheck319Application {

    public static void main(String[] args) {
        SpringApplication.run(Procheck319Application.class, args);

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

        Class c = new Class();
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

        Group g1 = new Group();
        g1.addGroupMember(s1);
        s1.setGroupMember(true);
        g1.addGroupMember(s5);
        //s5.setGroupMember(true);


        Group g2 = new Group();
        //g2.addGroupMember(s2);
        //s2.setGroupMember(true);
        g2.addGroupMember(s3);
        s3.setGroupMember(true);
        g2.addGroupMember(s4);
        s4.setGroupMember(true);


        Group g3 = new Group();
        g3.addGroupMember(s6);
        s6.setGroupMember(true);
        g3.addGroupMember(s7);
        s7.setGroupMember(true);
        g3.addGroupMember(s8);
        s8.setGroupMember(true);

        Group g4 = new Group();
        g4.addGroupMember(s14);
        s14.setGroupMember(true);

        c.addGroup(g1);
        c.addGroup(g2);
        c.addGroup(g3);
        c.addGroup(g4);

        System.out.println("--------------------BEFORE GROUP FORMATION DEADLINE-----------------------");
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("\ngroup---");
            for(int j = 0; j < c.getGroups().get(i).getStudentList().size(); j++){
                System.out.println("student "+c.getGroups().get(i).getStudentList().get(j).getUserName());
            }
        }
        c.formRandomGroups();

        System.out.println("---------------AFTER GROUP FORMATION DEADLINE------------------");
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("\ngroup---");
            for(int j = 0; j < c.getGroups().get(i).getStudentList().size(); j++){
                System.out.println("student "+c.getGroups().get(i).getStudentList().get(j).getUserName());
            }
        }

    }

}
