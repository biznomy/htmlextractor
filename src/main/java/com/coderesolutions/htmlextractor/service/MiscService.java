package com.coderesolutions.htmlextractor.service;

import java.util.Map;
import java.util.Set;

public interface MiscService {
	
	public void findFromUrl();
	public void filterContacts(String value, Set<String> arrayMobile, Set<String> arrayLandline);	
	public void filterAll(String htmlText, Map<String, Set<String>> result);

}
