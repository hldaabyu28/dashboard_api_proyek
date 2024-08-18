package com.domain.services;

import com.domain.models.entities.Lokasi;
import com.domain.models.repos.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> findById(Integer id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi save(@RequestBody Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public void deleteById(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
