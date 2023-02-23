package com.example.caching;

public interface BookRepository {
	Book getByIsbn(String isbn);
	void clearCache();
}
