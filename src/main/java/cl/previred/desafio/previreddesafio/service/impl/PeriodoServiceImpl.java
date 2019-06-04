package cl.previred.desafio.previreddesafio.service.impl;

import cl.previred.desafio.previreddesafio.dto.PeriodoDTO;
import cl.previred.desafio.previreddesafio.dto.PeriodosFaltantesDTO;
import cl.previred.desafio.previreddesafio.service.PeriodoService;
import cl.previred.desafio.previreddesafio.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private Environment env;

    @Override
    public PeriodosFaltantesDTO obtenerPeriodosFaltantes(){
        PeriodoDTO periodos = obtenerPeriodo();
        List<LocalDate> listaPeriodos = DateUtil.getDatesBetween(periodos.getFechaCreacion(), periodos.getFechaFin(), periodos.getFechas());
        PeriodosFaltantesDTO periodosFaltantes = new PeriodosFaltantesDTO();
        periodosFaltantes.setFechaCreacion(periodos.getFechaCreacion());
        periodosFaltantes.setFechaFin(periodos.getFechaFin());
        periodosFaltantes.setFechas(periodos.getFechas());
        periodosFaltantes.setFechasFaltantes(listaPeriodos);
        periodosFaltantes.setId(periodos.getId());

        return periodosFaltantes;

    }

    public PeriodoDTO obtenerPeriodo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>("body", headers);
        String endpoint = env.getProperty("servicio.generador.datos");
        ResponseEntity<PeriodoDTO> response = restTemplate.exchange(
                endpoint, HttpMethod.GET, httpEntity, PeriodoDTO.class);
        return response.getBody();
    }


}
