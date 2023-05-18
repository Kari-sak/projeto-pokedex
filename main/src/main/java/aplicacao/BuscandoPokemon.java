package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;

public class BuscandoPokemon {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		Pokemon pokemon = em.find(Pokemon.class, 1L);
		System.out.println("O código do "+ pokemon.getNome() + " é: " + pokemon.getCodigo());
		
		//Pokemon pokemon = em.getReference(Pokemon.class, 1L);
		//System.out.println("O código do "+ pokemon.getNome() + " é: " + pokemon.getCodigo());
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
