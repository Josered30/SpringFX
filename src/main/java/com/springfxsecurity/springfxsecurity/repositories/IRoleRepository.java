package com.springfxsecurity.springfxsecurity.repositories;

import com.springfxsecurity.springfxsecurity.entities.Role;
import com.springfxsecurity.springfxsecurity.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}