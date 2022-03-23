package br.com.soc.sistema.vo;

public class FuncionarioVo {
	private String cdFuncionario;
	private String nome;
	
	public FuncionarioVo() {}
		
	public FuncionarioVo(String cdFuncionario, String nome) {
		this.cdFuncionario = cdFuncionario;
		this.nome = nome;
	}

	public String getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(String cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	@Override
	public String toString() {
		return "FuncionarioVo [cdFuncionario=" + cdFuncionario + ", nome=" + nome + "]";
	}
	
}
