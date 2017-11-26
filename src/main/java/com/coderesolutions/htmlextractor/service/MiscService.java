package com.coderesolutions.htmlextractor.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MiscService {
	
	public void findFromUrl();
	public void filterContacts(String value, List<String> arrayMobile, List<String> arrayLandline);	
	public void filterAll(String htmlText, Map<String, Set<String>> result);

}
