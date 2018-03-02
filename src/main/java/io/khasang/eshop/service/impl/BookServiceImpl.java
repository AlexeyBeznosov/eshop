package io.khasang.eshop.service.impl;

import io.khasang.eshop.DTO.BookDTO;
import io.khasang.eshop.dao.BookDao;
import io.khasang.eshop.entity.Book;
import io.khasang.eshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDao bookDao;
    @Autowired
    public BookDTO bookDTO;

    @Override
    public List<BookDTO> getAllBook() {
        return bookDTO.getBookDTOList(bookDao.getList());
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.add(book);
    }

    @Override
    public BookDTO getBook(long id) {
        return bookDTO.getBook(bookDao.getById(id));
    }

    @Override
    public BookDTO deleteBook(long id) {
        return bookDTO.getBook(bookDao.delete(bookDao.getById(id)));
    }

    @Override
    public BookDTO updateBook(Book book) {
        return bookDTO.getBook(bookDao.update(book));
    }
}
