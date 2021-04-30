package cs319.group1e.procheck319;

//import cs319.group1e.repositories.StudentRepository;
//import cs319.group1e.repositories.UserRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private ClassRepository classRepository;

    public DbSeeder(UserRepository userRepository, StudentRepository studentRepository, GroupRepository groupRepository, ClassRepository classRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.classRepository = classRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        classRepository.deleteAll();
        Class erayClass = new Class("AnanZa", "CS",0, 319);
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
        Class erayClass = new Class("AnanZa", "CS",0, 319);
        Project p = erayClass.getProject();
        p.setMaxGroupSize(5);

        //-----------------------------Adding student and instructor-----------------------------
        Student s1 = new Student("ayşe","fe","3243",400,"fdl","student");
        Student s2 = new Student("fatma","fe","3243",401,"fdl","student");
        Student s3 = new Student("hayriye","fe","3243",402,"fdl","student");
        Student s4 = new Student("figen","fe","3243",403,"fdl","student");
        Student s5 = new Student("lale","fe","3243",404,"fdl","student");
        Student s6 = new Student("doga","fe","3243",405,"fdl","student");
        Student s7 = new Student("aslı","fe","3243",406,"fdl","student");
        Student s8 = new Student("ömer","fe","3243",407,"fdl","student");
        Student s9 = new Student("fadik","fe","3243",408,"fdl","student");
        Student s10 = new Student("leman","fe","3243",409,"fdl","student");
        Student s11 = new Student("furkan","fe","3243",410,"fdl","student");
        Student s12 = new Student("mali","fe","3243",411,"fdl","student");
        Student s13 = new Student("leonard","fe","3243",412,"fdl","student");
        Student s14 = new Student("lara","fe","3243",413,"fdl","student");
        Student s15 = new Student("mehmet","se","3242",414,"fal","student");

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

        classRepository.save(erayClass);

        List<Student> users = Arrays.asList(s1, s2, s3,s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15);
        this.studentRepository.saveAll(users);
        //-----------------------------adding groups-----------------------------

        Group g1 = new Group(erayClass.assignGroupId(),p.getMaxGroupSize());
        erayClass.addGroupId(g1.getGroupId());
        g1.addGroupMember(s1);
        g1.addGroupMember(s5);
        g1.addGroupMember(s15);
        groupRepository.save(g1);

        Group g2 = new Group(erayClass.assignGroupId(),p.getMaxGroupSize());
        erayClass.addGroupId(g2.getGroupId());
        g2.addGroupMember(s2);
        g2.addGroupMember(s3);
        g2.addGroupMember(s4);
        groupRepository.save(g2);

        Group g3 = new Group(erayClass.assignGroupId(),p.getMaxGroupSize());
        erayClass.addGroupId(g3.getGroupId());
        g3.addGroupMember(s6);
        g3.addGroupMember(s7);
        g3.addGroupMember(s8);
        groupRepository.save(g3);

        Group g4 = new Group(erayClass.assignGroupId(),p.getMaxGroupSize());
        erayClass.addGroupId(g4.getGroupId());
        g4.addGroupMember(s14);
        groupRepository.save(g4);

        studentRepository.saveAll(users);

        System.out.println("--------------------BEFORE GROUP FORMATION DEADLINE-----------------------");
        for(int i = 0; i < erayClass.getGroupIdList().size(); i++){
            System.out.println("Group " + erayClass.getGroupIdList().get(i));
            Group g = groupRepository.findByGroupId(erayClass.getGroupIdList().get(i));
            for(int j = 0; j < g.getStudentIdList().size(); j++){
                Student s = studentRepository.findByUserId(g.getStudentIdList().get(j));
                System.out.println("    Student " + s.getUserName());
            }
        }

        //---------------------------------------------------------------------
        List<Group> groups = groupRepository.findAll();
        List<Student> students = studentRepository.findAll();
        HashMap<Integer,List<Student>> studentsGroupsMap = new HashMap<>();

        /*for(Integer j =0;j<groups.size();j++){
            studentsGroupsMap.keySet((groups.get(j).getGroupId()));
            //groups.get(j).getGroupId()
        }*/
        System.out.println("BURASIII"+groups);

        /*
        for(int i=0;i<students.size();i++){
            studentsGroupsMap.get(students.get(i).getGroupId()).add(students.get(i));
            studentsGroupsMap.putIfAbsent(students.get(i).getGroupId());
        }
         */
        //iterate over groups
        for(int i = 0; i < groups.size(); i++) {
            //create an empty student list to put group students and put that into map
            List<Student> g =  new ArrayList<>();
            //iterate over students
            for(int j = 0; j < students.size(); j++) {
                if(students.get(j).getGroupId()==groups.get(i).getGroupId()){
                    g.add(students.get(j));
                }
            }
            studentsGroupsMap.put(groups.get(i).getGroupId(),g);
        }
        System.out.println("BURASIII---------"+studentsGroupsMap.get(groups.get(0).getGroupId()));

        erayClass.formRandomGroups(groups,studentsGroupsMap,students);
        groupRepository.saveAll(groups);
        studentRepository.saveAll(students);

        System.out.println("---------------AFTER GROUP FORMATION DEADLINE------------------");
        for(int i = 0; i < erayClass.getGroupIdList().size(); i++){
            System.out.println("Group " + erayClass.getGroupIdList().get(i));
            Group g = groupRepository.findByGroupId(erayClass.getGroupIdList().get(i));
            for(int j = 0; j < g.getStudentIdList().size(); j++){
                Student s = studentRepository.findByUserId(g.getStudentIdList().get(j));
                System.out.println("    Student " + s.getUserName());
            }
        }


        /*
        Group otherGroup = new Group(5);
        otherGroup.addGroupMember((Student)kim);
        otherGroup.addGroupMember((Student)tutku);
         */


        /*
        this.groupRepository.deleteAll();
        Group g1 = new Group();
        g1.setStudentList(users);
        this.groupRepository.save(g1);

        Group g2 = new Group(2, 5);
        g2.setStudentList(users2);
        this.groupRepository.save(g2);
        */

        /*
            System.out.println(users.getClass());
            System.out.println(kim.getClass());

            if(studentRepository.findByUserId(21802) == null) {
                System.out.println("test");
            }
            User user = studentRepository.findByUserId(21802);
            System.out.println(user.getUserName());
            System.out.println(studentRepository.findByUserId(21802).getClass());
            System.out.println(user.getClass());
        */
    }
}
