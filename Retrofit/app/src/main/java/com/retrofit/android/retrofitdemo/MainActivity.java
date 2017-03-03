package com.retrofit.android.retrofitdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.retrofit.android.retrofitdemo.OAuth.AccessToken;
import com.retrofit.android.retrofitdemo.OAuth.ServiceGenerator;
import com.retrofit.android.retrofitdemo.db.Line;
import com.retrofit.android.retrofitdemo.db.Manager.ConnectionSingleton;
import com.retrofit.android.retrofitdemo.db.Manager.DataTransferObjectsParser;
import com.retrofit.android.retrofitdemo.db.Other;
import com.retrofit.android.retrofitdemo.db.OtherDao;
import com.retrofit.android.retrofitdemo.db.PhoneAllLines;
import com.retrofit.android.retrofitdemo.db.PhoneAllLinesDao;
import com.retrofit.android.retrofitdemo.db.PlainDetail;
import com.retrofit.android.retrofitdemo.db.TermsAndConditions;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String BASE_URL = "https://private-eed58-tyr1.apiary-mock.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConnectionSingleton.DeleteDatabase(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       try{
                                           Snackbar.make(view, "Sending info to server", Snackbar.LENGTH_LONG)
                                                   .setAction("Action", null).show();

                                           Retrofit retrofit = new Retrofit.Builder()
                                                   .baseUrl(BASE_URL)
                                                   .addConverterFactory(GsonConverterFactory.create())
                                                   .build();

                                           //region data
                                          /* String json = "{\n" +
                                                   "\t\"SolicitudEvaluacionNegocio\": {\n" +
                                                   "\t\t\"idSolicitante\": \"6eaf4e27-111e-4add-85fc-d83c10a4ac42\",\n" +
                                                   "\t\t\"idStatusAprobacion\": \"1\",\n" +
                                                   "\t\t\"observaciones\": \"\"\n" +
                                                   "\t},\n" +
                                                   "\t\"Ventas\": [\n" +
                                                   "\t\t{\n" +
                                                   "\t\t\t\"monto\": 123,\n" +
                                                   "\t\t\t\"idPeriodo\": \"\",\n" +
                                                   "\t\t\t\"idCalificacion\": \"\",\n" +
                                                   "\t\t\t\"idTipoVenta\": \"CRE\"\n" +
                                                   "\t\t}\n" +
                                                   "\t],\n" +
                                                   "\t\"CuentasCobrar\": [\n" +
                                                   "\t\t{\n" +
                                                   "\t\t\t\"clientes\": 2,\n" +
                                                   "\t\t\t\"monto\": 2333,\n" +
                                                   "\t\t\t\"idCuenta\": 1\n" +
                                                   "\t\t}\n" +
                                                   "\t],\n" +
                                                   "\t\"AnalisisCostoVentas\": [\n" +
                                                   "\t\t{\n" +
                                                   "\t\t\t\"producto\": \"\",\n" +
                                                   "\t\t\t\"unidadMedida\": \"\",\n" +
                                                   "\t\t\t\"cantidadVendidaMes\": 32,\n" +
                                                   "\t\t\t\"precioUnitario\": 2,\n" +
                                                   "\t\t\t\"costoUnitario\": 1\n" +
                                                   "\t\t}\n" +
                                                   "\t],\n" +
                                                   "\t\"EvaluacionNegocio\": [\n" +
                                                   "\t\t{\n" +
                                                   "\t\t\t\"monto\": 1,\n" +
                                                   "\t\t\t\"idCuenta\": 2\n" +
                                                   "\t\t}\n" +
                                                   "\t],\n" +
                                                   "\t\"HojaTrabajo\": {\n" +
                                                   "\t\t\"cajaBancos\": \"\",\n" +
                                                   "\t\t\"cuentasCobrar\": \"\",\n" +
                                                   "\t\t\"inventarios\": \"\",\n" +
                                                   "\t\t\"activoFijo\": \"\",\n" +
                                                   "\t\t\"actividad\": \"\",\n" +
                                                   "\t\t\"otrosIngresos\": 122,\n" +
                                                   "\t\t\"otrosGastos\": 0,\n" +
                                                   "\t\t\"comprasMensuales\": \"\"\n" +
                                                   "\t}\n" +
                                                   "}";
                                           Gson gson = new Gson();
                                           Negocio negocio = gson.fromJson(json, Negocio.class);
                                           */
                                           //endregion

                                           //region parser directly from json string
                                           /*
                                            Gson gson = new Gson();
                                           DataTransferObjectsParser.dtoCatalog objectToParse =
                                                   new DataTransferObjectsParser.dtoCatalog();
                                           objectToParse = gson.fromJson("{\"timestamp\": 1487786669,\"carrier\":{1:\"Telcel\",2:\"Telcel\"},\"loanPaymentType\":{1:\"Telc2el\",3:\"Telcel\"}}", objectToParse.getClass());
                                           objectToParse = gson.fromJson("{\n" +
                                                   "    \"timestamp\": 1487786669,\n" +
                                                   "    \"carrier\": {\n" +
                                                   "        1: \"Telcel\",\n" +
                                                   "        2: \"Movistar\",\n" +
                                                   "        3: \"AT&T\",\n" +
                                                   "        4: \"Virgin Mobile\",\n" +
                                                   "        5: \"Unefon\"\n" +
                                                   "    },\n" +
                                                   "    \"loanPaymentType\": {\n" +
                                                   "        1: \"Cash\",\n" +
                                                   "        2: \"Weekly\"\n" +
                                                   "    },\n" +
                                                   "    \"paymentReference\": {\n" +
                                                   "        1: \"Cuenta Compartamos\",\n" +
                                                   "        2: \"Bancomer\",\n" +
                                                   "        3: \"OXXO\"\n" +
                                                   "    },\n" +
                                                   "    \"plan\": {\n" +
                                                   "        1: \"SaldoDoble\",\n" +
                                                   "        2: \"Básico\",\n" +
                                                   "        3: \"BásicoPlus\",\n" +
                                                   "        4: \"Feis\",\n" +
                                                   "        5: \"Mujer\",\n" +
                                                   "        6: \"SúperFeis\",\n" +
                                                   "        7: \"Empresaria\",\n" +
                                                   "        8: \"EmpresariaPlus\"\n" +
                                                   "    },\n" +
                                                   "    \"prepayAmount\": {\n" +
                                                   "        1: 20,\n" +
                                                   "        2: 30,\n" +
                                                   "        3: 50,\n" +
                                                   "        4: 100,\n" +
                                                   "        5: 150,\n" +
                                                   "        6: 200\n" +
                                                   "    },\n" +
                                                   "    \"prepayStatus\": {\n" +
                                                   "        1: \"Approved\",\n" +
                                                   "        2: \"Pending\",\n" +
                                                   "        3: \"Rejected\"\n" +
                                                   "    },\n" +
                                                   "    \"products\": {\n" +
                                                   "        1: \"Crédito Mujer\",\n" +
                                                   "        2: \"ApoyaT\",\n" +
                                                   "        3: \"Mis números\",\n" +
                                                   "        4: \"Venta de tiempo aire\"\n" +
                                                   "    },\n" +
                                                   "    \"references\": {\n" +
                                                   "        1: \"Compartamos\",\n" +
                                                   "        2: \"Bancomer\",\n" +
                                                   "        3: \"OXXO\"\n" +
                                                   "    },\n" +
                                                   "    \"securityQuestion\": {\n" +
                                                   "        1: \"¿Cuál es el nombre de tu mejor amiga?\"\n" +
                                                   "    }\n" +
                                                   "}"
                                           , objectToParse.getClass());
                                           String json = "";
                                           */

                                           //endregion

                                           //region insert catalog section

                                           /*
                                           MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);


                                           Call<ResponseBody> call = apiService.GetCatalogs();
                                           call.enqueue(new Callback<ResponseBody>() {

                                               @Override
                                               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                                  DataTransferObjectsParser dataTransferObjectsParser = new DataTransferObjectsParser(getApplicationContext());
                                                   try {
                                                       dataTransferObjectsParser.addCatalogs(response);
                                                   } catch (IOException e) {
                                                       e.printStackTrace();
                                                   } catch (IllegalAccessException e) {
                                                       e.printStackTrace();
                                                   }
                                               }

                                               @Override
                                               public void onFailure(Call<ResponseBody> call, Throwable t) {
                                                   Log.e("error", "");
                                               }
                                           });*/

                                           //endregion

                                           //region parser phonealllines section
                                            /*
                                           Call<PhoneAllLines> call = apiService.GetAllLines("userId");
                                           call.enqueue(new Callback<PhoneAllLines>() {

                                               @Override
                                               public void onResponse(Call<PhoneAllLines> call, Response<PhoneAllLines> response) {
                                                  ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance(getApplicationContext());
                                                  PhoneAllLines phoneAllLines = new PhoneAllLines();
                                                  phoneAllLines.__setDaoSession(connectionSingleton.getDaoSession());
                                                  phoneAllLines.customInsert(response.body());
                                               }

                                               @Override
                                               public void onFailure(Call<PhoneAllLines> call, Throwable t) {
                                                   Log.e("error", "");
                                               }
                                           });
                                         */

                                           //endregion

                                           //region oauth section


                                           final AccessToken[] token = {null};
                                           final SharedPreferences prefs = getApplicationContext().getSharedPreferences(
                                                   BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
                                           final String password = "password";
                                           String user="user";
                                           MyApiEndpointInterface client = ServiceGenerator.createService(MyApiEndpointInterface.class);

                                           Call<AccessToken> call = client.PostLoginPassword(user, password);
                                           call.enqueue(new Callback<AccessToken>() {

                                               @Override
                                               public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                                                   if(response.code() == 200) {
                                                       token[0] = response.body();
                                                       prefs.edit().putBoolean("oauth.loggedin", true).apply();
                                                       prefs.edit().putString("oauth.accesstoken", token[0].getAccessToken()).apply();
                                                       prefs.edit().putString("oauth.refreshtoken", token[0].getRefreshToken()).apply();
                                                       prefs.edit().putString("oauth.tokentype", token[0].getTokenType()).apply();


                                                       /*MyApiEndpointInterface client_lines = ServiceGenerator.createService(MyApiEndpointInterface.class, token[0], getApplicationContext());

                                                       Call<PhoneAllLines> call_lines = client_lines.GetAllLines(password);
                                                       call_lines.enqueue(new Callback<PhoneAllLines>() {

                                                           @Override
                                                           public void onResponse(Call<PhoneAllLines> call_lines, Response<PhoneAllLines> response) {
                                                               if (response.code() == 200) {

                                                               }
                                                           }

                                                           @Override
                                                           public void onFailure(Call<PhoneAllLines> call, Throwable t) {
                                                               Log.e("error", "");
                                                           }
                                                       });*/

                                                       final DataTransferObjectsParser dataTransferObjectsParser = new DataTransferObjectsParser(getApplicationContext());
                                                       MyApiEndpointInterface client_lines = ServiceGenerator.createService(MyApiEndpointInterface.class, token[0], getApplicationContext());

                                                       Call<TermsAndConditions> call_lines = client_lines.GetTermsAndConditions();
                                                       call_lines.enqueue(new Callback<TermsAndConditions>() {

                                                           @Override
                                                           public void onResponse(Call<TermsAndConditions> call_lines, Response<TermsAndConditions> response) {
                                                               if (response.code() == 200) {
                                                                   dataTransferObjectsParser.addTermsAndConditions(response);
                                                               }
                                                           }

                                                           @Override
                                                           public void onFailure(Call<TermsAndConditions> call, Throwable t) {
                                                               Log.e("error", "");
                                                           }
                                                       });
                                                   }
                                               }

                                               @Override
                                               public void onFailure(Call<AccessToken> call, Throwable t) {
                                                   Log.e("error", "");
                                               }
                                           });

                                           //endregion

                                       }
                                       catch(Exception ex) {
                                           Log.e("",ex.toString());
                                       }
                                   }
                               });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
