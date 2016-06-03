package com.wmartinez.devep.petagramdb.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wmartinez.devep.petagramdb.R;
import com.wmartinez.devep.petagramdb.db.ConstructorMascotas;
import com.wmartinez.devep.petagramdb.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by WilsonMartinez on 6/3/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public int likes;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewHolder para que obtenga los views
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar o darle vida al Layout cardview_contactos.xml (asociarlo al RecyclerView del Activity_Main)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        //Pasar la lista de contactos ArrayList<Contacto> contactos; a cada elemento
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));
       /*
        mascotaViewHolder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, .class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("puntos", mascota.getLikes());
                activity.startActivity(intent);
            }
        });*/

        mascotaViewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvLikesCV.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

            }
        });
    }

    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        //Declarar todos los view ubicados en el cardview_contacto.xml
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton imgBtnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            //Asociar los objetos con su respectivo View:
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.imgBtnLike);
        }
    }
}
