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
	private boolean zeroStage = false;
	private boolean firstStage = false;
	private boolean secondStage = false;
	private String url;
	private String html;
	private String failed;
	private String state;
	private List<String> emails = new ArrayList<String>();
	private List<String> contacts = new ArrayList<String>();
	private List<String> telephone = new ArrayList<String>();
	private List<String> mobile = new ArrayList<String>();
	private List<String> facebook = new ArrayList<String>();
	private List<String> linkedin = new ArrayList<String>();
	private List<String> twitter = new ArrayList<String>();
	private List<String> youtube = new ArrayList<String>();
	private List<String> googleplus = new ArrayList<String>();

	private String country;
	private String countryCode;
	private String address;
	private String phoneNumber;
	private String internationalPhoneNumber;
	private String keyword;
	private String locality;
	private String name;
	private String neighborhood;
	private String placeId;
	private String postalCode;
	private String route;
	private String streetNumber;
	private String updated;
	private String mapUrl;
	private String utcOffset;
	private String vicinity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isZeroStage() {
		return zeroStage;
	}

	public void setZeroStage(boolean zeroStage) {
		this.zeroStage = zeroStage;
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

	public String getFailed() {
		return failed;
	}

	public void setFailed(String failed) {
		this.failed = failed;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInternationalPhoneNumber() {
		return internationalPhoneNumber;
	}

	public void setInternationalPhoneNumber(String internationalPhoneNumber) {
		this.internationalPhoneNumber = internationalPhoneNumber;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

}
