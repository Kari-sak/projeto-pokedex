package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Pokemon;

public class ListandoPokemon {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select p from Pokemon p");
		
		@SuppressWarnings("unchecked")
		List <Pokemon> pokemons = query.getResultList();
		for (Pokemon pokemon : pokemons) {
			System.out.println(pokemon.getCodigo() + " - "
					+ pokemon.getNome() + " - "
					+ pokemon.getAltura() + " - "
					+ pokemon.getPeso() + " - "
					+ pokemon.getTipo() + " - "
					+ pokemon.getDataCadastro());
		}
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();
		
	}

}
