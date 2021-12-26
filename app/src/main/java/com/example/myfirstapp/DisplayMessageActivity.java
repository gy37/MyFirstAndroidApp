package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapp.Data.MyBookDao;
import com.example.myfirstapp.Data.MyDatabaseHelper;
import com.example.myfirstapp.Items.Book;

import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String TAG = "DisplayMessageActivity";
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button button = findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button button1 = findViewById(R.id.button26);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
////                ContentValues values = new ContentValues();
////                values.put("name", "The Da Vinci Code");
////                values.put("author", "Dan Brown");
////                values.put("pages", 454);
////                values.put("price", 16.92);
////                database.insert("Book", null, values);
////                values.clear();
////
////                values.put("name", "The Lost Symbol");
////                values.put("author", "Dan Brown");
////                values.put("pages", 510);
////                values.put("price", 19.92);
////                database.insert("Book", null, values);
//
//                database.execSQL("insert into Book(name, author, pages, price) values(?, ?, ?, ?)", new String[] {"The Da Vinci Code", "Dan Brown", "454", "16.66"});
//                database.execSQL("insert into Book(name, author, pages, price) values(?, ?, ?, ?)", new String[] {"The Da Vinci Code", "Dan Brown", "510", "19.66"});

                MyBookDao dao = new MyBookDao(DisplayMessageActivity.this);
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPage(520);
                book.setPrice(22.33);
                dao.insertBook(book);
            }
        });

        Button button2 = findViewById(R.id.button27);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
////                ContentValues values = new ContentValues();
////                values.put("price", 12.34);
////                database.update("Book", values, "name = ?", new String[] {"The Da Vinci Code"});
//
//                database.execSQL("update Book set price = ? where name = ?", new String[] {"10.00", "The Da Vinci Code"});

                MyBookDao dao = new MyBookDao(DisplayMessageActivity.this);
                List<Book> bookList = dao.queryBookList(500);
                for (Book book: bookList) {
                    book.setPrice(99.99);
                    dao.updateBook(book);
                }
            }
        });

        Button button3 = findViewById(R.id.button28);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
////                database.delete("Book", "pages > ?", new String[] {"500"});
//
//                database.execSQL("delete from Book where pages > ?", new String[] {"500"});

                MyBookDao dao = new MyBookDao(DisplayMessageActivity.this);
                List<Book> bookList = dao.queryBookList(500);
                for (Book book: bookList) {
                    dao.deleteBook(book);
                }
            }
        });

        Button button4 = findViewById(R.id.button29);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
////                Cursor cursor = database.query("Book", null, null, null, null, null, null);
//
//                Cursor cursor = database.rawQuery("select * from Book", null);
//                if (cursor.moveToFirst()) {
//                    do {
//                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        String author = cursor.getString(cursor.getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
//                        Log.d(TAG, "onClick: book " + "（" + name + "，" + author + "，" + pages + "，" + price + "）");
//                    } while (cursor.moveToNext());
//                }
//                cursor.close();

                MyBookDao dao = new MyBookDao(DisplayMessageActivity.this);
                List<Book> bookList = dao.queryBookList(0);
                Log.d(TAG, "onClick: bookList" + bookList);
                for (Book book: bookList) {
                    Log.d(TAG, "onClick: book " + book);
                }
            }
        });
    }
}