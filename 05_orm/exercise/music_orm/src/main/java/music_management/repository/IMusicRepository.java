package music_management.repository;

import music_management.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music product);

    Music findById(int id);

    void update(Music product);

    void remove(int id);
}
