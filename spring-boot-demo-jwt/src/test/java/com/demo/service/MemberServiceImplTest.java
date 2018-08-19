package com.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.demo.model.Member;
import com.demo.repository.MemberRepository;
import com.demo.service.impl.MemberServiceImpl;
import com.demo.util.MockDataUtils;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTest {


	@Mock
	private MemberRepository memberRepository;	

	private MemberService memberService;
	

	@Before
    public void setUp() throws Exception {
		memberService = new MemberServiceImpl(memberRepository);
    }

	

	@Test
    public void createMemberSuccessfully() throws Exception {

        //Arrange
        doAnswer(returnsFirstArg()).when(memberRepository).save(any(Member.class));
        
        //Arrange
        Member newMember = MockDataUtils.createMember();

        //Act
        Member memberResponse = memberService.save(newMember);

        //Assert
        assertThat(memberResponse.getMembercode()).isEqualTo(newMember.getMembercode());
        verify(memberRepository).save(any(Member.class));

    }

	

	@Test
    public void getMemberByUserNameSuccessfully() throws Exception {		

		//Arrange
        Member newMember = MockDataUtils.createMember();
		when(memberRepository.findByUsername(newMember.getUsername())).thenReturn(newMember);		

        //Act
        Member memberResponse = memberService.getMemberByUserName(newMember.getUsername());

        //Assert
        assertThat(memberResponse.getUsername()).isEqualTo(newMember.getUsername());
        verify(memberRepository).findByUsername(newMember.getUsername());

    }
	

	@Test
    public void getMemberByIdSuccessfully() throws Exception {		

		//Arrange
        Member newMember = MockDataUtils.createMember();

		when(memberRepository.findOne(newMember.getMembercode())).thenReturn(newMember);		

        //Act
        Member memberResponse = memberService.getMemberById(newMember.getMembercode());

        //Assert
        assertThat(memberResponse.getMembercode()).isEqualTo(newMember.getMembercode());
        verify(memberRepository).findOne(newMember.getMembercode());

    }

}

