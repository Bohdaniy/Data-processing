package lab5.Controllers;

import lab5.entity.User;
import lab5.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    userRepository repo;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user){
        return repo.save(user);

    }

    @GetMapping("/retrieve")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        repo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public User putUser(@PathVariable int id, @RequestBody User newuser){
        User updatedUser = repo.findById(id).orElseThrow(()->  new ResourceAccessException("Not found User with id: "+id));
        updatedUser.setName(newuser.getName());
        updatedUser.setEmail(newuser.getEmail());
        updatedUser.setPassword(newuser.getPassword());
        updatedUser.setAge(newuser.getAge());
        updatedUser.setCountry(newuser.getCountry());
        updatedUser.setLang(newuser.getLang());
        updatedUser.setPassword(newuser.getPassword());
        updatedUser.setImage(newuser.getImage());
        updatedUser.setLogin(newuser.getLogin());
        updatedUser.setPhone(newuser.getPhone());
       return repo.save(updatedUser);

    }

}
