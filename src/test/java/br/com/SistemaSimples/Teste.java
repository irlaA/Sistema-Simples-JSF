package br.com.SistemaSimples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	
	public static void main(String[] args) {
		
		 Persistence.createEntityManagerFactory("SistemaSimples");
        
	}
}
