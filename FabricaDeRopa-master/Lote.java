package FabricaDeRopa;
import java.io.Serializable;
public class Lote implements Serializable {
private int numeroLote;
private int numeroPiezas;
private String fechaFabricacion;
private Prenda prenda;
public Lote(int numeroLote, int numeroPiezas,
String fechaFabricacion, Prenda prenda) {
this.numeroLote = numeroLote;
this.fechaFabricacion = fechaFabricacion;
this.prenda = prenda;
setNumeroPiezas(numeroPiezas);
}
public int getNumeroLote() {
return numeroLote;
}
public int getNumeroPiezas() {
return numeroPiezas;
}
public String getFechaFabricacion() {
return fechaFabricacion;
}
public Prenda getPrenda() {
return prenda;
}
public void setNumeroPiezas(int numeroPiezas) {
if (numeroPiezas < 50 || numeroPiezas > 350) {
throw new IllegalArgumentException(
"Las piezas deben estar entre 50 y 350.");
}
this.numeroPiezas = numeroPiezas;
}
public double calcularCostoProduccionLote() {
return prenda.getCostoProduccion() * numeroPiezas;
}
public double calcularMontoRecuperacion() {
double precioVentaPieza = prenda.calcularPrecioVentaPieza();
double precioFinal = precioVentaPieza * 1.05;
return precioFinal * numeroPiezas;
}
@Override
public String toString() {
return "\nNúmero de lote: " + numeroLote +
"\nNúmero de piezas: " + numeroPiezas +
"\nFecha fabricación: " + fechaFabricacion +
"\nCosto producción lote: $" + calcularCostoProduccionLote() +
"\nMonto recuperación: $" + calcularMontoRecuperacion() +
"\n" + prenda.toString();
}
}