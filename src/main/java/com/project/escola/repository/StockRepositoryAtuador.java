package com.project.escola.repository;

import com.project.escola.model.AtuadorStock;
import com.project.escola.model.SensorStock;
import com.project.escola.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface StockRepositoryAtuador extends JpaRepository<AtuadorStock,Long> {

//    @Query(value = "select stock from SensorStock stock" +
//            "           order by date desc")
    @Query(value = "select stock from SensorStock stock")
    Optional<SensorStock> findAllRecordSensor(LocalDate date);

    @Query(value = "SELECT stock FROM SensorStock stock WHERE stock.id = (select max(stock.id) from SensorStock stock)  ")
    Optional<SensorStock> findLastRecordSensorOne();

    @Query(value = "select stock from SensorStock stock")
    Optional<SensorStock> findAllRecordAtuador(LocalDate date);

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


    @Query ("SELECT stock from AtuadorStock stock where datetime between  :fromDate AND :toDate")
    Optional<List<AtuadorStock>> findAllReportsActuatorByDate(LocalDateTime fromDate, LocalDateTime toDate);


}
