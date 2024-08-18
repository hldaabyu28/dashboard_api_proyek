package com.domain.models.repos;

import com.domain.models.entities.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
    
}
