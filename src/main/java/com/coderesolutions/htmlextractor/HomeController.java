package com.coderesolutions.htmlextractor;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value = "test")
public class HomeController {
	
	@GetMapping(value="")
	@ResponseBody
	public String get(){
		System.out.println(new Date().toString());
		return new Date().toString(); 
	}

}
