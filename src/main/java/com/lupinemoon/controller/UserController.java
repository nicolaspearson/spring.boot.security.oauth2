package com.lupinemoon.controller;

import com.lupinemoon.model.SysUser;
import com.lupinemoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@SuppressWarnings("unused")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('CRUD_USERS') or hasAuthority('READ_USERS')")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('CRUD_USERS')")
    public List<SysUser> listUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('CRUD_USERS')")
    public SysUser create(@RequestBody SysUser sysUser) {
        return userService.save(sysUser);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('CRUD_USERS')")
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }

}
