package com.wmartinez.devep.petagramdb.presentador;

import android.content.Context;

import com.wmartinez.devep.petagramdb.db.ConstructorMascotas;
import com.wmartinez.devep.petagramdb.fragment.ILikeMascotaView;
import com.wmartinez.devep.petagramdb.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by WilsonMartinez on 6/3/2016.
 */
public class LikeMascotaPresenter implements ILikeMascotaPresenter {

    private ILikeMascotaView iLikeMascotaView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public LikeMascotaPresenter(ILikeMascotaView iLikeMascotaView, Context context){
        this.iLikeMascotaView = iLikeMascotaView;
        this.context = context;
        obtenerCincoMascotas();
    }

    @Override
    public void obtenerCincoMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerCincoDatos();
        mostarCincoMascotasRV();
    }

    @Override
    public void mostarCincoMascotasRV() {
        iLikeMascotaView.inicializarAdaptadorRV(iLikeMascotaView.crearAdaptador(mascotas));
        iLikeMascotaView.generarLinearLayouVertical();
    }
}
