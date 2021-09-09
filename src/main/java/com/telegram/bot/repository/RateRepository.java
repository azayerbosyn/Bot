package com.telegram.bot.repository;

import com.telegram.bot.model.Rate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RateRepository extends CrudRepository<Rate, Long> {

  @Query(value = "select amount "
    + "   from rate "
    + "   where currency = :currency"
    + " offset 0 limit 1", nativeQuery = true)
  Double findAmountByCurrency(@Param("currency") String currency);

  @Query(value = "insert into rate (currency, amount) "
    + "           values (:currency, :amount) "
    + "           on conflict (currency) "
    + "           do update set currency = :currency ", nativeQuery = true)
  void saveRate(@Param("currency") String currency, @Param("amount") Double amount);

}
