package ru.hogwarts.scool8.service1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model1.Author;
import ru.hogwarts.scool8.model1.Book;
import ru.hogwarts.scool8.repository1.AuthorRepository;

import java.util.Collection;

@Service
public class AuthorService {

    private final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        logger.debug("///:{}", author);
        final var save = authorRepository.save(author);
        logger.debug("///{}", save);
        return save;
    }

    public Collection<Book> getBookByAutor(Long id) {
        logger.debug("...:{}", id);
        final var books = authorRepository.findById(id).get().getBooks();
        logger.debug("The Students by faculty{}", books);
        return books;
    }
}

