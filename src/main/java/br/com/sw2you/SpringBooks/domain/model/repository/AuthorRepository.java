package br.com.sw2you.SpringBooks.domain.model.repository;

import br.com.sw2you.SpringBooks.domain.model.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
