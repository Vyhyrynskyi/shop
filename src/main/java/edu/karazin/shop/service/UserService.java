package edu.karazin.shop.service;

import edu.karazin.shop.entity.User;

public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    User getUser(String login);
}
