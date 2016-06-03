package com.wmartinez.devep.petagramdb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmartinez.devep.petagramdb.R;
import com.wmartinez.devep.petagramdb.adapter.MascotaAdaptador;
import com.wmartinez.devep.petagramdb.pojo.Mascota;
import com.wmartinez.devep.petagramdb.presentador.IRecyclerViewFragmentPresenter;
import com.wmartinez.devep.petagramdb.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas, listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);//Es a setContentView en un Activity
        listaMascotas   = (RecyclerView)view.findViewById(R.id.rvMascotas);
        rvMascotas      = (RecyclerView)view.findViewById(R.id.rvMascotas);
        // Inflate the layout for this fragment
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return view;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }

}
