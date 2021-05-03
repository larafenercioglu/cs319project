package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LoginManager {

    //Property
    @Autowired
    private InstructorAndTAsRepository instructorAndTAsRepository;
    private StudentRepository studentRepository;

    //Constructor
    public LoginManager(InstructorAndTAsRepository instructorAndTAsRepository, StudentRepository studentRepository){
        this.instructorAndTAsRepository = instructorAndTAsRepository;
        this.studentRepository = studentRepository;
    }

    //Getters
    public InstructorAndTAsRepository getInstructorAndTAsRepository() {
        return instructorAndTAsRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    //Setters
    public void setInstructorAndTAsRepository(InstructorAndTAsRepository instructorAndTAsRepository) {
        this.instructorAndTAsRepository = instructorAndTAsRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping()
    public void registerToSystem(@ModelAttribute("user") Student newUser ) {
        boolean flag = true;
        //Get all students from student repo
        List<Student> newList = studentRepository.findAll();

        //Check whether new user is already registered to the system
        for(int i = 0; i < newList.size() && flag; i++) {
            if(newList.get(i).getEmail().equals(newUser.getEmail()) || newList.get(i).getUserId() == (newUser.getUserId())) {
                flag = false;
                System.out.println("Student Already Exists!");
            }
        }

        //If new user is not registered
        if(flag){
            //Save the student
            studentRepository.save(newUser);

            //Print message
            System.out.println("Student has been saved to studentRepository successfully");
        }
    }

    @GetMapping()
    public Model logintoSystem(@ModelAttribute("user") User newUser, Model newModel) {
        //Get email and password
        String email = newUser.getEmail();
        String password = newUser.getPassword();

        List<Student> students = studentRepository.findAll();
        List<InstructorAndTAs> instructorAndTAs = instructorAndTAsRepository.findAll();

        //Check student repository
        for(int i  = 0; i < students.size(); i++) {
            if(students.get(i).getEmail().equals(email) && students.get(i).getPassword().equals(password)) {

                //Create student model to use it later
                newModel.addAttribute("studentModel", students.get(i));
                return newModel;
            }
        }

        //Check instructor repository
        for(int i  = 0; i < instructorAndTAs.size(); i++) {
            if(instructorAndTAs.get(i).getEmail().equals(email) && instructorAndTAs.get(i).getPassword().equals(password)) {

                //Create instructor model to use it later
                newModel.addAttribute("instructorModel", instructorAndTAs.get(i));
                return newModel;
            }
        }
        return null;
    }
}
