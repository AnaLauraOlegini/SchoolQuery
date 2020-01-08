package com.totvs.sl.school.query.turma.api;

import static com.totvs.tjf.mock.test.RacEmulator.HEADER_STRING;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.totvs.sl.school.query.Fabrica;
import com.totvs.tjf.mock.test.RacEmulator;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GetTurmaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EntityManager em;

	private String jwt = RacEmulator.getInstance().generateJWT("user", "");
	private String turmaId1 = UUID.randomUUID().toString();

	@Before
	public void setup() {
		this.em.persist(Fabrica.novaTurma(turmaId1));
		this.em.flush();
	}

	@Test
	public void deveRetornarTurmaPeloId() throws Exception {
		this.mockMvc.perform(get(TurmaController.PATH + "/" + this.turmaId1).header(HEADER_STRING, jwt))
		            .andExpect(jsonPath("$.id", is(this.turmaId1)))
		            .andExpect(jsonPath("$.descricao", is(Fabrica.turmaDescricao1)))
		            .andExpect(jsonPath("$.anoLetivo", is(Fabrica.turmaAnoLetivo1)))
		            .andExpect(jsonPath("$.peridoLetivo", is(Fabrica.turmaPeriodoLetivo1)))
		            .andExpect(jsonPath("$.numeroVagas", is(Fabrica.turmaNumeroVagas1)))
		            .andExpect(jsonPath("$.disciplinaId.length()", is(2)))
		            .andExpect(jsonPath("$.discplinaId[0].id", is(Fabrica.turmaDisciplinaId1)))
		            .andExpect(jsonPath("$.discplinaId[1].id", is(Fabrica.turmaDisciplinaId2)))
		            .andExpect(jsonPath("$.alunoId.length()", is(2)))
		            .andExpect(jsonPath("$.alunoId[0].id", is(Fabrica.turmaAlunoId1)))
		            .andExpect(jsonPath("$.alunoId[1].id", is(Fabrica.turmaAlunoId2)))
		            .andExpect(status().is2xxSuccessful())
		            .andReturn();
	}

}
