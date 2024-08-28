package demo.controller;

import demo.entity.Book;
import demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.AutoPopulatingList;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping()
    public Object getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Object addNewBook(@RequestBody Book newBook) {
        Book result=bookRepository.save(newBook);
        return result;
    }

    @PutMapping
    public Object updateBook(@RequestBody Book updateBook) {
        Book result = bookRepository.update(updateBook);
        if (result == null) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", updateBook.getId() + " does not exist");
            }};
            return error;
        }
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteBook(@PathVariable(value="id") String id){
        Boolean result=bookRepository.delete(Integer.valueOf(id));
        if(!result){
            Map<String,String> error=new HashMap<String,String>(){{
                put("error", "A book which book Id= "+id + " does not exist");
            }};
            return error;
        } else {
            Map<String,String> success=new HashMap<String,String>(){{
                put("success", "A book which book Id= "+id + " has been deleted successfully");
            }};
            return success;
        }
    }
}
