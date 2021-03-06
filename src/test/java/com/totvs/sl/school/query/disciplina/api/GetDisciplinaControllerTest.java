package com.totvs.sl.school.query.disciplina.api;

import static com.totvs.tjf.mock.test.RacEmulator.HEADER_STRING;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.totvs.sl.school.query.Fabrica;
import com.totvs.tjf.mock.test.RacEmulator;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GetDisciplinaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EntityManager em;

	private String jwt = RacEmulator.getInstance().generateJWT("user", "");
	private String disciplinaId = UUID.randomUUID().toString();

	@Before
	public void setup() {
		this.em.persist(Fabrica.novaDisciplina(disciplinaId));
		this.em.persist(Fabrica.novoProfessorDisciplina(Fabrica.disciplinaProfessorId1));
		//this.em.flush();
	}

	@Test
	public void deveRetornarDisciplinaPeloId() throws Exception {
		this.mockMvc.perform(get(DisciplinaController.PATH + "/" + this.disciplinaId).header(HEADER_STRING, jwt))
		            .andExpect(jsonPath("$.id", is(this.disciplinaId)))
		            .andExpect(jsonPath("$.descricao", is(Fabrica.disciplinaDescricao1)))
		            .andExpect(jsonPath("$.sigla", is(Fabrica.disciplinaSigla1)))
		            .andExpect(jsonPath("$.cargaHoraria", is(Fabrica.disciplinaCargaHoraria1)))
		            .andExpect(jsonPath("$.professorId.length()", is(1)))
		            .andExpect(jsonPath("$.professorId[0].DisciplinaProfessorDisciplina.professorId", is(Fabrica.disciplinaProfessorId1)))
		            .andExpect(status().is2xxSuccessful())
		            .andReturn();
	}
}
