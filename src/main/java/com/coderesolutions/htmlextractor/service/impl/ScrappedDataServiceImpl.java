package com.coderesolutions.htmlextractor.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
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
	MiscService miscService;

	@Autowired
	ScrappedDataRepository scrappedDataRepository;

	Logger logger = LoggerFactory.getLogger(ScrappedDataServiceImpl.class);

	@Override
	public ScrappedData saveScrappedData(ScrappedData scrappedData) {
		return scrappedDataRepository.save(scrappedData);
	}

	@Async
	@Override
	@Transactional
	public void findByZeroStage() {
		Pageable pageable = new PageRequest(0, 10000);
		Page<ScrappedData> list = scrappedDataRepository.findByZeroStage(pageable, false);
		Iterator<ScrappedData> it = list.iterator();
		while (it.hasNext()) {
			ScrappedData scrappedData = (ScrappedData) it.next();
			logger.info(scrappedData.toString());

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
				} catch (Exception e) {
					scrappedData.setFailed(e.getMessage());
					scrappedData.setFirstStage(true);
					scrappedData.setSecondStage(true);
				}
				scrappedDataRepository.save(scrappedData);

			}
		}
	}

	@Async
	@Override
	@Transactional
	public void findByFirstStage() {
		Pageable pageable = new PageRequest(0, 5000);
		Page<ScrappedData> list = scrappedDataRepository.findByFirstStage(pageable, false);
		Iterator<ScrappedData> it = list.iterator();
		
		while (it.hasNext()) {
			final ScrappedData scrappedData = (ScrappedData) it.next();
			try {
				class Task implements Callable<String> {
					@Override
					public String call() throws Exception {
						logger.info(scrappedData.toString());

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
						}
						return "Ready!";
					}
				}
				ExecutorService executor = Executors.newSingleThreadExecutor();
				Future<String> future = executor.submit(new Task());

				try {
					// System.out.println("Started..");
					System.out.println(future.get(3, TimeUnit.SECONDS));
					// System.out.println("Finished!");
				} catch (TimeoutException e) {
					future.cancel(true);
					// System.out.println("Terminated!");
					throw new Exception("Terminated!");
				}
				
				executor.shutdownNow();

			} catch (Exception e) {

				scrappedData.setFailed(e.getMessage());
				scrappedData.setFirstStage(true);
				scrappedData.setSecondStage(true);
				scrappedDataRepository.save(scrappedData);
				System.err.println(scrappedData.getFailed());
			}

		}
		
	}

	@Async
	@Override
	@Transactional
	public void findBySecondStage() {
		Pageable pageable = new PageRequest(0, 2000);
		Page<ScrappedData> list = scrappedDataRepository.findByContactCount(pageable, true);
		Iterator<ScrappedData> it = list.iterator();
		while (it.hasNext()) {
			ScrappedData scrappedData = (ScrappedData) it.next();
			try {

				if (scrappedData.getContacts() != null && scrappedData.getContacts().size() > 0) {
					String contacts = StringUtils.collectionToDelimitedString(scrappedData.getContacts(), ",");
					miscService.filterContacts(contacts, scrappedData.getMobile(), scrappedData.getTelephone());
				}

				scrappedData.setSecondStage(true);
				scrappedDataRepository.save(scrappedData);

			} catch (Exception e) {
				scrappedData.setFailed(e.getMessage());
				scrappedData.setSecondStage(true);
				scrappedDataRepository.save(scrappedData);
			}
		}
	}
}
