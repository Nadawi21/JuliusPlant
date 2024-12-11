import java.io.*;
import java.util.List;

public class Filhanterare {

    public void sparaBokningar(List<Object> objektLista, String filnamn) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            for (Object objekt : objektLista) {
                oos.writeObject(objekt);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void läsInBokningar(List<Object> objektLista, String filnamn) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                Bokning bokning = (Bokning) obj;
                objektLista.add(bokning);
            }
        } catch (EOFException e) {
            System.out.println("Bokningarna har lästs in");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
