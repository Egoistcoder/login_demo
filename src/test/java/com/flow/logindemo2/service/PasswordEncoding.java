package com.flow.logindemo2.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncoding {

    @Test
    void encoding() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("111111"));
        System.out.println(bCryptPasswordEncoder.encode("222222"));
        System.out.println(bCryptPasswordEncoder.encode("333333"));

        /**
         $2a$10$setSZiUVg1UazTVM5BkA8uZWHk3GBxYzO2O.OkRy6z7v9A1m.25Du
         $2a$10$4T9c6v/u0jonJdU.G1JNNOFdfddvx0oh9VQbdAk7YNnLHKUD96gF2
         $2a$10$h6PzAi5qWgDGLs3TvdEWs.SAzORnnhy5733VfAv6MCbEzxDLKdrQa
         */
    }

}
