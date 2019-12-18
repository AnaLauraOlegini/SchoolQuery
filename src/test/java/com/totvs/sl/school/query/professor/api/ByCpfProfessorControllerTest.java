package com.totvs.sl.school.query.professor.api;

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
public class ByCpfProfessorControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private EntityManager em;
    
    private String jwt = RacEmulator.getInstance().generateJWT("user", "");
    
    @Before
    public void setup() {
        this.em.persist(Fabrica.novoProfessorModel());
    }
    
    @Test
    public void deveRetornarUmProfessor() throws Exception{
        this.mockMvc
        .perform(get(ProfessorController.PATH + "/cpf/" + Fabrica.professorCpf)
                .header((HEADER_STRING), jwt))
        .andExpect(jsonPath("$.id", is(Fabrica.professorId)))
        .andExpect(jsonPath("$.cpf", is(Fabrica.professorCpf)))
        .andExpect(status().is2xxSuccessful())
        .andReturn();
    }

    @Test
    public void naoDeveRetornarUmProfessor() throws Exception{
        this.mockMvc
        .perform(get(ProfessorController.PATH + "/cpf/" + "18998957957")
                .header(HEADER_STRING, jwt))
        .andExpect(status().isNotFound());
    }
}
