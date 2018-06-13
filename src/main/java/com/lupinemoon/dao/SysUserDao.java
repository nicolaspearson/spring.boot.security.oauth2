package com.lupinemoon.dao;

import com.lupinemoon.model.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserDao extends CrudRepository<SysUser, Long> {
    Optional<SysUser> findByUsername(String username);
}
