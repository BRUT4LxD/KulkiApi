package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.User;
import org.springframework.web.bind.annotation.*;
import AIProject.KulkiApi.Repositories.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("email") String email, @RequestParam("password") String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();

        return users;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = new User();
        try{
            user = userRepository.findById(id);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return user;
    }
}
