package AIProject.KulkiApi.services;

import AIProject.KulkiApi.Model.Game;
import AIProject.KulkiApi.Model.User;
import AIProject.KulkiApi.Repositories.GameRepository;
import AIProject.KulkiApi.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final Logger logger;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public GameService(GameRepository gameRepository, UserRepository userRepository) {
        this.logger = LoggerFactory.getLogger(GameService.class);
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public List<Game> getAllGamesById(Integer id){
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
    public Game addGame(Integer userId, Game game){

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
