package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "1984", 279, "Оруэл Джордж", 349, 1949);
    private Book secondBook = new Book(2, "Черный обелиск", 459, "Эрих Мария Ремарк",
            447, 1956);
    private Smartphone firstSmartphone = new Smartphone(3, "AYYA T1", 18000, "T1"
            ,"AYYA");
    private Smartphone secondSmartphone = new Smartphone(4, "Iphone X 128gb", 58000,
            "X", "Apple");
    private Smartphone thirdSmartphone = new Smartphone(5, "Iphone X", 54000, "X",
            "Apple");


    @BeforeEach
    void add() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{
                firstBook, secondBook, firstSmartphone, secondSmartphone,thirdSmartphone
        };
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthor() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Оруэл Джордж");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByName() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Черный обелиск");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByName() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("T1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByManufacturer() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("AYYA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByManufacturerFewProduct() {
        Product[] expected = new Product[]{secondSmartphone, thirdSmartphone};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindByNameFewProduct() {
        Product[] expected = new Product[]{secondSmartphone, thirdSmartphone};
        Product[] actual = manager.searchBy("X");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Оно");
        assertArrayEquals(expected, actual);
    }
}