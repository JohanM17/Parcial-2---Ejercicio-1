package service;

import model.RutaBus;
import repository.RutaBusRepository;
import java.util.List;

public class RutaBusServiceImpl implements RutaBusService {
    private RutaBusRepository rutaBusRepository;

    public RutaBusServiceImpl(RutaBusRepository rutaBusRepository) {
        this.rutaBusRepository = rutaBusRepository;
    }

    @Override
    public void agregarRuta(RutaBus rutaBus) {
        rutaBusRepository.create(rutaBus);
    }

    @Override
    public RutaBus obtenerRuta(int id) {
        return rutaBusRepository.read(id);
    }

    @Override
    public List<RutaBus> obtenerTodasLasRutas() {
        return rutaBusRepository.readAll();
    }

    @Override
    public void actualizarRuta(RutaBus rutaBus) {
        rutaBusRepository.update(rutaBus);
    }

    @Override
    public void eliminarRuta(int id) {
        rutaBusRepository.delete(id);
    }
}
