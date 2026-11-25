public class UbicacionGeografica {
    private double latitud;
    private double longitud;
    private double altitud;

    public UbicacionGeografica() {
        this(0.0, 0.0, 0.0);
    }

    public UbicacionGeografica(double latitud, double longitud, double altitud) {
        setLatitud(latitud);
        setLongitud(longitud);
        setAltitud(altitud);
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        if (latitud < -90 || latitud > 90) {
            throw new IllegalArgumentException("La latitud debe estar entre -90 y 90.");
        }
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        if (longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException("La longitud debe estar entre -180 y 180.");
        }
        this.longitud = longitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        if (altitud < 0) {
            throw new IllegalArgumentException("La altitud no puede ser negativa.");
        }
        this.altitud = altitud;
    }

    @Override
    public String toString() {
        return String.format(
                "(latitud=%.4f, longitud=%.4f, altitud=%.0f m)",
                latitud, longitud, altitud
        );
    }
}