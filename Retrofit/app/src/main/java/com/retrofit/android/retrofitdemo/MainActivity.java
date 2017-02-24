package com.retrofit.android.retrofitdemo;

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

import com.retrofit.android.retrofitdemo.db.Line;
import com.retrofit.android.retrofitdemo.db.Manager.ConnectionSingleton;
import com.retrofit.android.retrofitdemo.db.Other;
import com.retrofit.android.retrofitdemo.db.OtherDao;
import com.retrofit.android.retrofitdemo.db.PhoneAllLines;
import com.retrofit.android.retrofitdemo.db.PhoneAllLinesDao;
import com.retrofit.android.retrofitdemo.db.PlainDetail;

import java.util.ArrayList;
import java.util.List;

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

                                           MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);


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
