package com.example.szeleromu.Uzenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UzenetOsztalyService {
    @Autowired
    private UzenetOsztalyRepository uzenetRepo;

    public List<UzenetOsztaly> findAllGuestMessages() {
        return uzenetRepo.findAllByOrderByTimestampDesc();
    }

    public void saveGuestMessage(UzenetOsztaly uzenet, String senderName) {
        uzenet.setTimestamp(LocalDateTime.now());
        uzenet.setGuest(true);
        uzenet.setSenderName(senderName); // Ez a sor új, feltételezve, hogy a UzenetOsztaly tartalmaz egy senderName tagváltozót.
        uzenetRepo.save(uzenet);
    }

    public UzenetOsztaly findMessageById(Long id) {
        return uzenetRepo.findById(id).orElse(null);
    }

    public UzenetOsztaly updateMessage(Long id, UzenetOsztaly uzenetOsztaly) {
        return uzenetRepo.findById(id)
                .map(existingMessage -> {
                    // Itt az existingMessage adatait frissíteni kell az uzenetOsztaly adataival.
                    // Például:
                    // existingMessage.setContent(uzenetOsztaly.getContent());
                    // További frissítések...
                    uzenetRepo.save(existingMessage);
                    return existingMessage;
                }).orElse(null);
    }

    public boolean deleteMessage(Long id) {
        return uzenetRepo.findById(id)
                .map(message -> {
                    uzenetRepo.delete(message);
                    return true;
                }).orElse(false);
    }
}
