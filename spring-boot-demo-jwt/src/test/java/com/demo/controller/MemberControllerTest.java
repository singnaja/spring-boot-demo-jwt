package com.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.demo.model.Member;
import com.demo.service.MemberService;
import com.demo.util.MockDataUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
@AutoConfigureMockMvc(secure=false)
public class MemberControllerTest {	

	@Autowired
    MockMvc mockMvc;	

	@MockBean
	MemberService memberService;	

	@MockBean
	private BCryptPasswordEncoder bcryptEncoder;	

	@Autowired
    ObjectMapper objectMapper;	

	@Test
    public void testCreateMemberSuccessfully() throws Exception {
		
        //Arrange
        Member newMember = MockDataUtils.createMember();	
        when(memberService.save(any(Member.class))).thenReturn(newMember);


        //Act
        ResultActions result = mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(newMember)));


        //Assert
        result.andExpect(status().isOk())
        .andExpect(jsonPath("$.membercode", is(newMember.getMembercode())))
        .andExpect(jsonPath("$.address", is(newMember.getAddress())))
        .andExpect(jsonPath("$.membertype", is(newMember.getMembertype())))
        .andExpect(jsonPath("$.phone", is(newMember.getPhone())))
        .andExpect(jsonPath("$.username", is(newMember.getUsername())))
        .andExpect(jsonPath("$.salary", is(newMember.getSalary())));
        verify(memberService).save(any(Member.class));
    }

	@Test
	public void testCreateMemberBadRequest() throws Exception {		

        //Arrange
        Member newMember = MockDataUtils.createMemberWithoutUserName();
        when(memberService.save(any(Member.class))).thenReturn(newMember);


        //Act
        ResultActions result = mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(newMember)));

        //Assert
        result.andExpect(status().isBadRequest()).andExpect(content().string("UserName is required."));
    }

	

	@Test
    public void testGetMemberSuccessfully() throws Exception {		
		

        //Arrange
		Member newMember = MockDataUtils.createMember();
        when(memberService.getMemberById(newMember.getMembercode())).thenReturn(newMember);

        //Act
        ResultActions result = mockMvc.perform(get("/member/{id}",newMember.getMembercode())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(newMember)));

        //Assert
        result.andExpect(status().isOk())
        .andExpect(jsonPath("$.membercode", is(newMember.getMembercode())))
        .andExpect(jsonPath("$.address", is(newMember.getAddress())))
        .andExpect(jsonPath("$.membertype", is(newMember.getMembertype())))
        .andExpect(jsonPath("$.phone", is(newMember.getPhone())))
        .andExpect(jsonPath("$.username", is(newMember.getUsername())))
        .andExpect(jsonPath("$.salary", is(newMember.getSalary())));
        verify(memberService).getMemberById(newMember.getMembercode());

    

    }
}


