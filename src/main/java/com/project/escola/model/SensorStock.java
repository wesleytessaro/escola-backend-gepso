package com.project.escola.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table (name = "tb_sensor")
public class SensorStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")//Mesmo id do banco
    private Long id;

    @Column (name="datetime")
    private LocalDateTime datetime;

    @Column(name = "pressao_atm")
    private Double  pressao_atm;

    @Column(name = "umidade_atm")
    private Double  umidade_atm;

    @Column(name = "temperatura_atm")
    private Double  temperatura_atm;

    @Column(name = "umidade_solo")
    private Double  umidade_solo;

    @Column(name = "temperatura_solo")
    private Double  temperatura_solo;

    @Column(name = "condutividade")
    private Double  condutividade;

    @Column(name = "luminosidade")
    private Integer  luminosidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUmidade_atm() {
        return umidade_atm;
    }

    public void setUmidade_atm(Double umidade_atm) {
        this.umidade_atm = umidade_atm;
    }

    public Double getTemperatura_atm() {
        return temperatura_atm;
    }

    public void setTemperatura_atm(Double temperatura_atm) {
        this.temperatura_atm = temperatura_atm;
    }

    public Double getUmidade_solo() {
        return umidade_solo;
    }

    public void setUmidade_solo(Double umidade_solo) {
        this.umidade_solo = umidade_solo;
    }

    public Double getTemperatura_solo() {
        return temperatura_solo;
    }

    public void setTemperatura_solo(Double temperatura_solo) {
        this.temperatura_solo = temperatura_solo;
    }

    public Double getCondutividade() {
        return condutividade;
    }

    public void setCondutividade(Double condutividade) {
        this.condutividade = condutividade;
    }

    public Integer getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(Integer luminosidade) {
        this.luminosidade = luminosidade;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Double getPressao_atm() {
        return pressao_atm;
    }
    public void setPressao_atm(Double pressao_atm) {
        this.pressao_atm = pressao_atm;
    }
}
