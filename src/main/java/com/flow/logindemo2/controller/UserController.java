package com.flow.logindemo2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flow.logindemo2.mapper.UserMapper;
import com.flow.logindemo2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("{id}/")
    public User userIndex(@PathVariable int id) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id);
        User user = userMapper.selectOne(userQueryWrapper);
        return user;
    }

    @GetMapping("all/")
    public List<User> getAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @GetMapping("update/{id}/{username}/{password}/")
    public String userUpdate(
            @PathVariable int id,
            @PathVariable String username,
            @PathVariable String password) {
        User user = userMapper.selectById(id);
        user.setUsername(username);
        user.setPassword(password);
        return "Update User Successfully";
    }

    @GetMapping("delete/{id}/")
    public String userDelete(@PathVariable int id) {
        userMapper.deleteById(id);
        return "Delete User Successfully";
    }

    @GetMapping("add/{id}/{username}/{password}/")
    public String userInsert(
            @PathVariable int id,
            @PathVariable String username,
            @PathVariable String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(password);
        userMapper.insert(new User(id, username, encode));
        return "Add User Successfully";
    }
}
