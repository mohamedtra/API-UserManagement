package com.mohamedtra.userManagement.api.userUtil;

import java.time.LocalDate;

import com.mohamedtra.userManagement.api.Constants.Constants;

/**
 * Class utils to use in all project
 * @author mohamed
 * 
 *
 */
public class UserUtil {
	
	/**
	 * Method to check if some user is adult
	 * @param localDate
	 * @return a boolean
	 */
	public static boolean isMajor(LocalDate localDate) {
        return LocalDate.now().getYear() - localDate.getYear() > Constants.AGE_AUTHORISED ||
                (LocalDate.now().getYear() - localDate.getYear() == Constants.AGE_AUTHORISED
                        && LocalDate.now().getDayOfYear() > localDate.getDayOfYear());
    }
}
