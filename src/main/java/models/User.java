package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user", schema = "resource_account", indexes = {
		@Index(name = "ixUser_Nome", columnList = "nome"),
		@Index(name = "ixUser_Email", columnList = "email", unique = true),
		@Index(name = "ixUser_Login", columnList = "login", unique = true),
})
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", schema = "resource_account", initialValue = 1, allocationSize = 1)
public class User implements Serializable {

	private static final long serialVersionUID = -5377014283141606606L;

	@Id
	@GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank(message = "O Nome é Obrigatório")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotBlank(message = "O Login é Obrigatório")
	@Column(name = "login", nullable = false)
	private String login;

	@NotBlank(message = "O E-mail é Obrigatório")
	@Column(name = "email", nullable = false)
	private String email;

	@NotBlank(message = "A Senha é Obrigatória")
	@Column(name = "senha", nullable = false)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", login=" + login + ", email=" + email + ", senha=" + senha + "]";
	}

}
