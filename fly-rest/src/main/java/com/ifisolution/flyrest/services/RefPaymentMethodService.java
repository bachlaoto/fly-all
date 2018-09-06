package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefPaymentMethod;

import java.util.List;

public interface RefPaymentMethodService {
    RefPaymentMethod findRefPaymentMethodByID(Long id);

    List<RefPaymentMethod> findAllRefPaymentMethod();

    RefPaymentMethod save(RefPaymentMethod refPaymentMethod);

    void deleteRefPaymentMethod(Long id);

}
