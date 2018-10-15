package com.usc.dao;

import com.usc.dao.objects.SeatsNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public interface SeatsMapper extends JpaRepository<SeatsNode, Long> {

    @Query(value = "SELECT COUNT(id) FROM seats_node WHERE airline_num=?1 AND seat_type=?2")
    Integer countByType(String flightNum, Integer seatType);

    @Query(value = "SELECT seat_num FROM seats_node WHERE airline_num = ?1 AND seat_type= ?2", nativeQuery = true)
    List<String> selectSeatInfo(String airlineNum, Integer seatType);

    @Query(value = "SELECT COUNT(id) FROM seats_node WHERE airline_num=?1 AND seat_num=?2")
    Integer countBySeatNum(String airlineNum, String seatNum);
}
