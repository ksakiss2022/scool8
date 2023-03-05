package ru.hogwarts.scool8.model1;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authorName;

    public Author(long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Collection<Book> books;

    public Author() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && authorName.equals(author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }

}
