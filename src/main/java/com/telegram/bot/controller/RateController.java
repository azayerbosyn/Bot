package com.telegram.bot.controller;

import com.telegram.bot.in_service.ApiService;
import com.telegram.bot.model.Rate;
import com.telegram.bot.repository.RateRepository;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rate")
public class RateController {

  @Autowired
  RateRepository repository;

  @Autowired
  ApiService apiService;

  @GetMapping("/get-list")
  public Double bulkcreate(@RequestParam(value = "currency") String currency) throws IOException {

    Double amount = apiService.getRateByCode(currency);

    Rate rate = new Rate(currency, amount, new Date());

    repository.save(rate);

    return repository.findAmountByCurrency(currency);
  }

}
