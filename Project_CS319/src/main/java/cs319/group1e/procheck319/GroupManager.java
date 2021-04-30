package cs319.group1e.procheck319;
import cs319.group1e.procheck319.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GroupManager {
    @Autowired
    private GroupRepository groupRepository;

    public GroupManager(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    //Group Formation page
    @GetMapping("/formGroup")
    public String getMain(Model theModel) {
        // create model attribute to bind form data
        Group theGroup = new Group();

        theModel.addAttribute("group", theGroup);
        return "";
    }

    @GetMapping("/allGroups")
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    @DeleteMapping(value = "deleteGroup/{groupId}")
    public String deleteGroup(@PathVariable("groupId") int id) {
        groupRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@RequestBody Group theGroup) {
        groupRepository.save(theGroup);

        return "redirect:/";
    }

}
