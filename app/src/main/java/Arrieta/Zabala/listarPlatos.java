package Arrieta.Zabala;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapters.ListaPlatoAdapter;
import model.Plato;


public class listarPlatos extends AppCompatActivity {
    public static List<Plato> listaPlatos = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Toolbar miToolbar2;
    Plato platoR = new Plato();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_platos);
        setToolBar();
        recyclerView = (RecyclerView) findViewById(R.id.recycleLista);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Log.d(listarPlatos.NOTIFICATION_SERVICE, "listarplatos: ");

        Bundle platoRecib = getIntent().getExtras();
        if(platoRecib != null){
            platoR = (Plato) platoRecib.getSerializable("lista");
        }
        Log.d(listarPlatos.NOTIFICATION_SERVICE, "salio lista: ");
        adapter = new ListaPlatoAdapter(platoR.getListaPlatos());
        recyclerView.setAdapter(adapter);

    }
    private void setToolBar() {
        miToolbar2 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miToolbar2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.listarPlatos);
    }
}