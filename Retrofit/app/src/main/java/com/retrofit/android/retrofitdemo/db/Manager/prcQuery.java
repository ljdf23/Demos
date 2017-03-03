package com.retrofit.android.retrofitdemo.db.Manager;

import android.content.Context;

import com.retrofit.android.retrofitdemo.db.Catalogs;
import com.retrofit.android.retrofitdemo.db.DaoSession;

import java.util.HashMap;

/**
 * Created by Luis on 02/03/2017.
 */

public class prcQuery {

    private Context mContext;
    private DaoSession daoSession;

    public prcQuery(Context context)
    {
        mContext = context;
        daoSession = ConnectionSingleton.getInstance(mContext).getDaoSession();

    }
    public void addCatalog(String name, Integer key, String value )
    {
        try {
            Catalogs catalogs = new Catalogs();
            catalogs.setName(name);
            catalogs.setKey(key);
            catalogs.setValue(value);
            daoSession.getCatalogsDao().insert(catalogs);
        }
        catch (Exception ex) {
            throw  ex;
        }
    }
}
