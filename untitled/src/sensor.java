public abstract class Sensor {
    private String codigo;
    private String unidad;
    private double umbral;
    private EstadoSensor estado;
    private final double[] lecturas = new double[24];
    private int cantidad = 0;

    public Sensor(String codigo, String unidad, double umbral, String prefijo) {
        String cod = codigo.trim().toUpperCase();

        if (!cod.matches(prefijo + "-\\d{3}"))
            throw new IllegalArgumentException("Código inválido");
        if (umbral <= 0)
            throw new IllegalArgumentException("El umbral debe ser mayor que cero");

        this.codigo = cod;
        this.unidad = unidad;
        this.umbral = umbral;
        this.estado = EstadoSensor.ACTIVO;
    }

    public String getCodigo() { return codigo; }
    public String getUnidad() { return unidad; }
    public double getUmbral() { return umbral; }
    public EstadoSensor getEstado() { return estado; }

    public void setUmbral(double umbral) {
        if (umbral <= 0) throw new IllegalArgumentException("Umbral inválido");
        this.umbral = umbral;
    }

    public void setEstado(EstadoSensor estado) {
        this.estado = estado;
    }

    public void registrarLectura(double valor) {
        if (valor < 0) {
            System.out.println("No se aceptan lecturas negativas.");
        } else if (cantidad == 24) {
            System.out.println("El arreglo de lecturas está lleno.");
        } else {
            lecturas[cantidad++] = valor;
        }
    }

    public void registrarLectura(double[] lote) {
        for (double valor : lote) registrarLectura(valor);
    }

    public double calcularPromedio() {
        if (cantidad == 0) return 0;
        double suma = 0;
        for (int i = 0; i < cantidad; i++) suma += lecturas[i];
        return suma / cantidad;
    }

    public double obtenerMaximo() {
        double maximo = 0;
        for (int i = 0; i < cantidad; i++)
            if (lecturas[i] > maximo) maximo = lecturas[i];
        return maximo;
    }

    public int contarSobreUmbral() {
        int total = 0;
        for (int i = 0; i < cantidad; i++)
            if (lecturas[i] > umbral) total++;
        return total;
    }

    public boolean estaEnAlerta() {
        return estado == EstadoSensor.ACTIVO && cantidad > 0
                && (calcularPromedio() > umbral || obtenerMaximo() > 1.5 * umbral);
    }

    public abstract String getTipo();
}