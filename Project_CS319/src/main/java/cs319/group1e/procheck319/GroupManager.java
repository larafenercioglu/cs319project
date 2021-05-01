package cs319.group1e.procheck319;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class GroupManager {

    @Autowired
    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public GroupManager(GroupRepository groupRepository, StudentRepository studentRepository){
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    /*
    //Group Formation page
    @GetMapping("/formGroup")
    public String getMain(Model theModel) {
        // create model attribute to bind form data
        Group theGroup = new Group();

        theModel.addAttribute("group", theGroup);
        return "";
    }
     */

    @GetMapping("/allGroups")
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    @DeleteMapping(value = "deleteGroup/{groupId}")
    public String deleteGroup(@PathVariable("groupId") int id) {
        groupRepository.deleteById(id);
        return "Group is deleted";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@RequestBody Group theGroup) {
        groupRepository.save(theGroup);
        return "New Group is created";
    }

    @PostMapping("/saveGroup/{groupId}/{userId}")
    public String addGroupMember(@PathVariable int groupId, @PathVariable int userId) {
        Group group = groupRepository.findByGroupId(groupId);
        group.getStudentIdList().add(userId);
        groupRepository.save(group);
        return "New member is added";
    }

    @GetMapping("/getAllGroupMembers/{groupId}")
    public List<Student> getGroupMembers(@PathVariable("groupId") int id) {
        Group group = groupRepository.findByGroupId(id);
        List<Integer> idList = group.getStudentIdList();
        List<Student> students = new ArrayList<>();
        for(int i = 0;i <idList.size(); i++) {
            students.add(studentRepository.findByUserId(idList.get(i)));
        }
        return students;
    }

    @PostMapping("/formNewGroup")
    public String formNewGroup(@ModelAttribute("user") Student theStudent) {

        groupRepository.save(theStudent.formAGroup(31, 5)); //TODO id artık parametre değil sıkıntı çıkarabilir
        studentRepository.save(theStudent);
        return "dashboardIndex";
    }

}
