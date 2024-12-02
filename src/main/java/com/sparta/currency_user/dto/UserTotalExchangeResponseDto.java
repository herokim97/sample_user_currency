package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserTotalExchangeResponseDto {

    Long userId;

    Long count;

    BigDecimal totalAmountInKrw;

    public UserTotalExchangeResponseDto(Long userId, Long count, BigDecimal totalAmountInKrw) {
        this.userId = userId;
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}
