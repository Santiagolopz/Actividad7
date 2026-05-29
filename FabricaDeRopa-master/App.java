package FabricaDeRopa;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
ArrayList<Prenda> prendas = Archivo.cargarPrendas();
ArrayList<Lote> lotes = Archivo.cargarLotes();
int opcion;
do {
System.out.println("1. Registrar prenda");
System.out.println("2. Registrar lote");
System.out.println("3. Mostrar prendas");
System.out.println("4. Mostrar lotes");
System.out.println("5. Eliminar prenda");
System.out.println("6. Salir");
opcion = sc.nextInt();
sc.nextLine();
switch (opcion) {
case 1:
try {
System.out.print("Modelo: ");
String modelo = sc.nextLine();
System.out.print("Tela: ");
String tela = sc.nextLine();
System.out.print("Costo producción: ");
double costo = sc.nextDouble();
System.out.print("Límite costo: ");
double limite = sc.nextDouble();
sc.nextLine();
System.out.print("Género: ");
String genero = sc.nextLine();
System.out.print("Temporada: ");
String temporada = sc.nextLine();
Prenda prenda = new Prenda(
modelo,
tela,
costo,
genero,
temporada,
limite
);
prendas.add(prenda);
Archivo.guardarPrendas(prendas);
System.out.println("Prenda registrada.");
} catch (Exception e) {
System.out.println(e.getMessage());
}
break;
case 2:
try {
if (prendas.isEmpty()) {
System.out.println(
"Primero registre una prenda.");
break;
}
System.out.println("Seleccione prenda:");
for (int i = 0; i < prendas.size(); i++) {
System.out.println(
(i + 1) + ". " +
prendas.get(i).getModelo());
}
int indice = sc.nextInt() - 1;
System.out.print("Número lote: ");
int numLote = sc.nextInt();
System.out.print("Número piezas: ");
int piezas = sc.nextInt();
sc.nextLine();
System.out.print("Fecha fabricación: ");
String fecha = sc.nextLine();
Lote lote = new Lote(
numLote,
piezas,
fecha,
prendas.get(indice)
);
lotes.add(lote);
Archivo.guardarLotes(lotes);
System.out.println("Lote registrado.");
} catch (Exception e) {
System.out.println(e.getMessage());
}
break;
case 3:
for (Prenda p : prendas) {
System.out.println(p);
}
break;
case 4:
for (Lote l : lotes) {
System.out.println(l);
}
break;
case 5:
System.out.println("Seleccione prenda a eliminar:");
for (int i = 0; i < prendas.size(); i++) {
System.out.println(
(i + 1) + ". " +
prendas.get(i).getModelo());
}
int eliminar = sc.nextInt() - 1;
Prenda prendaEliminar = prendas.get(eliminar);
prendas.remove(prendaEliminar);
}prendas.remove(prendaEliminar);
lotes.removeIf(
lote -> lote.getPrenda() == prendaEliminar)
Archivo.guardarPrendas(prendas);
Archivo.guardarLotes(lotes);
System.out.println(
"Prenda y lotes eliminados.");
break;
case 6:
System.out.println("Saliendo...");
break;
default:
System.out.println("Opción inválida.");
}
} while (opcion != 6);
sc.close();
}