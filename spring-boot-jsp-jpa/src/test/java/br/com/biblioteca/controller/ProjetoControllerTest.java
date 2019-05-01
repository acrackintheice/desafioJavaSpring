package br.com.biblioteca.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.biblioteca.MainServer;
import br.com.biblioteca.controller.ProjetoController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainServer.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjetoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProjetoController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void projetosMustContainAurora() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/projetos",
                String.class)).isNotEmpty();
    }


}