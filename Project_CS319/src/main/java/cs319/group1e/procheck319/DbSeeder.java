package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private ClassRepository classRepository;
    private InstructorAndTAsRepository instructorAndTAsRepository;

    //Constructor
    public DbSeeder(StudentRepository studentRepository, GroupRepository groupRepository, ClassRepository classRepository, InstructorAndTAsRepository instructorAndTAsRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.classRepository = classRepository;
        this.instructorAndTAsRepository = instructorAndTAsRepository;

        /////////////////////////Hep olacak/////////////////////////////////
        InstructorAndTAs tuzun = new InstructorAndTAs("eray","tuzun","4590",345,"tuzun@gmail.com","instructor");
        InstructorAndTAs jabrayilzade = new InstructorAndTAs("elgun","jabrayilzade","8886",315,"elgun@gmail.com","instructor");
        InstructorAndTAs tuna = new InstructorAndTAs("erdem","tuna","5486",815,"tuna@gmail.com","instructor");
        Class csClass = tuzun.createClass("CS319",319);
        csClass.addInstructorAndTAId(jabrayilzade.getUserId());
        csClass.addInstructorAndTAId(tuna.getUserId());
        jabrayilzade.setClass(319);
        tuna.setClass(319);

        this.instructorAndTAsRepository.save(tuzun);
        this.instructorAndTAsRepository.save(jabrayilzade);
        this.instructorAndTAsRepository.save(tuna);
        this.classRepository.save(csClass);
        Project p = csClass.getProject();
        /////////////////////////////////////////////////////////////////////

        Student bedo = new Student("Bedirhan", "Sakinoglu" , "bedo123", 21801, "bedisakinoglu@gmail.com","student");
        Student gok = new Student("Gokhan", "Tas" , "fener", 21802, "gokhan@gmail.com","student");
        Student tutku = new Student("Utku","Sezer", "sebo", 21803, "darnque@gmail.com","student");
        Student lara = new Student("Lara", "Fenerci", "yes", 21804, "lara@ug.bilkent.edu.tr","student");
        Student kim = new Student("Kimya","Ghasem", "kimya", 21805, "kimya@ug.bilkent.edu.tr","student");

        csClass.addStudentId(bedo.getUserId());
        csClass.addStudentId(gok.getUserId());
        csClass.addStudentId(tutku.getUserId());
        csClass.addStudentId(lara.getUserId());
        csClass.addStudentId(kim.getUserId());
        this.classRepository.save(csClass);

        List<Student> users = Arrays.asList(bedo, gok, tutku, lara, kim);
        this.studentRepository.saveAll(users);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
