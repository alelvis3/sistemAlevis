package br.com.alelvis.sistemAlevis.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbos")
public class OrdemServico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long os;

	@Column(nullable = false)
	private Timestamp data_os;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Situacao situacao;

	@Column(nullable = false)
	private String equipamento;

	private String defeito;

	private String servico;

	private String tecnico;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "idcli", nullable = false)
	private Cliente cliente;

	// Getters and setters

	public Long getOs() {
		return os;
	}

	public void setOs(Long os) {
		this.os = os;
	}

	public Timestamp getData_os() {
		return data_os;
	}

	public void setData_os(Timestamp data_os) {
		this.data_os = data_os;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}