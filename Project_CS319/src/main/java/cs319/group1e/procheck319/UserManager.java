//package cs319.group1e.managers;
package cs319.group1e.procheck319;

import cs319.group1e.procheck319.*;
//import cs319.group1e.repositories.InstructorAndTAsRepository;
//import cs319.group1e.repositories.StudentRepository;
//import cs319.group1e.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserManager {

    @Autowired
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private InstructorAndTAsRepository instructorAndTAsRepository;

    //Constructor
    public UserManager(UserRepository theUserRepository, StudentRepository studentRepository,
                       InstructorAndTAsRepository instructorAndTAsRepository) {
        userRepository = theUserRepository;
        this.studentRepository = studentRepository;
        this.instructorAndTAsRepository =instructorAndTAsRepository;
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
        It is done by UserRepository class
    */
    @PostMapping(value = "/checkUserInput")
    public String checkUserByLoginInput(@ModelAttribute("user") User theUser) {

        //Get email and password
        String email = theUser.getEmail();
        String password = theUser.getPassword();

        List<User> newList = userRepository.findAll();
        for(int i  = 0; i < newList.size(); i++) {
            if(newList.get(i).getEmail().equals(email) && newList.get(i).getPassword().equals(password)) {
                theUser.setUserName(newList.get(i).getUserName());
                theUser.setUserSurname(newList.get(i).getUserSurname());
                theUser.setUserId(newList.get(i).getUserId());
                theUser.setType(newList.get(i).getType());

                if(theUser.getType().equals("student")){
                    System.out.println("INSIDE checkUserByLoginInput");
                    System.out.println(theUser.getUserName());
                    System.out.println(theUser.getUserSurname());
                    System.out.println(theUser.getClass());

                    return "dashboardIndex";
                }else{
                    return "instructorDashboard";
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

        System.out.println(theStudent.getUserName());
        System.out.println(theStudent.getClass());

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
            studentRepository.save(theStudent);

            //Print message
            System.out.println("Student has been saved successfully");
        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/login";
    }

    /**
        Register new Instructor
        It is done by InstructorRepository class
    */
    @PostMapping("/saveInstructorAndTAs")
    public String saveInstructor(@ModelAttribute("user") InstructorAndTAs theInstructor) {
        boolean flag = true;
        List<InstructorAndTAs> newList = instructorAndTAsRepository.findAll();

        for(int i = 0; i < newList.size() && flag; i++) {
            if(newList.get(i).getEmail().equals(theInstructor.getEmail()) || newList.get(i).getUserId() == (theInstructor.getUserId())) {
                flag = false;
                System.out.println("Instructor Already Exists!");
            }
        }

        if(flag){
            // save the student
            theInstructor.setType("instructor");
            instructorAndTAsRepository.save(theInstructor);

            //Print message
            System.out.println("Instructor has been saved successfully");
        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/login";
    }

    /**
        Delete a instructor by using id
        It is done by instructorAndTAsRepository class
    */
    @DeleteMapping(value = "deleteInstructor/{userId}")
    public String deleteInstructor(@PathVariable("userId") int id) {
        instructorAndTAsRepository.deleteById(id);
        return "redirect:/login";
    }

    /**
        Update a student by using id
        It is done by StudentRepository class
    */
    @GetMapping("/updateInstructor/{userId}")
    public String updateInstructorById(@PathVariable int userId, @ModelAttribute("user") InstructorAndTAs theInstructorAndTAs) {

        User user = instructorAndTAsRepository.findByUserId(userId);

        theInstructorAndTAs.setUserName(user.getUserName());
        theInstructorAndTAs.setUserSurname(user.getUserSurname());
        theInstructorAndTAs.setUserId(user.getUserId());
        theInstructorAndTAs.setEmail(user.getEmail());
        theInstructorAndTAs.setPassword(user.getPassword());

        return "dashboardIndex";
    }

    /**
        Update instructor
        It is done by instructorAndTAsRepository class
    */
    @PostMapping("/updateInstructor")
    public String updateInstructor(@ModelAttribute("user") InstructorAndTAs theInstructor) {

        System.out.println(theInstructor.getUserName());
        System.out.println(theInstructor.getClass());

        //Save the user
        instructorAndTAsRepository.save(theInstructor);

        //Use a redirect to prevent duplicate submissions
        return "redirect:/login";
    }


    @GetMapping(value = "/allInstructorAndTAs")
    public List<InstructorAndTAs> getAllInstructorAndTAs() {
        return instructorAndTAsRepository.findAll();
    }


    /*
    @PostMapping
    public String createUser(@RequestBody User user) {
        User newUser = userRepository.insert(user);
        return "User " + newUser.getUserName() + " created";
    }
    */

    /*
    @PutMapping(value = "/{userId}")
    public boolean updateUser(@PathVariable("userId") int id, @RequestBody User user ) {

        if(user.getUserId() == id) {
            userRepository.save(user);
            return true;
        }
        else {
            return false;
        }
    }
    */

    /*
    @DeleteMapping(value = "delete/{userId}")
    public String deleteUser(@PathVariable("userId") int id) {
        userRepository.deleteById(id);
        return "redirect:/login";
    }
    */
}
