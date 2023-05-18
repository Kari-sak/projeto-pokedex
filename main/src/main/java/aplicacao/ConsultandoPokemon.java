package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;
import dominio.Treinador;

public class ConsultandoPokemon {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		//TESTE
		//List <Pokemon> pokemons = em.createQuery("select p from Pokemon p", Pokemon.class).getResultList();
		//for (Pokemon pokemon : pokemons) {
		//	System.out.println(pokemon.getNome() + " - " + pokemon.getTreinador().getNome());
		//}
		
		//TESTE
		//Treinador t1 = em.find(Treinador.class, 1L);
		//System.out.println("Treinador: " + t1.getNome());
		
		//for (Pokemon pokemon : t1.getPokemons()) {
		//	System.out.println("Pokemon: " + pokemon.getNome());
		//}
		
		//TESTE
		Pokemon pokemon = em.find(Pokemon.class, 1L);
		System.out.println(pokemon.getNome() + " - " + pokemon.getTreinador().getNome());
		
		Treinador t1 = em.find(Treinador.class, 1L);
		System.out.println(t1.getEmail() + " - " + t1.getIdade());
		
		System.out.println("pronto!");
		
		em.close(); 
		emf.close();

	}

}
