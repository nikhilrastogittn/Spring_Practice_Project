package com.project.main.service;

import com.project.main.entity.JournalEntry;
import com.project.main.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    Object getById(String id);

    void add(User user);

    Object getAll();

    void deleteById(String id);

    void update(User user);

    List<User> getAllByPassword(String password);
}
