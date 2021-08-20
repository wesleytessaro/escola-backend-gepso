package com.project.escola.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CsvSensorDTO {
    private String datetime="", pressao_atm="", umidade_atm="", temperatura_atm="", umidade_solo="", temperatura_solo="", condutividade="", luminosidade="";


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.datetime += datetime.format(formatter) + ",";
    }

    public String getPressao_atm() {
        return pressao_atm;
    }

    public void setPressao_atm(Double pressao_atm) {
        this.pressao_atm += pressao_atm + ",";
    }

    public String getUmidade_atm() {
        return umidade_atm;
    }

    public void setUmidade_atm(Double umidade_atm) {
        this.umidade_atm += umidade_atm  + ",";
    }

    public String getTemperatura_atm() {
        return temperatura_atm;
    }

    public void setTemperatura_atm(Double temperatura_atm) {
        this.temperatura_atm += temperatura_atm + ",";
    }

    public String getUmidade_solo() {
        return umidade_solo;
    }

    public void setUmidade_solo(Double umidade_solo) {
        this.umidade_solo += umidade_solo + ",";
    }

    public String getTemperatura_solo() {
        return temperatura_solo;
    }

    public void setTemperatura_solo(Double temperatura_solo) {
        this.temperatura_solo += temperatura_solo + ",";
    }

    public String getCondutividade() {
        return condutividade;
    }

    public void setCondutividade(Double condutividade) {
        this.condutividade += condutividade + ",";
    }

    public String getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(Integer luminosidade) {
        this.luminosidade += luminosidade + ",";
    }
}
