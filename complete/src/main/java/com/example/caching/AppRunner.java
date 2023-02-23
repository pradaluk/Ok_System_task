package com.example.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final BookRepository bookRepository;

	public AppRunner(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		logger.info(".... Fetching books");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234") + ", time: " + stopWatch.getElapsedTime() + "sec");
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567") + ", time: " + stopWatch.getElapsedTime() + "sec");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234") + ", time: " + stopWatch.getElapsedTime() + "sec");
		bookRepository.clearCache();
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567") + ", time: " + stopWatch.getElapsedTime() + "sec");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234") + ", time: " + stopWatch.getElapsedTime() + "sec");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234") + ", time: " + stopWatch.getElapsedTime() + "sec");
	}

}
