package com.danilorocha.sistema.bancario;
/**
 *
 * @author danilorocha
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

	// Requisito 01
	@Test
	void testConta() throws Exception {
		final Conta instance = new Conta();
		final String esperado = "12345-6";
		instance.setNumero(esperado);
		final String obtido = instance.getNumero();
		assertEquals(esperado, obtido);
	}

	@Test
	void testSetNumeroInvalidoNaoArmazena() {
		final Conta instance = new Conta();
		final String invalido = "123";
		assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
		final String obtido = instance.getNumero();
		assertNotEquals(invalido, obtido);
	}
        
	@Test
	void testSetNumeroVazio() {
		final Conta instance = new Conta();
		final String invalido = "";
		assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
		final String obtido = instance.getNumero();
		assertNotEquals(invalido, obtido);
	}
       
	// Requisito 02
	@Test
	void testInstanciaPadraoPoupanca() {
		final Conta instance = new Conta();
		assertFalse(instance.isPoupanca());
	}
        
        // Requisito 03
	@Test
	void testSetLimiteContaEspecia () {
		final Conta instance = new Conta();
		instance.setEspecial(true);
		final double esperado = 1000;
		instance.setLimite(esperado);
		final double obtido = instance.getLimite();
		assertEquals(esperado, obtido);
	}
        
        @Test
	void testSetLimiteContNaoEspecialNaoArmazena() {
		final Conta instance = new Conta();
		final double limite = 1000;
		assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
		final double obtido = instance.getLimite();
		assertNotEquals(limite, obtido);
	}
        
        // Requisito 04
	@Test
	void testHistoricoNotNull() {
		final Conta instance = new Conta();
		assertNotNull(instance.getMovimentacoes());
	}

}