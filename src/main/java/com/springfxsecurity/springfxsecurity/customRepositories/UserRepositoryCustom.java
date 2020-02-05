package com.springfxsecurity.springfxsecurity.customRepositories;

import com.springfxsecurity.springfxsecurity.entities.User;

//name - nameImpl  Name convention

public interface UserRepositoryCustom {
    User customFind(Long id) throws Exception;
}
