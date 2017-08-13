package com.nguyentthai.modelcommon.model;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfor implements RowMapper {

    private long id;
    private String name;
    private String imagePath;

    private BookCategory bookCategory;

    public BookInfor() {
    }

    public BookInfor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public BookInfor mapRow(ResultSet resultSet, int i) throws SQLException {
        BookCategory bookCategory = new BeanPropertyRowMapper<BookCategory>(BookCategory.class).mapRow(resultSet, i);
        BookInfor bookInfor = new BeanPropertyRowMapper<>(BookInfor.class).mapRow(resultSet, i);
        bookInfor.setBookCategory(bookCategory);
        return bookInfor;
    }

    @Override
    public String toString() {
        return "BookInfor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", bookCategory=" + bookCategory +
                '}';
    }

    // Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
    // \Getter and Setter
}
