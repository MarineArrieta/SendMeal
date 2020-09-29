package Arrieta.Zabala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    Switch recargar;
    TextView tv;
    CheckBox aceptarT;
    Button registrar;
    EditText pass1;
    EditText pass2;
    Toast toast;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.progresoSeekbar);
        tv.setVisibility(View.GONE);
        tv.setText("0");
        seekbar=(SeekBar) findViewById(R.id.seekBar);
        seekbar.setVisibility(View.GONE);
        recargar= (Switch) findViewById(R.id.recargaSwitch);
        aceptarT= findViewById(R.id.aceptarTermino);
        registrar= findViewById(R.id.registrar);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser)
                            {
                                tv.setText(Integer.toString(progress));
                            }
                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar)
                            {
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar)
                            {
                            }

        });
    }


    public void onclick(View view) {
        if(view.getId() == R.id.recargaSwitch)
            if(recargar.isChecked()) {
                seekbar.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
            }
            else {
                seekbar.setVisibility(View.GONE);
                tv.setVisibility(View.GONE);
            }
    }

    public void onClickCheckBox(View view) {
        if(view.getId() == R.id.aceptarTermino){
            if(aceptarT.isChecked()){
                registrar.setEnabled(true);
            }
            else{
                registrar.setEnabled(false);
            }
        }

    }

    public boolean validarDatos(View view) {
        String c1, c2;
        c1 = pass1.getText().toString();
        c2 = pass2.getText().toString();
        RadioButton debito = findViewById(R.id.tarjetaDebito);
        RadioButton credito = findViewById(R.id.tarjetaCredito);



        if(!(c1.equals(c2))){
             toast = Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden", Toast.LENGTH_SHORT);
             toast.show();
             return false;
        }
        else if(c1.equals(c2) && c1.isEmpty()) {
            toast = Toast.makeText(getApplicationContext(),"Contraseña vacia", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!validarCorreo()) {
            toast = Toast.makeText(getApplicationContext(), "email no valido", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!(debito.isChecked()) && !(credito.isChecked())){
            toast = Toast.makeText(getApplicationContext(),"Tipo de tarjeta no seleccionada", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!validarTarjeta()){
            toast = Toast.makeText(getApplicationContext(),"Tarjeta no valida", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!validarCCV()){
            toast = Toast.makeText(getApplicationContext(),"CCV no valido", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!validarFecha()){
            toast = Toast.makeText(getApplicationContext(), "Fecha invalida", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else if(!validarSwitch()){
            toast = Toast.makeText(getApplicationContext(), "Monto invalido", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            toast = Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        return true;
    }
    public boolean validarCorreo(){
        EditText correo = findViewById(R.id.correo);
        int longitud = correo.length();
        int indice;
        if(!correo.getText().toString().contains("@"))
            return false;
        else {
            indice = correo.getText().toString().indexOf("@");
            if((longitud-(indice+1)) < 3)
                return false;
            else
                return true;
        }
    }
    public boolean validarTarjeta(){
        EditText tarjeta = findViewById(R.id.tarjetaNumero);
        if(tarjeta.length() != 16)
            return false;
        else
            return true;
    }
    public boolean validarCCV(){
        EditText CCV = findViewById(R.id.TarjetaCCV);
        if(CCV.length() != 3)
            return false;
        else
            return true;
    }
    public boolean validarFecha(){
        EditText mes = findViewById(R.id.mesVenc);
        EditText anio = findViewById(R.id.anioVenc);
        int mesInt,anioInt;
        Calendar fecha = Calendar.getInstance();
        int añoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH);

        if(!mes.getText().toString().isEmpty() && !anio.getText().toString().isEmpty()) {
            mesInt = Integer.parseInt(mes.getText().toString());
            anioInt = Integer.parseInt(anio.getText().toString());

            if (mes.length() != 2) {
                return false;

            } else if (mesInt < 1 || mesInt > 12) {
                return false;
            }
            if (anio.length() != 4) {
                return false;

            } else if (anioInt < 2020) {
                return false;
            }

            if((anioInt-añoActual) == 0){

                if(mesInt < mesActual || (mesInt-(mesActual+1) < 3)){
                    return false;
                }
            }
            else if((anioInt-añoActual) == 1){
                int dif = (12+mesInt) - (mesActual+1);
                if(dif < 3) {
                    return false;
                }

            }
            else
                return true;
        }
        else
            return false;

      return true;
    }
    public boolean validarSwitch() {
        if (recargar.isChecked()) {
            if (seekbar.getProgress() == 0)
                return false;
        }
        return true;
    }

}