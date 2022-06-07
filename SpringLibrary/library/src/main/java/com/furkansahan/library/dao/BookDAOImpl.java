package com.furkansahan.library.dao;


import com.furkansahan.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BookDAOImpl implements BookDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO book (id ,bookName , bookDescription) VALUES (?,?,?)",new Object[]{book.getId(),book.getBookName(),book.getBookDescription()});
    }

    @Override
    public int update(Book book, int id) {
        return  jdbcTemplate.update("UPDATE book SET bookName=?, bookDescription=? WHERE id=?",new Object[]{book.getBookName(),book.getBookDescription(),id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id=?",id);
    }

    @Override
    public List<Book> getAll() {
      return jdbcTemplate.query("SELECT*FROM book", new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public Book getById(int id) {
        return jdbcTemplate.queryForObject("SELECT*FROM book WHERE id=?",new BeanPropertyRowMapper<Book>(Book.class),id);
    }
}
