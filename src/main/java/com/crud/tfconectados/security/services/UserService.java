package com.crud.tfconectados.security.services;


import com.crud.tfconectados.security.entities.User;
import com.crud.tfconectados.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {

        userRepository.save(user);
    }

    public Integer insertUserRol(Long user_id, Long rol_id) {
        userRepository.insertUserRol(user_id, rol_id);
        return 1;
    }

}
