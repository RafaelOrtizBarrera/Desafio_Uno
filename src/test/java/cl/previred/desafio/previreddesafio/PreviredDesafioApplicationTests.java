package cl.previred.desafio.previreddesafio;

import cl.previred.desafio.previreddesafio.dto.PeriodosFaltantesDTO;
import cl.previred.desafio.previreddesafio.service.impl.PeriodoServiceImpl;
import cl.previred.desafio.previreddesafio.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreviredDesafioApplicationTests {

	@Autowired
	private PeriodoServiceImpl periodosService;

	@Test
	public void contextLoads() {
	}
	@Test
	public void retornaPeriodosRecibidosMasFaltantes(){
		PeriodosFaltantesDTO periodosFaltantes = periodosService.obtenerPeriodosFaltantes();
		Long totalFechas = DateUtil.numOfMonthsBetween(periodosFaltantes.getFechaCreacion(), periodosFaltantes.getFechaFin());
		Number totalFechasServicio = (periodosFaltantes.getFechas().size() + periodosFaltantes.getFechasFaltantes().size());
		Assert.assertEquals(totalFechas.longValue(),  totalFechasServicio.longValue());
	}

}
