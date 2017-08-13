package com.nguyentthai.rest.controller;

import com.nguyentthai.modelcommon.exception.DaoException;
import com.nguyentthai.modelcommon.exception.MyException;
import com.nguyentthai.modelcommon.model.BookCategory;
import com.nguyentthai.modelcommon.model.BookInfor;
import com.nguyentthai.modelcommon.response.BaseResponse;
import com.nguyentthai.modelcommon.response.BookResponse;
import com.nguyentthai.rest.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookDao.class);

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/insertBookCategory", method = RequestMethod.POST)
    public BaseResponse insertBookCategory(@RequestBody BookCategory bookCategory) {
        DaoException daoException = bookDao.insertBookCategory(bookCategory);
        return setResualtError(daoException);
    }

    @RequestMapping(value = "/insertBookInfor", method = RequestMethod.POST)
    public BaseResponse insertBookInfor(@RequestBody BookInfor bookInfor) {
        DaoException daoException = bookDao.insertBookInfor(bookInfor);
        return setResualtError(daoException);
    }

    private BaseResponse setResualtError(DaoException daoException) {
        BaseResponse response = new BookResponse();
        switch (daoException.getResultCode()) {
            case MyException.OK:
                response.setResultCode(BaseResponse.OK);
                break;
            case MyException.FAILED:
                response.setResultCode(BaseResponse.FAILED);
                response.setErrorMessage(daoException.getErrorMessage());
                response.setErrorSystem(daoException.getErrorSystem());
                break;
            default:
                response.setResultCode(BaseResponse.UNKNOWN);
                response.setErrorSystem(daoException.getErrorSystem());
        }
        return response;
    }

    @RequestMapping(value = "/getAllListBookCategory", method = RequestMethod.GET)
    public BookResponse getAllListBookCategory() {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setListBookCategories(bookDao.getAllListCategory());

        if (bookResponse.getListBookCategories() != null && bookResponse.getListBookCategories().size() > 0) {
            bookResponse.setResultCode(BaseResponse.OK);
        } else {
            bookResponse.setListBookCategories(null);
            bookResponse.setResultCode(BaseResponse.FAILED);
        }
        return bookResponse;
    }

    @RequestMapping(value = "/getAllListBookInfor", method = RequestMethod.GET)
    public BookResponse getAllListBookInfor() {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setListBookInfors(bookDao.getAllListBookInfor());

        if (bookResponse.getListBookInfors() != null && bookResponse.getListBookInfors().size() > 0) {
            bookResponse.setResultCode(BaseResponse.OK);
        } else {
            bookResponse.setListBookInfors(null);
            bookResponse.setResultCode(BaseResponse.FAILED);
        }
        return bookResponse;
    }

    @RequestMapping(value = "/getAllListBookInfor/{categoryId}", method = RequestMethod.GET)
    public BookResponse getListBookInforAllByCategory(@PathVariable(value = "categoryId") long categoryId) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setListBookInfors(bookDao.getListBookInforAllByCategory(categoryId));

        if (bookResponse.getListBookInfors() != null && bookResponse.getListBookInfors().size() > 0) {
            bookResponse.setResultCode(BaseResponse.OK);
        } else {
            bookResponse.setListBookInfors(null);
            bookResponse.setResultCode(BaseResponse.FAILED);
        }
        return bookResponse;
    }

    @RequestMapping(value = "/getAllListBookInforCategory", method = RequestMethod.GET)
    public BookResponse getAllListBookInforCategory() {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setListBookInfors(bookDao.getAllListBookInforCategory());

        if (bookResponse.getListBookInfors() != null && bookResponse.getListBookInfors().size() > 0) {
            bookResponse.setResultCode(BaseResponse.OK);
        } else {
            bookResponse.setListBookInfors(null);
            bookResponse.setResultCode(BaseResponse.FAILED);
        }
        return bookResponse;
    }
}
