package com.totvs.sl.school.query.aluno.api;

import static com.totvs.tjf.mock.test.RacEmulator.HEADER_STRING;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class ByCpfAlunoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EntityManager entityManager;

	private String jwt = RacEmulator.getInstance().generateJWT("user", "");

	@Before
	public void setup() {
		this.entityManager.persist(Fabrica.novoAlunoModel());
	}

	@Test
	public void deveRetornarUmAluno() throws Exception {
		this.mockMvc.perform(get(AlunoController.PATH + "/cpf/" + Fabrica.alunoCpf2).header(HEADER_STRING, jwt))
		            .andExpect(jsonPath("$.id", is(Fabrica.alunoId2)))
		            .andExpect(jsonPath("$.cpf", is(Fabrica.alunoCpf2)))
		            .andExpect(status().is2xxSuccessful())
		            .andReturn();
	}

	@Test
	public void naoDeveRetornarUmAluno() throws Exception {
		this.mockMvc.perform(get(AlunoController.PATH + "/cpf/" + "07240966046").header(HEADER_STRING, jwt))
		            .andExpect(status().isNotFound());

	}
}
