package com.jdbc.StudentService;

import java.util.List;



import com.jdbc.jdbc.Student;

public interface StudentService {
	int add(Student student);

    int update(Student student);

    int delete(int id);

    Student findStudentById(int id);

    List<Student> findStudentList();
}
