package com.furkansahan.library.dao;

import com.furkansahan.library.entity.Book;

import java.util.List;

public interface BookDAO {

    int save(Book book);

    int update(Book book , int id);

    int delete (int id);

    List <Book> getAll();

    Book getById (int id);

}
