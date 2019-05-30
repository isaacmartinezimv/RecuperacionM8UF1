package com.example.isaac.recum8uf1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TalleresAdapter extends RecyclerView.Adapter<TalleresAdapter.TalleresViewHolder> {

    ArrayList<TallerModel> listaTalleres;

    public TalleresAdapter(ArrayList<TallerModel> listaTalleres){
        this.listaTalleres = listaTalleres;
    }

    @NonNull
    @Override
    public TalleresAdapter.TalleresViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Inflamos la vista
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.taller_item, null, false);
        return new TalleresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TalleresAdapter.TalleresViewHolder talleresViewHolder, int position) {
        talleresViewHolder.verValoracion.setText(listaTalleres.get(position).getValoraciones());
        talleresViewHolder.verComentarios.setText(listaTalleres.get(position).getComentarios());
    }

    @Override
    public int getItemCount() {
        return listaTalleres.size();
    }

    public class TalleresViewHolder extends RecyclerView.ViewHolder {
        //declaramos las variables de la vista
        TextView verValoracion;
        TextView verComentarios;


        public TalleresViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asignamoslas variables de la vista a los elementos
            verValoracion = itemView.findViewById(R.id.verValoracionesID);
            verComentarios = itemView.findViewById(R.id.verComentariosID);
        }
    }
}
