import org.example.digitallibrarymanagementsystem.enumes.StockStatus;
import org.example.digitallibrarymanagementsystem.model.Author;
import org.example.digitallibrarymanagementsystem.model.Book;
import org.example.digitallibrarymanagementsystem.model.PublisherAddress;
import org.example.digitallibrarymanagementsystem.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class BookRepositoryTest {
    private static BookRepository bookRepository;

    @BeforeAll
    static void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testBook() {
        Book book1 = new Book.Builder()
                .title("Java Programming")
                .isbn("1256589526952")
                .publicationYear(2025)
                .price(50.0)
                .stockStatus(StockStatus.OUT_OF_STOCK)
                .publisherAddress(new PublisherAddress(
                        "street",
                        "city",
                        10))
                .build();
    }
}
