package com.coderesolutions.htmlextractor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderesolutions.htmlextractor.service.ScrappedDataService;

@Controller
//@RequestMapping(value = "test")
public class HomeController {
	
	@Autowired
	ScrappedDataService scrappedDataService; 
	
	
	@GetMapping(value="zero")
	@ResponseBody
	public String zero(){
		System.out.println(new Date().toString());
		scrappedDataService.findByZeroStage();
		return new Date().toString(); 
	}
	
	@GetMapping(value="first")
	@ResponseBody
	public String first(){
		System.out.println(new Date().toString());
		scrappedDataService.findByFirstStage();
		return new Date().toString(); 
	}
	
	@GetMapping(value="second")
	@ResponseBody
	public String second(){
		System.out.println(new Date().toString());
		scrappedDataService.findBySecondStage();
		return new Date().toString(); 
	}

}
