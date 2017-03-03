package com.retrofit.android.retrofitdemo.db.Manager;

import android.content.Context;
import com.google.gson.Gson;
import com.retrofit.android.retrofitdemo.db.TermsAndConditions;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Luis on 01/03/2017.
 */

public class DataTransferObjectsParser {

    private Context mContext;
    private Gson mGson = new Gson();
    private dtoCatalog mDtoCatalog;
    private prcQuery prcQuery;

    public DataTransferObjectsParser(Context poContext) {
        this.mContext = poContext;
        mDtoCatalog = new dtoCatalog();
        mGson = new Gson();
        prcQuery = new prcQuery(mContext);
    }

    /**
     * Response is a hashmap, we have to parse and insert in tx
     * @param response
     * @throws IOException
     * @throws IllegalAccessException
     */

    public void addCatalogs(Response<ResponseBody> response) throws IOException, IllegalAccessException {
        try {
            mDtoCatalog = mGson.fromJson(response.body().string(), mDtoCatalog.getClass());
            Field[] fields = mDtoCatalog.getClass().getDeclaredFields();

            for(Field field : fields) {
                if((field.getType().equals(HashMap.class))) {
                    HashMap<Integer,String> hashmap = (HashMap<Integer, String>) field.get(mDtoCatalog);
                    Set set = (Set) hashmap.entrySet();
                    Iterator it = set.iterator();

                    while(it.hasNext()) {
                        Map.Entry entry = (Map.Entry)it.next();
                        prcQuery.addCatalog(field.getName(),
                                (Integer)entry.getKey(),
                                (String)entry.getValue());
                    }
                    prcQuery.addCatalogs();
                }
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    public void addTermsAndConditions(Response<TermsAndConditions> response)
    {
        try
        {
            prcQuery.addTermsAndConditions(response.body());
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public class dtoCatalog
    {
        String timestamp;
        HashMap<Integer, String> carrier;
        HashMap<Integer, String> loanPaymentType;
        HashMap<Integer, String> paymentReference;
        HashMap<Integer, String> plan;
        HashMap<Integer, String> prepayAmount;
        HashMap<Integer, String> prepayStatus;
        HashMap<Integer, String> products;
        HashMap<Integer, String> references;
        HashMap<Integer, String> securityQuestion;
    }
}
