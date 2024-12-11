import java.io.*;
import java.util.List;

public class Filhanterare {

    public void skrivTillFil(List<Object> objektLista, String filnamn) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            for (Object objekt : objektLista) {
                oos.writeObject(objekt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void läsFrånFil(List<Object> objektLista, String filnamn) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Bokning) {
                    Bokning b = (Bokning) obj;
                    objektLista.add(b);
                } else if (obj instanceof Recension) {
                    Recension r = (Recension) obj;
                    objektLista.add(r);
                }
            }
        } catch (EOFException e) {
            System.out.println("Bokningarna har lästs in");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
