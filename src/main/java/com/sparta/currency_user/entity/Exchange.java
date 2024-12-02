package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
public class Exchange extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_currency_id")
    private Currency toCurrencyId;

    private BigDecimal amountInKrw;

    private BigDecimal amountAfterExchange;

    private BigDecimal exchangeRate;

    private int count;

    private BigDecimal totalAmountInKrw;

    private String status = "normal";


    public Exchange(User userId, Currency toCurrencyId, BigDecimal amountInKrw, BigDecimal amountAfterExchange, BigDecimal exchangeRate) {
        this.userId = userId;
        this.toCurrencyId = toCurrencyId;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.exchangeRate = exchangeRate;

    }

    public Exchange() {

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exchange(User userId, int count, BigDecimal totalAmountInKrw) {
        this.userId = userId;
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}
