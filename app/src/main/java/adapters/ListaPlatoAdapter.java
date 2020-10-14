package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import Arrieta.Zabala.R;
import model.Plato;

public class ListaPlatoAdapter extends RecyclerView.Adapter<ListaPlatoAdapter.PlatoViewHolder >{
    private List<Plato> listaPlato;

    public ListaPlatoAdapter (List <Plato> listaP) {
        this.listaPlato = listaP;
    }
    public static class PlatoViewHolder extends RecyclerView.ViewHolder{
        public PlatoViewHolder(View v){
            super(v);
        }


    }

    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listar_platos,parent,false);
        PlatoViewHolder pvh = new PlatoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
