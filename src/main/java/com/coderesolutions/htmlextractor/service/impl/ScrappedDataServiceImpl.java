package com.coderesolutions.htmlextractor.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.coderesolutions.htmlextractor.model.ScrappedData;
import com.coderesolutions.htmlextractor.repository.ScrappedDataRepository;
import com.coderesolutions.htmlextractor.service.MiscService;
import com.coderesolutions.htmlextractor.service.ScrappedDataService;

@Service
public class ScrappedDataServiceImpl implements ScrappedDataService {

	@Autowired
	ScrappedDataRepository scrappedDataRepository;

	@Autowired
	MiscService miscService;

	@Override
	public ScrappedData saveScrappedData(ScrappedData scrappedData) {
		return scrappedDataRepository.save(scrappedData);
	}

	@Override
	@Transactional
	public void findByZeroStage() {
		// Random random = new Random();
		// int number = random.nextInt((5000 - 100) + 1) + 100;
		// Pageable pageable = new PageRequest(number, 10);
		Pageable pageable = new PageRequest(0, 10);
		Page<ScrappedData> list = scrappedDataRepository.findByZeroStage(pageable, false);
		Iterator<ScrappedData> it = list.iterator();
		while (it.hasNext()) {
			ScrappedData scrappedData = (ScrappedData) it.next();

			if (scrappedData.getUrl() != null && !scrappedData.getUrl().isEmpty()) {

				URL url = null;
				Document doc = null;
				try {
					url = new URL(scrappedData.getUrl());
				} catch (MalformedURLException malformedURLException) {
					scrappedData.setFailed(malformedURLException.getMessage());
					scrappedData.setFirstStage(true);
					scrappedData.setSecondStage(true);
				}
				scrappedData.setZeroStage(true);

				Connection connection = Jsoup.connect(url.toString());
				try {
					connection.timeout(1000 * 30);
					doc = connection.get();
					scrappedData.setHtml(doc.html());
				} catch (IOException | NullPointerException e) {
					scrappedData.setFailed(e.getMessage());
					scrappedData.setFirstStage(true);
					scrappedData.setSecondStage(true);
				}
				scrappedDataRepository.save(scrappedData);

			}
		}
	}

	@Override
	@Transactional
	public void findByFirstStage() {
		// Random random = new Random();
		// int number = random.nextInt((5000 - 100) + 1) + 100;
		// Pageable pageable = new PageRequest(number, 10);
		Pageable pageable = new PageRequest(0, 10);
		Page<ScrappedData> list = scrappedDataRepository.findByFirstStage(pageable, false);
		Iterator<ScrappedData> it = list.iterator();
		while (it.hasNext()) {
			ScrappedData scrappedData = (ScrappedData) it.next();
			try {

				if (scrappedData.getHtml() != null && !scrappedData.getHtml().isEmpty()) {

					Map<String, Set<String>> result = new HashMap<String, Set<String>>();
					miscService.filterAll(scrappedData.getHtml(), result);
					scrappedData.setEmails(new ArrayList<String>(result.get("email")));
					scrappedData.setContacts(new ArrayList<String>(result.get("contact")));
					scrappedData.setFacebook(new ArrayList<String>(result.get("facebook")));
					scrappedData.setTwitter(new ArrayList<String>(result.get("twitter")));
					scrappedData.setLinkedin(new ArrayList<String>(result.get("linkedin")));
					scrappedData.setYoutube(new ArrayList<String>(result.get("youtube")));
					scrappedData.setGoogleplus(new ArrayList<String>(result.get("googleplus")));
					scrappedData.setFirstStage(true);
					scrappedDataRepository.save(scrappedData);

				} else {
					throw new Exception("html value not found");
				}

			} catch (Exception e) {
				scrappedData.setFailed(e.getMessage());
				scrappedData.setFirstStage(true);
				scrappedData.setSecondStage(true);
				scrappedDataRepository.save(scrappedData);
			}
		}
	}

	@Override
	@Transactional
	public void findBySecondStage() {
		// Random random = new Random();
		// int number = random.nextInt((5000 - 100) + 1) + 100;
		// Pageable pageable = new PageRequest(number, 10);
		Pageable pageable = new PageRequest(0, 10);
		Page<ScrappedData> list = scrappedDataRepository.findBySecondStage(pageable, false);
		Iterator<ScrappedData> it = list.iterator();
		while (it.hasNext()) {
			ScrappedData scrappedData = (ScrappedData) it.next();
			try {
				if (scrappedData.getHtml() != null && !scrappedData.getHtml().isEmpty()) {
					String contacts = StringUtils.collectionToDelimitedString(scrappedData.getContacts(), ",");
					miscService.filterContacts(contacts, scrappedData.getMobile(), scrappedData.getTelephone());
					scrappedData.setSecondStage(true);
					scrappedDataRepository.save(scrappedData);
				}
			} catch (Exception e) {
				scrappedData.setFailed(e.getMessage());
				scrappedData.setSecondStage(true);
				scrappedDataRepository.save(scrappedData);
			}
		}
	}
}
