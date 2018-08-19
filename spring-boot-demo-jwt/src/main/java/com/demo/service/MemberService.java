package com.demo.service;

import com.demo.model.Member;

public interface MemberService {
	
	Member save(Member member);
	Member getMemberByUserName(String userName);
	Member getMemberById(String memberCode);


}
