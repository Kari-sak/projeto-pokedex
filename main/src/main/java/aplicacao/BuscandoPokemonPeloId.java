package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;
import dominio.PokemonId;

public class BuscandoPokemonPeloId {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		PokemonId codigo = new PokemonId("Kanto", "Fuchsia");
		Pokemon pokemon = em.find(Pokemon.class, codigo);
		//System.out.println("Região: " + pokemon.getCodigo().getRegiao());
		//System.out.println("Cidade: " + pokemon.getCodigo().getCidade());
		System.out.println("Nome: " + pokemon.getNome());
		System.out.println("Altura: " + pokemon.getAltura());
		System.out.println("Peso: " + pokemon.getPeso());
		System.out.println("Tipo: " + pokemon.getTipo());
		System.out.println("Data Cadastro: " + pokemon.getDataCadastro());

		System.out.println("Feito!");
		
		em.close();
		emf.close();
		
	}

}
