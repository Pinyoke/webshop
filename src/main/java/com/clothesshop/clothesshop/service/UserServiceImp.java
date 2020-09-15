package com.clothesshop.clothesshop.service;

import com.clothesshop.clothesshop.modell.Role;
import com.clothesshop.clothesshop.modell.User;
import com.clothesshop.clothesshop.repository.RoleRepository;
import com.clothesshop.clothesshop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final String ROLE_USER = "ROLE_USER";
    private final String ROLE_ADMIN = "ROLE_ADMIN";

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user) {

            user.setRole(roleRepository.findByName(ROLE_USER));
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        //Jelszót!

        return userRepository.save(user);
    }

    @Override
    public void createRole() {

        Role roleUser = new Role();
        roleUser.setName(ROLE_USER);
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName(ROLE_ADMIN);
        roleRepository.save(roleAdmin);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
