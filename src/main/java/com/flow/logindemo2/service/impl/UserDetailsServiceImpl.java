package com.flow.logindemo2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flow.logindemo2.mapper.UserMapper;
import com.flow.logindemo2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        User user = userMapper.selectOne(userQueryWrapper);
        if(user == null) {
            throw new RuntimeException("不存在该用户!");
        }

        return new UserDetailsImpl(user);
    }
}
