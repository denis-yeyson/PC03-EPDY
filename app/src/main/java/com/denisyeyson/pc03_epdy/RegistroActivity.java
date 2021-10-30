package com.denisyeyson.pc03_epdy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.denisyeyson.pc03_epdy.db.DbProductos;

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre,txtMarca,txtDescripcion,txtCantidad,txtPrecio;
    Button btnAgregarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombres);
        txtMarca = findViewById(R.id.txtMarca);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);

        btnAgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProductos dbProductos = new DbProductos(RegistroActivity.this);
                long id = dbProductos.insertarProducto(txtNombre.getText().toString(), txtMarca.getText().toString(),
                        txtDescripcion.getText().toString(),Integer.valueOf(txtCantidad.getText().toString()),
                        Double.valueOf(txtPrecio.getText().toString()));
                if (id > 0){
                    limpiar();
                    Toast.makeText(RegistroActivity.this, "PRODUCTO GUARDADO", Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(RegistroActivity.this,PrincipalActivity.class));
                }else{
                    Toast.makeText(RegistroActivity.this, "ERROR AL GUARDAR PRODUCTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiar(){
        txtNombre.setText("");
        txtMarca.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
    }
}