package com.wmartinez.devep.petagramdb.fragment;

import com.wmartinez.devep.petagramdb.adapter.MascotaAdaptador;
import com.wmartinez.devep.petagramdb.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by WilsonMartinez on 6/3/2016.
 */
public interface ILikeMascotaView {

    void generarLinearLayouVertical();
    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
