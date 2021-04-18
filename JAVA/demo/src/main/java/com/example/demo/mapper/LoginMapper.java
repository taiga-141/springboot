package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Account;

@Mapper
public interface LoginMapper {

    public Account findAccount(String name);
}