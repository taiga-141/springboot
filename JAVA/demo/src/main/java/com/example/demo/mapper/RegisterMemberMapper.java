package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MemberRegistrationEntity;

@Mapper
public interface RegisterMemberMapper {

	//会員情報をUSERテーブルにinsertする。
	public void insertMemberInfo(MemberRegistrationEntity entity);
}