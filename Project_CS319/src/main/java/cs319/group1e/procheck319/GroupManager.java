package cs319.group1e.procheck319;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GroupManager {

    private GroupRepository groupRepository;

    //Constructor
    public GroupRepository getGroupRepository() {
        return groupRepository;
    }

    //Getters
    public GroupManager(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    //Setters
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @RequestMapping("/getAllGroups")
    public List<Group> getAllGroupsInRepo() {
        return groupRepository.findAll();
    }

}
