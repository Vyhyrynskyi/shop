package edu.karazin.shop.dao;

import org.springframework.data.repository.CrudRepository;

import edu.karazin.shop.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
