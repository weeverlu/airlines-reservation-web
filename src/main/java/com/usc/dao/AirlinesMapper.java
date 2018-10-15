package com.usc.dao;

import com.usc.dao.objects.AirlinesNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public interface AirlinesMapper extends JpaRepository<AirlinesNode, Long> {

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "UPDATE airlines_node SET airline_num=?2, plane_model=?3, num_firstclass=?4, num_economy=?5, price_firstclass=?6," +
            "price_economy=?7,departure_port=?8,departure_time=?9,arrival_port=?10,arrival_time=?11 WHERE id=?1", nativeQuery = true)
    Integer customerUpdate(Long id, String airlineNum, String model, Integer numFirst, Integer numEco, Integer priceFirst,
                                  Integer priceEco, String depPort, String depTime, String arrPort, String arrTime);

    @Query(value = "SELECT * FROM airlines_node WHERE airline_num=?1", nativeQuery = true)
    AirlinesNode selectByAirlineNum(String airlineNum);
}
