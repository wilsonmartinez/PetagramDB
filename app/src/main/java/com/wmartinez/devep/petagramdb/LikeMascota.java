package com.wmartinez.devep.petagramdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.wmartinez.devep.petagramdb.adapter.MascotaAdaptador;
import com.wmartinez.devep.petagramdb.fragment.ILikeMascotaView;
import com.wmartinez.devep.petagramdb.pojo.Mascota;
import com.wmartinez.devep.petagramdb.presentador.ILikeMascotaPresenter;
import com.wmartinez.devep.petagramdb.presentador.LikeMascotaPresenter;

import java.util.ArrayList;

public class LikeMascota extends AppCompatActivity  implements ILikeMascotaView{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas1, listaMascotas;
    public MascotaAdaptador adaptador;
    //private Context context;
    private ILikeMascotaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_mascota);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar) ;
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas1      = (RecyclerView)findViewById(R.id.rvLikeMascotas);
        presenter = new LikeMascotaPresenter(this, getApplicationContext());
    }

    @Override
    public void generarLinearLayouVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas1.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas1.setAdapter(adaptador);
    }
}
