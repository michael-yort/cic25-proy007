package es.cic.curso25.proy007.model;

public class Bombilla {

    private Long id;
    private int potencia; // En watts
    private String tipo="LED"; // "LED", "Halogena"
    private boolean encendida;

    public Bombilla() {
    }

    public Bombilla(Long id, int potencia, String tipo, boolean encendida) {
        this.id = id;
        this.potencia = potencia;
        this.tipo = tipo;
        this.encendida = encendida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }
}
