package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class ClassManager {

    @Autowired
    private LoginManager loginManager;
    private StudentManager studentManager;
    private InstructorAndTAsManager instructorAndTAsManager;
    private GroupManager groupManager;
    private ClassRepository classRepository;
    private DbSeeder dbSeeder;
    private Class aClass;

    //Constructor
    public ClassManager(LoginManager loginManager, StudentManager studentManager,
                        InstructorAndTAsManager instructorAndTAsManager, GroupManager groupManager, ClassRepository classRepository){
        this.loginManager = loginManager;
        this.studentManager = studentManager;
        this.instructorAndTAsManager = instructorAndTAsManager;
        this.groupManager = groupManager;
        this.classRepository = classRepository;

        dbSeeder = new DbSeeder(this.studentManager.getStudentRepository(), this.groupManager.getGroupRepository(),
                this.classRepository, this.instructorAndTAsManager.getInstructorAndTAsRepository());

        System.out.println(this.classRepository.findByClassId(319));
        System.out.println("*******" + aClass);
        //Class c = this.classRepository.findByClassId(319);
        this.aClass = (this.classRepository.findByClassId(319));
        System.out.println("--------" + aClass);
    }

    /**
     Open login page
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
        //Class aClass = classRepository.findAll().get(0); //there is only one class --- SINGLETON --- eray hocam buraya bakın!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        aClass.addStudentId(newUser.getUserId());
        classRepository.save(aClass);

        // use a redirect to prevent duplicate submissions
        return "redirect:/loginPage";
    }

    /**
     Login to the system
     */
    @PostMapping("/loginToSystem")
    public String loginToTheSystem(@ModelAttribute("user") User theUser, Model theModel,
                                   @ModelAttribute("newStudentModel") Student newStudent, @ModelAttribute("newInstructorModel") InstructorAndTAs newInstructor ) {

        if(loginManager.logintoSystem(theUser, theModel) != null) {
            theModel = loginManager.logintoSystem(theUser, theModel);
            if (theModel.getAttribute("studentModel") != null) {
                Student s = (Student) theModel.getAttribute("studentModel");
                newStudent.studentSetEqual(s);
                //If for dashboard
                if (newStudent.isGroupMember()) {
                    return "studentDashboard";
                } else {
                    return "noGroupDashboard";
                }
            } else if(theModel.getAttribute("instructorModel") != null) {
                InstructorAndTAs ins = (InstructorAndTAs) theModel.getAttribute("instructorModel");
                newInstructor.setInstructorEqual(ins);

                return "InstructorDashboard";
            }
        }
        return  "redirect:/loginPage";
    }

    @PostMapping("/formNewGroup")
    public String formNewGroup(@ModelAttribute("newStudentModel") Student theStudent) {

        //Get student from student repo
        System.out.println(studentManager.getStudentRepository().findByUserId(theStudent.getUserId()));
        theStudent.studentSetEqual(studentManager.getStudentRepository().findByUserId(theStudent.getUserId()));

        //Create group
        Group g = theStudent.formAGroup(aClass.assignGroupId(),5);
        //Add group to class repo
        aClass.addGroupId(g.getGroupId());

        //Add group to group repo
        groupManager.getGroupRepository().save(g);

        //Update student in student repo
        studentManager.getStudentRepository().save(theStudent);

        //Save to class repo
        classRepository.save(aClass);

        return "dashboardIndex";
    }
    // TODO: burayii kontrol edin-yeni yazdim
    @PostMapping("/sendRequestToGroup")
    public String sendRequestToGroup(@ModelAttribute("newStudentModel") Student theStudent,  int groupId){

    // get group from repo
    System.out.println("BAKALIM NEYMİŞ" + groupId);
    Group g = groupManager.getGroupRepository().findByGroupId(groupId);

    // get student from repo
        System.out.println("***********before " + theStudent);
        System.out.println("********--------" + studentManager.getStudentRepository().findByUserId(theStudent.getUserId()));
    theStudent.studentSetEqual(studentManager.getStudentRepository().findByUserId(theStudent.getUserId()));

    System.out.println(theStudent + "*****12312312");
    // call send request method and create request TODO
    g = theStudent.sendRequest(g);
    System.out.println(g);
    // update student in repo
    studentManager.getStudentRepository().save(theStudent);
    // update group in repo
    groupManager.getGroupRepository().save(g);

    classRepository.save(aClass);

    //TODO:redirect?
        return"redirect:/noGroupDashboard";
    }

}
