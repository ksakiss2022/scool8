package ru.hogwarts.scool8.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scool8.model1.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Collection<Author> findBookByAuthorContainsIgnoreCase(String authorName);

    //  Author findAuthorByAuthorNameContainsIgnoreCase(String authorName);

}
