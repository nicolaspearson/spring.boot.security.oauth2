package com.lupinemoon.dao;

import com.lupinemoon.model.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleDao extends CrudRepository<SysUser, Long> {

}