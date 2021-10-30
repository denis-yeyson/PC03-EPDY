package com.denisyeyson.pc03_epdy.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.denisyeyson.pc03_epdy.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_producto,null,false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.nombre.setText("nombre: "+listaProductos.get(position).getNombre());
        holder.precio.setText("marca: "+listaProductos.get(position).getPrecioUnit());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,precio;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtViewNombre);
            precio = itemView.findViewById(R.id.txtViewPrecio);
        }
    }
}
