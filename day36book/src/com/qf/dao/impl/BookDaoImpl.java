package com.qf.dao.impl;

import com.qf.dao.BookDao;
import com.qf.entity.Book;
import com.qf.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());


    @Override
    public List<Book> select() {
        try {
            return qr.query("select id,title,author,public_date as publicDate,publisher,isbn,price,picture,cid from book",new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Book book) {
        Object[] params={book.getTitle(),book.getAuthor(),book.getPublicDate(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getPicture(),book.getCid()};
        try {
            qr.update("insert into book values(null,?,?,?,?,?,?,?,?);",params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try {
            qr.update("delete from book where id=?;",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
