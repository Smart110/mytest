package com.test.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.Pojo.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	//通过id查询
	User findById(Integer id);
	//通过年龄来查询
	List<User> findByAge(Integer age);
	
	
}
