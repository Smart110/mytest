package com.jdbc.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.StudentDao.StudentDao;
import com.jdbc.jdbc.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao; 
	@Override
	public int add(Student student) {
		 return studentDao.add(student);
	}

	@Override
	public int update(Student student) {
		  return studentDao.update(student);
	}

	@Override
	public int delete(int id) {
		 return studentDao.delete(id);
	}

	@Override
	public Student findStudentById(int id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public List<Student> findStudentList() {
		return studentDao.findStudentList();
	}

}
