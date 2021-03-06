package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "users", catalog = "bookstoredb")
@NamedQueries({
	@NamedQuery(name = "Users.findAll", query = "SELECT u from Users u "),
	@NamedQuery(name = "Users.countAll", query = "SELECT COUNT(u.nome) FROM Users u "),
	@NamedQuery(name = "Users.findByEmail", query = "SELECT u from Users u where u.email = :email"),
	@NamedQuery(name = "Users.checkLogin", query = "select u from Users u where u.email = :email and u.senha = :password")
}) 
public class Users implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String nome;
	private String senha;
	private String email;
	
	public Users() {
		
	}

	
	public Users(Integer userId, String nome, String senha, String email) {
		this(nome, senha, email);
		this.user_id =  userId;
	}

	public Users(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	


	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.user_id;
	}

	public void setUserId(Integer userId) {
		this.user_id = userId;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "senha")
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
