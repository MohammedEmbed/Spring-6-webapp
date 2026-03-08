package com.momed.spring6webapp.repositories;

import com.momed.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepoistory extends CrudRepository<Author, Long> {

}
