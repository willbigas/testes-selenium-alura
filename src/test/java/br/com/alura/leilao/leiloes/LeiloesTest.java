package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();

    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valorInicial = "500.00";

        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valorInicial, hoje);
        assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valorInicial , hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() {
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
        assertFalse(this.paginaDeCadastro.isPaginaAtual());
        assertTrue(this.paginaDeCadastro.isPaginaLeiloes());
        assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());
    }

}
