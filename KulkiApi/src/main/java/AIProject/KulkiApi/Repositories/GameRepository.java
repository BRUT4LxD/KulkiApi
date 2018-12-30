package AIProject.KulkiApi.Repositories;

import AIProject.KulkiApi.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM Game g WHERE g.user.id = id")
    List<Game> findGamesbyUserId(Integer id);
}
