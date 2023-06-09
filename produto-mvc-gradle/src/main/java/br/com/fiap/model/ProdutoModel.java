package br.com.fiap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PRODUTO_SEQ")
	@SequenceGenerator(name="PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	private long id;
	
	private String nome;
	private String sku;
	private String descricao;
	private double preco;
	private String caracteristicas;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA", nullable=false)
	private CategoriaModel categoriaModel;
	
	@ManyToOne
	@JoinColumn(name="ID_MARCA", nullable=false)
	private MarcaModel marcaModel;
	
	
	public ProdutoModel() {
		super();
	}
	
	

	public ProdutoModel(long id, String nome, String sku, String descricao, double preco, String caracteristicas,
			CategoriaModel categoriaModel, MarcaModel marcaModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.preco = preco;
		this.caracteristicas = caracteristicas;
		this.categoriaModel = categoriaModel;
		this.marcaModel = marcaModel;
	}



	public long getId() {
	return id;
}
	public void setId(long id) {
		this.id = id;
	}
	
	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}


	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	

	public MarcaModel getMarcaModel() {
		return marcaModel;
	}



	public void setMarcaModel(MarcaModel marcaModel) {
		this.marcaModel = marcaModel;
	}



	@Size(min=2,max=40, message = "Nome deve ter no mínimo 2 e no máximo 40 caracteres")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Size(min = 8, max = 8, message="SKU deve conter 8 caracteres")
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Size(min=1,max=200, message="Descrição deve ter no mínimo 1 e no máximo 200 caracteres")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@DecimalMin(value="0.1", message = "Preço deve ser acima de 0.0")
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Size(min=1, max = 200, message="Caracteristicas deve ter no mínimo 1 e no máximo 200 caracteres")
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	
	
}
