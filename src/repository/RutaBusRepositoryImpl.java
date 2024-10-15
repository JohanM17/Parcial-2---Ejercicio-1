package repository;

import model.RutaBus;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RutaBusRepositoryImpl implements RutaBusRepository {
    private final String filePath = "rutasBus.dat";  // Archivo para la persistencia

    @Override
    public void create(RutaBus rutaBus) {
        List<RutaBus> rutas = readAll();
        rutas.add(rutaBus);
        writeToFile(rutas);
    }

    @Override
    public RutaBus read(int id) {
        List<RutaBus> rutas = readAll();
        for (RutaBus ruta : rutas) {
            if (ruta.getId() == id) {
                return ruta;
            }
        }
        return null;
    }

    @Override
    public List<RutaBus> readAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<RutaBus>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void update(RutaBus rutaBus) {
        List<RutaBus> rutas = readAll();
        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).getId() == rutaBus.getId()) {
                rutas.set(i, rutaBus);
                break;
            }
        }
        writeToFile(rutas);
    }

    @Override
    public void delete(int id) {
        List<RutaBus> rutas = readAll();
        rutas.removeIf(ruta -> ruta.getId() == id);
        writeToFile(rutas);
    }

    private void writeToFile(List<RutaBus> rutas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(rutas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
