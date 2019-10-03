package af.hu.cs.se.repository;

import af.hu.cs.se.model.Book;
import af.hu.cs.se.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, BookId> {
}
