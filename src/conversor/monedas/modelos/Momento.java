package conversor.monedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Momento {
    private LocalDateTime ahora;

    public String getFechayHora() {
        this.ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return ahora.format(formatter);
    }
}