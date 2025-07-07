package conversor.monedas.modelos;

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

    @Override
    public String toString() {
        return "Moneda{" +
                "codigoMoneda='" + codigoMoneda + '\'' +
                ", nombreMoneda='" + nombreMoneda + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

