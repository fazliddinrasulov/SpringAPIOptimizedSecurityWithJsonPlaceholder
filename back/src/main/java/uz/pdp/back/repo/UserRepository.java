package uz.pdp.back.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.back.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}