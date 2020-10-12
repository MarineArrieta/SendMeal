package Arrieta.Zabala;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import model.Plato;

public class PlatoActivity extends AppCompatActivity {
    private EditText titulo,descripcion,precio,caloria;
    private Button guardar;
    private Toast toast;
    private Plato plato;
    private Toolbar miToolbar;
    public static List<Plato> listaPlatos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plato);
        setToolBar();
        titulo = (EditText) findViewById(R.id.titulo);
        descripcion = (EditText) findViewById(R.id.descripcion);
        precio = (EditText) findViewById(R.id.precio);
        caloria = (EditText) findViewById(R.id.caloria);
        guardar = (Button) findViewById(R.id.btGuardar);

        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validarDatos()){
                    toast = Toast.makeText(getApplicationContext(), "Nuevo plato guardado", Toast.LENGTH_SHORT);
                    toast.show();
                    double p = Double.parseDouble(precio.getText().toString());
                    int c = Integer.parseInt(caloria.getText().toString());
                    plato.setTitulo(titulo.getText().toString());
                    plato.setDescripcion(descripcion.getText().toString());
                    plato.setPrecio(p);
                    plato.setCaloria(c);
                    listaPlatos.add(plato);
                }
            }
        });


    }
    public boolean validarDatos(){

        if(titulo.getText().toString().isEmpty()){
            toast = Toast.makeText(getApplicationContext(), "Titulo vacío", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(descripcion.getText().toString().isEmpty()){
            toast = Toast.makeText(getApplicationContext(), "Descripción vacía", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(precio.getText().toString().isEmpty()){
            toast = Toast.makeText(getApplicationContext(), "Ingrese el precio del plato", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!precio.getText().toString().isEmpty()) {
            double p = Double.parseDouble(precio.getText().toString());
            if (p == 0) {
                toast = Toast.makeText(getApplicationContext(), "Ingrese precio > 0", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            } else if (caloria.getText().toString().isEmpty()) {
                toast = Toast.makeText(getApplicationContext(), "Ingrese las calorías del plato", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            } else if (!caloria.getText().toString().isEmpty()) {
                int c = Integer.parseInt(caloria.getText().toString());
                if (c == 0) {
                    toast = Toast.makeText(getApplicationContext(), "Ingrese caloria > 0", Toast.LENGTH_SHORT);
                    toast.show();
                    return false;
                }
            }
        }


            return true;
    }
    public void setToolBar(){
        miToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(miToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.agregarPlato);
    }

}