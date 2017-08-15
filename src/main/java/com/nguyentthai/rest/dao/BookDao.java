package com.nguyentthai.rest.dao;

import com.nguyentthai.rest.exception.DaoException;
import com.nguyentthai.modelcommon.exception.MyException;
import com.nguyentthai.modelcommon.model.BookCategory;
import com.nguyentthai.modelcommon.model.BookInfor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BookDao {
    private static final Logger log = LoggerFactory.getLogger(BookDao.class);

    @Autowired
    private JdbcTemplate template;

    public DaoException insertBookCategory(BookCategory bookCategory) {
        final String sql = "INSERT INTO BookCategory (name) VALUES(?);";

        DaoException daoException;
        try {
            int res = template.update(sql, bookCategory.getName());

            if (res > 0) {
                daoException = new DaoException();
                daoException.setResultCode(MyException.OK);
            } else {
                daoException = new DaoException();
                daoException.setResultCode(MyException.FAILED);
                daoException.setErrorMessage(MyException.insertResualtFailed);
                log.error("Resual update query JDBC template res:" + res +" category:"+bookCategory.toString());
            }
        } catch (Exception e) {
            daoException = new DaoException();
            daoException.setResultCode(MyException.FAILED);
            daoException.setErrorSystem(e.toString());
            log.error("Error insert exception " + e.toString());
        }

        return daoException;
    }

    public List<BookCategory> getAllListCategory() {
        final String sql = "SELECT id, name FROM BookCategory;";
        List<BookCategory> bookCategories;

        try {
            bookCategories = template.query(sql, new BeanPropertyRowMapper<BookCategory>(BookCategory.class));
        } catch (Exception e){
            bookCategories=null;
            log.error("Get all list category failed: "+e);
        }
        return bookCategories;
    }


    public DaoException insertBookInfor(BookInfor bookInfor) {
        final String sql = "INSERT INTO BookInfor (name, imagePath, categoryId) VALUES(?, ?, ?);";

        DaoException daoException;
        try {
            int res = template.update(sql, bookInfor.getName(), bookInfor.getImagePath(),bookInfor.getBookCategory().getId());

            if (res > 0) {
                daoException = new DaoException();
                daoException.setResultCode(MyException.OK);
            } else {
                daoException = new DaoException();
                daoException.setResultCode(MyException.FAILED);
                daoException.setErrorMessage(MyException.insertResualtFailed);
                log.error("Resual insert bookInfor query JDBC template res:" + res +"bookInfor"+bookInfor.toString());
            }
        } catch (Exception e) {
            daoException = new DaoException();
            daoException.setResultCode(MyException.FAILED);
            daoException.setErrorSystem(e.toString());
            log.error("Error insert exception " + e.toString());
        }

        return daoException;
    }

    public List<BookInfor> getAllListBookInfor() {
        final String sql = "SELECT * FROM BookInfor;";
        List<BookInfor> bookInfors;

        try {
            bookInfors = template.query(sql, new BeanPropertyRowMapper<BookInfor>(BookInfor.class));
        } catch (Exception e){
            bookInfors=null;
            log.error("Get all list category failed: "+e);
        }
        return bookInfors;
    }


    public List<BookInfor> getListBookInforAllByCategory(long categoryId) {
        final String sql = "SELECT * FROM BookInfor WHERE categoryId = ?;";
        List<BookInfor> bookInfors;

        try {
            bookInfors = template.query(sql,new Object[]{categoryId}, new BeanPropertyRowMapper<BookInfor>(BookInfor.class));
        } catch (Exception e){
            bookInfors=null;
            log.error("Get all list category failed: "+e);
        }
        return bookInfors;
    }

    public List<BookInfor> getAllListBookInforCategory() {
        final String sql = "SELECT BookInfor.id, BookInfor.name, imagePath, categoryId, BookCategory.name FROM BookInfor INNER JOIN BookCategory on BookInfor.categoryId= BookCategory.id;";
        List<BookInfor> bookInfors;

        try {
            bookInfors= template.query(sql, new BookInfor());
        } catch (Exception e){
            bookInfors=null;
            log.error("Get all list category failed: "+e);
        }
        return bookInfors;
    }

}
