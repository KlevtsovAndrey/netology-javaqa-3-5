package repository;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book book = new Book();
    private final Smartphone smartphone = new Smartphone();


    @Test
    public void shouldSaveBookToTheProducts() {
        repository.save(book);
        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSmartphoneToTheProducts() {
        repository.save(smartphone);
        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneById() {
        repository.save(smartphone);
        repository.save(book);
        Product actual = repository.findById(0);
        assertEquals(smartphone, actual);
    }

    @Test
    public void shouldNotFind() {
        repository.save(smartphone);
        repository.save(book);
        Product actual = repository.findById(3);
        assertEquals(null, actual);
    }

    @Test
    public void shouldRemoveBookById() {
        Book book = new Book("Война и мир",1, 1000, "Л.Н. Толстой");
        Smartphone smartphone = new Smartphone("S20", 2, 60000, "Samsung");
        repository.save(smartphone);
        repository.save(book);
        repository.removeById(book.getId());
        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}