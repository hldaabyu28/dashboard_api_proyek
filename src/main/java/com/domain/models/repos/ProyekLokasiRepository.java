package com.domain.models.repos;

import com.domain.models.entities.ProyekLokasi;
import com.domain.models.entities.ProyekLokasiId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasiId> {
}
