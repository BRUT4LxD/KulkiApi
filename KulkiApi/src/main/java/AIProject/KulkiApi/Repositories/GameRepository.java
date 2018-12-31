package AIProject.KulkiApi.Repositories;

import AIProject.KulkiApi.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(
            value = "select * from game as g where g.user_id = :id order by g.result desc limit 5",
            nativeQuery = true)
    List<Game> findGamesbyUserId(@Param("id") Integer id);

}
