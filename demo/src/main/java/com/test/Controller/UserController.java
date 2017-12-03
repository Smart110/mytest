package com.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.Dao.UserDao;
import com.test.Pojo.User;
import com.test.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
    private UserService userService;
	
	
	@GetMapping("/findAll")
    public List<User> getAll() {
        return userDao.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        System.out.println("name=" + name + "\tage=" + age);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userDao.save(user);
    }

    @PostMapping("/findOne")
    public User findOne(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        return userDao.findOne(id);
    }

    @PostMapping("/update")
    public User update(@RequestParam("id") Integer id, @RequestParam("name") String score, @RequestParam("age") Integer age) {
        System.out.println("name=" + score + "\tage=" + age);
        User user = new User();
        user.setId(id);//带有id,表示更新
        user.setName(score);
        user.setAge(age);
        return userDao.save(user);
    }


    @PostMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        userDao.delete(id);
    }

    
    @PostMapping("/findByAge")
    public List<User> findByAge(@RequestParam("age") Integer age) {
        return userDao.findByAge(age);
    }

    @PostMapping("/addTwo")
    public void addTwo(@RequestParam("a") String a, @RequestParam("b") String b) {
        userService.insertTwo(a, b);
    }

}
