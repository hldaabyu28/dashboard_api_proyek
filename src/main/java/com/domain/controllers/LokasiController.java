package com.domain.controllers;

import com.domain.models.entities.Lokasi;
import com.domain.services.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Integer id) {
        Optional<Lokasi> lokasiOpt = lokasiService.findById(id);
        if (lokasiOpt.isPresent()) {
            return new ResponseEntity<>(lokasiOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.save(lokasi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasiDetails) {
        Optional<Lokasi> lokasiOpt = lokasiService.findById(id);
        if (lokasiOpt.isPresent()) {
            Lokasi lokasi = lokasiOpt.get();
            lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
            lokasi.setNegara(lokasiDetails.getNegara());
            lokasi.setProvinsi(lokasiDetails.getProvinsi());
            lokasi.setKota(lokasiDetails.getKota());
            final Lokasi updatedLokasi = lokasiService.save(lokasi);
            return ResponseEntity.ok(updatedLokasi);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Integer id) {
        lokasiService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
