package com.example.szeleromu.szeleromu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final HelyszinRepository helyszinRepository;
    private final MegyeRepository megyeRepository;
    private final ToronyRepository toronyRepository;

    @Autowired
    public DataService(HelyszinRepository helyszinRepository, MegyeRepository megyeRepository, ToronyRepository toronyRepository) {
        this.helyszinRepository = helyszinRepository;
        this.megyeRepository = megyeRepository;
        this.toronyRepository = toronyRepository;
    }

    public List<Helyszin> getAllHelyszin() {
        return helyszinRepository.findAll();
    }

    public List<Megye> getAllMegye() {
        return megyeRepository.findAll();
    }

    public List<Torony> getAllTorony() {
        return toronyRepository.findAll();
    }
}
