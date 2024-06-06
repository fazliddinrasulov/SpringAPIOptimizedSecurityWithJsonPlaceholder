package uz.pdp.back.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.back.entity.Role;
import uz.pdp.back.entity.User;
import uz.pdp.back.entity.enums.RoleEnum;
import uz.pdp.back.service.RoleService;
import uz.pdp.back.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) {
        if(ddl.equals("create")) {
            List<Role> roles = addRoles();
            List<User> users = addUsers(roles);
        }
    }

    private List<Role> addRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.save(Role.builder().role(RoleEnum.ROLE_ADMIN).build()));
        roles.add(roleService.save(Role.builder().role(RoleEnum.ROLE_USER).build()));
        return roles;
    }

    private List<User> addUsers( List<Role> roles) {
        List<User> users = new ArrayList<>();
        users.add(userService.save(User.builder()
                .username("eshmat@gmail.com")
                .password(passwordEncoder.encode("qwe"))
                .age(10)
                .roles(List.of(roles.get(0)))
                .build()));
        users.add(userService.save(User.builder()
                .username("toshmat@gmail.com")
                .password(passwordEncoder.encode("qwe"))
                .age(20)
                .roles(List.of(roles.get(1)))
                .build()));
        users.add(userService.save(User.builder()
                .username("hikmat@gmail.com")
                .password(passwordEncoder.encode("qwe"))
                .age(30)
                .roles(List.of(roles.get(1)))
                .build()));
        users.add(userService.save(User.builder()
                .username("nusrat@gmail.com")
                .password(passwordEncoder.encode("qwe"))
                .age(40)
                .roles(List.of(roles.get(1)))
                .build()));
        users.add(userService.save(User.builder()
                .username("qudrat@gmail.com")
                .password(passwordEncoder.encode("qwe"))
                .age(50)
                .roles(List.of(roles.get(1)))
                .build()));
        return users;
    }


}
