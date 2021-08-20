package com.project.escola.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "tb_atuador")
public class AtuadorStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")//Mesmo id do banco
    private Long id;

    @Column (name="datetime")
    private LocalDateTime datetime;

    @Column(name = "lamina")
    private Double  lamina;

    @Column(name = "estado_bomba")
    private Boolean  estado_bomba;

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

    public Double getLamina() {
        return lamina;
    }

    public void setLamina(Double lamina) {
        this.lamina = lamina;
    }

    public Boolean getEstado_bomba() {
        return estado_bomba;
    }

    public void setEstado_bomba(Boolean estado_bomba) {
        this.estado_bomba = estado_bomba;
    }
}
