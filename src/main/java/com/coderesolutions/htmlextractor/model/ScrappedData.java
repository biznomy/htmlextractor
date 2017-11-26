package com.coderesolutions.htmlextractor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScrappedData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private boolean firstStage = false;
	private boolean secondStage = false;
	private String url;
	private String html;
	private List<String> emails = new ArrayList<String>();
	private List<String> contacts = new ArrayList<String>();
	private List<String> telephone = new ArrayList<String>();
	private List<String> mobile = new ArrayList<String>();
	private List<String> facebook = new ArrayList<String>();
	private List<String> linkedin = new ArrayList<String>();
	private List<String> twitter = new ArrayList<String>();
	private List<String> youtube = new ArrayList<String>();
	private List<String> googleplus = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isFirstStage() {
		return firstStage;
	}

	public void setFirstStage(boolean firstStage) {
		this.firstStage = firstStage;
	}

	public boolean isSecondStage() {
		return secondStage;
	}

	public void setSecondStage(boolean secondStage) {
		this.secondStage = secondStage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}

	public List<String> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<String> telephone) {
		this.telephone = telephone;
	}

	public List<String> getMobile() {
		return mobile;
	}

	public void setMobile(List<String> mobile) {
		this.mobile = mobile;
	}

	public List<String> getFacebook() {
		return facebook;
	}

	public void setFacebook(List<String> facebook) {
		this.facebook = facebook;
	}

	public List<String> getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(List<String> linkedin) {
		this.linkedin = linkedin;
	}

	public List<String> getTwitter() {
		return twitter;
	}

	public void setTwitter(List<String> twitter) {
		this.twitter = twitter;
	}

	public List<String> getYoutube() {
		return youtube;
	}

	public void setYoutube(List<String> youtube) {
		this.youtube = youtube;
	}

	public List<String> getGoogleplus() {
		return googleplus;
	}

	public void setGoogleplus(List<String> googleplus) {
		this.googleplus = googleplus;
	}

}
