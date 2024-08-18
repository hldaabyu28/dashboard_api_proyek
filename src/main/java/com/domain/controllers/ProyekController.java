package com.domain.controllers;

import com.domain.models.entities.Proyek;
import com.domain.models.entities.Lokasi;
import com.domain.services.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Integer id) {
        Optional<Proyek> proyekOpt = proyekService.findById(id);
        if (proyekOpt.isPresent()) {
            return new ResponseEntity<>(proyekOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return proyekService.save(proyek);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@RequestBody  @PathVariable Integer id, @RequestBody Proyek proyekDetails) {
        Optional<Proyek> proyekOpt = proyekService.findById(id);
        if (proyekOpt.isPresent()) {
            Proyek proyek = proyekOpt.get();
            proyek.setNamaProyek(proyekDetails.getNamaProyek());
            proyek.setClient(proyekDetails.getClient());
            proyek.setTglMulai(proyekDetails.getTglMulai());
            proyek.setTglSelesai(proyekDetails.getTglSelesai());
            proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
            proyek.setKeterangan(proyekDetails.getKeterangan());
            final Proyek updatedProyek = proyekService.save(proyek);
            return ResponseEntity.ok(updatedProyek);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Integer id) {
        proyekService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{proyekId}/lokasi")
    public ResponseEntity<Proyek> addLokasiToProyek(@PathVariable @RequestBody Integer proyekId, @RequestBody Lokasi lokasi) {
        Proyek proyek = proyekService.addLokasiToProyek(proyekId, lokasi);
        if (proyek != null) {
            return new ResponseEntity<>(proyek, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
