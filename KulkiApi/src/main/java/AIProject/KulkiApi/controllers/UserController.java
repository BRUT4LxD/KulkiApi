package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.User;
import org.springframework.web.bind.annotation.*;
import AIProject.KulkiApi.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class UserController {

    private final UserRepository userRepository;
    private Logger logger;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.logger = LoggerFactory.getLogger(UserController.class);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("email") String email, @RequestParam("password") String password){

        User user;
        try{
            user = userRepository.findByEmailAndPassword(email,password);
            logger.info("User has been gathered by email: " + email);
        }
        catch(Exception e){
            logger.error("There was a problem with gathering User by email and password");
            throw e;
        }
        return user;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        try{
            userRepository.save(user);
            logger.info("User with id=" + user.getId() + " has been successfully added to database");
        }
        catch(Exception e){
            logger.error("There was a problem with adding user with id=" + user.getId());
            throw e;
        }
        return null;
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users;
        try{
            users = userRepository.findAll();
            logger.info("All users has been retrieved from the database");
        }
        catch(Exception e){
            logger.error("There was a problem with retrieving all users from the database");
            throw e;
        }
        return users;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user;
        try{
            user = userRepository.findById(id);
            logger.info("User has been gathered by id: " + id);
        }
        catch(Exception e){
            logger.error("There was a problem with gathering User by id");
            throw e;
        }

        return user;
    }
}
