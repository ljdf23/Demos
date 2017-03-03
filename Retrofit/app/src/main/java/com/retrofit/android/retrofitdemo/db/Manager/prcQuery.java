package com.retrofit.android.retrofitdemo.db.Manager;

import android.content.Context;

import com.retrofit.android.retrofitdemo.db.Catalogs;
import com.retrofit.android.retrofitdemo.db.CatalogsDao;
import com.retrofit.android.retrofitdemo.db.DaoSession;
import com.retrofit.android.retrofitdemo.db.TermsAndConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 02/03/2017.
 */

public class prcQuery {

    private Context mContext;
    private DaoSession daoSession;
    private List<Catalogs> mCatalogsList;

    public prcQuery(Context context)
    {
        mContext = context;
        daoSession = ConnectionSingleton.getInstance(mContext).getDaoSession();
        mCatalogsList = new ArrayList<>();
    }

    public void addCatalog(String name, Integer key, String value)
    {
        Catalogs catalogs = new Catalogs();
        catalogs.setName(name);
        catalogs.setKey(key);
        catalogs.setValue(value);
        mCatalogsList.add(catalogs);
    }

    public void addCatalogs()
    {
        daoSession.getCatalogsDao().insertInTx(mCatalogsList);
    }

    public void addTermsAndConditions(TermsAndConditions termsAndConditions)
    {
        daoSession.getTermsAndConditionsDao().insert(termsAndConditions);
    }

    public void deleteAllTables()
    {
        daoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                daoSession.getTermsAndConditionsDao().deleteAll();
                daoSession.getCatalogsDao().deleteAll();
                daoSession.getOtherDao().deleteAll();
                daoSession.getPhoneAllLinesDao().deleteAll();
                daoSession.getLineDao().deleteAll();
                daoSession.getPlainDetailDao().deleteAll();
                daoSession.getUserDao().deleteAll();
            }
            });
    }

    public void deleteCatalogs()
    {
        daoSession.getCatalogsDao().deleteAll();
    }

    //// TODO: 02/03/2017  CHANGE FOR ENUM (GREENDAO SPECIAL DATATYPE)
    public List<Catalogs> getCatalog(String name)
    {
        return daoSession.getCatalogsDao().queryBuilder()
                .where(CatalogsDao.Properties.Name.eq(name))
                .orderAsc(CatalogsDao.Properties.Key)
                .list();
    }
}
