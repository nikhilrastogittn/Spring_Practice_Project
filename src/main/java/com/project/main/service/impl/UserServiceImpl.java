package com.project.main.service.impl;

import com.project.main.entity.User;
import com.project.main.repository.UserRepository;
import com.project.main.service.JournalEntryService;
import com.project.main.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private JournalEntryService journalEntryService;


    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void add(User user) {
        if (!user.getJournalEntryList().isEmpty())
            user.setJournalEntryList(journalEntryService.addAll(user.getJournalEntryList()));
//        user.setUsername(null);
        userRepository.save(user);
    }

    @Override
    public Object getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid User"));
        journalEntryService.deleteAll(user.getJournalEntryList());
        userRepository.deleteById(id);


    }

    @Override
    public void update(User user) {
        User currentUser = userRepository.findById(user.getId()).orElse(null);

        if (currentUser != null) {
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
            if (!user.getJournalEntryList().isEmpty())
                currentUser.setJournalEntryList(journalEntryService.addAll(user.getJournalEntryList()));
            userRepository.save(currentUser);

        } else throw new RuntimeException("Invalid User or User not found");
    }


    @PostConstruct
    void test(){
        getAllByPassword("123456");
    }

    @Override
    public List<User> getAllByPassword(String password){

        List<User> users= userRepository.findByPassword(password);
        System.out.println(users);
        return users;
    }


}
