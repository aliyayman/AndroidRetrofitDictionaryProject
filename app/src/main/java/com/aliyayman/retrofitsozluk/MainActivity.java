package com.aliyayman.retrofitsozluk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerList;
    private KelimelerAdapter adapter;
    private KelimelerDaoInterface kelimelerDaoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rv=findViewById(R.id.rv);


        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);


        kelimelerDaoInterface=ApiUtils.getKisilerDaoInterface();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        tumKelimeler();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem item=menu.findItem(R.id.action_ara);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen arama",query);
        aramaYap(query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("harf girdikçe",newText);
        aramaYap(newText);
        return false;
    }


    public void aramaYap(String aramaKelime){

        kelimelerDaoInterface.kelimeAra(aramaKelime).enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {
                List<Kelimeler> kelimelerTemp=response.body().getKelimeler();

                adapter=new KelimelerAdapter(MainActivity.this,kelimelerTemp);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });



    }
    public void tumKelimeler(){
        kelimelerDaoInterface.tumKelimeler().enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {
                 List<Kelimeler> kelimelerTemp=response.body().getKelimeler();

                 adapter=new KelimelerAdapter(MainActivity.this,kelimelerTemp);
                 rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });
    }
}