package com.sun.study.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러 라고 해주는 어노테이션
public class IndexController {
	
	// Get전송 index에 반응함
	@GetMapping("index")
	public String index() {
		return "index/index";
	}
	
}
