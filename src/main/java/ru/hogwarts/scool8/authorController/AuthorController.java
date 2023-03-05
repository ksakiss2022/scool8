package ru.hogwarts.scool8.authorController;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.scool8.model1.Author;
import ru.hogwarts.scool8.model1.Book;
import ru.hogwarts.scool8.service1.AuthorService;

import java.util.Collection;

@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping //POST http://localhost:8080/author
    public Author createAuthor(@RequestBody Author author) {

        return authorService.createAuthor(author);
    }

    @GetMapping("author-book/{id}") //GET http://localhost:8080/author/finde-book-by-author-id
    public Collection<Book> getBookByAutor(@PathVariable Long id) {
        return authorService.getBookByAutor(id);
    }

}
