package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClassManager {

    @Autowired
    private LoginManager loginManager;
    private StudentManager studentManager;
    private InstructorAndTAsManager instructorAndTAsManager;
    private GroupManager groupManager;
    private ClassRepository classRepository;

    //Constructor
    public ClassManager(LoginManager loginManager, StudentManager studentManager,
                        InstructorAndTAsManager instructorAndTAsManager, GroupManager groupManager, ClassRepository classRepository){
        this.loginManager = loginManager;
        this.studentManager = studentManager;
        this.instructorAndTAsManager = instructorAndTAsManager;
        this.groupManager = groupManager;
        this.classRepository = classRepository;
    }

    /**

     */
    @GetMapping("/loginPage")
    public String getLoginScreen(Model theModel) {
        // create model attribute to bind form data
        User theUser = new Student();
        theModel.addAttribute("user", theUser);

        return "loginIndex";
    }

    /**
     Register new user to class
     */
    @PostMapping("/registerNewStudent")
    public String registerNewStudent(@ModelAttribute("user") Student newUser ) {
        loginManager.registerToSystem(newUser);

        //Save new student to class repository
        Class c = classRepository.findAll().get(0); //there is only one class --- SINGLETON --- eray hocam buraya bakın!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        c.addStudentId(newUser.getUserId());
        classRepository.save(c);

        // use a redirect to prevent duplicate submissions
        return "redirect:/loginPage";
    }

    /**
     Login to the system
     */
    @PostMapping("/loginToSystem")
    public String loginToTheSystem(@ModelAttribute("user") User theUser, Model theModel) {

        if(loginManager.logintoSystem(theUser, theModel) != null) {
            theModel = loginManager.logintoSystem(theUser, theModel);
            if (theModel.getAttribute("studentModel") != null) {
                Student s = (Student) theModel.getAttribute("studentModel");
                if (s.isGroupMember()) {
                    return "studentDashboard";
                } else {
                    return "noGroupDashboard";
                }
            } else if(theModel.getAttribute("instructorModel") != null) {
                InstructorAndTAs ins = (InstructorAndTAs) theModel.getAttribute("instructorModel");
                return "InstructorDashboard";
            }
        }
        return  "redirect:/loginPage";

    }


}
