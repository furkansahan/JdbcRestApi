package com.furkansahan.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    private int id;

    private String bookName;

    private String bookDescription;
}
