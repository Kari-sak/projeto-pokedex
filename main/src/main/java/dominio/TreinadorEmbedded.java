package dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TreinadorEmbedded {

	@Column(name = "nome_treinador", length= 50, nullable = false)
	private String nome;
	
	@Column(name = "email_treinador", nullable = false)
	private String email;
	
	@Column(name = "idade_treinador", precision = 2, nullable = false)
	private int idade;

	public TreinadorEmbedded() {
	
	}

	public TreinadorEmbedded(String nome, String email, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
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

	@Override
	public String toString() {
		return "TreinadorEmbedded [nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreinadorEmbedded other = (TreinadorEmbedded) obj;
		return Objects.equals(email, other.email) && idade == other.idade && Objects.equals(nome, other.nome);
	}
	
}
