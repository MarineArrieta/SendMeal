package Arrieta.Zabala;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


public class HomeActivity extends AppCompatActivity {

    Toolbar miToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView textoBienvenida;
    private int contador = 0;
    private final int repeticion = 1;
    Intent intent;

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

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case (R.id.menuRegistrar):
                        intent = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(intent);
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





