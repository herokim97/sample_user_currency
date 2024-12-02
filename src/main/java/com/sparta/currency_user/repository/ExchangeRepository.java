package com.sparta.currency_user.repository;


import com.sparta.currency_user.dto.UserTotalExchangeResponseDto;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    @Query("select new com.sparta.currency_user.dto.UserTotalExchangeResponseDto(er.userId.id, count(er.id), sum(er.amountInKrw))" +
            "from Exchange er " +
            "where er.userId.id = :userId ")
    UserTotalExchangeResponseDto findTotalAmountInKrw(@Param("userId") Long userId);

    List<Exchange> findAllByUserId(User user);


}
