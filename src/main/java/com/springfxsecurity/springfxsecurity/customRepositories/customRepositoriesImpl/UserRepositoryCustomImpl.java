package com.springfxsecurity.springfxsecurity.customRepositories.customRepositoriesImpl;

import com.springfxsecurity.springfxsecurity.customRepositories.UserRepositoryCustom;
import com.springfxsecurity.springfxsecurity.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


//name - nameImpl   Name convention

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User customFind(Long id) throws Exception {
           return entityManager.find(User.class,id);
    }
}
