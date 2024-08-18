package com.domain.controllers;

import com.domain.models.entities.ProyekLokasi;
import com.domain.models.entities.ProyekLokasiId;
import com.domain.services.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyek-lokasi")
public class ProyekLokasiController {

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @GetMapping
    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiService.findAll();
    }

    @GetMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<ProyekLokasi> getProyekLokasiById(@PathVariable Integer proyekId, @PathVariable Integer lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        Optional<ProyekLokasi> proyekLokasiOpt = proyekLokasiService.findById(id);
        if (proyekLokasiOpt.isPresent()) {
            return new ResponseEntity<>(proyekLokasiOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProyekLokasi> createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        ProyekLokasi savedProyekLokasi = proyekLokasiService.save(proyekLokasi);
        return new ResponseEntity<>(savedProyekLokasi, HttpStatus.CREATED);
    }

    @DeleteMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<Void> deleteProyekLokasi(@PathVariable Integer proyekId, @PathVariable Integer lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        proyekLokasiService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
