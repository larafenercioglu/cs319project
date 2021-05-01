package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserManager {

    @Autowired
    private StudentRepository studentRepository;
    private InstructorAndTAsRepository instructorAndTAsRepository;
    private GroupRepository groupRepository;

    //Constructor
    public UserManager(StudentRepository studentRepository,
                       GroupRepository groupRepository, InstructorAndTAsRepository instructorAndTAsRepository) {

        this.studentRepository = studentRepository;
        this.instructorAndTAsRepository =instructorAndTAsRepository;
        this.groupRepository = groupRepository;
    }

    //Open Login page
    @GetMapping("/login")
    public String getMain(Model theModel) {

        // create model attribute to bind form data
        User theUser = new Student();

        theModel.addAttribute("user", theUser);
        return "loginIndex";
    }

    /**
        Login the system
        It is done by StudentRepository and InstructorAndTAsRepository class
    */
    @PostMapping(value = "/checkUserInput")
    public String checkUserByLoginInput(@ModelAttribute("user") User theUser) {

        //Get email and password
        String email = theUser.getEmail();
        String password = theUser.getPassword();

        List<Student> students = studentRepository.findAll();
        List<InstructorAndTAs> instructorAndTAs = instructorAndTAsRepository.findAll();

        //Check student repository
        for(int i  = 0; i < students.size(); i++) {
            if(students.get(i).getEmail().equals(email) && students.get(i).getPassword().equals(password)) {
                theUser.setUserName(students.get(i).getUserName());
                theUser.setUserSurname(students.get(i).getUserSurname());
                theUser.setUserId(students.get(i).getUserId());
                theUser.setType(students.get(i).getType());

                if(theUser.getType().equals("student")){
                    if(students.get(i).isGroupMember()) {
                        return "studentDashboard"; //TODO DEĞİŞECEK !!!!!!!!!!!!!!!!!
                    }else{

                        return "noGroupDashboard";
                    }
                }else{
                    return "redirect:/login";
                }
            }
        }

        //Check instructor repository
        for(int i  = 0; i < instructorAndTAs.size(); i++) {
            if(instructorAndTAs.get(i).getEmail().equals(email) && instructorAndTAs.get(i).getPassword().equals(password)) {
                theUser.setUserName(instructorAndTAs.get(i).getUserName());
                theUser.setUserSurname(instructorAndTAs.get(i).getUserSurname());
                theUser.setUserId(instructorAndTAs.get(i).getUserId());
                theUser.setType(instructorAndTAs.get(i).getType());

                if(theUser.getType().equals("instructor")){
                    return "instructorDashboard";
                }else{
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/login";
    }

    /**
        Update a student by using id
        It is done by StudentRepository class
    */
    @GetMapping("/updateStudent/{userId}")
    public String updateStudentById(@PathVariable int userId, @ModelAttribute("user") Student theStudent) {
        User user = studentRepository.findByUserId(userId);

        theStudent.setUserName(user.getUserName());
        theStudent.setUserSurname(user.getUserSurname());
        theStudent.setUserId(user.getUserId());
        theStudent.setEmail(user.getEmail());
        theStudent.setPassword(user.getPassword());
        theStudent.setType(user.getType());

        return "dashboardIndex";
    }

    /**
        Update student
        It is done by StudentRepository class
    */
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("user") Student theStudent) {

        //Save the user
        studentRepository.save(theStudent);

        //Use a redirect to prevent duplicate submissions
        return "redirect:/login";
    }

    /**
        Delete a student by using id
        It is done by StudentRepository class
    */
    @DeleteMapping(value = "deleteStudent/{userId}")
    public String deleteStudent(@PathVariable("userId") int id) {
        studentRepository.deleteById(id);
        return "redirect:/login";
    }

    /**
        Register new Student
        It is done by StudentRepository class
    */
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("user") Student theStudent) {
        boolean flag = true;
        List<Student> newList = studentRepository.findAll();

        for(int i = 0; i < newList.size() && flag; i++) {
            if(newList.get(i).getEmail().equals(theStudent.getEmail()) || newList.get(i).getUserId() == (theStudent.getUserId())) {
                flag = false;
                System.out.println("Student Already Exists!");
            }
        }

        if(flag){
            // save the student
            theStudent.setType("student");
            //theStudent.setGroupId(-1);
            studentRepository.save(theStudent);

            //Print message
            System.out.println("Student has been saved successfully");
        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/login";
    }

    @GetMapping(value = "/allInstructorAndTAs")
    public List<InstructorAndTAs> getAllInstructorAndTAs() {
        return instructorAndTAsRepository.findAll();
    }


}
