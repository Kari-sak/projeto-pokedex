package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;

public class ExcluindoPokemon {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Pokemon pokemon = em.find(Pokemon.class, 2L);
		em.remove(pokemon);
		
		em.getTransaction().commit();
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
