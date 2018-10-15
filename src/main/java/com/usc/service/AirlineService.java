package com.usc.service;

import com.usc.Response.ListResponse;
import com.usc.Response.SingleResponse;
import com.usc.dao.objects.AirlinesNode;
import com.usc.dao.objects.SeatsNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public interface AirlineService {
    SingleResponse insertSeatNode(SeatsNode seatsNode);

    SingleResponse selectNodeByFlightNum(String airlineNum);

    SingleResponse getOccupiedSeatString(String airlineNum);

    ListResponse getAirlineforGuests();

    SingleResponse updateAirline(AirlinesNode airlinesNode);

    SingleResponse deleteAirline(AirlinesNode airlinesNode);

    SingleResponse insertAirline(AirlinesNode airlinesNode);

    List<AirlinesNode> selectAllNodes();

    List<AirlinesNode> saveAirlines(List<AirlinesNode> airlinesNodes);

    Integer deleteById(Long id);

    Page<AirlinesNode> findByAirlineNum(String airlineNum, Pageable pageable);
}
