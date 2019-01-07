package AIProject.KulkiApi.services;

import AIProject.KulkiApi.Model.User;
import AIProject.KulkiApi.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    private Logger logger;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.logger = LoggerFactory.getLogger(UserService.class);
    }

    public User getUser(String email, String password){

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

    public User addUser(User user){
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
    public User getUserById(Integer id){
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
