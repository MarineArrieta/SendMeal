package Arrieta.Zabala;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import  androidx.appcompat.widget.Toolbar ;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Plato;


public class HomeActivity extends AppCompatActivity {

    Toolbar miToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView textoBienvenida;
    private int contador = 0;
    private final int repeticion = 1;
    Toast toast;
    List<Plato> listaDePlatos = new ArrayList<>();
    Plato platoR = new Plato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(HomeActivity.NOTIFICATION_SERVICE, "onCreate: Activity 1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textoBienvenida = (TextView) findViewById(R.id.textBienvenida);
        animacionTexto();

        Bundle platoRecibido = getIntent().getExtras();
        if(platoRecibido != null){
            platoR = (Plato) platoRecibido.getSerializable("plato");

        }
        if(platoR.getListaPlatos().isEmpty())
            platoR.cargarPlatosPorDefecto();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case (R.id.menuRegistrar):
                        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case (R.id.menuPlato):
                        Intent intent2 = new Intent(HomeActivity.this,PlatoActivity.class);
                        Log.d(HomeActivity.NOTIFICATION_SERVICE, "onCreate: Activity 1-> plato enviado");
                        startActivity(intent2);
                        break;
                    case (R.id.menu_recetas):
                        Bundle bundle = new Bundle();
                        Intent intent3 = new Intent(HomeActivity.this,listarPlatos.class);
                        bundle.putSerializable("lista",platoR);
                        intent3.putExtras(bundle);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }

    private void animacionTexto() {

        final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1500);
        fadeIn.setStartOffset(2000);
        fadeIn.setFillAfter(true);

        final AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 0.1f);
        fadeOut.setDuration(1500);
        fadeOut.setStartOffset(2000);
        fadeOut.setFillAfter(true);


        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                contador++;

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (contador == 0)
                    textoBienvenida.startAnimation(fadeOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (contador < repeticion)
                    textoBienvenida.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textoBienvenida.startAnimation(fadeIn);

    }

    private void setToolBar() {
        miToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Toast.makeText(this,"CLICK EN OPCION 1",Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}





