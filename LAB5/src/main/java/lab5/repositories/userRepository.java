package lab5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lab5.entity.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
//@RepositoryRestResource(collectionResourceRel = "user1", path = "user")
public interface userRepository extends JpaRepository<User, Integer> {

//  List<User> findByLastName(@Param("name") String name);

}