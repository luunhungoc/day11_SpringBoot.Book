package demo.repository;

import demo.entity.Book;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    @PostConstruct
    public void init() {
        //simulate data in a Java list
        // these data can fetched from a table
        bookList.add(new Book(1, "Java A-Z", 13.2, "Roger"));
        bookList.add(new Book(2, "IT", 33.5, "Peter"));
    }

    public List<Book> findAll() {
        return bookList;
    }

    public Book save(Book book){
        bookList.add(book);
        return book;
    }

    public Book update(Book newBook){
        boolean isFound=false;
        Book foundBook = null;
        //check if book Id is existing
        for(Book book:bookList){
            if(book.getId() == newBook.getId()){
                isFound=true;
                foundBook=book;
                break;
            }
        }
    if(!isFound){
        return null;
    }
    bookList.remove(foundBook);
    newBook.setId(foundBook.getId());
    bookList.add(newBook);
    return newBook;
    }

    public boolean delete(int id){
        boolean isFound=false;
        Book foundBook=null;
        //check if book id is existing
        for(Book book:bookList){
            if(book.getId()== id){
                isFound=true;
                foundBook=book;
                break;
            }
        }
        if(!isFound){
            return false;
        }
        bookList.remove(foundBook);
        return true;
    }

}
