package app.traductor.traductor.modelo;

public class Opcion {

    private int imagen;
    private String texto;

    public Opcion(int imagen, String texto){
        this.imagen = imagen;
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
