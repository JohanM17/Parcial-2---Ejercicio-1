package repository;

import model.RutaBus;
import java.util.List;

public interface RutaBusRepository {
    void create(RutaBus rutaBus);
    RutaBus read(int id);
    List<RutaBus> readAll();
    void update(RutaBus rutaBus);
    void delete(int id);
}
