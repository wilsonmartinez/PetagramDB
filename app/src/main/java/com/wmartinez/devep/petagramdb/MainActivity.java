package com.wmartinez.devep.petagramdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.wmartinez.devep.petagramdb.adapter.PageAdapter;
import com.wmartinez.devep.petagramdb.fragment.PerfilFragment;
import com.wmartinez.devep.petagramdb.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Como cree una actionbar la debo declarar donde la este utilizando
        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar) ;
        setSupportActionBar(miActionBar);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }
    private  void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_action_bar, menu);
        return true;    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLike:
                Toast.makeText(this, "Los cinco preferidos", Toast.LENGTH_SHORT).show();
                Intent iLike = new Intent(this, LikeMascota.class);
                startActivity(iLike);
                return true;

            case R.id.action_contacto:
                Toast.makeText(this, "Informacion de contacto", Toast.LENGTH_SHORT).show();
                Intent iContacto = new Intent(this, FormularioActivity.class);
                startActivity(iContacto);
                return true;

            case R.id.action_acerca_de:
                Toast.makeText(this, "Acerca del desarrollador.", Toast.LENGTH_SHORT).show();
                Intent iAcercaDe = new Intent(this, AcercaDeActivity.class);
                startActivity(iAcercaDe);
                return true;
            default:
                return true;
        }
    }
}
