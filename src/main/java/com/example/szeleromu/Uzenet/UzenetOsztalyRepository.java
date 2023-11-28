package com.example.szeleromu.Uzenet;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UzenetOsztalyRepository extends JpaRepository<UzenetOsztaly, Long> {
    List<UzenetOsztaly> findAllByOrderByTimestampDesc();
}
