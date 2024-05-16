package com.teste3.teste3;

import com.teste3.teste3.domain.endereco.Endereco;
import com.teste3.teste3.domain.pessoa.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootTest
class Teste3ApplicationTests {

	private Endereco endereco;
	private Pessoa pessoa;
	private final LocalDate dataNascimento = LocalDate.parse("2018-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	@BeforeEach
    public void setupPessoa() {

		pessoa = new Pessoa("Carlos Augusto", this.dataNascimento);
	}
	@BeforeEach
	public void setupEndereco() {
		pessoa = new Pessoa("Carlos Augusto", this.dataNascimento);
		endereco = new Endereco(
			"Rua A",
			"12345-678",
			"3",
			"Cidade A",
			"Alagoas",
			true, pessoa);
	}


	@Test
	public void testConstrutorEndereco() {
		assertEquals("Rua A", endereco.getLogradouro());
		assertEquals("12345-678", endereco.getCep());
		assertEquals("3", endereco.getNumero());
		assertEquals("Cidade A", endereco.getCidade());
		assertEquals("Alagoas", endereco.getEstado());
		assertEquals(true, endereco.getPrincipal());
		assertEquals(pessoa, endereco.getPessoa());
	}

	@Test
	public void testConstrutorPessoa() {
		assertEquals("Carlos Augusto", pessoa.getNomeCompleto());
		assertEquals(this.dataNascimento, pessoa.getDataNascimento());
	}

	@Test
	public void testSetnomeComletoPessoa() {
		pessoa.setNomeCompleto("Fernando José");
		assertEquals("Fernando José", pessoa.getNomeCompleto());
	}
	@Test
	public void testSetdataNascimentoPessoa() {
		pessoa.setDataNascimento(this.dataNascimento);
		assertEquals(this.dataNascimento, pessoa.getDataNascimento());
	}

	@Test
	public void testSetLogradouroEndereco() {
		endereco.setLogradouro("Nova Rua");
		assertEquals("Nova Rua", endereco.getLogradouro());
	}

	@Test
	public void testSetCidadeEndereco() {
		endereco.setCidade("Nova Cidade");
		assertEquals("Nova Cidade", endereco.getCidade());
	}

	@Test
	public void testSetCepEndereco() {
		endereco.setCep("98765-432");
		assertEquals("98765-432", endereco.getCep());
	}

	@Test
	public void testEnderecoEquals() {
		Endereco outroEndereco = new Endereco("Rua A", "12345-678", "3", "Cidade A", "Alagoas", true, pessoa);
		assertTrue(endereco.equals(outroEndereco));
	}

	@Test
	public void testEnderecoHashCode() {
		Endereco outroEndereco = new Endereco("Rua A", "12345-678", "3", "Cidade A", "Alagoas", true, pessoa);
		assertEquals(endereco.hashCode(), outroEndereco.hashCode());
	}

}
