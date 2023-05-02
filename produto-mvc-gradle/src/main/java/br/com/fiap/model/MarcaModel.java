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
@Table(name = "TB_MARCA")
public class MarcaModel {

	@Id
	@Column(name="id_marca")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MARCA_SEQ")
	@SequenceGenerator(name="MARCA_SEQ", sequenceName = "MARCA_SEQ", allocationSize = 1)
	private long idMarca;
	
	@Column(name="NOME_MARCA")
	private String nomeMarca;
	
	@OneToMany(mappedBy = "marcaModel")
	private List<ProdutoModel> produtos;
	
	
	public MarcaModel() {
		super();
	}


	public MarcaModel(long idMarca, String nomeMarca) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}

	public long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(long idMarca) {
		this.idMarca = idMarca;
	}

	@NotNull(message="Nome da marca é obrigatório")
	@Size(min=2, max=50, message="Nome da marca deve ter entre 2 e 50 cracateres")
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	

}
