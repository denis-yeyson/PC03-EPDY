package com.denisyeyson.pc03_epdy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.denisyeyson.pc03_epdy.entidades.Productos;

import java.util.ArrayList;

public class DbProductos extends DbHelper{

    Context context;

    public DbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(String nombre, String marca,String descripcion, int cantidad,double precioUnit){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("marca", marca);
            values.put("descripcion", descripcion);
            values.put("cantidad", cantidad);
            values.put("precioUnit", precioUnit);

            id = db.insert(TABLE_PRODUCTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Productos> mostrarInquilinos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Productos> lista = new ArrayList<>();
        Productos prod = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM "+TABLE_PRODUCTOS,null);
        if(cursorProductos.moveToFirst()){
            do{
                prod = new Productos();
                prod.setId(cursorProductos.getInt(0));
                prod.setNombre(cursorProductos.getString(1));
                prod.setMarca(cursorProductos.getString(2));
                prod.setDescripcion(cursorProductos.getString(3));
                prod.setCantidad(cursorProductos.getInt(4));
                prod.setPrecioUnit(cursorProductos.getDouble(5));
                lista.add(prod);
            }while (cursorProductos.moveToNext());
        }
        cursorProductos.close();
        return lista;
    }

}
