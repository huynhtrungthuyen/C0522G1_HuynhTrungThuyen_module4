package music_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import music_management.model.Music;
import music_management.repository.IMusicRepository;
import music_management.service.IMusicService;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music product) {
        iMusicRepository.save(product);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void update(Music product) {
        iMusicRepository.update(product);
    }

    @Override
    public void remove(int id) {
        iMusicRepository.remove(id);
    }
}
