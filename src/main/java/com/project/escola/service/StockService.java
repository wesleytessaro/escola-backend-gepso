package com.project.escola.service;

import com.project.escola.exceptions.BusinessException;
import com.project.escola.exceptions.NotFoundException;
import com.project.escola.mapper.StockMapper;
import com.project.escola.model.AtuadorStock;
import com.project.escola.model.SensorStock;
import com.project.escola.model.Stock;
import com.project.escola.model.dto.*;
import com.project.escola.repository.StockRepository;
import com.project.escola.repository.StockRepositoryAtuador;
import com.project.escola.repository.StockRepositorySensor;
import com.project.escola.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockRepositorySensor repositorySensor;

    @Autowired
    private StockRepositoryAtuador repositoryAtuador;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {//Original
        //Para definir uma leitura por dia/nome
        /*Optional<Stock> optionalStock=repository.findByNameAndDate(dto.getName(),dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }*/
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public SensorStockDTO saveSensor(SensorStockDTO dto) {
        SensorStock stock = mapper.toEntitySensor(dto);
        repositorySensor.save(stock);
        return mapper.toDtoSensor(stock);
    }

    @Transactional
    public AtuadorStockDTO saveAtuador(AtuadorStockDTO dto) {
        AtuadorStock stock = mapper.toEntityAtuador(dto);
        repositoryAtuador.save(stock);
        return mapper.toDtoAtuador(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDto(list);
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(id);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public SensorStockDTO lastSensor() {
        return repository.lastSensor().map(mapper::toDtoSensor).orElseThrow(NotFoundException::new);

    }

    @Transactional(readOnly = true)
    public AtuadorStockDTO lastAtuador() {
        return repository.lastAtuador().map(mapper::toDtoAtuador).orElseThrow(NotFoundException::new);
    }


    @Transactional(readOnly = true)
    public List<SensorStockDTO> findAllSensors() {
        return repository.findAllRecordSensor().map(mapper::toDtoSensor).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<AtuadorStockDTO> findAllActuators() {
        return repository.findAllRecordAtuador().map(mapper::toDtoAtuadorList).orElseThrow(NotFoundException::new);
        //return repository.findAllRecordAtuador().map(mapper::toDtoAtuador).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public CsvSensorDTO getAllReportsSensorsByDates(String fromDate, String toDate) {
        LocalDateTime fromDateFix;
        LocalDateTime toDateFix;

        if(toDate.equals("00000000")){
            toDateFix = LocalDateTime.now();
            fromDateFix = toDateFix.minusDays(7);
        }else {
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyyMMdd");

            fromDateFix = LocalDate.parse(fromDate, parser).atStartOfDay();
            toDateFix = LocalDate.parse(toDate, parser).atStartOfDay();
        }

        System.out.println(fromDateFix);
        System.out.println(toDateFix);
        List<SensorStockDTO> lista = repositorySensor.findAllRecordSensorByDate(fromDateFix, toDateFix).map(mapper::toDtoSensor).orElseThrow(NotFoundException::new);

        CsvSensorDTO csvSensorDTO=new CsvSensorDTO();
        for(int i=0;i<lista.size();i++){
            csvSensorDTO.setDatetime(lista.get(i).getDatetime());
            csvSensorDTO.setPressao_atm(lista.get(i).getPressao_atm());
            csvSensorDTO.setUmidade_atm(lista.get(i).getUmidade_atm());
            csvSensorDTO.setTemperatura_atm(lista.get(i).getTemperatura_atm());
            csvSensorDTO.setUmidade_solo(lista.get(i).getUmidade_solo());
            csvSensorDTO.setTemperatura_solo(lista.get(i).getTemperatura_solo());
            csvSensorDTO.setCondutividade(lista.get(i).getCondutividade());
            csvSensorDTO.setLuminosidade(lista.get(i).getLuminosidade());




        }
        System.out.println(lista.size());
        return csvSensorDTO;
        //return repositorySensor.findAllRecordSensorByDate(fromDateFix, toDateFix).map(mapper::toDtoSensor).orElseThrow(NotFoundException::new);



    }

    @Transactional(readOnly = true)
    public CsvAtuadorDTO getAllReportsAtuadorByDates(String fromDate, String toDate) {
        LocalDateTime fromDateFix;
        LocalDateTime toDateFix;

        if(toDate.equals("00000000")){
            toDateFix = LocalDateTime.now();
            fromDateFix = toDateFix.minusDays(7);
        }else {
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyyMMdd");

            fromDateFix = LocalDate.parse(fromDate, parser).atStartOfDay();
            toDateFix = LocalDate.parse(toDate, parser).atStartOfDay();
        }

        System.out.println(fromDateFix);
        System.out.println(toDateFix);
        List<AtuadorStockDTO> lista = repositoryAtuador.findAllReportsActuatorByDate(fromDateFix, toDateFix).map(mapper::toDtoAtuadorList).orElseThrow(NotFoundException::new);
        CsvAtuadorDTO csvAtuadorDTO=new CsvAtuadorDTO();

        for(int i=0;i<lista.size();i++){
            csvAtuadorDTO.setDatetime(lista.get(i).getDatetime());
            csvAtuadorDTO.setEstado_bomba(lista.get(i).getEstado_bomba());
            csvAtuadorDTO.setLamina(lista.get(i).getLamina());
        }
        return csvAtuadorDTO;
    }
}

