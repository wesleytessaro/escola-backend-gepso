package com.project.escola.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvAtuadorDTO {
    private String datetime="", estado_bomba="", lamina="";


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.datetime += datetime.format(formatter) + ",";
    }

    public String getEstado_bomba() {
        return estado_bomba;
    }

    public void setEstado_bomba(boolean estado_bomba) {
        this.estado_bomba += estado_bomba + ",";
    }

    public String getLamina() {
        return lamina;
    }

    public void setLamina(Double lamina) {
        this.lamina += lamina  + ",";
    }

}
