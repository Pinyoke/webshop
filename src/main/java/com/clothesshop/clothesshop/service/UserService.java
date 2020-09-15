package com.clothesshop.clothesshop.service;

import com.clothesshop.clothesshop.modell.User;

public interface UserService {

    User save(User user);

    void createRole();

    void deleteUser(Long id);



}
