package com.retrofit.android.retrofitdemo.db.Manager;

import android.content.Context;


import com.retrofit.android.retrofitdemo.db.DaoMaster;
import com.retrofit.android.retrofitdemo.db.DaoSession;

import org.greenrobot.greendao.database.Database;

import java.io.File;

/**
 * Created by Luis on 23/02/2017.
 */
public class ConnectionSingleton {
    private static final String DATABASE_NAME = "skadi.db";
    public static final boolean ENCRYPTED = false;
    public static final String CIPHER_DATABASE_NAME = "skadi.cipher.db";

    private static ConnectionSingleton mInstance;
    private static final int DATABASE_VERSION = 1;
    private static DaoMaster.DevOpenHelper mHelper;
    private DaoSession mDaoSession;
    private File mFile;

    public static ConnectionSingleton getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new ConnectionSingleton(context);
        }
        return mInstance;
    }

    public ConnectionSingleton(Context context) {

        mHelper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), ENCRYPTED ? CIPHER_DATABASE_NAME : DATABASE_NAME);
        Database db = ENCRYPTED ? mHelper.getEncryptedWritableDb("123456a") : mHelper.getWritableDb();

        mDaoSession = new DaoMaster(db).newSession();
        mFile = context.getDatabasePath(DATABASE_NAME);
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static void DeleteDatabase(Context context)
    {
        mInstance = null;
        context.deleteDatabase(DATABASE_NAME);
    }
    private ConnectionSingleton() { }
}
