package com.denisyeyson.pc03_epdy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.denisyeyson.pc03_epdy.adaptador.ListaProductosAdapter;
import com.denisyeyson.pc03_epdy.db.DbProductos;
import com.denisyeyson.pc03_epdy.entidades.Productos;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        listaProductos=findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbInquilinos =  new DbProductos(PrincipalActivity.this);
        listaArrayProductos =  new ArrayList<>();

        ListaProductosAdapter adapter=new ListaProductosAdapter(dbInquilinos.mostrarInquilinos());
        listaProductos.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemAgregar:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}