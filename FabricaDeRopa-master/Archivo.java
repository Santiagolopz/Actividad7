package FabricaDeRopa;
import java.io.*;
import java.util.ArrayList;
public class Archivo {
public static void guardarPrendas(ArrayList<Prenda> prendas) {
try (ObjectOutputStream oos =
new ObjectOutputStream(
new FileOutputStream("prendas.dat"))) {
oos.writeObject(prendas);
} catch (IOException e) {
System.out.println("Error al guardar prendas.");
}
}
public static void guardarLotes(ArrayList<Lote> lotes) {
try (ObjectOutputStream oos =
new ObjectOutputStream(
new FileOutputStream("lotes.dat"))) {
oos.writeObject(lotes);
} catch (IOException e) {
System.out.println("Error al guardar lotes.");
}
}
public static ArrayList<Prenda> cargarPrendas() {
try (ObjectInputStream ois =
new ObjectInputStream(
new FileInputStream("prendas.dat"))) {
return (ArrayList<Prenda>) ois.readObject();
} catch (Exception e) {
return new ArrayList<>();
}
}
public static ArrayList<Lote> cargarLotes() {
try (ObjectInputStream ois =
new ObjectInputStream(
new FileInputStream("lotes.dat"))) {
return (ArrayList<Lote>) ois.readObject();
} catch (Exception e) {
return new ArrayList<>();
}
}
}