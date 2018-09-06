package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefClass;
import com.ifisolution.flyrest.repositories.RefClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefClassServiceImpl implements RefClassService {

    @Autowired
    private RefClassRepository refClassRepository;


    @Override
    public RefClass findRefClassByID(Long id) {
        Optional<RefClass> recipeOptional = refClassRepository.findById(id);

        return recipeOptional.get();
    }

    @Override
    public List<RefClass> findAllRefClass() {
        List<RefClass> recipeOptional = refClassRepository.findAll();

        return recipeOptional;
    }

    @Override
    public RefClass save(RefClass refClass) {

        return refClassRepository.save(refClass);
    }

    @Override
    public void deleteRefClass(Long id) {
        refClassRepository.deleteById(id);
    }
}
