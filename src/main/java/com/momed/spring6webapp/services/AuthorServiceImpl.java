package com.momed.spring6webapp.services;

import com.momed.spring6webapp.domain.Author;
import com.momed.spring6webapp.repositories.AuthorRepoistory;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepoistory authorRepoistory;

    public AuthorServiceImpl(AuthorRepoistory authorRepoistory) {
        this.authorRepoistory = authorRepoistory;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepoistory.findAll();
    }
}
