package dominio;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Treinador")
public class Treinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nome_treinador", length= 50, nullable = false)
	private String nome;
	
	@Column(name = "email_treinador", nullable = false)
	private String email;
	
	@Column(name = "idade_treinador", precision = 2, nullable = false)
	private int idade;
	
	//@OneToOne
	//@OneToOne(mappedBy = "treinador")
	//private Pokemon pokemon;
	
	@OneToMany(mappedBy = "treinador")
	private List <Pokemon> pokemons;

	public Treinador() {
	
	}

	public Treinador(Long codigo, String nome, String email, int idade, List<Pokemon> pokemons) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.pokemons = pokemons;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	@Override
	public String toString() {
		return "Treinador [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", idade=" + idade
				+ ", pokemons=" + pokemons + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, email, idade, nome, pokemons);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treinador other = (Treinador) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(email, other.email) && idade == other.idade
				&& Objects.equals(nome, other.nome) && Objects.equals(pokemons, other.pokemons);
	}
	
}
