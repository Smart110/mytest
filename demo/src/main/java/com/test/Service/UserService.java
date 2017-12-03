package com.test.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.Dao.UserDao;
import com.test.Pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void insertTwo(String a ,String b){
		User userA=new User();
		userA.setName(a);
		userA.setAge(21);
		userDao.save(userA);
		
		User userB=new User();
		userB.setName(b);
		userB.setAge(22);
		userDao.save(userB);
	}
}
