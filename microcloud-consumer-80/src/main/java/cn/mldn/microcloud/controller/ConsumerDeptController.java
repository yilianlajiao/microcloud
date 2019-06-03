package cn.mldn.microcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.mldn.vo.Dept;

@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
	public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
	public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";
	@Resource
	private RestTemplate restTemplate;
	@RequestMapping(value = "/consumer/dept/get")
	public Object getDept(long id) {
		Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + id,Dept.class);
		return dept;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		List<Dept> allDepts = this.restTemplate.getForObject(DEPT_LIST_URL,
				List.class); 
		return allDepts;
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) {
		Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL, dept,
				Boolean.class);
		return flag;
	}
}
