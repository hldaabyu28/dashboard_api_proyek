package com.domain.services;

import com.domain.models.entities.ProyekLokasi;
import com.domain.models.entities.ProyekLokasiId;
import com.domain.models.repos.ProyekLokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    public List<ProyekLokasi> findAll() {
        return proyekLokasiRepository.findAll();
    }

    public Optional<ProyekLokasi> findById(ProyekLokasiId id) {
        return proyekLokasiRepository.findById(id);
    }

    public ProyekLokasi save(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    public void deleteById(ProyekLokasiId id) {
        proyekLokasiRepository.deleteById(id);
    }
}
