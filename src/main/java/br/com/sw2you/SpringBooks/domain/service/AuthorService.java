package br.com.sw2you.SpringBooks.domain.service;

import br.com.sw2you.SpringBooks.domain.model.entity.Author;
import br.com.sw2you.SpringBooks.domain.model.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> getAuthorList() {
        Iterable<Author> authorIterable = this.authorRepository.findAll();
        return Streamable.of(authorIterable).toList();
    }
}
