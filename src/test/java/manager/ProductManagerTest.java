package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book("Война и мир",1, 1000, "Л.Н. Толстой");
    Book book2 = new Book("Анна Каренина",2, 1000, "Л.Н. Толстой");
    Book book3 = new Book("Катя",3, 1000, "А.Н. Толстой");
    Smartphone smartphone1 = new Smartphone("S20", 4, 60000, "Samsung");
    Smartphone smartphone2 = new Smartphone("S21", 5, 80000, "Samsung");
    Smartphone smartphone3 = new Smartphone("iPhone 13 Pro", 4, 110000, "Apple");
    Product macbook = new Product();


    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(macbook);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldFindByAuthor() {
        Product[] actual = manager.searchBy("Л.Н. Толстой");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBrand() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {
        Product[] actual = manager.searchBy("Катя");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone 13 Pro");
        Product[] expected = new Product[]{smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone 10");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}