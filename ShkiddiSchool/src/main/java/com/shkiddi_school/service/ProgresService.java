package com.shkiddi_school.service;

import com.shkiddi_school.domain.Progres;
import com.shkiddi_school.repos.ProgresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgresService {

    @Autowired
    ProgresRepo progresRepo;

    public void saveProgres(Progres progres) {
        progresRepo.save(progres);
    }



}
