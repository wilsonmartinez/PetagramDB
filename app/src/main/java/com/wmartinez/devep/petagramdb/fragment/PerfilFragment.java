package com.wmartinez.devep.petagramdb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmartinez.devep.petagramdb.R;
import com.wmartinez.devep.petagramdb.adapter.PerfilMascotaAdaptador;
import com.wmartinez.devep.petagramdb.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> perfilMascota;
    private RecyclerView rvPerfilMascota, listaPerfilMascota;
    public PerfilMascotaAdaptador adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaPerfilMascota   = (RecyclerView)view.findViewById(R.id.rvPerfilMascota);
        rvPerfilMascota      = (RecyclerView)view.findViewById(R.id.rvPerfilMascota);

        final GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        listaPerfilMascota.setLayoutManager(glm);
        inicializarListaPerfilMascota();
        inicializarAdaptadorPerfil();

        // Inflate the layout for this fragment
        return view;
    }

    public void inicializarAdaptadorPerfil(){
        adaptador = new PerfilMascotaAdaptador(perfilMascota, getActivity());
        rvPerfilMascota.setAdapter(adaptador);
    }

    public void  inicializarListaPerfilMascota(){
        perfilMascota = new ArrayList<Mascota>();
        perfilMascota.add(new Mascota("Ergo", 4 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 2 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 3 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 2 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 2 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 5 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 5 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 3 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 2 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 2 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 5 ,R.drawable.gato));
        perfilMascota.add(new Mascota("Ergo", 5 ,R.drawable.gato));
    }

}
