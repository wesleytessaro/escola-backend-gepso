package com.project.escola.repository;

import com.project.escola.model.AtuadorStock;
import com.project.escola.model.SensorStock;
import com.project.escola.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

   // Optional<Stock> findByNameAndDate(String name, LocalDate date);
//    @Query(value = "select stock from SensorStock stock" +
//            "           order by date desc")
    @Query(value = "select stock from SensorStock stock")
    Optional<List<SensorStock>> findAllRecordSensor();

    @Query(value = "SELECT stock FROM SensorStock stock WHERE stock.id = (select max(stock.id) from SensorStock stock)  ")
    Optional<SensorStock> lastSensor();
// @Query(value = "SELECT stock FROM AtuadorStock stock WHERE stock.id = (select max(stock.id) from AtuadorStock stock)  ")
//@Query(value = "SELECT stock FROM AtuadorStock stock ORDER BY datetime desc LIMIT <=1")
@Query(value = "SELECT stock FROM AtuadorStock stock WHERE stock.id = (select max(stock.id) from AtuadorStock stock)  ")
    Optional<AtuadorStock> lastAtuador();

    @Query(value = "select stock from AtuadorStock stock")
    Optional<List<AtuadorStock>> findAllRecordAtuador();

    @Query(value = "select stock from AtuadorStock stock where stock.id = (select max(stock.id) from AtuadorStock stock)")
    Optional<Stock> findLastRecordAtuadorOne(String name, LocalDate date);


    @Query("SELECT stock "+
            "FROM Stock stock "+
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id ")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query(" SELECT stock " +
            " FROM Stock stock " +
            " WHERE stock.date = CURRENT_DATE ")
    Optional<List<Stock>> findByToday(LocalDate date);






}
