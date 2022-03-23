package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private LoginPage paginaDeLogin;


    @BeforeEach
    public void beforeEach() {
       this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
       paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() throws InterruptedException {
        paginaDeLogin.preencheFormularioDeLogin("fulano" , "pass");
        paginaDeLogin.efetuaLogin();

        assertFalse(paginaDeLogin.isPaginaDeLogin());
        assertEquals("fulano" , paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos() throws InterruptedException {
        paginaDeLogin.preencheFormularioDeLogin("invalido" , "123456789");
        paginaDeLogin.efetuaLogin();

        assertTrue(paginaDeLogin.isPaginaDeLogin());
        assertNull(paginaDeLogin.getNomeUsuarioLogado());
        assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();
        assertTrue(paginaDeLogin.isPaginaDeLogin());
        assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
