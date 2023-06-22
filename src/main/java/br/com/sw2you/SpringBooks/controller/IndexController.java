package br.com.sw2you.SpringBooks.controller;

import br.com.sw2you.SpringBooks.domain.model.entity.Book;
import br.com.sw2you.SpringBooks.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @GetMapping("/lista")
    public ModelAndView getList() {
        List<Book> books = this.bookService.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("bookList", books);

        return modelAndView;
    }
}
