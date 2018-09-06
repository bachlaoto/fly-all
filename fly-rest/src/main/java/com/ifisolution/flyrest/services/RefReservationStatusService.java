package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.RefReservationStatus;

import java.util.List;

public interface RefReservationStatusService {
    RefReservationStatus findRefReservationStatusByID(Long id);

    List<RefReservationStatus> findAllRefReservationStatus();

    RefReservationStatus save(RefReservationStatus refReservationStatus);

    void deleteRefReservationStatus(Long id);

}
