package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ExchangeResponseDto {


    private Long id;

    //환전 전 비용(원)
    private BigDecimal amountInKrw;

    private BigDecimal exchangeRate;

    //환전 후 비용(달러)
    private String amountAfterExchange;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private String symbol;

    private String formattedAmountAfterExchange;


    public ExchangeResponseDto(Exchange exchange) {
        this.id = exchange.getId();
        this.amountInKrw = exchange.getAmountInKrw();
        this.exchangeRate = exchange.getExchangeRate();
        this.amountAfterExchange = exchange.getAmountAfterExchange().toPlainString();
        this.createdAt = exchange.getCreatedAt();
        this.modifiedAt = exchange.getModifiedAt();
        this.status = exchange.getStatus();
        this.symbol = exchange.getToCurrencyId().getSymbol();
        this.formattedAmountAfterExchange = formatAmountAfterExchange();
    }

    private String formatAmountAfterExchange() {
        return String.format("%s %s", amountAfterExchange, symbol);
    }


}
