package com.domain.services;

import com.domain.models.entities.Proyek;
import com.domain.models.entities.Lokasi;
import com.domain.models.repos.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public List<Proyek> findAll() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> findById(Integer id) {
        return proyekRepository.findById(id);
    }

    public Proyek save(@RequestBody Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public void deleteById(Integer id) {
        proyekRepository.deleteById(id);
    }

    public Proyek addLokasiToProyek(Integer proyekId, Lokasi lokasi) {
        Optional<Proyek> proyekOpt = proyekRepository.findById(proyekId);
        if (proyekOpt.isPresent()) {
            Proyek proyek = proyekOpt.get();
            proyek.getLokasis().add(lokasi);
            return proyekRepository.save(proyek);
        }
        return null;
    }
}
