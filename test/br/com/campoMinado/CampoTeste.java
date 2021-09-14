package br.com.campoMinado;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.modelo.Campo;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach  //BeforeEach significa que para cada método, ele vai chamar essa função
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3,2);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3,4);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Cima() {
		Campo vizinho = new Campo(2,3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Baixo() {
		Campo vizinho = new Campo(4,3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2,2);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1,1);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}	
	
	@Test
	void testeAlternarMarcado() {
		campo.alternarMarcado();
		assertTrue(campo.isMarcado());
	}	
	
	@Test
	void testeAlternarMarcadoDuasChamadas() {
		campo.alternarMarcado();
		campo.alternarMarcado();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {	
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {	
		campo.alternarMarcado();
		assertFalse(campo.abrir());
	}
	
	
	
	
}
