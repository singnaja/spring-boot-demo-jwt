package com.demo.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.demo.model.Member;
import com.demo.service.MemberService;
import com.demo.util.DemoUtils;







@RestController
public class MemberController {

	@Autowired
    private MemberService memberService;

	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity saveMember(@RequestBody Member req){

		
		if(req.getUsername() == null || "".equals(req.getUsername())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserName is required.");
		}

		if(req.getPassword() == null || "".equals(req.getPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password is required.");
		}

		if(req.getPhone() == null || "".equals(req.getPhone())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone is required.");
		}

		if(req.getPhone().length() < 4) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone is invalid.");
		}

		if(req.getSalary() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Salary is required.");
		}

		Member newMember = new Member();
		newMember.setMembercode(DemoUtils.genMemberCode(new Date(),req.getPhone()));
		newMember.setUsername(req.getUsername());
		newMember.setPassword(bcryptEncoder.encode(req.getPassword()));
		newMember.setAddress(req.getAddress());
		newMember.setPhone(req.getPhone());

		if(req.getSalary() < 15000) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Salary must be more than 15000.");
		}else{
			newMember.setMembertype(DemoUtils.genMemberType(req.getSalary()));
		}

		newMember.setSalary(req.getSalary());
		return new ResponseEntity(memberService.save(newMember), HttpStatus.OK);

	}

	

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
    public Member getOne(@PathVariable(value = "id") String id){
        return memberService.getMemberById(id);
    }



}


