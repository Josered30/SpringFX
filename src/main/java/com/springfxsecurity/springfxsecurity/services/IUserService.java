package com.springfxsecurity.springfxsecurity.services;


import com.springfxsecurity.springfxsecurity.entities.User;

public interface IUserService extends CrudService<User> {
    String test() throws Exception ;
    User customFind(Long id) throws Exception;

}
