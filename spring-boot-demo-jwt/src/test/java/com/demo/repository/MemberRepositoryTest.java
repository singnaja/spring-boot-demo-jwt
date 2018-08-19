package com.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import com.demo.model.Member;
import com.demo.util.DemoUtils;
import com.demo.util.MockDataUtils;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

	

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private MemberRepository memberRepository;	

	@After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }
	

	@Test
    public void testFindById() {		

		//Arrange
        Member newMember = MockDataUtils.createMember();
        entityManager.persist(newMember);

        //Act
        Member memberOptional = memberRepository.findOne(newMember.getMembercode());

        //Assert
        assertThat(memberOptional.getMembercode()).isEqualTo(newMember.getMembercode());
    }

	

	@Test
    public void testFindByName() {
		

		//Arrange
        Member newMember = MockDataUtils.createMember();
        entityManager.persist(newMember);

        //Act
        Member memberOptional = memberRepository.findByUsername(newMember.getUsername());

        //Assert
        assertThat(memberOptional.getUsername()).isEqualTo(newMember.getUsername());

    }

}


