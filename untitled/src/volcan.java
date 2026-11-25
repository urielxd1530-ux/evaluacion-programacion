enum NivelAlerta {
    BLANCA, AMARILLA, NARANJA, ROJA
}

public class Volcan {
    private String nombre, provincia;
    private double latitud, longitud;
    private NivelAlerta nivelAlerta = NivelAlerta.BLANCA;

    public Volcan(String nombre, String provincia, double latitud, double longitud) {
        setNombre(nombre);
        setProvincia(provincia);
        setLatitud(latitud);
        setLongitud(longitud);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String n) {
        if (n == null || n.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        nombre = n;
    }

    public String getProvincia() { return provincia; }
    public void setProvincia(String p) {
        if (p == null || p.isBlank()) throw new IllegalArgumentException("Provincia inválida");
        provincia = p;
    }

    public double getLatitud() { return latitud; }
    public void setLatitud(double x) {
        if (x < -90 || x > 90) throw new IllegalArgumentException("Latitud inválida");
        latitud = x;
    }

    public double getLongitud() { return longitud; }
    public void setLongitud(double x) {
        if (x < -180 || x > 180) throw new IllegalArgumentException("Longitud inválida");
        longitud = x;
    }

    public NivelAlerta getNivelAlerta() { return nivelAlerta; }
    public void setNivelAlerta(NivelAlerta n) { nivelAlerta = n; }

    @Override
    public String toString() {
        return nombre + " (" + provincia + ") - alerta " + nivelAlerta;
    }
}
