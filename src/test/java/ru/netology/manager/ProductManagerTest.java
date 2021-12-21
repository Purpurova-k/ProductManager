package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ProductManagerTest {

    private ProductRepository repository = Mockito.mock(ProductRepository.class);

    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Пиковая дама", 500, "Александр Пушкин");
    private Book book2 = new Book(2, "Герой нашего времени", 800, "Михаил Лермонтов");
    private Book book3 = new Book(3, "Оно", 1000, "Стивен Кинг");
    private Book book4 = new Book(4, "Вино из одуванчиков", 400, "Рэй Брэдбери");
    private Book book5 = new Book(5, "Дубровский", 450, "Александр Пушкин");


    private Smartphone phone1 = new Smartphone(6, "IPhone 13 pro", 50000, "Apple");
    private Smartphone phone2 = new Smartphone(7, "Samsung Galaxy A52", 25000, "Samsung");
    private Smartphone phone3 = new Smartphone(8, "Xiaomi Mi 10T", 25000, "Xiaomi");
    private Smartphone phone4 = new Smartphone(9, "Samsung Galaxy S20 FE", 38000, "Samsung");
    private Smartphone phone5 = new Smartphone(10, "Nokia X20", 26000, "Nokia");


    @Test
    public void shouldAddBookToRepository() {
        Product[] returned = {book1};
        doReturn(returned).when(repository).findAll();

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldAddPhoneToRepository() {
        Product[] returned = {phone1};
        doReturn(returned).when(repository).findAll();

        manager.add(phone1);

        Product[] expected = {phone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindBookByName() {
        Product[] returned = {book3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Оно");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindBookByAuthor() {
        Product[] returned = {book1, book5};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {book1, book5};
        Product[] actual = manager.searchBy("Александр Пушкин");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindBookInvalid() {
        Product[] returned = {book1, book2, book3, book4, book5};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Лев Толстой");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindEmptyRepositoryBook() {
        Product[] returned = {};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("книги");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindSmartphoneByName() {
        Product[] returned = {phone1};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("IPhone");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindSmartphoneByProducer() {
        Product[] returned = {phone2, phone4};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {phone2, phone4};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldFindSmartphoneInvalid() {
        Product[] returned = {phone1, phone2, phone3, phone4, phone5};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Iphone 10");

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


    @Test
    public void shouldFindBookMatchesTrue() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        assertEquals(true, book1.matches("Пиковая дама"));
    }


    @Test
    public void shouldFindBookMatchesFalse() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        assertEquals(false, book1.matches("Оно"));
    }


    @Test
    public void shouldFindFhoneMatchesTrue() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        assertEquals(true, phone1.matches("IPhone 13 pro"));
    }


    @Test
    public void shouldFindFhoneMatchesFalse() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        assertEquals(false, phone1.matches("IPhone 10"));
    }
}
