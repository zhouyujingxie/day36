package com.qf.service.impl;

import com.qf.dao.BookDao;
import com.qf.dao.impl.BookDaoImpl;
import com.qf.entity.Book;
import com.qf.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public List<Book> findAll() {
        List<Book> bookList=bookDao.select();
        return bookList;
    }

    @Override
    public void add(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }
}
