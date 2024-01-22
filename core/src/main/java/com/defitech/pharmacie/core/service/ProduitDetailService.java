package com.defitech.pharmacie.core.service;

import com.defitech.pharmacie.core.entity.ProduitDetail;
import com.defitech.pharmacie.core.repository.ProduitDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitDetailService {

    @Autowired
    ProduitDetailRepository produitDetailRepository;

    public void ajouter(ProduitDetail pd){
        produitDetailRepository.save(pd);
    }

}
