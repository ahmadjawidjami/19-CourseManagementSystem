package af.hu.cs.se.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Book {


    private BookId bookId;

    private String publisher;

    @EmbeddedId
    public BookId getBookId() {
        return bookId;
    }

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
