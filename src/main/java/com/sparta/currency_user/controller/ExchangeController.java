package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.UserTotalExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exchanges")
public class ExchangeController {
    private final ExchangeService exchangeService;


    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    //Create
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(@Valid @RequestBody ExchangeRequestDto exchangeRequestDto) {


        return ResponseEntity.ok().body(exchangeService.save(exchangeRequestDto));

    }

    //Read
    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> getExchangeByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok().body(exchangeService.getExchangeById(userId));
    }

    //Update
    @PatchMapping("/{id}")
    public ResponseEntity<ExchangeResponseDto> updateExchange(@PathVariable Long id,
                                                              @RequestBody ExchangeRequestDto exchangeRequestDto) {

        ExchangeResponseDto responseDto = exchangeService.update(exchangeRequestDto, id);

        return ResponseEntity.ok().body(responseDto);

    }

    //userRequestCount
    @GetMapping("/count")
    public ResponseEntity<UserTotalExchangeResponseDto> countExchangeByUserId(@RequestParam Long userId) {

        UserTotalExchangeResponseDto totalExchangeResponseDto = exchangeService.totalCount(userId);

        return ResponseEntity.ok().body(totalExchangeResponseDto);
    }

}
