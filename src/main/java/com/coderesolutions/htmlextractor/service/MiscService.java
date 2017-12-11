package com.coderesolutions.htmlextractor.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MiscService {
	
	public void findFromUrl();
	public Set<String> getEmails(String value);
	public Set<String> getContacts(String value);
	public Set<String> getFacebook(String value);	
	public Set<String> getTwitter(String value);	
	public Set<String> getLinkedIn(String value);	
	public Set<String> getYouTube(String value);	
	public Set<String> getGooglePlus(String value);	
	public void filterContacts(String value, List<String> arrayMobile, List<String> arrayLandline);	
	public void filterAll(String htmlText, Map<String, Set<String>> result);

}
