package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.User;
import AIProject.KulkiApi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/user")
    public User getUser(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.getUser(email, password);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}
