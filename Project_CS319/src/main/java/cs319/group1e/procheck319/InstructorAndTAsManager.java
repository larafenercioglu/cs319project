package cs319.group1e.procheck319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InstructorAndTAsManager {
    @Autowired
    private InstructorAndTAsRepository instructorAndTAsRepository;

    public InstructorAndTAsManager(InstructorAndTAsRepository instructorAndTAsRepository) {
        this.instructorAndTAsRepository = instructorAndTAsRepository;
    }
}
