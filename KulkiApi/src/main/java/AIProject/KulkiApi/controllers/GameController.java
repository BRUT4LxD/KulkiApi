package AIProject.KulkiApi.controllers;

import AIProject.KulkiApi.Model.Game;
import AIProject.KulkiApi.services.GameService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/{id}")
    public List<Game> getAllGamesById(@PathVariable Integer id){
        return gameService.getAllGamesById(id);
    }

    @GetMapping("/games")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }
    @PostMapping("/game/{userId}")
    public Game addGame(@PathVariable Integer userId, @RequestBody Game game){
        return gameService.addGame(userId, game);
    }

    @GetMapping("/games/top5")
    public List<Game> getTop5Games(){
        return gameService.getTop5Games();
    }

    @GetMapping("/games/time/{id}")
    public Integer timeSpentPlaying(@PathVariable Integer id){
        return gameService.timeSpentPlaying(id);
    }

    @GetMapping("/gamesByDate")
    public List<Game> gamesByDate(){
        return gameService.getAllGamesOrderByDate();
    }
}
