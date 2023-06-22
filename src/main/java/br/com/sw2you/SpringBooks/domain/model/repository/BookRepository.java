package br.com.sw2you.SpringBooks.domain.model.repository;

import br.com.sw2you.SpringBooks.domain.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();
}
