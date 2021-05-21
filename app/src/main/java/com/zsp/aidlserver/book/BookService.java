package com.zsp.aidlserver.book;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2021/5/21
 *
 * @author zsp
 * @desc 书籍服务
 */
public class BookService extends Service {
    private final String TAG = this.getClass().getSimpleName();
    private List<Book> bookList;
    private final BookAIDL.Stub stub = new BookAIDL.Stub() {
        @Override
        public List<Book> getBookList() {
            return bookList;
        }

        @Override
        public void addBookWithInOut(Book book) {
            if (null != book) {
                book.setName("服务器更改书名 TAG InOut");
                bookList.add(book);
            } else {
                Log.e(TAG, "接到一空对象 TAG InOut");
            }
        }
    };

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        initData();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return stub;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void initData() {
        bookList = new ArrayList<>();
        bookList.add(new Book("服务器端书籍"));
    }
}
