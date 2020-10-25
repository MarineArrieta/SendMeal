package model;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plato implements Serializable {
    String titulo,descripcion;
    double precio;
    int caloria;
    public static List<Plato> listaPlatos = new ArrayList<>();

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Plato() {
    }

    ImageView imagen;

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCaloria() {
        return caloria;
    }

    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }

    public Plato(String titulo, String descripcion, double precio, int caloria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.caloria = caloria;
    }
    public void cargarPlatosPorDefecto(){
            listaPlatos.add(new Plato("Hamburguesa op", "cheddar,panceta,cebolla,papas", 450.00, 500));
            listaPlatos.add(new Plato("Pizza 4 quesos", "Mozzarella,roquefort,provolone,gouda", 550.00, 800));
            listaPlatos.add(new Plato("Parrillada", "costilla,matrimonio,chinchulin,papas o ensalada", 1000.00, 1000));
            listaPlatos.add(new Plato("Sandwich de Lomo", "lomo,rucula,jamon crudo,huevo,parmessano", 600.00, 500));
            listaPlatos.add(new Plato("Empanadas", "carne cortada a cuchillo, morron,huevo,aceituna", 600.00, 500));

    }
}
