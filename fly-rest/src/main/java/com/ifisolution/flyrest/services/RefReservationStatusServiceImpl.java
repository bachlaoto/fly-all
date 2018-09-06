package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefReservationStatus;
import com.ifisolution.flyrest.repositories.RefReservationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefReservationStatusServiceImpl implements RefReservationStatusService {

    @Autowired
    private RefReservationStatusRepository refReservationStatusRepository;


    @Override
    public RefReservationStatus findRefReservationStatusByID(Long id) {
        Optional<RefReservationStatus> recipeOptional = refReservationStatusRepository.findById(id);

        return recipeOptional.get();
    }

    @Override
    public List<RefReservationStatus> findAllRefReservationStatus() {
        List<RefReservationStatus> recipeOptional = refReservationStatusRepository.findAll();

        return recipeOptional;
    }

    @Override
    public RefReservationStatus save(RefReservationStatus refReservationStatus) {

        return refReservationStatusRepository.save(refReservationStatus);
    }

    @Override
    public void deleteRefReservationStatus(Long id) {
        refReservationStatusRepository.deleteById(id);
    }
}
