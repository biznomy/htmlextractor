package com.coderesolutions.htmlextractor;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coderesolutions.htmlextractor.service.MiscService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlextractorApplicationTests {
	
	@Autowired
	MiscService miscService;

	@Test
	public void contextLoads() {
		
		String html = "<html><a href='http://www.fb.com/abc' >facebook</html>";
		
		Set<String> setFB =  miscService.getFacebook(html);
		
		System.out.println(setFB);
	}

}
