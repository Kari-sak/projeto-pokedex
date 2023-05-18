package aplicacao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dominio.Pokemon;
import dominio.PokemonId;
import dominio.Tipo;

public class ExibindoImagem {

	public static void main(String[] args) throws IOException {
		
		Path path = FileSystems.getDefault().getPath("arquivos-extras/pikachu.jpg");
		byte[] imagem = Files.readAllBytes(path);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pokedex");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Pokemon p1 = new Pokemon();
		//p1.setCodigo(new PokemonId("Kanto", "Fuchsia"));
		p1.setNome("Pikachu");
		p1.setAltura("0.4 m");
		p1.setPeso("6 kg");
		p1.setTipo(Tipo.ELÉTRICO);
		p1.setDataCadastro(LocalDate.of(2023, 04, 11));
		//p1.setImagem(imagem);
		
		em.persist(p1);
		
		em.getTransaction().commit();
		
		em.detach(p1);
		PokemonId codigo = new PokemonId("Kanto", "Fuchsia");
		Pokemon pokemon1 = em.find(Pokemon.class, codigo);
		//if (pokemon1.getImagem() != null) {
		//	BufferedImage img = ImageIO.read(new ByteArrayInputStream(pokemon1.getImagem()));
		//	JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		//}
		//else {
		//	System.out.println("Pokémon não possui imagem.");
		//}
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();
		
	}

}
