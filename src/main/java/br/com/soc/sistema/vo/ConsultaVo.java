package br.com.soc.sistema.vo;

public class ConsultaVo {

    private String cdConsulta;
    private String cdExame;
    private String nmExame;
    private String qtdExame;
    private String cdFuncionario;
    private String nmFuncionario;
    private String data;
    private String dataInicial;
    private String dataFinal;

    public ConsultaVo() {
    }

    public ConsultaVo(String cdConsulta, String cdExame, String nmExame, String cdFuncionario, String nmFuncionario,
	    String data) {
	this.cdConsulta = cdConsulta;
	this.cdExame = cdExame;
	this.nmExame = nmExame;
	this.cdFuncionario = cdFuncionario;
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

    public String getCdExame() {
	return cdExame;
    }

    public void setCdExame(String cdExame) {
	this.cdExame = cdExame;
    }

    public String getCdFuncionario() {
	return cdFuncionario;
    }

    public void setCdFuncionario(String cdFuncionario) {
	this.cdFuncionario = cdFuncionario;
    }

    public String getDataInicial() {
	return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
	this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
	return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
	this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
	return ("ConsultaVo [cdConsulta=" + cdConsulta + ", nmExame=" + nmExame + ", nmFuncionario=" + nmFuncionario
		+ ", data=" + data + "]");
    }

    public String getQtdExame() {
	return qtdExame;
    }

    public void setQtdExame(String qtdExame) {
	this.qtdExame = qtdExame;
    }
}
