package br.com.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.excecao.ExplosaoException;

public class Campo {

	//atributos
	private int linha;
	private int coluna;	
	private boolean aberto;  //por padr�o � false(padr�o boolean);
	private boolean minado;  //por padr�o � false(padr�o boolean);
	private boolean marcado; //por padr�o � false(padr�o boolean);
	
	//lista
	private List<Campo> vizinhos = new ArrayList<>();
	
	//construtor
	public Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//m�todos
	public boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} 
		else {
			return false;
		}
	}
	
	//m�todo
	public void alternarMarcado() {
		if(!aberto) {
			marcado = !marcado;
		}		
	}
	
	//m�todo
	public boolean abrir() {
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			if(vizinhacaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}else {
			return false;
		}	
	}
	
	boolean vizinhacaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void minar() {
		minado = true;
	}
	
	public boolean isMinado() {		
		return minado;
	}
	
	public boolean isMarcado() {
		return marcado;
	}	
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !isAberto();
	}

	//m�todos getter and setters
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNavizinhaca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;		
	}
	public String toString() {
		if(marcado) {
			return "X";
		}else if(aberto && minado) {
			return "*";
		}else if (aberto && minasNavizinhaca() > 0 ) {
			return Long.toOctalString(minasNavizinhaca());
		}else if (aberto) {
			return " ";
		}else {
			return "?";
		}
	}
}
