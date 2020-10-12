package model;

public class Plato {
    String titulo,descripcion;
    double precio;
    int caloria;

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



}
