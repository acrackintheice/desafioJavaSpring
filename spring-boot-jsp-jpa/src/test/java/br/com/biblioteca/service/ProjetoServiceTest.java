package br.com.biblioteca.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.biblioteca.MainServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainServer.class)
public class ProjetoServiceTest {

    @Autowired
    private ProjetoService service;

    @Test
    public void contexLoads() throws Exception {
        assertThat(service).isNotNull();
    }

}