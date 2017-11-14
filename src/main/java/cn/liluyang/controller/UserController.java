package cn.liluyang.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.liluyang.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	// 线程安全的Map
	static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer,User>());
	
	public UserController() {
		users.put(01, new User(1,17,"宫水三叶"));
		users.put(02, new User(2,17,"立花泷"));
	}
	
	@ApiOperation(value="查询用户列表")
	@GetMapping
	public List<User> list() {
		List<User> userList = new ArrayList<>(users.values());
		return userList;
	}
	
	@ApiOperation(value="创建用户",notes="根据传入的参数创建用户")
	@ApiImplicitParam(name="user", value="用户实体类", required = true, dataType = "User")
	@PostMapping
	public String post(@RequestBody User user) {
		users.put(user.getId(), user);
		return "success";
	}
	
	@ApiOperation(value="删除用户")
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		users.remove(id);
		return "success";
	}
	
	@ApiOperation(value="修改用户")
	@PutMapping("/{id}")
	public String post(@PathVariable Integer id, @ModelAttribute User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}
	
	@GetMapping("/error")
	public Object error() {
		throw new RuntimeException();
	}
}