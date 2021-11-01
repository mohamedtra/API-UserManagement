package com.mohamedtra.userManagement.api.test.userUtil;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mohamedtra.userManagement.api.userUtil.UserUtil;

public class UserUtilTest {
	
	@Test
    @DisplayName("Check a valid majority")
    public void isValidMajor(){
		assertThat(UserUtil.isMajor(LocalDate.of(2000, 12, 13))).isEqualTo(true).as("Should be a major");
        //assertEquals(true, UserUtil.isMajor(LocalDate.of(2000, 12, 13)), "Should be a major");
    }

    @Test
    @DisplayName("Check a non valid majority")
    public void isNonValidMajor(){
    	assertThat(UserUtil.isMajor(LocalDate.of(2010, 12, 13))).isEqualTo(false).as("Should be a non valid major");
        // assertEquals(false, UserUtil.isMajor(LocalDate.of(2010, 12, 13)), "Should be a non valid major");
    }
}
