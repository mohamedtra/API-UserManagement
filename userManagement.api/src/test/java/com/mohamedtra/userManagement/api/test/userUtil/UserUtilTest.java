package com.mohamedtra.userManagement.api.test.userUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohamedtra.userManagement.api.userUtil.UserUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserUtilTest {
	
	@Test
    @DisplayName("Check a valid majority")
    public void isValidMajor(){
		//assertThat(UserUtil.isMajor(LocalDate.of(2000, 12, 13))).isEqualTo(true).as("Should be a major");
		assertEquals(true, UserUtil.isMajor(LocalDate.of(2000, 12, 13)), "Should be a major");
    }

    @Test
    @DisplayName("Check a non valid majority")
    public void isNonValidMajor(){
    	//assertThat(UserUtil.isMajor(LocalDate.of(2010, 12, 13))).isEqualTo(false).as("Should be a non valid major");
        assertEquals(false, UserUtil.isMajor(LocalDate.of(2010, 12, 13)), "Should be a non valid major");
    }
}
