package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.Game;
import AIProject.KulkiApi.Model.User;
import AIProject.KulkiApi.Repositories.GameRepository;
import AIProject.KulkiApi.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class GameController {

    private GameRepository gameRepository;
    private UserRepository userRepository;
    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/game")
    public List<Game> getAllGamesById(@PathVariable Integer id){
        List<Game> games = gameRepository.findGamesbyUserId(id);
        return games;
    }

    @GetMapping("/games")
    public List<Game> getAllGames(){
        List<Game> games = gameRepository.findAll();
        return games;
    }
    @PostMapping("/game/{userId}")
    public Game addGame(@PathVariable Integer userId, @RequestBody Game game){
        System.out.println("siema");
        User user = userRepository.findById(userId);
        game.setUser(user);
        return gameRepository.save(game);
    }
}
