package AIProject.KulkiApi.Repositories;

import AIProject.KulkiApi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends  JpaRepository<User, Long>{
    User findByEmailAndPassword(String email, String password);
    User findById(Integer id);
}
