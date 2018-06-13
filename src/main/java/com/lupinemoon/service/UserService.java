package com.lupinemoon.service;

import com.lupinemoon.model.SysUser;

import java.util.List;

public interface UserService {

    SysUser save(SysUser sysUser);

    List<SysUser> findAll();

    void delete(long id);
}
