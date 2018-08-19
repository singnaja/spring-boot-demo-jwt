package com.demo.util;

import java.util.Date;
import com.demo.model.Member;
import com.demo.req.GetTokenReq;



public class MockDataUtils {
	

	private static final String username = "asc222";
	private static final String password = "asc222";
	private static final String address = "299/129 Thailand";
	private static final String phone = "9876543210";
	private static final int salary = 35000;
	private static final String membertype = DemoUtils.genMemberType(salary);
	private static final String membercode = DemoUtils.genMemberCode(new Date(),phone);

	
	public static Member createMember() {
        return new Member(membercode, address, membertype, password, phone, username, salary);
    }


	public static Member createMemberWithoutUserName() {
        return new Member(membercode, address, membertype, password, phone, "", salary);
    }


	public static GetTokenReq createTokenReq() {
        return new GetTokenReq(username, password);
    }

}

