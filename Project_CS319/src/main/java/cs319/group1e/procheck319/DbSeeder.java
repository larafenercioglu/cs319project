package cs319.group1e.procheck319;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private StudentRepository studentRepository;

    public DbSeeder(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User bedo = new Student("Bedirhan", "Sakinoglu" , "bedo123", 21801, "bedisakinoglu@gmail.com","student");
        User gok = new Student("Gokhan", "Tas" , "fener", 21802, "gokhan@gmail.com","student");
        User tutku = new Student("Utku","Sezer", "sebo", 21803, "darnque@gmail.com","student");
        User lara = new Student("Lara", "Fenerci", "yes", 21804, "lara@ug.bilkent.edu.tr","student");
        User kim = new Student("Kimya","Ghasem", "kimya", 21805, "kimya@ug.bilkent.edu.tr","student");

        //this.studentRepository.deleteAll();
        List<Student> users = Arrays.asList((Student) bedo,(Student) gok,(Student)tutku,(Student) lara,(Student) kim);
        this.studentRepository.saveAll(users);

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