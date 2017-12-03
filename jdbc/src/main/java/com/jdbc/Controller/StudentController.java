package com.jdbc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.StudentService.StudentService;
import com.jdbc.jdbc.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	//查询所有
	@PostMapping(value="/list")
	public List<Student> getStudent(){
		return studentService.findStudentList();
	}
	//查询id
	@PostMapping(value="/byid")
	public Student getStudentById(@RequestParam(value="id") Integer id){
		return studentService.findStudentById(id);
		
	}
	//更改
	@PostMapping(value="/update")
	public  String updateStudent(@RequestParam(value="id") Integer id , @RequestParam(value = "name") String name,
		    @RequestParam(value = "age" )Integer age){
		        Student student=new Student();
		        student.setName(name);
		        student.setAge(age);
		        student.setId(id);
		        int t=studentService.update(student);
		        if(t==1){
		            return student.toString();
		        }else {
		            return "fail";
		        }
		    }
	//添加数据
	@PostMapping(value="/add")
	public String addStudent(@RequestParam(value="name") String name,
	                           @RequestParam(value="age") Integer age){
		Student student=new Student();
		student.setName(name);
		student.setAge(age);
		int t=studentService.add(student);
		if(t==1){
			return student.toString();
		 }else {
	            return "fail";
	        }	
	}
	
}
