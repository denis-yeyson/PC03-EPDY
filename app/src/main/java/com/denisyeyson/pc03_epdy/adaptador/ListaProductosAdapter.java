package com.denisyeyson.pc03_epdy.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denisyeyson.pc03_epdy.entidades.Productos;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder>{

    ArrayList<Productos> listaProductos;

    public ListaProductosAdapter(ArrayList<Productos> listaInquilinos){
        this.listaProductos = listaInquilinos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_inquilino,null,false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InquilinoViewHolder holder, int position) {
        holder.dni.setText("DNI: "+listaInquilinos.get(position).getDni());
        holder.nombres.setText("Nombres: "+listaInquilinos.get(position).getApPaterno()+" "+listaProductos.get(position).getApMaterno()+" "+listaProductos.get(position).getNombres());
        holder.telefono.setText("Telefono: "+listaInquilinos.get(position).getTelefono());
        holder.correo.setText("Correo: "+listaInquilinos.get(position).getCorreo());
        holder.deuda.setText("Deuda: "+listaInquilinos.get(position).getDeuda());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView dni,nombres,telefono,correo,deuda;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.txtViewNombres);
            dni = itemView.findViewById(R.id.txtViewDni);
            telefono = itemView.findViewById(R.id.txtViewTelefono);
            correo = itemView.findViewById(R.id.txtViewCorreo);
            deuda = itemView.findViewById(R.id.txtViewDeuda);
        }
    }
}
