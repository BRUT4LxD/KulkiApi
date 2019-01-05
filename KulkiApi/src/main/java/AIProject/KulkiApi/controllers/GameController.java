package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.Game;
import AIProject.KulkiApi.Model.User;
import AIProject.KulkiApi.Repositories.GameRepository;
import AIProject.KulkiApi.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class GameController {

    private Logger logger;
    private GameRepository gameRepository;
    private UserRepository userRepository;
    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        logger = LoggerFactory.getLogger(GameController.class);
    }

    @GetMapping("/game/{id}")
    public List<Game> getAllGamesById(@PathVariable Integer id){
        List<Game> games;
        try{
            games = gameRepository.findGamesbyUserId(id);
            logger.info("All games with user_id = " + id + " has been retrieved from the database.");
        }
        catch (Exception e){
            logger.info("There was a problem with gathering games by user id = " + id + " from the database.");
            return null;
        }
        return games;
    }

    @GetMapping("/games")
    public List<Game> getAllGames(){
        List<Game> games;

        try{
            games = gameRepository.findAll();
            logger.info("All games has been retrieved from the database.");
        }
        catch (Exception e){
            logger.info("There was a problem with gathering all games from the database.");
            return null;
        }
        return games;
    }
    @PostMapping("/game/{userId}")
    public Game addGame(@PathVariable Integer userId, @RequestBody Game game){

        try{
            System.out.println("siema");
            User user = userRepository.findById(userId);
            game.setUser(user);
            gameRepository.save(game);
            logger.info("New game has been created");
        }
        catch (Exception e){
            logger.info("There was a problem with creating the game.");
            return null;
        }
        return null;
    }

    @GetMapping("/games/top5")
    public List<Game> getTop5Games(){
        List<Game> games;
        try{
            games = gameRepository.findTop5OrderByResultDesc();
            logger.info("Top 5 games by result has been retrieved from the database.");
        }
        catch (Exception e){
            logger.info("There was a problem with gathering top 5 games by result from the database.");
            return null;
        }
        return games;
    }
}
