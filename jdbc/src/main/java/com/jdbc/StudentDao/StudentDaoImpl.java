package com.jdbc.StudentDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.jdbc.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//增加
	@Override
	public int add(Student student) {
	  return jdbcTemplate.update("insert into student(name, age) values(?, ?)",
	              student.getName(),student.getAge());
	}

	@Override
	public int update(Student student) {
		 return jdbcTemplate.update("UPDATE  student SET name=? ,age=? WHERE id=?",
	                student.getName(),student.getAge(),student.getId());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
	}

	@Override
	public Student findStudentById(int id) {
		 List<Student> list = jdbcTemplate.query("select * from student where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Student.class));
	        if(list!=null && list.size()>0){
	        	Student student = list.get(0);
	            return student;
	        }else{
	            return null;
	        }
	}

	@Override
	public List<Student> findStudentList() {
		 List<Student> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
	        if(list!=null && list.size()>0){
	            return list;
	        }else{
	            return null;
	        }
	}

}
