package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import Arrieta.Zabala.R;
import model.Plato;

import static android.widget.Toast.LENGTH_SHORT;

public class ListaPlatoAdapter extends RecyclerView.Adapter<ListaPlatoAdapter.PlatoViewHolder >{
    private List<Plato> listaPlato;
    private Toast toast;
    int contador = 0;
    final int repeticion = 1;


    public static class PlatoViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, descripcion, precio,caloria;
        CardView card;
        ImageView imagen;
        public PlatoViewHolder(View v){
            super(v);
            card = v.findViewById(R.id.cardviewPlato);
            titulo = v.findViewById(R.id.tituloCard);
            descripcion = v.findViewById(R.id.descripcionCard);
            precio = v.findViewById(R.id.precioCard);
            caloria = v.findViewById(R.id.caloriaCard);
            imagen = v.findViewById(R.id.imagenCard);
        }


    }

    public ListaPlatoAdapter (List <Plato> listaP) {

        this.listaPlato = listaP;
    }


    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plato_fila,parent,false);
        PlatoViewHolder pvh = new PlatoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int position) {

        Plato plato = listaPlato.get(position);
        holder.titulo.setText(plato.getTitulo());
        animacionTexto(holder.titulo);
        holder.descripcion.setText(plato.getDescripcion());
        holder.caloria.setText((String.valueOf(plato.getCaloria())));
        holder.precio.setText(String.valueOf(plato.getPrecio()));

    }


    @Override
    public int getItemCount() {
        return listaPlato.size();
    }

    private void animacionTexto(final TextView texto) {


        final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(450);
        fadeIn.setStartOffset(350);
        fadeIn.setFillAfter(true);

        final AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 0.1f);
        fadeOut.setDuration(400);
        fadeOut.setStartOffset(350);
        fadeOut.setFillAfter(true);


        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                contador++;

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (contador == 0)
                    texto.startAnimation(fadeOut);
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
                    texto.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        texto.startAnimation(fadeIn);

    }
}
