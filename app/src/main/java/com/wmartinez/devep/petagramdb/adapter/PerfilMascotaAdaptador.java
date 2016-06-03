package com.wmartinez.devep.petagramdb.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmartinez.devep.petagramdb.R;
import com.wmartinez.devep.petagramdb.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by WilsonMartinez on 6/3/2016.
 */
public class PerfilMascotaAdaptador extends  RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilMascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;
    public int puntos;

    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewHolder para que obtenga los views
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar o darle vida al Layout cardview_contactos.xml (asociarlo al RecyclerView del Activity_Main)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);
        return new PerfilMascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PerfilMascotaViewHolder perfilMascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        perfilMascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        perfilMascotaViewHolder.tvPuntosCV.setText(String.valueOf(mascota.getLikes()));
    }


    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder {
        //Declarar todos los view ubicados en el cardview_contacto.xml
        private ImageView imgFotoCV;
        private TextView tvPuntosCV;

        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            //Asociar los objetos con su respectivo View:
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCVPerfil);
            tvPuntosCV = (TextView) itemView.findViewById(R.id.tvLikesCVPerfil);
        }
    }
}
