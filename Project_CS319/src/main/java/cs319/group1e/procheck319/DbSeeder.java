package cs319.group1e.procheck319;

//import cs319.group1e.repositories.StudentRepository;
//import cs319.group1e.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    public DbSeeder(UserRepository userRepository, StudentRepository studentRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User bedo = new Student("Bedirhan", "Sakinoglu" , "bedo123", 21801, "bedisakinoglu@gmail.com","student");
        User gok = new Student("Gokhan", "Tas" , "fener", 21802, "gokhan@gmail.com","student");
        User tutku = new Student("Utku","Sezer", "sebo", 21803, "darnque@gmail.com","student");
        User lara = new Student("Lara", "Fenerci", "yes", 21804, "lara@ug.bilkent.edu.tr","student");
        User kim = new Student("Kimya","Ghasem", "kimya", 21805, "kimya@ug.bilkent.edu.tr","student");


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
