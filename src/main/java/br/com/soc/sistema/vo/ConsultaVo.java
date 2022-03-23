package br.com.soc.sistema.vo;

public class ConsultaVo {
	private String cdConsulta;
	private String nmExame;
	private String nmFuncionario;
	private String data;

	public ConsultaVo() {}
	
	public ConsultaVo(String cdConsulta, String nmExame, String nmFuncionario, String data) {
		this.cdConsulta = cdConsulta;
		this.nmExame = nmExame;
		this.nmFuncionario = nmFuncionario;
		this.data = data;
	}

	public String getCdConsulta() {
		return cdConsulta;
	}

	public void setCdConsulta(String cdConsulta) {
		this.cdConsulta = cdConsulta;
	}

	public String getNmExame() {
		return nmExame;
	}

	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}

	public String getNmFuncionario() {
		return nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ConsultaVo [cdConsulta=" + cdConsulta + ", nmExame=" + nmExame + ", nmFuncionario=" + nmFuncionario + ", data=" + data + "]";
	}
}
