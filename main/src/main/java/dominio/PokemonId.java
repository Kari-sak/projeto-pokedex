package dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PokemonId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String regiao;
	private String cidade;
	
	public PokemonId() {
	
	}

	public PokemonId(String regiao, String cidade) {
		super();
		this.regiao = regiao;
		this.cidade = cidade;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "PokemonId [regiao=" + regiao + ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonId other = (PokemonId) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(regiao, other.regiao);
	}
	
}
