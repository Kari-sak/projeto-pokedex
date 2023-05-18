package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;

public class AtualizandoPokemon {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Pokemon pokemon = em.find(Pokemon.class, 2L);
		System.out.println("O peso atual do pokémon " + pokemon.getNome() + " é: " + pokemon.getPeso());
		pokemon.setPeso("9 kg");
		System.out.println("O novo peso do pokémon " + pokemon.getNome() + " é: " + pokemon.getPeso());
		
		em.getTransaction().commit();
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
