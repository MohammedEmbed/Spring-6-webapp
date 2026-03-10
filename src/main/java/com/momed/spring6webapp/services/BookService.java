package com.momed.spring6webapp.services;

import com.momed.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
