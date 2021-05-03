//package cs319.group1e.repositories;
package cs319.group1e.procheck319;

import cs319.group1e.procheck319.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{

    /*
    ---How to implement---
    User user = new User();
    user = userRepository.findByUserId(theUser.getUserId());

    //Print to see if it works
    System.out.println(user.getUserName());
    System.out.println(user.getUserSurname());
    */
    Student findByUserId(int id);
}
