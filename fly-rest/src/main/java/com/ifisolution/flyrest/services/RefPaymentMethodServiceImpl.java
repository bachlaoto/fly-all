package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefPaymentMethod;
import com.ifisolution.flyrest.repositories.RefPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefPaymentMethodServiceImpl implements RefPaymentMethodService {

    @Autowired
    private RefPaymentMethodRepository refPaymentMethodRepository;


    @Override
    public RefPaymentMethod findRefPaymentMethodByID(Long id) {
        Optional<RefPaymentMethod> recipeOptional = refPaymentMethodRepository.findById(id);

        return recipeOptional.get();
    }

    @Override
    public List<RefPaymentMethod> findAllRefPaymentMethod() {
        List<RefPaymentMethod> recipeOptional = refPaymentMethodRepository.findAll();

        return recipeOptional;
    }

    @Override
    public RefPaymentMethod save(RefPaymentMethod refPaymentMethod) {

        return refPaymentMethodRepository.save(refPaymentMethod);
    }

    @Override
    public void deleteRefPaymentMethod(Long id) {
        refPaymentMethodRepository.deleteById(id);
    }
}
