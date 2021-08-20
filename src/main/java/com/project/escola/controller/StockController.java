package com.project.escola.controller;

import com.project.escola.model.dto.*;
import com.project.escola.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    private StockService service;


    /*
    @PostMapping(value = "/stockEnvio",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service. save(dto));
    }
    */

    @PostMapping(value = "/SaveSensor",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorStockDTO> saveSensor(@Valid @RequestBody SensorStockDTO dto){
       return ResponseEntity.ok(service.saveSensor(dto));
    }

    @PostMapping(value = "/SaveAtuador",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AtuadorStockDTO> saveAtuador(@Valid @RequestBody AtuadorStockDTO dto){
        return ResponseEntity.ok(service.saveAtuador(dto));
    }

/*
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update (@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
*/

/*
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){

        return  ResponseEntity.ok(service.findAll());

    }

 */
/*
@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
*/

  /*
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
*/
  /*
    @GetMapping(value = "/today",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return  ResponseEntity.ok(service.findByToday());
    }
*/

    @GetMapping(value = "/lastSensor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorStockDTO> lastSensor(){
        return  ResponseEntity.ok(service.lastSensor());
    }

    @GetMapping(value = "/lastAtuador",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AtuadorStockDTO> lastAtuador(){
        return  ResponseEntity.ok(service.lastAtuador());
    }

    @GetMapping(value = "/findAllSensor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SensorStockDTO>> findAllSensor(){
        return  ResponseEntity.ok(service.findAllSensors());
    }

    @GetMapping(value = "/findAllActuators",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AtuadorStockDTO>> findAllAtuador(){
        return  ResponseEntity.ok(service.findAllActuators());
    }

    @GetMapping(value = "/findAllSensorByDates",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CsvSensorDTO> getAllReportsSensorsByDates(String fromDate, String toDate){
        System.out.println("Entrou:"+fromDate);
        return  ResponseEntity.ok(service.getAllReportsSensorsByDates(fromDate, toDate));
    }

    @GetMapping(value = "/findAllActuatorByDates",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CsvAtuadorDTO> getAllReportsAtuadorByDates(String fromDate, String toDate){
        System.out.println("Entrou:"+fromDate);
        return  ResponseEntity.ok(service.getAllReportsAtuadorByDates(fromDate, toDate));
    }

    }


