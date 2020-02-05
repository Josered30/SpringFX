package com.springfxsecurity.springfxsecurity.repositories;

import com.springfxsecurity.springfxsecurity.entities.Permission;
import com.springfxsecurity.springfxsecurity.entities.PermissionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IPermissionRepository  extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(PermissionName permissionName);
}
