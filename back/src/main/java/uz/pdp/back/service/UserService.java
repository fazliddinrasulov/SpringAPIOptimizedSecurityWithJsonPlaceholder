package uz.pdp.back.service;

import org.springframework.stereotype.Service;
import uz.pdp.back.entity.User;

@Service
public interface UserService {
    User findByUsername(String username);

    User save(User user);

    String getAllUser();
}
