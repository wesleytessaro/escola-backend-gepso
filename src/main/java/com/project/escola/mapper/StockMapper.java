package com.project.escola.mapper;

import com.project.escola.model.AtuadorStock;
import com.project.escola.model.SensorStock;
import com.project.escola.model.Stock;
import com.project.escola.model.dto.AtuadorStockDTO;
import com.project.escola.model.dto.SensorStockDTO;
import com.project.escola.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock toEntity(StockDTO dto) {///original
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDate(dto.getDate());
        return stock;
    }

    public SensorStock toEntitySensor(SensorStockDTO dto) {
        SensorStock stock = new SensorStock();
        stock.setId(dto.getId());
        stock.setPressao_atm(dto.getPressao_atm());
        stock.setUmidade_atm(dto.getUmidade_atm());
        stock.setUmidade_solo(dto.getUmidade_solo());
        stock.setTemperatura_atm(dto.getTemperatura_atm());
        stock.setTemperatura_solo(dto.getTemperatura_solo());
        stock.setCondutividade(dto.getCondutividade());
        stock.setLuminosidade(dto.getLuminosidade());
        stock.setDatetime(LocalDateTime.now());

        return stock;
    }

    public AtuadorStock toEntityAtuador(AtuadorStockDTO dto) {
        AtuadorStock stock = new AtuadorStock();
        stock.setId(dto.getId());
        stock.setDatetime(LocalDateTime.now());
        stock.setEstado_bomba(dto.getEstado_bomba());
        stock.setLamina(dto.getLamina());
        return stock;
    }

    public StockDTO toDto(Stock stock) {//original
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDate(stock.getDate());
        return dto;
    }

    public SensorStockDTO toDtoSensor(SensorStock stock) {
        SensorStockDTO dto = new SensorStockDTO();
        dto.setId(stock.getId());
        dto.setDatetime(stock.getDatetime());
        dto.setPressao_atm(stock.getPressao_atm());
        dto.setTemperatura_atm(stock.getTemperatura_atm());
        dto.setTemperatura_solo(stock.getTemperatura_solo());
        dto.setCondutividade(stock.getCondutividade());
        dto.setLuminosidade(stock.getLuminosidade());
        dto.setUmidade_solo(stock.getUmidade_solo());
        dto.setUmidade_atm(stock.getUmidade_atm());
        return dto;
    }

    public AtuadorStockDTO toDtoAtuador(AtuadorStock stock) {
        AtuadorStockDTO dto = new AtuadorStockDTO();
        dto.setId(stock.getId());
        dto.setDatetime(stock.getDatetime());
        dto.setEstado_bomba(stock.getEstado_bomba());
        dto.setLamina(stock.getLamina());
        return dto;

    }


    public List<StockDTO> toDto(List<Stock> listStock) {
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<SensorStockDTO> toDtoSensor(List<SensorStock> listStock) {
        return listStock.stream().map(this::toDtoSensor).collect(Collectors.toList());
    }

    public List<AtuadorStockDTO> toDtoAtuadorList(List<AtuadorStock> listStock) {
        return listStock.stream().map(this::toDtoAtuador).collect(Collectors.toList());
    }




}
