package com.weather.data.test.bean;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weather.core.exception.WeatherException;
import com.weather.data.dao.UserDao;
import com.weather.data.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional
public class TestUserDao {

	@Autowired
	UserDao userDao;
	
	@Test
	@Rollback
	public void testAddNewUser()
	{
		String userName = "ramy123";
		String password = "12345678";
		String email = "ramyfeteha@gmail.com";
		String mobile = "012345677";
		boolean admin = true;
		
		User user = new User();
		user.setName(userName);
		user.setPassword(password);				
		user.setEmail(email);
		user.setMobile(mobile);
		user.setAdmin(admin);
		
		try {
			userDao.createUser(user);
		} catch (WeatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//User newUser = userDao.getUserByUserEmailAndPassword(email, password);
		//Assert.assertEquals("User is not the same", user , newUser);				
	}
	
}
