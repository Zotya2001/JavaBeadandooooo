package com.example.szeleromu.szeleromu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MegyeRepository extends JpaRepository<Megye, Long> {
    // Egyedi lekérdezések ide kerülhetnek, ha szükséges
}
