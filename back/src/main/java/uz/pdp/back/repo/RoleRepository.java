package uz.pdp.back.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.back.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}