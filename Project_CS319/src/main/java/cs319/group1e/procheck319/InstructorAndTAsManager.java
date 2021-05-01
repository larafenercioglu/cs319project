package cs319.group1e.procheck319;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InstructorAndTAsManager {
    private InstructorAndTAsRepository instructorAndTAsRepository;
    public InstructorAndTAsManager(InstructorAndTAsRepository instructorAndTAsRepository){
        this.instructorAndTAsRepository = instructorAndTAsRepository;
    }
}
