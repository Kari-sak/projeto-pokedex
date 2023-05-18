package aplicacao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pokemon;
import dominio.PokemonId;
import dominio.Tipo;
import dominio.Treinador;
import dominio.TreinadorEmbedded;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//PARTE I - CHAVE PRIMÁRIA
		//Pokemon p1 = new Pokemon();
		//p1.setNome("Pikachu");
		//p1.setAltura("0.4 m");
		//p1.setPeso("6 kg");
		//p1.setTipo(Tipo.ELÉTRICO);
		//p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		
		//Pokemon p2 = new Pokemon();
		//p2.setNome("Charmander");
		//p2.setAltura("0.6 m");
		//p2.setPeso("8.5 kg");
		//p2.setTipo(Tipo.FOGO);
		//p2.setDataCadastro(LocalDate.of(2022, 12, 26));
		
		//em.persist(p1);
		//em.persist(p2);
		
		//PARTE II - CHAVE COMPOSTA
		//Pokemon p1 = new Pokemon();
		//p1.setCodigo(new PokemonId("Kanto", "Fuchsia"));
		//p1.setNome("Pikachu");
		//p1.setAltura("0.4 m");
		//p1.setPeso("6 kg");
		//p1.setTipo(Tipo.ELÉTRICO);
		//p1.setDataCadastro(LocalDate.of(2023, 04, 11));

		//Pokemon p2 = new Pokemon();
		//p2.setCodigo(new PokemonId("Kanto", "Pallet"));
		//p2.setNome("Charmander");
		//p2.setAltura("0.6 m");
		//p2.setPeso("8.5 kg");
		//p2.setTipo(Tipo.FOGO);
		//p2.setDataCadastro(LocalDate.of(2022, 12, 26));
		
		//em.persist(p1);
		//em.persist(p2);
		
		//PARTE III - CLOB 
		//StringBuilder descricaoCompleta1 = new StringBuilder();
		//descricaoCompleta1.append("Pikachu é um pokémon roedor meio gordinho, com o pêlo amarelo em todo o seu corpo. \n");
		//descricaoCompleta1.append("As orelhas de Pikachu são longas e chegam a um ponto com pontas pretas. \n");
		//descricaoCompleta1.append("Ele tem duas listras marrons em suas costas, e sua cauda é em forma de raio Zigzag de estilo, com um pedaço de pele marrom na base da cauda. \n");
		
		//Pokemon p1 = new Pokemon();
		//p1.setCodigo(new PokemonId("Kanto", "Fuchsia"));
		//p1.setNome("Pikachu");
		//p1.setAltura("0.4 m");
		//p1.setPeso("6 kg");
		//p1.setTipo(Tipo.ELÉTRICO);
		//p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		//p1.setDescricaoCompleta(descricaoCompleta1.toString());
		
		//StringBuilder descricaoCompleta2 = new StringBuilder();
		//descricaoCompleta2.append("Charmander é um pequeno dinossauro bípede como pokémon. \n");
		//descricaoCompleta2.append("A maioria da cor do seu corpo é laranja, enquanto o seu ventre baixo é de cor amarelo-claro. \n");
		//descricaoCompleta2.append("Charmander, como suas evoluções, tem uma chama na ponta de sua cauda que arde constantemente. \n");
		
		//Pokemon p2 = new Pokemon();
		//p2.setCodigo(new PokemonId("Kanto", "Pallet"));
		//p2.setNome("Charmander");
		//p2.setAltura("0.6 m");
		//p2.setPeso("8.5 kg");
		//p2.setTipo(Tipo.FOGO);
		//p2.setDataCadastro(LocalDate.of(2022, 12, 26));
		//p2.setDescricaoCompleta(descricaoCompleta2.toString());
		
		//em.persist(p1);
		//em.persist(p2);
		
		//PARTE IV - OBJETOS EMBUTIDOS
		//TreinadorEmbedded t1 = new TreinadorEmbedded();
		//t1.setNome("Ash Katchum");
		//t1.setEmail("ash@email.com");
		//t1.setIdade(10);
		
		//Pokemon p1 = new Pokemon();
		//p1.setNome("Pikachu");
		//p1.setAltura("0.4 m");
		//p1.setPeso("6 kg");
		//p1.setTipo(Tipo.ELÉTRICO);
		//p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		//p1.setTreinador(t1);
		
		//em.persist(p1);
		
		//PARTE V - @OneToOne
		//Treinador t1 = new Treinador();
		//t1.setNome("Ash Ketchum");
		//t1.setEmail("ash@email.com");
		//t1.setIdade(10);
		
		//Pokemon p1 = new Pokemon();
		//p1.setNome("Pikachu");
		//p1.setAltura("0.4 m");
		//p1.setPeso("6 kg");
		//p1.setTipo(Tipo.ELÉTRICO);
		//p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		//p1.setTreinador(t1);
		
		//em.persist(t1);
		//em.persist(p1);
		
		//PARTE V - @ManyToOne
		Treinador t1 = new Treinador();
		t1.setNome("Ash Ketchum");
		t1.setEmail("ash@email.com");
		t1.setIdade(10);
		
		Pokemon p1 = new Pokemon();
		p1.setNome("Pikachu");
		p1.setAltura("0.4 m");
		p1.setPeso("6 kg");
		p1.setTipo(Tipo.ELÉTRICO);
		p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		p1.setTreinador(t1);
		
		Pokemon p2 = new Pokemon();
		p2.setNome("Charmander");
		p2.setAltura("0.6 m");
		p2.setPeso("8.5 kg");
		p2.setTipo(Tipo.FOGO);
		p2.setDataCadastro(LocalDate.of(2022, 12, 26));
		p2.setTreinador(t1);
		
		em.persist(t1);
		em.persist(p1);
		em.persist(p2);
		
		em.getTransaction().commit();
		
		//CONTINUAÇÃO PARTE III
		//em.detach(p1);
		//Pokemon pokemon1 = em.find(Pokemon.class, p1.getCodigo());
		//System.out.println("Pokémon: " + p1.getNome());
		//System.out.println("-");
		//System.out.println(pokemon1.getDescricaoCompleta());
		
		//em.detach(p2);
		//Pokemon pokemon2 = em.find(Pokemon.class, p2.getCodigo());
		//System.out.println("Pokémon: " + p2.getNome());
		//System.out.println("-");
		//System.out.println(pokemon2.getDescricaoCompleta());
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
