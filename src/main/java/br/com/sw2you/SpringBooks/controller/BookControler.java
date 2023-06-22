package br.com.sw2you.SpringBooks.controller;

import br.com.sw2you.SpringBooks.domain.model.entity.Author;
import br.com.sw2you.SpringBooks.domain.model.entity.Book;
import br.com.sw2you.SpringBooks.domain.service.AuthorService;
import br.com.sw2you.SpringBooks.domain.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookControler {

    @Autowired
    private AuthorService serviceAuthor;
    @Autowired
    private BookService serviceBook;

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd() {
        ModelAndView modelAndView = new ModelAndView("bookForm");
        List<Author> authorList = this.serviceAuthor.getAuthorList();
        modelAndView.addObject("authorList", authorList);

        return modelAndView;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()){
            redirect.addFlashAttribute("Mensagem", "Verifique os campos obrigatórios!");
            return "redirect:/book/form/add";
        }
        this.serviceBook.save(book);

        return "redirect:/lista";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("bookForm");
        List<Author> authorList = this.serviceAuthor.getAuthorList();
        modelAndView.addObject("authorList", authorList);

        Book book = this.serviceBook.findById(id);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.serviceBook.delete(id);
        return "redirect:/lista";
    }
}
