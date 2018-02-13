package io.khasang.eshop.servise.impl;

import io.khasang.eshop.dao.BookDao;
import io.khasang.eshop.entity.Book;
import io.khasang.eshop.servise.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDao bookDao;

    @Override
    public void addBook() {
        bookDao.add();
    }

    @Override
    public Book getBook(int id){
        return bookDao.getById(id);
    }
}
