package conversor.monedas.monedas;

public class  Moneda{
    private String codigoMoneda;
    private String nombreMoneda;
    private String pais;

    public Moneda(String codigoMoneda, String nombreMoneda, String pais) {
        this.codigoMoneda = codigoMoneda;
        this.nombreMoneda = nombreMoneda;
        this.pais = pais;
    }



    // Getters para cada atributo (opcional si necesitas acceder a ellos)
    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public String getpais() {
        return pais;
    }

    // Setters para cada atributo (opcional si necesitas modificarlos)
    public void setcodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public void setnombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "codigoMoneda='" + codigoMoneda + '\'' +
                ", nombreMoneda='" + nombreMoneda + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

