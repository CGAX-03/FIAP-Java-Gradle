package br.com.fiap.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaModel {
	
	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CATEGORIA_SEQ")
	@SequenceGenerator(name="CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
	private long idCategoria;
	
	@Column(name="NOME_CATEGORIA")
	private String nomeCategoria;
	
	@OneToMany(mappedBy = "categoriaModel")
	private List<ProdutoModel> produtos;

	public CategoriaModel() {
		super();
	}

	public CategoriaModel(long idCategoria, String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	
	
	public long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@NotNull(message="Nome é obrigatório")
	@Size(min=2, max=50, message="Nome deve ter entre 2 e 50 cracateres")
	public String getNomeCategoria() {
		return nomeCategoria;
	}


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

}
