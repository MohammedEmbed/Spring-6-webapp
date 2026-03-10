package com.momed.spring6webapp.services;

import com.momed.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();

}
