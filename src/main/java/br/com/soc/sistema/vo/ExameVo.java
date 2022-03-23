package br.com.soc.sistema.vo;

public class ExameVo {
	private String cdExame;
	private String nome;
	
	public ExameVo() {}
		
	public ExameVo(String cdExame, String nome) {
		this.cdExame = cdExame;
		this.nome = nome;
	}

	public String getCdExame() {
		return cdExame;
	}
	public void setCdExame(String cdExame) {
		this.cdExame = cdExame;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "ExameVo [cdExame=" + cdExame + ", nome=" + nome + "]";
	}
}
