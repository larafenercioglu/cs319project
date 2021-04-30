package cs319.group1e.procheck319;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<Class, Integer> {

    /*
    ---How to implement---
    User user = new User();
    user = userRepository.findByUserId(theUser.getUserId());

    //Print to see if it works
    System.out.println(user.getUserName());
    System.out.println(user.getUserSurname());
    */
    Class findByClassId(int id);
}
