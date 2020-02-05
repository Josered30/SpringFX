package com.springfxsecurity.springfxsecurity.services.impl;

import com.springfxsecurity.springfxsecurity.entities.User;
import com.springfxsecurity.springfxsecurity.repositories.IUserRepository;
import com.springfxsecurity.springfxsecurity.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        userRepository.deleteById((long)id);
    }

    @Override
    public Optional<User> findById(Integer id) throws Exception {
        return userRepository.findById((long)id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String test()throws Exception {
        return "Hello";
    }


    @Override
    public User customFind(Long id) throws Exception {
        return userRepository.customFind(id);
    }
}
