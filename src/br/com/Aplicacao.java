package br.com;

import br.com.modelo.Tabuleiro;
import br.com.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);		
		new TabuleiroConsole(tabuleiro);	
		

	}

}
