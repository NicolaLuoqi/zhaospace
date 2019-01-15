package com.shiliu.zhaospace.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {

    public static String encode(String password){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        password=passwordEncoder.encode(password);
        return password;
    }
}
