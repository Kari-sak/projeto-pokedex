package dominio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Pokedex")
public class Pokemon {

	//CHAVE PRIMÁRIA
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_pokemon")
	private Long codigo; 
	
	//@EmbeddedId
	//private PokemonId codigo;
	
	@Column(length = 30, nullable = false) 
	private String nome;
	
	@Column(nullable = false)
	private String altura;
	
	@Column(nullable = false)
	private String peso;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column(name="data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	//@Transient
	//private String fraqueza;
	
	//@Lob
	//@Column(name="descricao_completa")
	//private String descricaoCompleta;
	
	//@Lob 
	//private byte[] imagem;
	
	//@Embedded
	//private TreinadorEmbedded treinador;
	
	//@OneToOne
	//@OneToOne(optional = false)
	//@JoinColumn(name = "cod_treinador")
	//private Treinador treinador;
	
	@ManyToOne
	@JoinColumn(name = "cod_treinador")
	private Treinador treinador;
	
	public Pokemon() {
		
	}

	public Pokemon(Long codigo, String nome, String altura, String peso, Tipo tipo, LocalDate dataCadastro,
			Treinador treinador) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.tipo = tipo;
		this.dataCadastro = dataCadastro;
		this.treinador = treinador;
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

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, codigo, dataCadastro, nome, peso, tipo, treinador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(nome, other.nome)
				&& Objects.equals(peso, other.peso) && tipo == other.tipo && Objects.equals(treinador, other.treinador);
	}
	
}
