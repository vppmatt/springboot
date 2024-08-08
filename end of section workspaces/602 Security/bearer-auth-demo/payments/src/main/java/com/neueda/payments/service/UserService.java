package com.neueda.payments.service;

import com.neueda.payments.model.User;

import java.util.List;

public interface UserService {
    User getById(Long id);

    List<User> getAll();

    User save(User user);

}
