package com.example.myfirstapp.Data;

import android.content.Context;

import com.example.myfirstapp.Items.Book;
import com.example.myfirstapp.Items.BookDao;
import com.example.myfirstapp.Items.DaoMaster;
import com.example.myfirstapp.Items.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MyBookDao {
    public Context context;
    public MyBookDao(Context context) {
        this.context = context;
    }

    public void insertBook(Book book) {
        DaoMaster daoMaster = new DaoMaster(GreenDaoManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        BookDao bookDao = daoSession.getBookDao();
        bookDao.insert(book);
    }

    public List<Book> queryBookList(int page) {
        DaoMaster daoMaster = new DaoMaster(GreenDaoManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        BookDao bookDao = daoSession.getBookDao();
        QueryBuilder<Book> queryBuilder = bookDao.queryBuilder();
        queryBuilder.where(BookDao.Properties.Page.gt(page)).orderAsc(BookDao.Properties.Page);
        List<Book> list = queryBuilder.list();
        return list;
    }

    public void updateBook(Book book) {
        DaoMaster daoMaster = new DaoMaster(GreenDaoManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        BookDao bookDao = daoSession.getBookDao();
        bookDao.update(book);
    }

    public void deleteBook(Book book) {
        DaoMaster daoMaster = new DaoMaster(GreenDaoManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        BookDao bookDao = daoSession.getBookDao();
        bookDao.delete(book);
    }

}
