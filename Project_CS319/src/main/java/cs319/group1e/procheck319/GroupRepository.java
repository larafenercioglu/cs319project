package cs319.group1e.procheck319;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer> {

    /*
    ---How to implement---
    User user = new User();
    user = userRepository.findByUserId(theUser.getUserId());

    //Print to see if it works
    System.out.println(user.getUserName());
    System.out.println(user.getUserSurname());
    */
    Group findByGroupId(int id);
}
