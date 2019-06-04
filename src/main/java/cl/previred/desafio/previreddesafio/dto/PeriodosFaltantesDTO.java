package cl.previred.desafio.previreddesafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public class PeriodosFaltantesDTO {

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("fechaCreacion")
    private LocalDate fechaCreacion;

    @JsonProperty("fechaFin")
    private LocalDate fechaFin;

    @JsonProperty("fechas")
    @Valid
    private List<LocalDate> fechas;

    @JsonProperty("fechasFaltantes")
    @Valid
    private List<LocalDate> fechasFaltantes;

    public Long getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public List<LocalDate> getFechas() {
        return fechas;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }

    public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
}
