package service;

import model.RutaBus;
import java.util.List;

public interface RutaBusService {
    void agregarRuta(RutaBus rutaBus);
    RutaBus obtenerRuta(int id);
    List<RutaBus> obtenerTodasLasRutas();
    void actualizarRuta(RutaBus rutaBus);
    void eliminarRuta(int id);
}
