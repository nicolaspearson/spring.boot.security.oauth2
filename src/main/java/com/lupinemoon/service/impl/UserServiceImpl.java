package com.lupinemoon.service.impl;

import com.lupinemoon.dao.SysUserDao;
import com.lupinemoon.model.SysUser;
import com.lupinemoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service(value = "userService")
@SuppressWarnings("unused")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> sysUser = sysUserDao.findByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return sysUser.map(user -> {
            Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
    }

    @Override
    public List<SysUser> findAll() {
        List<SysUser> list = new ArrayList<>();
        sysUserDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        sysUserDao.deleteById(id);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserDao.save(sysUser);
    }
}
