package com.koal.learning.springboot.chapter.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.koal.learning.springboot.chapter.entity.User;
import com.koal.learning.springboot.chapter.exception.CommonsException;
import com.koal.learning.springboot.chapter.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangS
 * @since 2018-08-29
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("add")
	// 正常业务下 会在user对象中进行事物的控制 而不是在 控制层进行
//	@Transactional(rollbackFor = Exception.class)
	public Map<String, String> addUser(@Valid @RequestBody UserReq userReq) {
		User user = new User();
		user.setCode(userReq.getCode());
		user.setName(userReq.getName());
		// 设置了主键策略 id可以自动生成
		// 插入
		userService.insert(user);

		Map<String, String> result = new HashMap<>();
		result.put("respCode", "10000");
		result.put("respMsg", "sucess");
		// 事物测试
//		System.out.println(1/0);
		return result;
	}

	@PostMapping("update")
	public Map<String, String> updateUser(@Valid @RequestBody UserReq userReq) {
		if (StringUtils.isEmpty(userReq.getId())) {
			throw new CommonsException("1000", "更新时主键是空！！！");
		}
		User user = new User();
		user.setCode(userReq.getCode());
		user.setName(userReq.getName());
		user.setId(Long.parseLong(userReq.getId()));
		// 设置了主键策略 id可以自动生成
		// 插入
		userService.updateById(user);

		Map<String, String> result = new HashMap<>();
		result.put("respCode", "10000");
		result.put("respMsg", "sucess");
		// 事物测试
//		System.out.println(1/0);
		return result;
	}

	@GetMapping("/get/{id}")
	public Map<String, Object> getUser(@PathVariable("id") String id) {
		User user = userService.selectById(id);
		if (user == null) {
			throw new CommonsException("0001", "用户ID：" + id + "，未找到");
		}
		UserResp resp = UserResp.builder().id(user.getId().toString()).code(user.getCode()).name(user.getName())
				.status(user.getStatus()).build();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "01");
		result.put("respMsg", "成功");
		result.put("data", resp);
		return result;

	}
	@GetMapping("/page")
    public Map<String,Object> pageUser(int current, int size){
        //分页
        Page<User> page = new Page<>(current, size);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "01");
        result.put("respMsg", "成功");
        result.put("data", userService.selectPage(page));
        return result;
    }
}
