package com.project.escola.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtuadorStockDTO {
    Long id;

    //@NotNull
    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDateTime datetime;


    @NotNull
    private Boolean estado_bomba;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double lamina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Boolean getEstado_bomba() {
        return estado_bomba;
    }

    public void setEstado_bomba(Boolean estado_bomba) {
        this.estado_bomba = estado_bomba;
    }

    public Double getLamina() {
        return lamina;
    }

    public void setLamina(Double lamina) {
        this.lamina = lamina;
    }
}
