package com.nguyentthai.modelcommon.response;

import com.nguyentthai.modelcommon.model.BookCategory;
import com.nguyentthai.modelcommon.model.BookInfor;

import java.util.List;

public class BookResponse extends BaseResponse {
    BookInfor bookInfor;
    BookCategory bookCategory;
    List<BookInfor> listBookInfors;
    List<BookCategory> listBookCategories;


    // Getter and Setter

    public BookInfor getBookInfor() {
        return bookInfor;
    }

    public void setBookInfor(BookInfor bookInfor) {
        this.bookInfor = bookInfor;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public List<BookInfor> getListBookInfors() {
        return listBookInfors;
    }

    public void setListBookInfors(List<BookInfor> listBookInfors) {
        this.listBookInfors = listBookInfors;
    }

    public List<BookCategory> getListBookCategories() {
        return listBookCategories;
    }

    public void setListBookCategories(List<BookCategory> listBookCategories) {
        this.listBookCategories = listBookCategories;
    }


    // \Getter and Setter
}
