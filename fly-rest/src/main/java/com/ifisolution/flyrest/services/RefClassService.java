package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefClass;

import java.util.List;

public interface RefClassService {
    RefClass findRefClassByID(Long id);

    List<RefClass> findAllRefClass();

    RefClass save(RefClass refClass);

    void deleteRefClass(Long id);

}
