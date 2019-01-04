package AIProject.KulkiApi.Repositories;

import AIProject.KulkiApi.Dto.TopResults;
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

    @Query(
            value = "select * from game as g order by g.result desc limit 5",
            nativeQuery = true)
    List<Game> findTop5OrderByResultDesc();


    @Query(
            value = "select g.result g.date u.name from game as g " +
                    "inner join user as u on g.user_id == u.id " +
                    "order by g.result desc limit 5",
            nativeQuery = true)
    List<TopResults> findTop5OrderByResultDescWithNames();

}
