package cs319.group1e.procheck319;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentManager {

    private StudentRepository studentRepository;

    //Constructor
    public StudentManager(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //Getters
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    //Setters
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    /*
    @PostMapping()
    public String sendRequest(@ModelAttribute("newStudentModel") Student student, Group group){

    }*/
}
