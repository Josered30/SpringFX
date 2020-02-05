package com.springfxsecurity.springfxsecurity.repositories;

import com.springfxsecurity.springfxsecurity.customRepositories.UserRepositoryCustom;
import com.springfxsecurity.springfxsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}