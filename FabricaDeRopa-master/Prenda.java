package FabricaDeRopa;
import java.io.Serializable;
public class Prenda implements Serializable {
private String modelo;
private String tela;
private double costoProduccion;
private String genero;
private String temporada;
private double limiteCosto;
public Prenda(String modelo, String tela, double costoProduccion,
String genero, String temporada, double limiteCosto) {
this.modelo = modelo;
this.tela = tela;
this.limiteCosto = limiteCosto;
setGenero(genero);
setTemporada(temporada);
setCostoProduccion(costoProduccion);
}
public String getModelo() {
return modelo;
}
public String getTela() {
return tela;
}
public double getCostoProduccion() {
return costoProduccion;
}
public String getGenero() {
return genero;
}
public String getTemporada() {
return temporada;
}
public void setCostoProduccion(double costoProduccion) {
if (costoProduccion > limiteCosto) {
throw new IllegalArgumentException(
"El costo excede el límite permitido.");
}
if (costoProduccion <= 0) {
throw new IllegalArgumentException(
"El costo debe ser mayor a cero.");
}
this.costoProduccion = costoProduccion;
}
public void setGenero(String genero) {
if (!genero.equalsIgnoreCase("Masculino") &&
!genero.equalsIgnoreCase("Femenino") &&
!genero.equalsIgnoreCase("Mixto")) {
throw new IllegalArgumentException("Género inválido.");
}
this.genero = genero;
}
public void setTemporada(String temporada) {
if (!temporada.equalsIgnoreCase("Primavera") &&
!temporada.equalsIgnoreCase("Verano") &&
!temporada.equalsIgnoreCase("Otoño") &&
!temporada.equalsIgnoreCase("Invierno")) {
throw new IllegalArgumentException("Temporada inválida.");
}
this.temporada = temporada;
}
public double calcularPrecioVentaPieza() {
return costoProduccion * 1.15;
}
@Override
public String toString() {
return "\nModelo: " + modelo +
"\nTela: " + tela +
"\nCosto Producción: $" + costoProduccion +
"\nGénero: " + genero +
"\nTemporada: " + temporada +
"\nPrecio Venta Pieza: $" + calcularPrecioVentaPieza();
}
}